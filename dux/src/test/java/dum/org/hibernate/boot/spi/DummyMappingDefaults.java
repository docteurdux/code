package dum.org.hibernate.boot.spi;

import org.hibernate.boot.spi.MappingDefaults;
import org.hibernate.cache.spi.access.AccessType;

public class DummyMappingDefaults implements MappingDefaults {

	private String implicitCatalogName;
	private String implicitSchemaName;

	@Override
	public String getImplicitSchemaName() {
		return implicitSchemaName;
	}

	public void setImplicitSchemaName(String implicitSchemaName) {
		this.implicitSchemaName = implicitSchemaName;
	}

	@Override
	public String getImplicitCatalogName() {
		return implicitCatalogName;
	}

	public void setImplicitCatalogName(String implicitCatalogName) {
		this.implicitCatalogName = implicitCatalogName;
	}

	@Override
	public boolean shouldImplicitlyQuoteIdentifiers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getImplicitIdColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImplicitTenantIdColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImplicitDiscriminatorColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImplicitPackageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoImportEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getImplicitCascadeStyleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImplicitPropertyAccessorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areEntitiesImplicitlyLazy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areCollectionsImplicitlyLazy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccessType getImplicitCacheAccessType() {
		// TODO Auto-generated method stub
		return null;
	}

}
