package dux.org.hibernate.boot.model.naming;

import org.hibernate.boot.model.naming.DatabaseIdentifier;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DatabaseIdentifierTest extends AbstractTest {

	@Test
	public void test() {

		an(DatabaseIdentifier.toIdentifier(null));
		an(DatabaseIdentifier.toIdentifier(""));

		aeq("name", DatabaseIdentifier.toIdentifier("`name`").getText());
		aeq("name", DatabaseIdentifier.toIdentifier("[name]").getText());
		aeq("name", DatabaseIdentifier.toIdentifier("\"name\"").getText());

		aeq("name", DatabaseIdentifier.toIdentifier("name").getText());

	}
}
