package dux.org.hibernate.engine.profile;

import org.hibernate.engine.profile.Association;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class AssociationTest extends AbstractTest {

	private String entityName;
	private String associationPath;

	private DummyEntityPersister entityPersister;

	@Before
	public void before() {

		entityName = "entityName";
		associationPath = "associationPath";

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);
	}

	@Test
	public void test() {

		Association association = new Association(entityPersister, associationPath);

		aeqr(entityPersister, association.getOwner());
		aeq(associationPath, association.getAssociationPath());
		aeq("entityName.associationPath", association.getRole());
	}
}
