package dux.org.springframework.security.access.annotation;

import java.lang.reflect.Method;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;

public class SecuredAnnotationSecurityMetadataSourceTest {

	private static class Foo {
		public void noAttribute() {

		}

		@Secured("a")
		public void secured() {

		}
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {

		SecuredAnnotationSecurityMetadataSource src = new SecuredAnnotationSecurityMetadataSource();

		Assert.assertNull(src.getAllConfigAttributes());

		Class<?> clazz = Foo.class;

		Method method = clazz.getMethod("noAttribute");
		Collection<ConfigAttribute> attributes = src.getAttributes(method, clazz);
		Assert.assertEquals(0, attributes.size());

		method = clazz.getMethod("secured");
		attributes = src.getAttributes(method, clazz);
		Assert.assertEquals(1, attributes.size());
		Assert.assertEquals("a", attributes.iterator().next().getAttribute());

	}
}
