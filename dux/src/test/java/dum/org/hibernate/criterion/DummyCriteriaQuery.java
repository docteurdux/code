package dum.org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.TypedValue;
import org.hibernate.type.Type;

import com.github.docteurdux.test.hibernate.ColumnGetter;

public class DummyCriteriaQuery implements CriteriaQuery {

	private ColumnGetter columnGetter;

	@Override
	public SessionFactoryImplementor getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumn(Criteria criteria, String propertyPath) throws HibernateException {
		return columnGetter.get(criteria, propertyPath);
	}

	public void setColumnGetter(ColumnGetter columnGetter) {
		this.columnGetter = columnGetter;
	}

	@Override
	public String[] getColumns(String propertyPath, Criteria criteria) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] findColumns(String propertyPath, Criteria criteria) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType(Criteria criteria, String propertyPath) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getColumnsUsingProjection(Criteria criteria, String propertyPath) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getTypeUsingProjection(Criteria criteria, String propertyPath) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypedValue getTypedValue(Criteria criteria, String propertyPath, Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName(Criteria criteria, String propertyPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQLAlias(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQLAlias(Criteria criteria, String propertyPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyName(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIdentifierColumns(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getIdentifierType(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypedValue getTypedIdentifierValue(Criteria criteria, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateSQLAlias() {
		// TODO Auto-generated method stub
		return null;
	}

}
