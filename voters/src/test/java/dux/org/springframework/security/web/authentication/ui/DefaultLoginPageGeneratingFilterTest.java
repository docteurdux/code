package dux.org.springframework.security.web.authentication.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

public class DefaultLoginPageGeneratingFilterTest {
	@Test
	public void test() throws IOException, ServletException {
		DefaultLoginPageGeneratingFilter filter = new DefaultLoginPageGeneratingFilter();

		DummyFilterConfig filterConfig = new DummyFilterConfig();
		filter.init(filterConfig);

		DummyHttpServletRequest req = new DummyHttpServletRequest();
		req.setMethod("GET");
		req.setContextPath("");
		req.setRequestURI(DefaultLoginPageGeneratingFilter.DEFAULT_LOGIN_PAGE_URL);
		DummyHttpServletResponse res = new DummyHttpServletResponse();
		StringWriter sw = new StringWriter();
		res.setWriter(new PrintWriter(sw));
		FilterChain chain = new DummyFilterChain();
		filter.setLoginPageUrl(DefaultLoginPageGeneratingFilter.DEFAULT_LOGIN_PAGE_URL);
		filter.setFormLoginEnabled(true);
		filter.setRememberMeParameter("rme");
		filter.setOpenIdEnabled(true);
		filter.doFilter(req, res, chain);

		Assert.assertEquals("", sw.toString());
	}
}
