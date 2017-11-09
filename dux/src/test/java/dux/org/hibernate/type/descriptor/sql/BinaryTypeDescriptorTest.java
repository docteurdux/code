package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarbinaryTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BinaryTypeDescriptorTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(VarbinaryTypeDescriptor.class, BinaryTypeDescriptor.class.getSuperclass());

		aeq(Types.BINARY, BinaryTypeDescriptor.INSTANCE.getSqlType());
		aeq(-2, Types.BINARY);

	}

}
