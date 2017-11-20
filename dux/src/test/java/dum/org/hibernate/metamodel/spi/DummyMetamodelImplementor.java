package dum.org.hibernate.metamodel.spi;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;

import org.hibernate.EntityNameResolver;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyMetamodelImplementor implements MetamodelImplementor {

	private Map<String, EntityPersister> entityPersisters = new HashMap<>();

	@Override
	public <X> EntityType<X> entity(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImportedClassName(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getImplementors(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> EntityType<X> entity(Class<X> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> ManagedType<X> managedType(Class<X> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X> EmbeddableType<X> embeddable(Class<X> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ManagedType<?>> getManagedTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EntityType<?>> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EmbeddableType<?>> getEmbeddables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryImplementor getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<EntityNameResolver> getEntityNameResolvers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister locateEntityPersister(Class byClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister locateEntityPersister(String byName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister entityPersister(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister entityPersister(String entityName) {
		return entityPersisters.get(entityName);
	}

	@Override
	public Map<String, EntityPersister> entityPersisters() {
		return entityPersisters;
	}

	@Override
	public CollectionPersister collectionPersister(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, CollectionPersister> collectionPersisters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getCollectionRolesByEntityParticipant(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAllEntityNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAllCollectionRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> EntityGraph<T> findEntityGraphByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<EntityGraph<? super T>> findEntityGraphsByType(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
