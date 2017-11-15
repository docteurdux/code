package dux.org.hibernate.type;

import org.hibernate.type.ClassType;
import org.hibernate.type.descriptor.java.ClassTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ClassTypeTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		ClassType instance = ClassType.INSTANCE;

		aeq("class", instance.getName());

		aeqr(VarcharTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(ClassTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

		at((Boolean) invoke(instance, "registerUnderJavaType"));
	}
}
