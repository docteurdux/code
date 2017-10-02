package dux.org.springframework.security.web.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import dum.javax.servlet.DummyServlet;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;
import duu.javax.servlet.Inspector;

public class SecurityContextPersistenceFilterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private InspectingFilter inspectingFilter;

	@Before
	public void reset() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		inspectingFilter = new InspectingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter, inspectingFilter);

	}

	/**
	 * Test that filter attribute is set on request and that strategy is thread
	 * local
	 */
	@Test
	public void testAttributeSetWithinFilterChain() throws IOException, ServletException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		SecurityContextPersistenceFilter filter = new SecurityContextPersistenceFilter();

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				Assert.assertTrue((boolean) request.getAttribute("__spring_security_scpf_applied"));

			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertNull(request.getAttribute("__spring_security_scpf_applied"));
		Assert.assertEquals(1, countingFilter.getCount());

		SecurityContextHolderUtils.assertThreadLocalStrategy();
	}

}
