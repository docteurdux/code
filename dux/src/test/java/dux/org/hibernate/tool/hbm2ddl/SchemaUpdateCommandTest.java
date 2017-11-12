package dux.org.hibernate.tool.hbm2ddl;

import org.hibernate.tool.hbm2ddl.SchemaUpdateCommand;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class SchemaUpdateCommandTest extends AbstractTest {
	@Test
	public void test() {

		String sql = "sql";
		boolean quiet = false;

		SchemaUpdateCommand suc = new SchemaUpdateCommand(sql, quiet);

		aeq(sql, suc.getSql());
		aeq(quiet, suc.isQuiet());
	}
}
