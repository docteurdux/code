package dux.org.hibernate.metamodel.internal;

import java.lang.reflect.Modifier;

import org.hibernate.metamodel.internal.MapMember;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MapMemberTest extends AbstractTest {
	private String name;
	private Class<Object> type;

	@Before
	public void before() {
		name = "name";
		type = Object.class;
	}

	@Test
	public void test() {

		MapMember mapMember = new MapMember(name, type);

		aeq(name, mapMember.getName());
		aeq(type, mapMember.getType());

		aeq(Modifier.PUBLIC, mapMember.getModifiers());
		aeq(false, mapMember.isSynthetic());
		aeq(null, mapMember.getDeclaringClass());
	}
}
