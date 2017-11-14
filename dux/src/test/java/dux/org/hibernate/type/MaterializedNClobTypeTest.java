package dux.org.hibernate.type;

import org.hibernate.type.MaterializedNClobType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.NClobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MaterializedNClobTypeTest extends AbstractTest {
	@Test
	public void test() {
		MaterializedNClobType instance = MaterializedNClobType.INSTANCE;
		aeq("materialized_nclob", instance.getName());
		aeqr(NClobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(StringTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
