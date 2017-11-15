package dux.org.hibernate.type.descriptor.converter;

import org.hibernate.type.descriptor.converter.AttributeConverterMutabilityPlanImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.DummyAttributeConverter;

@Done
public class AttributeConverterMutabilityPlanImplTest extends AbstractTest {

	private Object entity1;
	private Object entity2;
	private Object databaseValue;
	private DummyAttributeConverter<Object, Object> attributeConverter;

	public AttributeConverterMutabilityPlanImplTest() {

		entity1 = new Object();
		entity2 = new Object();
		databaseValue = new Object();

		attributeConverter = new DummyAttributeConverter<>();
		attributeConverter.addEntityToDatabasePair(entity1, databaseValue);
		attributeConverter.addDatabaseToEntityPair(databaseValue, entity2);
	}

	@Test
	public void test() throws Exception {

		AttributeConverterMutabilityPlanImpl<Object> attributeConverterMutabilityPlanImpl = new AttributeConverterMutabilityPlanImpl<>(
				attributeConverter);

		aeqr(entity2, invoke(attributeConverterMutabilityPlanImpl, "deepCopyNotNull", entity1));
	}
}
