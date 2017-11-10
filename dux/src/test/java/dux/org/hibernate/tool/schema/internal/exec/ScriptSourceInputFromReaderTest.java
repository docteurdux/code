package dux.org.hibernate.tool.schema.internal.exec;

import org.hibernate.tool.schema.internal.exec.AbstractScriptSourceInput;
import org.hibernate.tool.schema.internal.exec.ScriptSourceInputFromReader;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.io.DummyReader;

@Done
public class ScriptSourceInputFromReaderTest extends AbstractTest {

	private DummyReader reader;

	@Before
	public void before() {
		reader = new DummyReader();
	}

	@Test
	public void test() throws Exception {

		aeq(AbstractScriptSourceInput.class, ScriptSourceInputFromReader.class.getSuperclass());

		ScriptSourceInputFromReader ssifr = new ScriptSourceInputFromReader(reader);

		aeqr(reader, invoke(ssifr, "reader"));
		aeq("ScriptSourceInputFromReader()", ssifr.toString());
	}
}
