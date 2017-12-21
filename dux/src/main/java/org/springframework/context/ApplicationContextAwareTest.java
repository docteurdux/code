package org.springframework.context;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.AwareTest;
import dux.org.springframework.web.servlet.FrameworkServletTest;

@Topic(ApplicationContextAware.class)
@Extends({AwareTest.class})
@ExtendedBy({FrameworkServletTest.class})
public class ApplicationContextAwareTest extends AbstractTest {
	@Test
	public void test() {

	}
}
