package dux.org.hibernate.type;

import org.hibernate.type.CharacterArrayNClobType;
import org.hibernate.type.descriptor.java.CharacterArrayTypeDescriptor;
import org.hibernate.type.descriptor.sql.NClobTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CharacterArrayNClobTypeTest extends AbstractTest {
	
	@Test
	public void test() {

		CharacterArrayNClobType instance = CharacterArrayNClobType.INSTANCE;

		an(instance.getName());
		aeqr(NClobTypeDescriptor.DEFAULT, instance.getSqlTypeDescriptor());
		aeqr(CharacterArrayTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
