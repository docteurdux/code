package dux.org.hibernate.type;

import org.hibernate.type.MaterializedBlobType;
import org.hibernate.type.descriptor.java.PrimitiveByteArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.BlobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MaterializedBlobTypeTest extends AbstractTest {

	@Test
	public void test() {
		MaterializedBlobType instance = MaterializedBlobType.INSTANCE;
		aeq("materialized_blob", instance.getName());
		aeqr(BlobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(PrimitiveByteArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
