package dux.org.powermock.modules.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.docteurdux.test.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "dux.org.powermock.modules.junit4.PowerMockRunnerTest.A")
public class PowerMockRunnerTest extends AbstractTest {
	public static class A {
		public final String foo() {
			return "foo";
		}

		public final String baz() {
			return "baz";
		}
	}

	@Test
	public void test() throws Exception {

		A mock = PowerMockito.mock(A.class);
		PowerMockito.whenNew(A.class).withNoArguments().thenReturn(mock);

		A a = new A();
		PowerMockito.verifyNew(A.class).withNoArguments();

		PowerMockito.when(a.foo()).thenReturn("bar");

		String foor = a.foo();

		Mockito.verify(a).foo();
		aeq("bar", foor);

		a.baz();
	}
}
