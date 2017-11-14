package dum.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmHibernateMapping;
import org.hibernate.boot.model.source.internal.hbm.AbstractHbmSourceNode;
import org.hibernate.boot.model.source.internal.hbm.HbmLocalMetadataBuildingContext;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;

public class DummyAbstractHbmSourceNode extends AbstractHbmSourceNode {

	public DummyAbstractHbmSourceNode(MappingDocument sourceMappingDocument) {
		super(sourceMappingDocument);
	}

	@Override
	public MappingDocument sourceMappingDocument() {
		return super.sourceMappingDocument();
	}

	@Override
	public HbmLocalMetadataBuildingContext metadataBuildingContext() {
		return super.metadataBuildingContext();
	}

	@Override
	public Origin origin() {
		return super.origin();
	}

	@Override
	public JaxbHbmHibernateMapping mappingRoot() {
		return super.mappingRoot();
	}

}
