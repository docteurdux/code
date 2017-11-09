package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class LongVarcharTypeDescriptorTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(VarcharTypeDescriptor.class, LongVarcharTypeDescriptor.class.getSuperclass());

		aeq(Types.LONGVARCHAR, LongVarcharTypeDescriptor.INSTANCE.getSqlType());
		aeq(-1, Types.LONGVARCHAR);

	}

}
