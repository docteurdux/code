package dux.org.hibernate.tool.schema.internal.exec;

import org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.tool.hbm2ddl.DummyImportSqlCommandExtractor;

@Done
public class ScriptSourceInputNonExistentImplTest extends AbstractTest {

	private DummyImportSqlCommandExtractor ignoredCommandExtractor;

	@Before
	public void before() {
		ignoredCommandExtractor = new DummyImportSqlCommandExtractor();
	}

	@Test
	public void test() {

		ScriptSourceInputNonExistentImpl instance = ScriptSourceInputNonExistentImpl.INSTANCE;

		// does nothing
		instance.prepare();

		aeq(0, instance.read(ignoredCommandExtractor).size());

		// does nothing
		instance.release();
	}
}
