package dux.org.springframework.security.web.access.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.access.expression.DummySecurityExpressionHandler;
import dum.org.springframework.security.web.util.matcher.DummyRequestMatcher;
import duu.javax.servlet.CountingFilter;
import dux.org.springframework.expression.DummyExpression;
import dux.org.springframework.expression.DummyExpressionParser;
import dux.org.springframework.security.access.DummyConfigAttribute;

public class ExpressionBasedFilterInvocationSecurityMetadataSourceTest {

	private static final String WECA_CLSNAME = "org.springframework.security.web.access.expression.WebExpressionConfigAttribute";
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap;
	private DummyRequestMatcher requestMatcher;
	private Collection<ConfigAttribute> configAttributes;
	private ConfigAttribute configAttribute;
	private DummySecurityExpressionHandler<FilterInvocation> expressionHandler;
	private DummyExpressionParser expressionParser;
	private DummyExpression expression;
	private ExpressionBasedFilterInvocationSecurityMetadataSource source;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter);
		requestMap = new LinkedHashMap<>();
		requestMatcher = new DummyRequestMatcher();
		expressionHandler = new DummySecurityExpressionHandler<>();
	}

	@Test
	public void test() {
		requestMatcher.setMatches(true);
		configAttributes = new ArrayList<>();
		configAttribute = new DummyConfigAttribute("attribute");
		configAttributes.add(configAttribute);
		requestMap.put(requestMatcher, configAttributes);
		expressionParser = new DummyExpressionParser();
		expression = new DummyExpression();
		expression.setString("expressionString");
		expressionParser.setExpression(expression);
		expressionHandler.setExpressionParser(expressionParser);
		source = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);

		Collection<ConfigAttribute> allwecal = source.getAllConfigAttributes();
		Assert.assertEquals(1, allwecal.size());
		ConfigAttribute allweca = allwecal.iterator().next();
		Assert.assertEquals(WECA_CLSNAME, allweca.getClass().getName());
		Assert.assertNull(allweca.getAttribute());
		Assert.assertEquals("expressionString", allweca.toString());
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		Collection<ConfigAttribute> wecal = source.getAttributes(fi);
		Assert.assertEquals(1, wecal.size());
		ConfigAttribute weca = wecal.iterator().next();
		Assert.assertEquals(WECA_CLSNAME, weca.getClass().getName());
		Assert.assertNull(weca.getAttribute());
		Assert.assertEquals("expressionString", weca.toString());

		Assert.assertFalse(source.supports(Object.class));
		Assert.assertTrue(source.supports(FilterInvocation.class));

	}
}
