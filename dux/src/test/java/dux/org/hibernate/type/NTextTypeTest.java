package dux.org.hibernate.type;

import org.hibernate.type.NTextType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.LongNVarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class NTextTypeTest extends AbstractTest {
	
	@Test
	public void test() {

		NTextType instance = NTextType.INSTANCE;

		aeq("ntext", instance.getName());
		aeqr(LongNVarcharTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(StringTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
