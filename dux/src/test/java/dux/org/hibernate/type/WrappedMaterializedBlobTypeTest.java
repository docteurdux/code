package dux.org.hibernate.type;

import org.hibernate.type.WrappedMaterializedBlobType;
import org.hibernate.type.descriptor.java.ByteArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.BlobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class WrappedMaterializedBlobTypeTest extends AbstractTest {
	@Test
	public void test() {
		WrappedMaterializedBlobType instance = WrappedMaterializedBlobType.INSTANCE;
		aeq(null, instance.getName());
		aeqr(BlobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(ByteArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

	}
}
