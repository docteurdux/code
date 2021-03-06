package dum.org.hibernate.boot.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.SharedCacheMode;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.annotations.common.reflection.ReflectionManager;
import org.hibernate.boot.CacheRegionDefinition;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;
import org.hibernate.boot.archive.scan.spi.ScanOptions;
import org.hibernate.boot.archive.spi.ArchiveDescriptorFactory;
import org.hibernate.boot.model.IdGeneratorStrategyInterpreter;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.spi.BasicTypeRegistration;
import org.hibernate.boot.spi.MappingDefaults;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.cache.spi.access.AccessType;
import org.hibernate.cfg.AttributeConverterDefinition;
import org.hibernate.cfg.MetadataSourceType;
import org.hibernate.dialect.function.SQLFunction;
import org.jboss.jandex.IndexView;

public class DummyMetadataBuildingOptions implements MetadataBuildingOptions {

	private StandardServiceRegistry serviceRegistry;
	private MappingDefaults mappingDefaults;
	private PhysicalNamingStrategy physicalNamingStrategy;
	private ImplicitNamingStrategy implicitNamingStrategy;
	private ReflectionManager reflectionManager;
	private ClassLoader tempClassLoader;
	private IdGeneratorStrategyInterpreter idGenerationTypeInterpreter;
	private Map<String, SQLFunction> sqlFunctions = new HashMap<>();
	private List<AuxiliaryDatabaseObject> auxiliaryDatabaseObjectList = new ArrayList<>();

	@Override
	public StandardServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	public void setServiceRegistry(StandardServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

	@Override
	public MappingDefaults getMappingDefaults() {
		return mappingDefaults;
	}

	public void setMappingDefaults(MappingDefaults mappingDefaults) {
		this.mappingDefaults = mappingDefaults;
	}

	@Override
	public List<BasicTypeRegistration> getBasicTypeRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexView getJandexView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanOptions getScanOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanEnvironment getScanEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getScanner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArchiveDescriptorFactory getArchiveDescriptorFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassLoader getTempClassLoader() {
		return tempClassLoader;
	}

	public void setTempClassLoader(ClassLoader tempClassLoader) {
		this.tempClassLoader = tempClassLoader;
	}

	@Override
	public ImplicitNamingStrategy getImplicitNamingStrategy() {
		return implicitNamingStrategy;
	}

	public void setImplicitNamingStrategy(ImplicitNamingStrategy implicitNamingStrategy) {
		this.implicitNamingStrategy = implicitNamingStrategy;
	}

	@Override
	public PhysicalNamingStrategy getPhysicalNamingStrategy() {
		return physicalNamingStrategy;
	}

	public void setPhysicalNamingStrategy(PhysicalNamingStrategy physicalNamingStrategy) {
		this.physicalNamingStrategy = physicalNamingStrategy;
	}

	@Override
	public ReflectionManager getReflectionManager() {
		return reflectionManager;
	}

	public void setReflectionManager(ReflectionManager reflectionManager) {
		this.reflectionManager = reflectionManager;
	}

	@Override
	public SharedCacheMode getSharedCacheMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessType getImplicitCacheAccessType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MultiTenancyStrategy getMultiTenancyStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdGeneratorStrategyInterpreter getIdGenerationTypeInterpreter() {
		return idGenerationTypeInterpreter;
	}

	public void setIdGenerationTypeInterpreter(IdGeneratorStrategyInterpreter idGenerationTypeInterpreter) {
		this.idGenerationTypeInterpreter = idGenerationTypeInterpreter;
	}

	@Override
	public List<CacheRegionDefinition> getCacheRegionDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ignoreExplicitDiscriminatorsForJoinedInheritance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createImplicitDiscriminatorsForJoinedInheritance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldImplicitlyForceDiscriminatorInSelect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean useNationalizedCharacterData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSpecjProprietarySyntaxEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MetadataSourceType> getSourceProcessOrdering() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SQLFunction> getSqlFunctions() {
		return sqlFunctions;
	}

	@Override
	public List<AuxiliaryDatabaseObject> getAuxiliaryDatabaseObjectList() {
		return auxiliaryDatabaseObjectList;
	}

	@Override
	public List<AttributeConverterDefinition> getAttributeConverters() {
		// TODO Auto-generated method stub
		return null;
	}

}
