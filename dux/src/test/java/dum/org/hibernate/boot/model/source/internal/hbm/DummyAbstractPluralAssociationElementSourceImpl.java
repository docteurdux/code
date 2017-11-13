package dum.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.hibernate.boot.model.source.spi.PluralAttributeSource;

public class DummyAbstractPluralAssociationElementSourceImpl extends AbstractPluralAssociationElementSourceImpl {

	public DummyAbstractPluralAssociationElementSourceImpl(MappingDocument mappingDocument,
			PluralAttributeSource pluralAttributeSource) {
		super(mappingDocument, pluralAttributeSource);
	}

	@Override
	public String getReferencedEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIgnoreNotFound() {
		// TODO Auto-generated method stub
		return false;
	}

}
