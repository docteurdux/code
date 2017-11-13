package dux.org.hibernate.type;

import org.hibernate.type.ImageType;
import org.hibernate.type.descriptor.java.PrimitiveByteArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.LongVarbinaryTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ImageTypeTest extends AbstractTest {

	@Test
	public void test() {

		ImageType instance = ImageType.INSTANCE;
		aeq("image", instance.getName());
		aeqr(LongVarbinaryTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(PrimitiveByteArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

	}
}
