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
	private SqlExceptionHelper sqlExceptionHelper;
	private ExtractedDatabaseMetaData extractedDatabaseMetaData;
	private LobCreatorBuilder lobCreatorBuilder;
	private QualifiedObjectNameFormatter qualifiedObjectNameFormatter;

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	@Override
	public ExtractedDatabaseMetaData getExtractedDatabaseMetaData() {
		return extractedDatabaseMetaData;
	}

	public void setExtractedDatabaseMetaData(ExtractedDatabaseMetaData extractedDatabaseMetaData) {
		this.extractedDatabaseMetaData = extractedDatabaseMetaData;
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
		return qualifiedObjectNameFormatter;
	}

	public void setQualifiedObjectNameFormatter(QualifiedObjectNameFormatter qualifiedObjectNameFormatter) {
		this.qualifiedObjectNameFormatter = qualifiedObjectNameFormatter;
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
		return sqlExceptionHelper;
	}

	public void setSqlExceptionHelper(SqlExceptionHelper sqlExceptionHelper) {
		this.sqlExceptionHelper = sqlExceptionHelper;
	}

	@Override
	public LobCreatorBuilder getLobCreatorBuilder() {
		return lobCreatorBuilder;
	}

	public void setLobCreatorBuilder(LobCreatorBuilder lobCreatorBuilder) {
		this.lobCreatorBuilder = lobCreatorBuilder;
	}

	@Override
	public TypeInfo getTypeInfoForJdbcCode(int jdbcTypeCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
