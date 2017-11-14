package dux.org.hibernate.hql.spi.id.persistent;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PreparationContextImplTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		Class<?> clazz = Class.forName("org.hibernate.hql.spi.id.persistent.PreparationContextImpl");

		at(isPackage(clazz));
	}
}
