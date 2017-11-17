package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmClassRenameType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmClassRenameTypeTest extends AbstractTest {
	@Test
	public void test() {
		JaxbHbmClassRenameType jaxbHbmClassRenameType = new JaxbHbmClassRenameType();

		aeq(null, jaxbHbmClassRenameType.getClazz());
		jaxbHbmClassRenameType.setClazz("clazz");
		aeq("clazz", jaxbHbmClassRenameType.getClazz());

		aeq(null, jaxbHbmClassRenameType.getRename());
		jaxbHbmClassRenameType.setRename("rename");
		aeq("rename", jaxbHbmClassRenameType.getRename());
	}
}
