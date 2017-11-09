package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.LongNVarcharTypeDescriptor;
import org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class LongNVarcharTypeDescriptorTest extends AbstractTest {
	@Test
	public void test() {

		aeq(NVarcharTypeDescriptor.class, LongNVarcharTypeDescriptor.class.getSuperclass());

		aeq(Types.LONGNVARCHAR, LongNVarcharTypeDescriptor.INSTANCE.getSqlType());
		aeq(-16, Types.LONGNVARCHAR);
	}
}
