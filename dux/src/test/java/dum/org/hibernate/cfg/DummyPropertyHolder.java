package dum.org.hibernate.cfg;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.boot.spi.AttributeConverterDescriptor;
import org.hibernate.cfg.Ejb3Column;
import org.hibernate.cfg.PropertyHolder;
import org.hibernate.mapping.Join;
import org.hibernate.mapping.KeyValue;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Table;

public class DummyPropertyHolder implements PropertyHolder {

	private String path;
	private PersistentClass persistentClass;

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityOwnerClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProperty(Property prop, XClass declaringClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProperty(Property prop, Ejb3Column[] columns, XClass declaringClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public KeyValue getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOrWithinEmbeddedId() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWithinElementCollection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersistentClass getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(PersistentClass persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public boolean isComponent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEntity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setParentProperty(String parentProperty) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Column[] getOverriddenColumn(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JoinColumn[] getOverriddenJoinColumn(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JoinTable getJoinTable(XProperty property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Join addJoin(JoinTable joinTableAnn, boolean noDelayInPkColumnCreation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInIdClass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInIdClass(Boolean isInIdClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startingProperty(XProperty property) {
		// TODO Auto-generated method stub

	}

	@Override
	public AttributeConverterDescriptor resolveAttributeConverterDescriptor(XProperty property) {
		// TODO Auto-generated method stub
		return null;
	}

}
