package dux.org.hibernate.loader.plan.build.internal.returns;

import org.hibernate.loader.PropertyPath;
import org.hibernate.loader.plan.build.internal.returns.AbstractCompositeEntityIdentifierDescription;
import org.hibernate.loader.plan.build.internal.returns.AbstractExpandingFetchSource;
import org.hibernate.loader.plan.build.internal.returns.EncapsulatedEntityIdentifierDescription;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.plan.build.spi.DummyExpandingCompositeQuerySpace;
import dum.org.hibernate.loader.plan.spi.DummyEntityReference;
import dum.org.hibernate.type.DummyCompositeType;

@Done
public class EncapsulatedEntityIdentifierDescriptionTest extends AbstractTest {

	private DummyEntityReference entityReference;
	private DummyExpandingCompositeQuerySpace expandingCompositeQuerySpace;
	private DummyCompositeType compositeType;
	private PropertyPath propertyPath;

	@Before
	public void before() {
		entityReference = new DummyEntityReference();
		expandingCompositeQuerySpace = new DummyExpandingCompositeQuerySpace();
		compositeType = new DummyCompositeType();
		propertyPath = new PropertyPath();
	}

	@Test
	public void test() throws Exception {

		aeq(AbstractCompositeEntityIdentifierDescription.class,
				EncapsulatedEntityIdentifierDescription.class.getSuperclass());

		EncapsulatedEntityIdentifierDescription eeid = new EncapsulatedEntityIdentifierDescription(entityReference,
				expandingCompositeQuerySpace, compositeType, propertyPath) {
		};

		aeqr(entityReference, eeid.getSource());
		aeqr(compositeType, eeid.getFetchedType());
		aeqr(expandingCompositeQuerySpace, invoke(eeid, "expandingQuerySpace", AbstractExpandingFetchSource.class));
		aeqr(propertyPath, eeid.getPropertyPath());
	}
}
