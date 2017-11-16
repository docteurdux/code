package dux.org.hibernate.loader.plan.build.spi;

import org.hibernate.loader.plan.build.spi.MetamodelDrivenLoadPlanBuilder;
import org.hibernate.loader.plan.spi.LoadPlan;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.plan.build.spi.DummyLoadPlanBuildingAssociationVisitationStrategy;
import dum.org.hibernate.loader.plan.spi.DummyLoadPlan;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.persister.walking.spi.DummyCollectionElementDefinition;
import dum.org.hibernate.persister.walking.spi.DummyNonEncapsulatedEntityIdentifierDefinition;
import dum.org.hibernate.type.DummyType;

@Done("need second pass")
public class MetamodelDrivenLoadPlanBuilderTest extends AbstractTest {
	private DummyLoadPlan loadPlan;
	private DummyLoadPlanBuildingAssociationVisitationStrategy loadPlanBuildingAssociationVisitationStrategy;
	private DummyType type;
	private DummyCollectionElementDefinition elementDefinition;
	private DummyCollectionPersister collectionPersister;
	private DummyNonEncapsulatedEntityIdentifierDefinition entityKeyDefinition;
	private DummyEntityPersister entityPersister;

	@Before
	public void before() {

		loadPlan = new DummyLoadPlan();

		loadPlanBuildingAssociationVisitationStrategy = new DummyLoadPlanBuildingAssociationVisitationStrategy();
		loadPlanBuildingAssociationVisitationStrategy.setLoadPlan(loadPlan);

		type = new DummyType();

		elementDefinition = new DummyCollectionElementDefinition();
		elementDefinition.setType(type);

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setElementDefinition(elementDefinition);

		entityKeyDefinition = new DummyNonEncapsulatedEntityIdentifierDefinition();

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityKeyDefinition(entityKeyDefinition);
	}

	@Test
	public void test1() {

		LoadPlan collectionLoadPlan = MetamodelDrivenLoadPlanBuilder
				.buildRootCollectionLoadPlan(loadPlanBuildingAssociationVisitationStrategy, collectionPersister);
		aeqr(loadPlan, collectionLoadPlan);
		aeq(6, loadPlanBuildingAssociationVisitationStrategy.getTestEvents().size());
	}

	@Test
	public void test2() {

		LoadPlan entityLoadPlan = MetamodelDrivenLoadPlanBuilder
				.buildRootEntityLoadPlan(loadPlanBuildingAssociationVisitationStrategy, entityPersister);
		aeqr(loadPlan, entityLoadPlan);
		aeq(8, loadPlanBuildingAssociationVisitationStrategy.getTestEvents().size());
	}
}
