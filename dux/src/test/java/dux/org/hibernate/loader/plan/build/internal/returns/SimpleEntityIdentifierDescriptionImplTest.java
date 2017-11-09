package dux.org.hibernate.loader.plan.build.internal.returns;

import org.hibernate.loader.plan.build.internal.returns.SimpleEntityIdentifierDescriptionImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SimpleEntityIdentifierDescriptionImplTest extends AbstractTest {

	@Test
	public void test() {

		SimpleEntityIdentifierDescriptionImpl description = new SimpleEntityIdentifierDescriptionImpl();
		af(description.hasFetches());
		af(description.hasBidirectionalEntityReferences());
	}
}
