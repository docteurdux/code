package dux.java.security;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(Principal.class)
public class PrincipalTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * A java.security.Principal basically just has a name, and must implement
		 * equals and hashCode correctly because they will be use as keys in sets and
		 * maps ; default hashCode and equals behavior is object identity as usual
		 */

		Principal p = new Principal() {
			@Override
			public String getName() {
				return "name";
			}
		};

		aeq("name", p.getName());

		/*
		 * Additionally, the default method implies(Subject) checks whether the
		 * principal is in the list of the principals of some subject
		 */
		Set<Principal> principals = new HashSet<>();
		principals.add(p);
		Subject subject = new Subject(true, principals, new HashSet<>(), new HashSet<>());
		aeq(true, p.implies(subject));

	}
}
