package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.LongVarbinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarbinaryTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class LongVarbinaryTypeDescriptorTest extends AbstractTest {
	@Test
	public void test() {

		aeq(VarbinaryTypeDescriptor.class, LongVarbinaryTypeDescriptor.class.getSuperclass());

		aeq(Types.LONGVARBINARY, LongVarbinaryTypeDescriptor.INSTANCE.getSqlType());
		aeq(-4, Types.LONGVARBINARY);
	}
}
