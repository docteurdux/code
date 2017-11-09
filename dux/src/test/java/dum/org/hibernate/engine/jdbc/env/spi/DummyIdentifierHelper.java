package dum.org.hibernate.engine.jdbc.env.spi;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelper;

public class DummyIdentifierHelper implements IdentifierHelper {

	@Override
	public Identifier normalizeQuoting(Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier toIdentifier(String text) {
		System.out.println(text);
		return null;
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
