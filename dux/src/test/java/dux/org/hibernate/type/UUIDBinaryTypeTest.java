package dux.org.hibernate.type;

import org.hibernate.type.UUIDBinaryType;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class UUIDBinaryTypeTest extends AbstractTest {
	
	@Test
	public void test() throws Exception {

		UUIDBinaryType instance = UUIDBinaryType.INSTANCE;

		aeq("uuid-binary", instance.getName());
		aeqr(BinaryTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(UUIDTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

		at((Boolean) invoke(instance, "registerUnderJavaType"));
	}
}
