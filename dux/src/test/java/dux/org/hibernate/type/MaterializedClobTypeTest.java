package dux.org.hibernate.type;

import org.hibernate.type.MaterializedClobType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.ClobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MaterializedClobTypeTest extends AbstractTest {

	@Test
	public void test() {

		MaterializedClobType instance = MaterializedClobType.INSTANCE;
		aeqr(ClobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(StringTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
