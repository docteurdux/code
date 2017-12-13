package dux.org.springframework.security.web.authentication.logout;

import org.junit.Test;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.filter.GenericFilterBeanTest;

@Topic(LogoutFilter.class)
@Related({ GenericFilterBeanTest.class })
public class LogoutFilterTest extends AbstractTest {
	@Test
	public void test() {

	}
}
