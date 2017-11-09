package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.FloatTypeDescriptor;
import org.hibernate.type.descriptor.sql.RealTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class FloatTypeDescriptorTest extends AbstractTest {
	@Test
	public void test() {
		aeq(RealTypeDescriptor.class, FloatTypeDescriptor.class.getSuperclass());

		aeq(Types.FLOAT, FloatTypeDescriptor.INSTANCE.getSqlType());
		aeq(6, Types.FLOAT);

	}
}
