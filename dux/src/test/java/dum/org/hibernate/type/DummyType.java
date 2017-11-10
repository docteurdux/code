package dum.org.hibernate.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.ForeignKeyDirection;
import org.hibernate.type.Type;

public class DummyType implements Type {

	@Override
	public boolean isAssociationType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCollectionType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEntityType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAnyType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComponentType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getColumnSpan(Mapping mapping) throws MappingException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] sqlTypes(Mapping mapping) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size[] dictatedSizes(Mapping mapping) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size[] defaultSizes(Mapping mapping) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getReturnedClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSame(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(Object x, Object y, SessionFactoryImplementor factory) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHashCode(Object x, SessionFactoryImplementor factory) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Object x, Object y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDirty(Object old, Object current, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirty(Object oldState, Object currentState, boolean[] checkable,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified(Object dbState, Object currentState, boolean[] checkable,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String name, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, boolean[] settable,
			SharedSessionContractImplementor session) throws HibernateException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String toLoggableString(Object value, SessionFactoryImplementor factory) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deepCopy(Object value, SessionFactoryImplementor factory) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beforeAssemble(Serializable cached, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object hydrate(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object resolve(Object value, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object semiResolve(Object value, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getSemiResolvedType(SessionFactoryImplementor factory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner,
			Map copyCache) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner,
			Map copyCache, ForeignKeyDirection foreignKeyDirection) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] toColumnNullness(Object value, Mapping mapping) {
		// TODO Auto-generated method stub
		return null;
	}

}
