package dux.org.hibernate.internal;

import org.hibernate.internal.CoreLogging;
import org.hibernate.internal.CoreMessageLogger;
import org.jboss.logging.Logger;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CoreLoggingTest extends AbstractTest {

	private String loggerName;
	private Class<?> classNeedingLogging;

	public CoreLoggingTest() {
		loggerName = "loggerName";
		classNeedingLogging = Object.class;
	}

	@Test
	public void test() {

		Logger logger1 = CoreLogging.logger(classNeedingLogging);
		aeq("org.jboss.logging.JDKLogger", logger1.getClass().getName());

		Logger logger2 = CoreLogging.logger(loggerName);
		aeq("org.jboss.logging.JDKLogger", logger2.getClass().getName());

		CoreMessageLogger messageLogger1 = CoreLogging.messageLogger(classNeedingLogging);
		aeq("org.hibernate.internal.CoreMessageLogger_$logger", messageLogger1.getClass().getName());

		CoreMessageLogger messageLogger2 = CoreLogging.messageLogger(loggerName);
		aeq("org.hibernate.internal.CoreMessageLogger_$logger", messageLogger2.getClass().getName());

	}
}
