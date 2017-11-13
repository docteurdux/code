package dum.org.hibernate.tool.schema.internal.exec;

import java.io.Writer;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToWriter;

public class DummyScriptTargetOutputToWriter extends ScriptTargetOutputToWriter {

	public DummyScriptTargetOutputToWriter(Writer writer) {
		super(writer);
	}

	@Override
	public Writer writer() {
		return super.writer();
	}

}
