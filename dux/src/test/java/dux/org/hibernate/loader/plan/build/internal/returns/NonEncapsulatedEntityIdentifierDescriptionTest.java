package dux.org.hibernate.loader.plan.build.internal.returns;

import org.hibernate.loader.PropertyPath;
import org.hibernate.loader.plan.build.internal.returns.AbstractCompositeEntityIdentifierDescription;
import org.hibernate.loader.plan.build.internal.returns.AbstractExpandingFetchSource;
import org.hibernate.loader.plan.build.internal.returns.NonEncapsulatedEntityIdentifierDescription;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.plan.build.spi.DummyExpandingCompositeQuerySpace;
import dum.org.hibernate.loader.plan.spi.DummyEntityReference;
import dum.org.hibernate.type.DummyCompositeType;

@Done
public class NonEncapsulatedEntityIdentifierDescriptionTest extends AbstractTest {

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
				NonEncapsulatedEntityIdentifierDescription.class.getSuperclass());

		NonEncapsulatedEntityIdentifierDescription neeid = new NonEncapsulatedEntityIdentifierDescription(
				entityReference, expandingCompositeQuerySpace, compositeType, propertyPath);

		aeqr(entityReference, neeid.getSource());
		aeqr(compositeType, neeid.getFetchedType());
		aeqr(expandingCompositeQuerySpace, invoke(neeid, "expandingQuerySpace", AbstractExpandingFetchSource.class));
		aeqr(propertyPath, neeid.getPropertyPath());
	}
}
