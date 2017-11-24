package dum.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmRootEntityType;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.hibernate.boot.model.source.internal.hbm.RootEntitySourceImpl;

public class DummyRootEntitySourceImpl extends RootEntitySourceImpl {

	public DummyRootEntitySourceImpl(MappingDocument sourceMappingDocument, JaxbHbmRootEntityType entityElement) {
		super(sourceMappingDocument, entityElement);
	}

}
