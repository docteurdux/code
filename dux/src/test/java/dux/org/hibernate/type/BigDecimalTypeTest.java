package dux.org.hibernate.type;

import org.hibernate.type.BigDecimalType;
import org.hibernate.type.descriptor.java.BigDecimalTypeDescriptor;
import org.hibernate.type.descriptor.sql.NumericTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BigDecimalTypeTest extends AbstractTest {
	@Test
	public void test() {
		BigDecimalType instance = BigDecimalType.INSTANCE;
		aeq("big_decimal", instance.getName());
		aeqr(NumericTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(BigDecimalTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
		at((Boolean) invoke(instance, "registerUnderJavaType"));
	}
}
