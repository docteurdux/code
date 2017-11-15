package dux.org.hibernate.type;

import org.hibernate.type.CharacterArrayClobType;
import org.hibernate.type.PrimitiveCharacterArrayNClobType;
import org.hibernate.type.descriptor.java.CharacterArrayTypeDescriptor;
import org.hibernate.type.descriptor.java.PrimitiveCharacterArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.ClobTypeDescriptor;
import org.hibernate.type.descriptor.sql.NClobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PrimitiveCharacterArrayNClobTypeTest extends AbstractTest {
	@Test
	public void test() {

		CharacterArrayClobType instance = PrimitiveCharacterArrayNClobType.INSTANCE;
		an(instance.getName());
		aeqr(ClobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(CharacterArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

		PrimitiveCharacterArrayNClobType correctInstance = new PrimitiveCharacterArrayNClobType();
		an(correctInstance.getName());
		aeqr(NClobTypeDescriptor.DEFAULT, correctInstance.getSqlTypeDescriptor());
		aeqr(PrimitiveCharacterArrayTypeDescriptor.INSTANCE, correctInstance.getJavaTypeDescriptor());

	}
}
