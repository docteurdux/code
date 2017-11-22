package dum.org.hibernate.engine.jdbc.env.spi;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelper;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyIdentifierHelper implements IdentifierHelper {

	private RunnableWithArgs<Identifier> toIdentifierRWA;

	@Override
	public Identifier normalizeQuoting(Identifier identifier) {
		return identifier;
	}

	@Override
	public Identifier toIdentifier(String text) {
		if (toIdentifierRWA != null) {
			return toIdentifierRWA.run(text);
		}
		return null;
	}

	public void setToIdentifierRWA(RunnableWithArgs<Identifier> toIdentifierRWA) {
		this.toIdentifierRWA = toIdentifierRWA;
	}

	@Override
	public Identifier toIdentifier(String text, boolean quoted) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier applyGlobalQuoting(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReservedWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toMetaDataCatalogName(Identifier catalogIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMetaDataSchemaName(Identifier schemaIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMetaDataObjectName(Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

}
