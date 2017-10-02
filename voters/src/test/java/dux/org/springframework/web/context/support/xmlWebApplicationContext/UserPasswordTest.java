package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

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
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfLogoutHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;
import org.springframework.security.web.header.writers.HstsHeaderWriter;
import org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.DuxTest;

import dum.org.springframework.core.io.DummyProtocolResolver;
import duu.org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandlerExposer;
import duu.org.springframework.security.web.authentication.logout.CompositeLogoutHandlerExposer;
import duu.org.springframework.security.web.authentication.logout.LogoutFilterExposer;
import duu.org.springframework.security.web.csrf.CsrfFilterUtils;
import duu.org.springframework.security.web.csrf.LazyCsrfTokenRepositoryUtils;

public class UserPasswordTest extends DuxTest {

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

		aeq(23, context.getBeanDefinitionCount());

		FilterChainProxy filterChainProxy = (FilterChainProxy) context
				.getBean("org.springframework.security.filterChainProxy");

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		FilterChain chain = new MockFilterChain();
		filterChainProxy.doFilter(request, response, chain);
		aeq(403, response.getStatus());
		System.out.println(response.getContentAsString());

		List<SecurityFilterChain> filterChains = filterChainProxy.getFilterChains();
		aeq(1, filterChains.size());

		List<Filter> filters = filterChains.get(0).getFilters();

		aeq(14, filters.size());
		acclass(filters, SecurityContextPersistenceFilter.class);
		acclass(filters, WebAsyncManagerIntegrationFilter.class);
		acclass(filters, HeaderWriterFilter.class);
		acclass(filters, CsrfFilter.class);
		acclass(filters, LogoutFilter.class);
		acclass(filters, UsernamePasswordAuthenticationFilter.class);
		acclass(filters, DefaultLoginPageGeneratingFilter.class);
		acclass(filters, BasicAuthenticationFilter.class);
		acclass(filters, RequestCacheAwareFilter.class);
		acclass(filters, SecurityContextHolderAwareRequestFilter.class);
		acclass(filters, AnonymousAuthenticationFilter.class);
		acclass(filters, SessionManagementFilter.class);
		acclass(filters, ExceptionTranslationFilter.class);
		acclass(filters, FilterSecurityInterceptor.class);

		CsrfFilter csrfFilter = got(filters, CsrfFilter.class);

		LazyCsrfTokenRepository repository = (LazyCsrfTokenRepository) CsrfFilterUtils.getTokenRepository(csrfFilter);
		HttpSessionCsrfTokenRepository delegate = (HttpSessionCsrfTokenRepository) LazyCsrfTokenRepositoryUtils
				.getDelegate(repository);

		HeaderWriterFilterExposer headerWriterFilter = new HeaderWriterFilterExposer(
				got(filters, HeaderWriterFilter.class));
		List<HeaderWriter> headerWriters = headerWriterFilter.getHeaderWriters();

		acclass(headerWriters, CacheControlHeadersWriter.class);
		acclass(headerWriters, HstsHeaderWriter.class);
		acclass(headerWriters, XXssProtectionHeaderWriter.class);
		acclass(headerWriters, XFrameOptionsHeaderWriter.class);
		acclass(headerWriters, XContentTypeOptionsHeaderWriter.class);

		LogoutFilterExposer logoutFilter = new LogoutFilterExposer(got(filters, LogoutFilter.class));

		AbstractAuthenticationTargetUrlRequestHandlerExposer logoutSuccessHandler = getLogoutSuccessHandler(
				logoutFilter);

		CompositeLogoutHandlerExposer logoutHandler = getLogoutHandler(logoutFilter);

		aeq("/login?logout", logoutSuccessHandler.getDefaultTargetUrl());
		RedirectStrategy redirectStrategy = logoutSuccessHandler.getRedirectStrategy();
		atrue(redirectStrategy instanceof DefaultRedirectStrategy);

		AntPathRequestMatcher logoutRequestMatcher = (AntPathRequestMatcher) logoutFilter.getLogoutRequestMatcher();
		aeq("/logout", logoutRequestMatcher.getPattern());

		List<LogoutHandler> logoutHandlers = logoutHandler.getLogoutHandlers();
		aeq(2, logoutHandlers.size());

		aeq(2, logoutHandlers.size());
		acclass(logoutHandlers, CsrfLogoutHandler.class);
		acclass(logoutHandlers, SecurityContextLogoutHandler.class);

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

}
