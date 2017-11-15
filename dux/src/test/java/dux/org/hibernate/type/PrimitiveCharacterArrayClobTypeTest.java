package dux.org.hibernate.type;

import org.hibernate.type.CharacterArrayClobType;
import org.hibernate.type.PrimitiveCharacterArrayClobType;
import org.hibernate.type.descriptor.java.CharacterArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.ClobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PrimitiveCharacterArrayClobTypeTest extends AbstractTest {

	@Test
	public void test() {
		CharacterArrayClobType instance = PrimitiveCharacterArrayClobType.INSTANCE;
		an(instance.getName());
		aeqr(ClobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(CharacterArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
