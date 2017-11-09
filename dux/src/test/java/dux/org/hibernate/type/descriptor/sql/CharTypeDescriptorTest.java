package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.CharTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CharTypeDescriptorTest extends AbstractTest {
	@Test
	public void test() {

		aeq(VarcharTypeDescriptor.class, CharTypeDescriptor.class.getSuperclass());

		aeq(Types.CHAR, CharTypeDescriptor.INSTANCE.getSqlType());
		aeq(1, Types.CHAR);
	}
}
