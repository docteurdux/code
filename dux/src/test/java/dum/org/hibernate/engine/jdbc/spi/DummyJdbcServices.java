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
	private SqlExceptionHelper sqlExceptionHelper;
	private SqlStatementLogger sqlStatementLogger;
	private Dialect dialect;
	private JdbcConnectionAccess bootstrapJdbcConnectionAccess;
	private JdbcEnvironment jdbcEnvironment;
	private ExtractedDatabaseMetaData extractedMetaDataSupport;
	private ResultSetWrapper resultSetWrapper;

	public JdbcEnvironment getJdbcEnvironment() {
		return jdbcEnvironment;
	}

	public JdbcConnectionAccess getBootstrapJdbcConnectionAccess() {
		return bootstrapJdbcConnectionAccess;
	}

	public Dialect getDialect() {
		if (dialect == null && jdbcEnvironment != null) {
			return jdbcEnvironment.getDialect();
		}
		return dialect;
	}

	public SqlStatementLogger getSqlStatementLogger() {
		return sqlStatementLogger;
	}
	
	public void setSqlStatementLogger(SqlStatementLogger sqlStatementLogger) {
		this.sqlStatementLogger = sqlStatementLogger;
	}

	public SqlExceptionHelper getSqlExceptionHelper() {
		return sqlExceptionHelper;
	}

	public void setSqlExceptionHelper(SqlExceptionHelper sqlExceptionHelper) {
		this.sqlExceptionHelper = sqlExceptionHelper;
	}

	public ExtractedDatabaseMetaData getExtractedMetaDataSupport() {
		return extractedMetaDataSupport;
	}

	public LobCreator getLobCreator(LobCreationContext lobCreationContext) {
		return lobCreator;
	}

	public ResultSetWrapper getResultSetWrapper() {
		return resultSetWrapper;
	}

	public void setLobCreator(LobCreator lobCreator) {
		this.lobCreator = lobCreator;
	}

	

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public void setBootstrapJdbcConnectionAccess(JdbcConnectionAccess bootstrapJdbcConnectionAccess) {
		this.bootstrapJdbcConnectionAccess = bootstrapJdbcConnectionAccess;
	}

	public void setJdbcEnvironment(JdbcEnvironment jdbcEnvironment) {
		this.jdbcEnvironment = jdbcEnvironment;
	}

	public void setExtractedMetaDataSupport(ExtractedDatabaseMetaData extractedMetaDataSupport) {
		this.extractedMetaDataSupport = extractedMetaDataSupport;
	}

	public void setResultSetWrapper(ResultSetWrapper resultSetWrapper) {
		this.resultSetWrapper = resultSetWrapper;
	}

}
