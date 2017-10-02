package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dum.org.springframework.core.io.DummyProtocolResolver;
import duu.org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandlerExposer;
import duu.org.springframework.security.web.authentication.logout.CompositeLogoutHandlerExposer;
import duu.org.springframework.security.web.authentication.logout.LogoutFilterExposer;
import duu.org.springframework.security.web.csrf.CsrfFilterUtils;
import duu.org.springframework.security.web.csrf.LazyCsrfTokenRepositoryUtils;

public class UserPasswordTest {

	private static final String X_CONTENT_TYPE_OPTIONS_HEADER_WRITER_CLASSNAME = "org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter";
	private static final String X_FRAME_OPTIONS_HEADER_WRITER_CLASSNAME = "org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter";
	private static final String X_XSS_PROTECTION_HEADER_WRITER_CLASSNAME = "org.springframework.security.web.header.writers.XXssProtectionHeaderWriter";
	private static final String HSTS_HEADER_WRITER_CLASSNAME = "org.springframework.security.web.header.writers.HstsHeaderWriter";
	private static final String CACHE_CONTROL_HEADERS_WRITER_CLASSNAME = "org.springframework.security.web.header.writers.CacheControlHeadersWriter";
	private static final String SECURITY_CONTEXT_LOGOUT_HANDLER_CLASS = "org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler";
	private static final String CSRF_LOGOUT_HANDLER_CLASS = "org.springframework.security.web.csrf.CsrfLogoutHandler";

	public static enum FilterType {
		SecurityContextPersistenceFilter, WebAsyncManagerIntegrationFilter, HeaderWriterFilter, CsrfFilter, LogoutFilter, UsernamePasswordAuthenticationFilter, DefaultLoginPageGeneratingFilter, BasicAuthenticationFilter, RequestCacheAwareFilter, SecurityContextHolderAwareRequestFilter, AnonymousAuthenticationFilter, SessionManagementFilter, ExceptionTranslationFilter, FilterSecurityInterceptor

	}

	private static final String BEANS_XSD = "http://www.springframework.org/schema/beans/spring-beans-3.0.xsd";
	private static final String BEANS_NS = "http://www.springframework.org/schema/beans";
	private static final String SECURITY_NS = "http://www.springframework.org/schema/security";
	private static final String SECURITY_XSD = "http://www.springframework.org/schema/security/spring-security-4.2.xsd";
	private static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

	@Test
	public void test() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException,
			IOException, ServletException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {

		ServletContext servletContext = new MockServletContext();

		DummyProtocolResolver pr = new DummyProtocolResolver();
		pr.getResources().put("/WEB-INF/applicationContext.xml", getResource());

		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.addProtocolResolver(pr);

		context.setServletContext(servletContext);
		context.refresh();

		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}

		Assert.assertEquals(23, context.getBeanDefinitionCount());

		FilterChainProxy filterChainProxy = (FilterChainProxy) context
				.getBean("org.springframework.security.filterChainProxy");

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		FilterChain chain = new MockFilterChain();
		filterChainProxy.doFilter(request, response, chain);
		Assert.assertEquals(403, response.getStatus());
		System.out.println(response.getContentAsString());

		List<SecurityFilterChain> securityFilterChains = filterChainProxy.getFilterChains();
		System.out.println(securityFilterChains.size());
		SecurityFilterChain sfc = securityFilterChains.get(0);
		List<Filter> filters = sfc.getFilters();
		System.out.println(filters.size());

		Map<FilterType, Filter> filterMap = new HashMap<>();
		fillFilterMap(filters, filterMap);

		CsrfFilter csrfFilter = (CsrfFilter) filterMap.get(FilterType.CsrfFilter);

		LazyCsrfTokenRepository repository = (LazyCsrfTokenRepository) CsrfFilterUtils.getTokenRepository(csrfFilter);
		HttpSessionCsrfTokenRepository delegate = (HttpSessionCsrfTokenRepository) LazyCsrfTokenRepositoryUtils
				.getDelegate(repository);

		HeaderWriterFilter headerWriterFilter = (HeaderWriterFilter) filterMap.get(FilterType.HeaderWriterFilter);
		Field field = HeaderWriterFilter.class.getDeclaredField("headerWriters");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		List<HeaderWriter> headerWriters = (List<HeaderWriter>) field.get(headerWriterFilter);
		Set<String> headerWriterClassNames = new HashSet<>();
		for (HeaderWriter headerWriter : headerWriters) {
			headerWriterClassNames.add(headerWriter.getClass().getName());
		}
		Assert.assertTrue(headerWriterClassNames.contains(CACHE_CONTROL_HEADERS_WRITER_CLASSNAME));
		Assert.assertTrue(headerWriterClassNames.contains(HSTS_HEADER_WRITER_CLASSNAME));
		Assert.assertTrue(headerWriterClassNames.contains(X_XSS_PROTECTION_HEADER_WRITER_CLASSNAME));
		Assert.assertTrue(headerWriterClassNames.contains(X_FRAME_OPTIONS_HEADER_WRITER_CLASSNAME));
		Assert.assertTrue(headerWriterClassNames.contains(X_CONTENT_TYPE_OPTIONS_HEADER_WRITER_CLASSNAME));

		LogoutFilterExposer logoutFilter = new LogoutFilterExposer(
				(LogoutFilter) filterMap.get(FilterType.LogoutFilter));

