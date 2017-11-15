package dux.org.hibernate.internal;

import org.hibernate.internal.HEMLogging;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class HEMLoggingTest extends AbstractTest {

	private Class<?> classNeedingLogging;
	private String loggerName;

	@Before
	public void before() {
		classNeedingLogging = Object.class;
		loggerName = "loggerName";
	}

	@Test
	public void test() {
		aeq("org.hibernate.internal.EntityManagerMessageLogger_$logger",
				HEMLogging.messageLogger(classNeedingLogging).getClass().getName());
		aeq("org.hibernate.internal.EntityManagerMessageLogger_$logger",
				HEMLogging.messageLogger(loggerName).getClass().getName());
		aeq("org.jboss.logging.JDKLogger", HEMLogging.logger(classNeedingLogging).getClass().getName());
		aeq("org.jboss.logging.JDKLogger", HEMLogging.logger(loggerName).getClass().getName());
	}
}
