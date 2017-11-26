package dum.org.hibernate.engine.jdbc.env.spi;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.env.spi.SQLStateType;
import org.hibernate.engine.jdbc.spi.TypeInfo;

public class DummyExtractedDatabaseMetaData implements ExtractedDatabaseMetaData {

	@Override
	public JdbcEnvironment getJdbcEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConnectionCatalogName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConnectionSchemaName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashSet<TypeInfo> getTypeInfoSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getExtraKeywords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsNamedParameters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsRefCursors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsScrollableResults() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGetGeneratedKeys() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsBatchUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDataDefinitionInTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doesDataDefinitionCauseTransactionCommit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SQLStateType getSqlStateType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesLobLocatorUpdateCopy() {
		// TODO Auto-generated method stub
		return false;
	}

}
