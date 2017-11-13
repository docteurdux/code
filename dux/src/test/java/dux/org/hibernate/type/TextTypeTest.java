package dux.org.hibernate.type;

import org.hibernate.type.TextType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class TextTypeTest extends AbstractTest {

	@Test
	public void test() {

		TextType instance = TextType.INSTANCE;

		aeq("text", instance.getName());
		aeqr(LongVarcharTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(StringTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

	}
}
