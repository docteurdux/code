package dux.org.hibernate.tool.schema.spi;

import org.hibernate.tool.schema.spi.DelayedDropRegistryNotAvailableImpl;
import org.hibernate.tool.schema.spi.SchemaManagementException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.tool.schema.spi.DummyDelayedDropAction;

@Done
public class DelayedDropRegistryNotAvailableImplTest extends AbstractTest {

	private DummyDelayedDropAction delayedDropAction;

	@Before
	public void before() {
		delayedDropAction = new DummyDelayedDropAction();
	}

	@Test(expected = SchemaManagementException.class)
	public void test() {
		DelayedDropRegistryNotAvailableImpl.INSTANCE.registerOnCloseAction(delayedDropAction);
	}
}
