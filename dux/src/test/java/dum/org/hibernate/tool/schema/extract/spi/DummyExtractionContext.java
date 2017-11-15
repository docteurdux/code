package dum.org.hibernate.tool.schema.extract.spi;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;

public class DummyExtractionContext implements ExtractionContext {

	@Override
	public ServiceRegistry getServiceRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcEnvironment getJdbcEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getJdbcConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatabaseMetaData getJdbcDatabaseMetaData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier getDefaultCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier getDefaultSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatabaseObjectAccess getDatabaseObjectAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
