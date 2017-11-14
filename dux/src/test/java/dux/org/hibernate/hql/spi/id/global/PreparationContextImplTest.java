package dux.org.hibernate.hql.spi.id.global;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import javassist.Modifier;

@Done
public class PreparationContextImplTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		// class is package scoped

		Class<?> clazz = Class.forName("org.hibernate.hql.spi.id.global.PreparationContextImpl");

		int modifiers = clazz.getModifiers();

		af(Modifier.isPublic(modifiers));
		af(Modifier.isProtected(modifiers));
		af(Modifier.isPrivate(modifiers));

	}
}
