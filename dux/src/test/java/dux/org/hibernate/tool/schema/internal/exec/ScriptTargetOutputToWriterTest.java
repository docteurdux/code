package dux.org.hibernate.tool.schema.internal.exec;

import org.hibernate.tool.schema.spi.SchemaManagementException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.io.DummyWriter;
import dum.org.hibernate.tool.schema.internal.exec.DummyScriptTargetOutputToWriter;

@Done
public class ScriptTargetOutputToWriterTest extends AbstractTest {

	private DummyWriter writer;

	@Before
	public void before() {
		writer = new DummyWriter();
	}

	@Test
	public void test1() {
		DummyScriptTargetOutputToWriter stotw = new DummyScriptTargetOutputToWriter(writer);
		aeqr(writer, stotw.writer());
	}

	@Test(expected = SchemaManagementException.class)
	public void test2() {
		DummyScriptTargetOutputToWriter stotw = new DummyScriptTargetOutputToWriter(null);
	}
}