		AbstractAuthenticationTargetUrlRequestHandlerExposer logoutSuccessHandler = getLogoutSuccessHandler(
				logoutFilter);

		CompositeLogoutHandlerExposer logoutHandler = getLogoutHandler(logoutFilter);

		Assert.assertEquals("/login?logout", logoutSuccessHandler.getDefaultTargetUrl());
		RedirectStrategy redirectStrategy = logoutSuccessHandler.getRedirectStrategy();
		Assert.assertTrue(redirectStrategy instanceof DefaultRedirectStrategy);

		AntPathRequestMatcher logoutRequestMatcher = (AntPathRequestMatcher) logoutFilter.getLogoutRequestMatcher();
		Assert.assertEquals("/logout", logoutRequestMatcher.getPattern());

		List<LogoutHandler> logoutHandlers = logoutHandler.getLogoutHandlers();
		Assert.assertEquals(2, logoutHandlers.size());
		Set<String> logoutHandlersClasses = new HashSet<>();
		for (LogoutHandler lh : logoutHandlers) {
			logoutHandlersClasses.add(lh.getClass().getName());
		}

		Assert.assertEquals(2, logoutHandlers.size());
		Assert.assertEquals(2, logoutHandlersClasses.size());
		Assert.assertTrue(logoutHandlersClasses.contains(CSRF_LOGOUT_HANDLER_CLASS));
		Assert.assertTrue(logoutHandlersClasses.contains(SECURITY_CONTEXT_LOGOUT_HANDLER_CLASS));

		context.close();

	}

	private CompositeLogoutHandlerExposer getLogoutHandler(LogoutFilterExposer logoutFilter) {
		return new CompositeLogoutHandlerExposer((CompositeLogoutHandler) logoutFilter.getHandler());
	}

	private AbstractAuthenticationTargetUrlRequestHandlerExposer getLogoutSuccessHandler(
			LogoutFilterExposer logoutFilter) {
		return new AbstractAuthenticationTargetUrlRequestHandlerExposer(
				(AbstractAuthenticationTargetUrlRequestHandler) logoutFilter.getLogoutSuccessHandler());
	}

	private Resource getResource()
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element beans = document.createElementNS(BEANS_NS, ("b:beans"));
		beans.setAttribute("xmlns", SECURITY_NS);
		beans.setAttribute("xmlns:xsi", XSI_NS);
		beans.setAttribute("xmlns:b", BEANS_NS);
		beans.setAttributeNS(XSI_NS, "xsi:schemaLocation",
				BEANS_NS + " " + BEANS_XSD + " " + SECURITY_NS + " " + SECURITY_XSD);
		document.appendChild(beans);

		Element http = document.createElement("http");
		beans.appendChild(http);

		Element userService = document.createElement("user-service");
		beans.appendChild(userService);

		Element user = document.createElement("user");
		user.setAttribute("name", "user");
		user.setAttribute("password", "password");
		user.setAttribute("authorities", "ROLE_USER");
		userService.appendChild(user);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		transformer.transform(new DOMSource(document), new StreamResult(baos));
		byte[] bytes = baos.toByteArray();
		System.out.println(new String(bytes));
		Resource resource = new ByteArrayResource(bytes);
		return resource;
	}

	private void fillFilterMap(List<Filter> filters, Map<FilterType, Filter> filterMap) {
		for (Filter filter : filters) {
			if (filter instanceof SecurityContextPersistenceFilter) {
				filterMap.put(FilterType.SecurityContextPersistenceFilter, filter);
			}
			if (filter instanceof WebAsyncManagerIntegrationFilter) {
				filterMap.put(FilterType.WebAsyncManagerIntegrationFilter, filter);
			}
			if (filter instanceof HeaderWriterFilter) {
				filterMap.put(FilterType.HeaderWriterFilter, filter);
			}
			if (filter instanceof CsrfFilter) {
				filterMap.put(FilterType.CsrfFilter, filter);
			}
			if (filter instanceof LogoutFilter) {
				filterMap.put(FilterType.LogoutFilter, filter);
			}
			if (filter instanceof UsernamePasswordAuthenticationFilter) {
				filterMap.put(FilterType.UsernamePasswordAuthenticationFilter, filter);
			}
			if (filter instanceof DefaultLoginPageGeneratingFilter) {
				filterMap.put(FilterType.DefaultLoginPageGeneratingFilter, filter);
			}
			if (filter instanceof BasicAuthenticationFilter) {
				filterMap.put(FilterType.BasicAuthenticationFilter, filter);
			}
			if (filter instanceof RequestCacheAwareFilter) {
				filterMap.put(FilterType.RequestCacheAwareFilter, filter);
			}
			if (filter instanceof SecurityContextHolderAwareRequestFilter) {
				filterMap.put(FilterType.SecurityContextHolderAwareRequestFilter, filter);
			}
			if (filter instanceof AnonymousAuthenticationFilter) {
				filterMap.put(FilterType.AnonymousAuthenticationFilter, filter);
			}
			if (filter instanceof SessionManagementFilter) {
				filterMap.put(FilterType.SessionManagementFilter, filter);
			}
			if (filter instanceof ExceptionTranslationFilter) {
				filterMap.put(FilterType.ExceptionTranslationFilter, filter);
			}
			if (filter instanceof FilterSecurityInterceptor) {
				filterMap.put(FilterType.FilterSecurityInterceptor, filter);
			}
		}
	}

}
