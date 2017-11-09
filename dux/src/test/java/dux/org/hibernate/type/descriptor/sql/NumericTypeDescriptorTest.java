package dux.org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.hibernate.type.descriptor.sql.DecimalTypeDescriptor;
import org.hibernate.type.descriptor.sql.NumericTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class NumericTypeDescriptorTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(DecimalTypeDescriptor.class, NumericTypeDescriptor.class.getSuperclass());

		aeq(Types.NUMERIC, NumericTypeDescriptor.INSTANCE.getSqlType());
		aeq(2, Types.NUMERIC);

	}

}
