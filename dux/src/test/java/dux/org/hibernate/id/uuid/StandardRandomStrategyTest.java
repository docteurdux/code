package dux.org.hibernate.id.uuid;

import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.uuid.StandardRandomStrategy;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class StandardRandomStrategyTest extends AbstractTest {

	private SharedSessionContractImplementor sharedSessionContractImplementor;

	@Before
	public void before() {
		sharedSessionContractImplementor = new DummySharedSessionContractImplementor();
	}

	@Test
	public void test() {

		StandardRandomStrategy instance = StandardRandomStrategy.INSTANCE;
		aeq(4, instance.getGeneratedVersion());

		UUID uuid1 = instance.generateUUID(sharedSessionContractImplementor);
		UUID uuid2 = instance.generateUUID(sharedSessionContractImplementor);
		af(uuid1.equals(uuid2));

	}
}
