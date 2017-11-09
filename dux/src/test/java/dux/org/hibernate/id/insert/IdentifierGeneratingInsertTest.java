package dux.org.hibernate.id.insert;

import java.lang.reflect.Method;

import org.hibernate.dialect.Dialect;
import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.hibernate.sql.Insert;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IdentifierGeneratingInsertTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(Insert.class, IdentifierGeneratingInsert.class.getSuperclass());

		Dialect dialect = new Dialect() {
		};

		IdentifierGeneratingInsert igi = new IdentifierGeneratingInsert(dialect);

		Method m = Insert.class.getDeclaredMethod("getDialect");
		m.setAccessible(true);
		aeqr(dialect, m.invoke(igi));
	}
}
