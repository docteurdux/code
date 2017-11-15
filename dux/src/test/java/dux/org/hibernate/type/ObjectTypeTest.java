package dux.org.hibernate.type;

import org.hibernate.type.ObjectType;
import org.hibernate.type.SerializableType;
import org.hibernate.type.StringType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ObjectTypeTest extends AbstractTest {

	@Test
	public void test() {

		ObjectType instance = ObjectType.INSTANCE;

		aeq("object", instance.getName());

		aeqr(StringType.INSTANCE, instance.getDiscriminatorType());
		aeqr(SerializableType.INSTANCE, instance.getIdentifierType());

		aeq("object", instance.getRegistrationKeys()[0]);
		aeq("java.lang.Object", instance.getRegistrationKeys()[1]);
	}
}
