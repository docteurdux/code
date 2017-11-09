package dux.org.hibernate.boot;

import org.hibernate.boot.JaccPermissionDefinition;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaccPermissionDefinitionTest extends AbstractTest {
	@Test
	public void test() {

		String contextId = "contextId";
		String role = "role";
		String clazz = "clazz";
		String actions = "actions";

		JaccPermissionDefinition jpd = new JaccPermissionDefinition(contextId, role, clazz, actions);

		aeq(jpd.contextId, contextId);
		aeq(jpd.role, role);
		aeq(jpd.clazz, clazz);
		aeq(jpd.actions, actions);
	}
}
