package dum.org.hibernate.engine.jdbc.spi;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.LobCreationContext;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.ResultSetWrapper;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;

public class DummyJdbcServices implements JdbcServices {

	private static final long serialVersionUID = 1L;
	private LobCreator lobCreator;

	public JdbcEnvironment getJdbcEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcConnectionAccess getBootstrapJdbcConnectionAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dialect getDialect() {
		// TODO Auto-generated method stub
		return null;
	}

	public SqlStatementLogger getSqlStatementLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public SqlExceptionHelper getSqlExceptionHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExtractedDatabaseMetaData getExtractedMetaDataSupport() {
		// TODO Auto-generated method stub
		return null;
	}

	public LobCreator getLobCreator(LobCreationContext lobCreationContext) {
		return lobCreator;
	}

	public ResultSetWrapper getResultSetWrapper() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLobCreator(LobCreator lobCreator) {
		this.lobCreator = lobCreator;
	}

}
