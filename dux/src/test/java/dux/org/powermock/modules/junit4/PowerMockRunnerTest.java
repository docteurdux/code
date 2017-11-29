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
		
		System.out.println(A.class.getClassLoader());
		
		PowerMockito.whenNew(A.class).withNoArguments().thenReturn(mock);

		A a = new A();
		PowerMockito.verifyNew(A.class).withNoArguments();

		PowerMockito.when(a.foo()).thenReturn("bar");

		String foor = a.foo();

		Mockito.verify(a).foo();
		aeq("bar", foor);

		a.baz();
	}

	/*-
	 * MockClassLoader.<init>(String[], String[], UseClassPathAdjuster) line: 93	
	AbstractTestSuiteChunkerImpl$1.run() line: 227	
	AbstractTestSuiteChunkerImpl$1.run() line: 225	
	AccessController.doPrivileged(PrivilegedAction<T>) line: not available [native method]	
	JUnit4TestSuiteChunkerImpl(AbstractTestSuiteChunkerImpl<T>).createNewClassloader(Class<?>, String[], String[], MockTransformer...) line: 225	
	JUnit4TestSuiteChunkerImpl(AbstractTestSuiteChunkerImpl<T>).chunkClass(Class<?>) line: 178	
	JUnit4TestSuiteChunkerImpl(AbstractTestSuiteChunkerImpl<T>).<init>(Class<?>...) line: 96	
	JUnit4TestSuiteChunkerImpl(AbstractTestSuiteChunkerImpl<T>).<init>(Class<?>) line: 89	
	JUnit4TestSuiteChunkerImpl.<init>(Class<?>, Class<PowerMockJUnitRunnerDelegate>) line: 49	
	PowerMockRunner(AbstractCommonPowerMockRunner).<init>(Class<?>, Class<PowerMockJUnitRunnerDelegate>) line: 32	
	PowerMockRunner.<init>(Class<?>) line: 34	
	NativeConstructorAccessorImpl.newInstance0(Constructor<?>, Object[]) line: not available [native method]	
	NativeConstructorAccessorImpl.newInstance(Object[]) line: 62	
	DelegatingConstructorAccessorImpl.newInstance(Object[]) line: 45	
	Constructor<T>.newInstance(Object...) line: 423	
	AnnotatedBuilder.buildRunner(Class<Runner>, Class<?>) line: 104	
	AnnotatedBuilder.runnerForClass(Class<?>) line: 86	
	AnnotatedBuilder(RunnerBuilder).safeRunnerForClass(Class<?>) line: 59	
	AllDefaultPossibilitiesBuilder.runnerForClass(Class<?>) line: 26	
	AllDefaultPossibilitiesBuilder(RunnerBuilder).safeRunnerForClass(Class<?>) line: 59	
	ClassRequest.getRunner() line: 33	
	JUnit4TestLoader.createUnfilteredTest(Class<?>, String[]) line: 87	
	JUnit4TestLoader.createTest(Class<?>, String, String[], RemoteTestRunner) line: 73	
	JUnit4TestLoader.loadTests(Class[], String, String[], String[], String[][], String, RemoteTestRunner) line: 46	
	RemoteTestRunner.runTests(String[], String, TestExecution) line: 523	
	RemoteTestRunner.runTests(TestExecution) line: 761	
	RemoteTestRunner.run() line: 461	
	RemoteTestRunner.main(String[]) line: 207	
	*/
}
