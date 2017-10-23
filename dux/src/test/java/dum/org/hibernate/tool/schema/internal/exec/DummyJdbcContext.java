package dum.org.hibernate.tool.schema.internal.exec;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.schema.internal.exec.JdbcContext;

public class DummyJdbcContext implements JdbcContext {

	private JdbcConnectionAccess jdbcConnectionAccess;
	private SqlExceptionHelper sqlExceptionHelper;

	@Override
	public JdbcConnectionAccess getJdbcConnectionAccess() {
		return jdbcConnectionAccess;
	}

	public void setJdbcConnectionAccess(JdbcConnectionAccess jdbcConnectionAccess) {
		this.jdbcConnectionAccess = jdbcConnectionAccess;
	}

	@Override
	public Dialect getDialect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlStatementLogger getSqlStatementLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlExceptionHelper getSqlExceptionHelper() {
		return sqlExceptionHelper;
	}

	public void setSqlExceptionHelper(SqlExceptionHelper sqlExceptionHelper) {
		this.sqlExceptionHelper = sqlExceptionHelper;
	}

	@Override
	public ServiceRegistry getServiceRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

}
