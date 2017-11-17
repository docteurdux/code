package dux.org.hibernate.loader.criteria;

import java.io.Serializable;

import org.hibernate.loader.criteria.DummyEntityCriteriaInfoProvider;
import org.hibernate.type.Type;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.persister.entity.DummyQueryable;
import dum.org.hibernate.type.DummyType;

@Done
public class EntityCriteriaInfoProviderTest extends AbstractTest {

	private String entityName;
	private String relativePath;

	private DummyType type;

	private Serializable[] querySpaces;

	private RunnableWithArgs<Type> toTypeRWA;

	private DummyQueryable queryable;

	@Before
	public void before() {

		entityName = "entityName";
		relativePath = "relativePath";

		type = new DummyType();

		querySpaces = new Serializable[] {};

		toTypeRWA = new RunnableWithArgs<Type>() {
			@Override
			public Type run(Object... args) {
				return type;
			}
		};

		queryable = new DummyQueryable();
		queryable.setEntityName(entityName);
		queryable.setQuerySpaces(querySpaces);
		queryable.setToTypeRWA(toTypeRWA);
	}

	@Test
	public void test() {

		DummyEntityCriteriaInfoProvider entityCriteriaInfoProvider = new DummyEntityCriteriaInfoProvider(queryable);
		aeq(entityName, entityCriteriaInfoProvider.getName());
		aeqr(querySpaces, entityCriteriaInfoProvider.getSpaces());
		aeqr(queryable, entityCriteriaInfoProvider.getPropertyMapping());
		aeqr(type, entityCriteriaInfoProvider.getType(relativePath));

	}
}
