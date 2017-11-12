package dum.org.hibernate.boot.spi;

import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.boot.spi.ClassLoaderAccess;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.boot.spi.MappingDefaults;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.boot.spi.MetadataBuildingOptions;

public class DummyMetadataBuildingContext implements MetadataBuildingContext {

	private InFlightMetadataCollector metadataCollector;
	private ObjectNameNormalizer objectNameNormalizer;
	private MetadataBuildingOptions buildingOptions;
	private ClassLoaderAccess classLoaderAccess;

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
		return classLoaderAccess;
	}

	public void setClassLoaderAccess(ClassLoaderAccess classLoaderAccess) {
		this.classLoaderAccess = classLoaderAccess;
	}

	@Override
	public ObjectNameNormalizer getObjectNameNormalizer() {
		return objectNameNormalizer;
	}

	public void setObjectNameNormalizer(ObjectNameNormalizer objectNameNormalizer) {
		this.objectNameNormalizer = objectNameNormalizer;
	}

}
