package org.hibernate.mapping;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.boot.spi.MetadataBuildingContext;

public class DummyPersistentClass extends PersistentClass {

	private static final long serialVersionUID = 1L;
	private RootClass rootClass;
	private KeyValue identifier;
	private Iterator propertyClosureIterator;
	private Table rootTable;
	private Property identifierProperty;

	public DummyPersistentClass(MetadataBuildingContext metadataBuildingContext) {
		super(metadataBuildingContext);
	}

	@Override
	int nextSubclassId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSubclassId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasIdentifierProperty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Property getIdentifierProperty() {
		return identifierProperty;
	}

	public void setIdentifierProperty(Property identifierProperty) {
		this.identifierProperty = identifierProperty;
	}

	@Override
	public Property getDeclaredIdentifierProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyValue getIdentifier() {
		return identifier;
	}

	public void setIdentifier(KeyValue identifier) {
		this.identifier = identifier;
	}

	@Override
	public Property getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property getDeclaredVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value getDiscriminator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInherited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPolymorphic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVersioned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNaturalIdCacheRegionName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCacheConcurrencyStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentClass getSuperclass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExplicitPolymorphism() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDiscriminatorInsertable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator getPropertyClosureIterator() {
		return getPropertyIterator();
	}

	@Deprecated
	public void setPropertyClosureIterator(Iterator propertyClosureIterator) {
		this.propertyClosureIterator = propertyClosureIterator;
	}

	@Override
	public Iterator getTableClosureIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getKeyClosureIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEmbeddedIdentifier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class getEntityPersisterClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityPersisterClass(Class classPersisterClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public Table getRootTable() {
		return rootTable;
	}

	public void setRootTable(Table rootTable) {
		this.rootTable = rootTable;
	}

	@Override
	public RootClass getRootClass() {
		return rootClass;
	}

	public void setRootClass(RootClass rootClass) {
		this.rootClass = rootClass;
	}

	@Override
	public KeyValue getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWhere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJoinedSubclass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set getSynchronizedTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object accept(PersistentClassVisitor mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLazyPropertiesCacheable() {
		// TODO Auto-generated method stub
		return false;
	}

}
