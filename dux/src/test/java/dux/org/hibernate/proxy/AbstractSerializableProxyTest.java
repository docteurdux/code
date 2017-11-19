package dux.org.hibernate.proxy;

import java.io.Serializable;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.proxy.DummyAbstractLazyInitializer;
import dum.org.hibernate.proxy.DummyAbstractSerializableProxy;

@Done
public class AbstractSerializableProxyTest extends AbstractTest {

	private String entityName;
	private Serializable id;
	private Boolean readOnly;
	private DummyAbstractLazyInitializer abstractLazyInitializer;

	public AbstractSerializableProxyTest() {
		
		entityName = "entityName";
		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		readOnly = false;

		abstractLazyInitializer = new DummyAbstractLazyInitializer(entityName, id, null);

	}

	@Test
	public void test() {
		DummyAbstractSerializableProxy abstractSerializableProxy = new DummyAbstractSerializableProxy(entityName, id,
				readOnly);

		aeq(entityName, abstractSerializableProxy.getEntityName());
		aeqr(id, abstractSerializableProxy.getId());

		abstractSerializableProxy.setReadOnlyBeforeAttachedToSession(abstractLazyInitializer);

	}
}
