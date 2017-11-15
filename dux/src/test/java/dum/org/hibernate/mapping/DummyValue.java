package dum.org.hibernate.mapping;

import java.util.Iterator;

import org.hibernate.FetchMode;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.Table;
import org.hibernate.mapping.Value;
import org.hibernate.mapping.ValueVisitor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class DummyValue implements Value {

	private static final long serialVersionUID = 1L;

	private Type type;

	private boolean[] columnInsertability = new boolean[] {};

	private boolean[] columnUpdateability = new boolean[] {};

	@Override
	public int getColumnSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Selectable> getColumnIterator() {
		// TODO Auto-generated method stub
		return null;
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
		return columnUpdateability;
	}

	public void setColumnUpdateability(boolean[] columnUpdateability) {
		this.columnUpdateability = columnUpdateability;
	}

	@Override
	public boolean[] getColumnInsertability() {
		return columnInsertability;
	}

	public void setColumnInsertability(boolean[] columnInsertability) {
		this.columnInsertability = columnInsertability;
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

}
