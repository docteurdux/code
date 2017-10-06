package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.DuxTest;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.core.io.DummyProtocolResolver;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;

public class UserPasswordTest2 extends DuxTest {

	private static final String BEANS_XSD = "http://www.springframework.org/schema/beans/spring-beans-3.0.xsd";
	private static final String BEANS_NS = "http://www.springframework.org/schema/beans";
	private static final String SECURITY_NS = "http://www.springframework.org/schema/security";
	private static final String SECURITY_XSD = "http://www.springframework.org/schema/security/spring-security-4.2.xsd";
	private static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

	private DummyServlet servlet;
	private CountingFilter countingFilter1;
	private InspectingFilter inspectingFilter;
	private CountingFilter countingFilter2;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private FilterChain chain;
	private ServletContext servletContext;
	private DummyProtocolResolver pr;
	private XmlWebApplicationContext context;

	@Before
	public void before()
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		servlet = new DummyServlet();
		countingFilter1 = new CountingFilter();
		inspectingFilter = new InspectingFilter();
		countingFilter2 = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter1, inspectingFilter, countingFilter2);
		servletContext = new MockServletContext();
		pr = new DummyProtocolResolver();
		pr.getResources().put("/WEB-INF/applicationContext.xml", getResource());
		context = new XmlWebApplicationContext();
		context.addProtocolResolver(pr);
		context.setServletContext(servletContext);
		context.refresh();
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void test() throws IOException, ServletException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {

		request.setMethod("GET");

		FilterChainProxy filterChainProxy = (FilterChainProxy) context
				.getBean("org.springframework.security.filterChainProxy");

		filterChainProxy.doFilter(request, response, chain);

		assertFilterClasses(filterChainProxy.getFilterChains().get(0).getFilters());

		aeq(0, countingFilter1.getCount());

		context.close();

	}

	private void assertFilterClasses(List<Filter> filters) {
		aeq(14, filters.size());
		int c = -1;
		aeq(SecurityContextPersistenceFilter.class, filters.get(++c).getClass());
		aeq(WebAsyncManagerIntegrationFilter.class, filters.get(++c).getClass());
		aeq(HeaderWriterFilter.class, filters.get(++c).getClass());
		aeq(CsrfFilter.class, filters.get(++c).getClass());
		aeq(LogoutFilter.class, filters.get(++c).getClass());
		aeq(UsernamePasswordAuthenticationFilter.class, filters.get(++c).getClass());
		aeq(DefaultLoginPageGeneratingFilter.class, filters.get(++c).getClass());
		aeq(BasicAuthenticationFilter.class, filters.get(++c).getClass());
		aeq(RequestCacheAwareFilter.class, filters.get(++c).getClass());
		aeq(SecurityContextHolderAwareRequestFilter.class, filters.get(++c).getClass());
		aeq(AnonymousAuthenticationFilter.class, filters.get(++c).getClass());
		aeq(SessionManagementFilter.class, filters.get(++c).getClass());
		aeq(ExceptionTranslationFilter.class, filters.get(++c).getClass());
		aeq(FilterSecurityInterceptor.class, filters.get(++c).getClass());
	}

	public void shortcuts() throws InstantiationException, IllegalAccessException, IOException, ServletException {

		SecurityContextPersistenceFilter a = SecurityContextPersistenceFilter.class.newInstance();
		a.doFilter(request, response, chain);

		WebAsyncManagerIntegrationFilter b = WebAsyncManagerIntegrationFilter.class.newInstance();
		b.doFilter(request, response, chain);

		HeaderWriterFilter c = HeaderWriterFilter.class.newInstance();
		c.doFilter(request, response, chain);

		CsrfFilter d = CsrfFilter.class.newInstance();
		d.doFilter(request, response, chain);

		LogoutFilter e = LogoutFilter.class.newInstance();
		e.doFilter(request, response, chain);

		UsernamePasswordAuthenticationFilter f = UsernamePasswordAuthenticationFilter.class.newInstance();
		f.doFilter(request, response, chain);

		DefaultLoginPageGeneratingFilter g = DefaultLoginPageGeneratingFilter.class.newInstance();
		g.doFilter(request, response, chain);

		BasicAuthenticationFilter h = BasicAuthenticationFilter.class.newInstance();
		h.doFilter(request, response, chain);

		RequestCacheAwareFilter i = RequestCacheAwareFilter.class.newInstance();
		i.doFilter(request, response, chain);

		SecurityContextHolderAwareRequestFilter j = SecurityContextHolderAwareRequestFilter.class.newInstance();
		j.doFilter(request, response, chain);

		AnonymousAuthenticationFilter k = AnonymousAuthenticationFilter.class.newInstance();
		k.doFilter(request, response, chain);

		SessionManagementFilter l = SessionManagementFilter.class.newInstance();
		l.doFilter(request, response, chain);

		ExceptionTranslationFilter m = ExceptionTranslationFilter.class.newInstance();
		m.doFilter(request, response, chain);

		FilterSecurityInterceptor n = FilterSecurityInterceptor.class.newInstance();
		n.doFilter(request, response, chain);
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
