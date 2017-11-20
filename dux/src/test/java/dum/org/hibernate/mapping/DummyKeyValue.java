package dum.org.hibernate.mapping;

import java.util.Iterator;

import org.hibernate.FetchMode;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.mapping.KeyValue;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.Table;
import org.hibernate.mapping.ValueVisitor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class DummyKeyValue implements KeyValue {

	private static final long serialVersionUID = 1L;
	private Iterator<Selectable> columnIterator;
	private Type type;
	private int columnSpan;

	@Override
	public int getColumnSpan() {
		return columnSpan;
	}

	public void setColumnSpan(int columnSpan) {
		this.columnSpan = columnSpan;
	}

	@Override
	public Iterator<Selectable> getColumnIterator() {
		return columnIterator;
	}

	public void setColumnIterator(Iterator<Selectable> columnIterator) {
		this.columnIterator = columnIterator;
	}

	@Override
	public Type getType() throws MappingException {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public FetchMode getFetchMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasFormula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlternateUniqueKey() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNullable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean[] getColumnUpdateability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getColumnInsertability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createForeignKey() throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSimpleValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(Mapping mapping) throws MappingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTypeUsingReflection(String className, String propertyName) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object accept(ValueVisitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRegistry getServiceRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentifierGenerator createIdentifierGenerator(IdentifierGeneratorFactory identifierGeneratorFactory,
			Dialect dialect, String defaultCatalog, String defaultSchema, RootClass rootClass) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIdentityColumn(IdentifierGeneratorFactory identifierGeneratorFactory, Dialect dialect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createForeignKeyOfEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCascadeDeleteEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNullValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUpdateable() {
		// TODO Auto-generated method stub
		return false;
	}

}
