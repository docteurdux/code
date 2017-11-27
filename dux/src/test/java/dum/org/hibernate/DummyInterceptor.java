package dum.org.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;
import com.github.docteurdux.test.TestEventCollectorI;

public class DummyInterceptor extends EmptyInterceptor implements TestEventCollectorI {

	private static final long serialVersionUID = 1L;

	private List<TestEvent> testEvents;

	private TestEventCollector testEventCollector = new TestEventCollector() {
	};

	public DummyInterceptor() {
		testEvents = testEventCollector.getTestEvents();
	}

	@Override
	public TestEventCollector getTestEventCollector() {
		return testEventCollector;
	}

	@Override
	public void afterTransactionBegin(Transaction transaction) {
		testEvents.add(new TestEvent("afterTransactionBegin").prop("transaction", transaction));
		super.afterTransactionBegin(transaction);
	}

	@Override
	public void afterTransactionCompletion(Transaction transaction) {
		testEvents.add(new TestEvent("afterTransactionCompletion").prop("transaction", transaction));
		super.afterTransactionCompletion(transaction);
	}

	@Override
	public void beforeTransactionCompletion(Transaction transaction) {
		testEvents.add(new TestEvent("beforeTransactionCompletion").prop("transaction", transaction));
		super.beforeTransactionCompletion(transaction);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		testEvents.add(new TestEvent("findDirty").prop("entity", entity).prop("id", id)
				.prop("currentState", currentState).prop("previousState", previousState)
				.prop("propertyNames", propertyNames).prop("types", types));
		return super.findDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		testEvents.add(new TestEvent("getEntity").prop("entityName", entityName).prop("id", id));
		return super.getEntity(entityName, id);
	}

	@Override
	public String getEntityName(Object entity) {
		testEvents.add(new TestEvent("getEntityName").prop("entity", entity));
		return super.getEntityName(entity);
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
		testEvents.add(new TestEvent("instantiate").prop("entityName", entityName).prop("entityMode", entityMode)
				.prop("id", id));
		return super.instantiate(entityName, entityMode, id);
	}

	@Override
	public Boolean isTransient(Object entity) {
		testEvents.add(new TestEvent("isTransient").prop("entity", entity));
		return super.isTransient(entity);
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		testEvents.add(new TestEvent("onCollectionRecreate").prop("collection", collection).prop("key", key));
		super.onCollectionRecreate(collection, key);
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		testEvents.add(new TestEvent("onCollectionRemove").prop("collection", collection).prop("key", key));
		super.onCollectionRemove(collection, key);
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		testEvents.add(new TestEvent("onCollectionUpdate").prop("collection", collection).prop("key", key));
		super.onCollectionUpdate(collection, key);
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		testEvents.add(new TestEvent("onDelete").prop("entity", entity).prop("id", id).prop("state", state)
				.prop("propertyNames", propertyNames).prop("types", types));
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		testEvents.add(new TestEvent("onFlushDirty").prop("entity", entity).prop("id", id)
				.prop("currentState", currentState).prop("previousState", previousState)
				.prop("propertyNames", propertyNames).prop("types", types));
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		testEvents.add(new TestEvent("onLoad").prop("entity", entity).prop("id", id).prop("state", state)
				.prop("propertyNames", propertyNames).prop("types", types));
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		testEvents.add(new TestEvent("onPrepareStatement").prop("sql", sql));
		return super.onPrepareStatement(sql);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		testEvents.add(new TestEvent("onSave").prop("entity", entity).prop("id", id).prop("state", state)
				.prop("propertyNames", propertyNames).prop("types", types));
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		testEvents.add(new TestEvent("postFlush").prop("entities", entities));
		super.postFlush(entities);
	}

	@Override
	public void preFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		testEvents.add(new TestEvent("preFlush").prop("entities", entities));
		super.preFlush(entities);
	}

}
