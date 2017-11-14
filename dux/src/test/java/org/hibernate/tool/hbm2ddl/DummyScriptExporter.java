package org.hibernate.tool.hbm2ddl;

@SuppressWarnings("deprecation")
public class DummyScriptExporter implements Exporter {

	private ScriptExporter instance = new ScriptExporter();

	@Override
	public boolean acceptsImportScripts() {
		return instance.acceptsImportScripts();
	}

	@Override
	public void export(String string) throws Exception {
		instance.export(string);
	}

	@Override
	public void release() throws Exception {
		instance.release();
	}

}
