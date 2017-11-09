package dum.org.hibernate.engine.jdbc.env.spi;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelper;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.engine.jdbc.env.spi.QualifiedObjectNameFormatter;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.TypeInfo;

public class DummyJdbcEnvironment implements JdbcEnvironment {

	private static final long serialVersionUID = 1L;
	private IdentifierHelper identifierHelper;
	private Dialect dialect;

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	@Override
	public ExtractedDatabaseMetaData getExtractedDatabaseMetaData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier getCurrentCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier getCurrentSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QualifiedObjectNameFormatter getQualifiedObjectNameFormatter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentifierHelper getIdentifierHelper() {
		return identifierHelper;
	}

	public void setIdentifierHelper(IdentifierHelper identifierHelper) {
		this.identifierHelper = identifierHelper;
	}

	@Override
	public NameQualifierSupport getNameQualifierSupport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlExceptionHelper getSqlExceptionHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LobCreatorBuilder getLobCreatorBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeInfo getTypeInfoForJdbcCode(int jdbcTypeCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
