package dux.org.junit.runner.notification;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;

import com.github.docteurdux.test.AbstractTest;

public class RunNotifierTest extends AbstractTest {

	@Before
	public void before() {
		requireSources("junit-4.12", RunNotifier.class);
	}

	@Test
	public void test() {
	}
}
