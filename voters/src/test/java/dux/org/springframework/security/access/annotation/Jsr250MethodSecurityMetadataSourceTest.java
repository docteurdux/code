package dux.org.springframework.security.access.annotation;

import java.lang.reflect.Method;
import java.util.Collection;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.Jsr250MethodSecurityMetadataSource;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;

public class Jsr250MethodSecurityMetadataSourceTest {

	private static class Foo {
		@DenyAll
		public void deny() {
		}

		@PermitAll
		public void permit() {
		}

		@RolesAllowed("ROLE_A")
		public void roleA() {
		}

		@RolesAllowed(value = "A")
		public void a() {
		}
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {


		Jsr250MethodSecurityMetadataSource src = new Jsr250MethodSecurityMetadataSource();
		Assert.assertNull(src.getAllConfigAttributes());

		Class<Foo> clazz = Foo.class;

		Method method = clazz.getMethod("deny");
		Collection<ConfigAttribute> attributes = src.getAttributes(method, clazz);
		Assert.assertEquals(Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE.getAttribute(),
				attributes.iterator().next().getAttribute());

		method = clazz.getMethod("permit");
		attributes = src.getAttributes(method, clazz);
		Assert.assertEquals(Jsr250SecurityConfig.PERMIT_ALL_ATTRIBUTE.getAttribute(),
				attributes.iterator().next().getAttribute());

		method = clazz.getMethod("roleA");
		attributes = src.getAttributes(method, clazz);
		Assert.assertEquals("ROLE_A", attributes.iterator().next().getAttribute());

		method = clazz.getMethod("a");
		attributes = src.getAttributes(method, clazz);
		Assert.assertEquals("ROLE_A", attributes.iterator().next().getAttribute());

		src.setDefaultRolePrefix(null);

		method = clazz.getMethod("a");
		attributes = src.getAttributes(method, clazz);
		Assert.assertEquals("A", attributes.iterator().next().getAttribute());
	}

}
