package dux.org.hibernate.jmx.internal;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.hibernate.jmx.internal.DisabledJmxServiceImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.service.spi.DummyManageable;

@Done
public class DisabledJmxServiceImplTest extends AbstractTest {

	private DummyManageable manageable;
	private Class<?> clazz;
	private ObjectName objectName;
	private Object object;

	@Before
	public void before() throws MalformedObjectNameException {

		manageable = new DummyManageable();
		clazz = Object.class;

		objectName = new ObjectName("domain", "key", "value");
		object = new Object();

	}

	@Test
	public void test() {

		DisabledJmxServiceImpl instance = DisabledJmxServiceImpl.INSTANCE;

		// these methods do nothing
		instance.registerService(manageable, clazz);
		instance.registerMBean(objectName, object);
	}
}
