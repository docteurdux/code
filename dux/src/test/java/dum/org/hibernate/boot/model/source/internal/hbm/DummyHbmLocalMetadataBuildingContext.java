package dum.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.hbm.spi.EntityInfo;
import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.boot.model.source.internal.hbm.HbmLocalMetadataBuildingContext;
import org.hibernate.boot.model.source.spi.ToolingHintContext;
import org.hibernate.boot.spi.ClassLoaderAccess;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.boot.spi.MappingDefaults;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.mapping.PersistentClass;

public class DummyHbmLocalMetadataBuildingContext implements HbmLocalMetadataBuildingContext {

	private MetadataBuildingOptions buildingOptions;
	private InFlightMetadataCollector metadataCollector;

	@Override
	public Origin getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetadataBuildingOptions getBuildingOptions() {
		return buildingOptions;
	}

	public void setBuildingOptions(MetadataBuildingOptions buildingOptions) {
		this.buildingOptions = buildingOptions;
	}

	@Override
	public MappingDefaults getMappingDefaults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InFlightMetadataCollector getMetadataCollector() {
		return metadataCollector;
	}

	public void setMetadataCollector(InFlightMetadataCollector metadataCollector) {
		this.metadataCollector = metadataCollector;
	}

	@Override
	public ClassLoaderAccess getClassLoaderAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectNameNormalizer getObjectNameNormalizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolingHintContext getToolingHintContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String determineEntityName(EntityInfo entityElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String determineEntityName(String entityName, String clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String qualifyClassName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentClass findEntityBinding(String entityName, String clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
