package dum.org.hibernate.persister.entity;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.internal.FilterAliasGenerator;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.spi.PersisterCreationContext;
import org.hibernate.type.Type;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyAbstractEntityPersister extends AbstractEntityPersister {

	private RunnableWithArgs<String[]> getSubclassTableKeyColumnsRWA;
	private int[] subclassColumnTableNumberClosure;
	private RunnableWithArgs<String> getTableNameRWA;

	public DummyAbstractEntityPersister(PersistentClass persistentClass, EntityRegionAccessStrategy cacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy, PersisterCreationContext creationContext)
			throws HibernateException {
		super(persistentClass, cacheAccessStrategy, naturalIdRegionAccessStrategy, creationContext);
	}

	@Override
	public String getSubclassPropertyTableName(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fromTableFragment(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyTableName(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getDiscriminatorType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDiscriminatorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubclassForDiscriminatorValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable[] getPropertySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterAliasGenerator getFilterAliasGenerator(String rootAlias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDiscriminatorSQLValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getConstraintOrderedTableNameClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getContraintOrderedTableKeyColumnClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int[] getSubclassColumnTableNumberClosure() {
		return subclassColumnTableNumberClosure;
	}

	public void setSubclassColumnTableNumberClosure(int[] subclassColumnTableNumberClosure) {
		this.subclassColumnTableNumberClosure = subclassColumnTableNumberClosure;
	}

	@Override
	protected int[] getSubclassFormulaTableNumberClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubclassTableName(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getSubclassTableKeyColumns(int j) {
		if (getSubclassTableKeyColumnsRWA != null) {
			return getSubclassTableKeyColumnsRWA.run(j);
		}
		return null;
	}

	public void setGetSubclassTableKeyColumnsRWA(RunnableWithArgs<String[]> getSubclassTableKeyColumnsRWA) {
		this.getSubclassTableKeyColumnsRWA = getSubclassTableKeyColumnsRWA;
	}

	@Override
	protected boolean isClassOrSuperclassTable(int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSubclassTableSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getTableSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean isTableCascadeDeleteEnabled(int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getTableName(int j) {
		if (getTableNameRWA != null) {
			return getTableNameRWA.run(j);
		}
		return null;
	}

	public void setGetTableNameRWA(RunnableWithArgs<String> getTableNameRWA) {
		this.getTableNameRWA = getTableNameRWA;
	}

	@Override
	protected String[] getKeyColumns(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isPropertyOfTable(int property, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int[] getPropertyTableNumbersInSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int[] getPropertyTableNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getSubclassPropertyTableNumber(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected String filterFragment(String alias) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String filterFragment(String alias, Set<String> treatAsDeclarations) {
		// TODO Auto-generated method stub
		return null;
	}

}
