package dux.org.hibernate.secure.spi;

import org.hibernate.secure.spi.GrantedPermission;
import org.hibernate.secure.spi.PermissibleAction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class GrantedPermissionTest extends AbstractTest {
	private String role;
	private String entityName;
	private String action;

	@Before
	public void before() {
		role = "role";
		entityName = "entityName";
		action = "*";
	}

	@Test
	public void test() {

		GrantedPermission grantedPermission = new GrantedPermission(role, entityName, action);

		aeq(role, grantedPermission.getRole());
		aeq(entityName, grantedPermission.getEntityName());
		aeq(PermissibleAction.ANY, grantedPermission.getPermissibleAction());

	}
}
