package dum.org.hibernate.boot.model.naming;

import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.boot.spi.MetadataBuildingContext;

public class DummyObjectNameNormalizer extends ObjectNameNormalizer {

	private MetadataBuildingContext metadataBuildingContext;

	@Override
	protected MetadataBuildingContext getBuildingContext() {
		return metadataBuildingContext;
	}

	public void setMetadataBuildingContext(MetadataBuildingContext metadataBuildingContext) {
		this.metadataBuildingContext = metadataBuildingContext;
	}

}
