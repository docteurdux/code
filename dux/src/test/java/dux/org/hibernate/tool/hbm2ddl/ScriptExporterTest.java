package dux.org.hibernate.tool.hbm2ddl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hibernate.tool.hbm2ddl.DummyScriptExporter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ScriptExporterTest extends AbstractTest {

	private ByteArrayOutputStream baos;
	private PrintStream out;

	@Before
	public void before() {
		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);
	}

	@Test
	public void test() throws Exception {

		DummyScriptExporter scriptExporter = new DummyScriptExporter();

		af(scriptExporter.acceptsImportScripts());

		System.setOut(out);
		try {
			scriptExporter.export("string");
		} finally {
			System.setOut(null);
		}
		aeq("string\r\n", new String(baos.toByteArray()));

		// does nothing
		scriptExporter.release();

	}
}
