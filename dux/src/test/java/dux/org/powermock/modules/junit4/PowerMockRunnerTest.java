package dux.org.powermock.modules.junit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunNotifier;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.docteurdux.test.AbstractTest;

public class PowerMockRunnerTest extends AbstractTest {

	@PrepareForTest(value = M.class)
	public static class T {
		@Test
		public void test() {
			M m = PowerMockito.mock(M.class);
		}
	}

	public static class M {

	}

	@Before
	public void before() {
		requireSources("powermock-module-junit4-1.6.4", PowerMockRunner.class);
	}

	@Test
	public void test() throws Exception {
		PowerMockRunner runner = new PowerMockRunner(T.class);
		runner.run(new RunNotifier());
	}

}
