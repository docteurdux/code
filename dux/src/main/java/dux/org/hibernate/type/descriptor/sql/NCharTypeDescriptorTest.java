package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.NCharTypeDescriptor;
import org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class NCharTypeDescriptorTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(NVarcharTypeDescriptor.class, NCharTypeDescriptor.class.getSuperclass());

		aeq(Types.NCHAR, NCharTypeDescriptor.INSTANCE.getSqlType());
		aeq(-15, Types.NCHAR);

	}

}
