package dum.org.hibernate.tool.hbm2ddl;

import java.io.Reader;

import org.hibernate.tool.hbm2ddl.ImportSqlCommandExtractor;

public class DummyImportSqlCommandExtractor implements ImportSqlCommandExtractor {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] extractCommands(Reader reader) {
		return null;
	}

}
