package dux.org.hibernate.metamodel.internal;

import javax.persistence.metamodel.Type.PersistenceType;

import org.hibernate.metamodel.internal.BasicTypeImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BasicTypeImplTest extends AbstractTest {

	private PersistenceType persistenceType;
	private Class<String> clazz;

	@Before
	public void before() {
		persistenceType = PersistenceType.BASIC;
		clazz = String.class;
	}

	@Test
	public void test() {
		BasicTypeImpl<String> b = new BasicTypeImpl<>(clazz, persistenceType);
		aeq(clazz, b.getJavaType());
		aeq(persistenceType, b.getPersistenceType());
	}
}
