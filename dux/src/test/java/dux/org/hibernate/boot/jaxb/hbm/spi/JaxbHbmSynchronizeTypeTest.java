package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmSynchronizeType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmSynchronizeTypeTest extends AbstractTest {

	@Test
	public void test() {

		JaxbHbmSynchronizeType jaxbHbmSynchronizeType = new JaxbHbmSynchronizeType();

		an(jaxbHbmSynchronizeType.getTable());
		jaxbHbmSynchronizeType.setTable("table");
		aeq("table", jaxbHbmSynchronizeType.getTable());
	}
}
