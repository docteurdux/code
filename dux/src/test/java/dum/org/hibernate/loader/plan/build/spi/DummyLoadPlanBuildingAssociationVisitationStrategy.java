package dum.org.hibernate.loader.plan.build.spi;

import org.hibernate.loader.plan.build.spi.LoadPlanBuildingAssociationVisitationStrategy;
import org.hibernate.loader.plan.spi.FetchSource;
import org.hibernate.loader.plan.spi.LoadPlan;
import org.hibernate.persister.walking.spi.AnyMappingDefinition;
import org.hibernate.persister.walking.spi.AssociationAttributeDefinition;
import org.hibernate.persister.walking.spi.AssociationKey;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.persister.walking.spi.CollectionDefinition;
import org.hibernate.persister.walking.spi.CollectionElementDefinition;
import org.hibernate.persister.walking.spi.CollectionIndexDefinition;
import org.hibernate.persister.walking.spi.CompositionDefinition;
import org.hibernate.persister.walking.spi.EntityDefinition;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyLoadPlanBuildingAssociationVisitationStrategy extends TestEventCollector
		implements LoadPlanBuildingAssociationVisitationStrategy {

	private LoadPlan loadPlan;
	private RunnableWithArgs<Boolean> startingAttributeRWA;
	private RunnableWithArgs<FetchSource> registeredFetchSourceRWA;
	private RunnableWithArgs<Boolean> isDuplicateAssociationKeyRWA;

	@Override
	public void start() {
		testEvents.add(new TestEvent("start"));
	}

	@Override
	public void finish() {
		testEvents.add(new TestEvent("finish"));
	}

	@Override
	public void startingEntity(EntityDefinition entityDefinition) {
		testEvents.add(new TestEvent("startingEntity").prop("entityDefinition", entityDefinition));
	}

	@Override
	public void finishingEntity(EntityDefinition entityDefinition) {
		testEvents.add(new TestEvent("finishingEntity").prop("entityDefinition", entityDefinition));
	}

	@Override
	public void startingEntityIdentifier(EntityIdentifierDefinition entityIdentifierDefinition) {
		testEvents.add(new TestEvent("startingEntityIdentifier").prop("entityIdentifierDefinition",
				entityIdentifierDefinition));
	}

	@Override
	public void finishingEntityIdentifier(EntityIdentifierDefinition entityIdentifierDefinition) {
		testEvents.add(new TestEvent("finishingEntityIdentifier").prop("entityIdentifierDefinition",
				entityIdentifierDefinition));
	}

	@Override
	public void startingCollection(CollectionDefinition collectionDefinition) {
		testEvents.add(new TestEvent("startingCollection").prop("collectionDefinition", collectionDefinition));
	}

	@Override
	public void finishingCollection(CollectionDefinition collectionDefinition) {
		testEvents.add(new TestEvent("finishingCollection").prop("collectionDefinition", collectionDefinition));
	}

	@Override
	public void startingCollectionIndex(CollectionIndexDefinition collectionIndexDefinition) {
		testEvents.add(
				new TestEvent("startingCollectionIndex").prop("collectionIndexDefinition", collectionIndexDefinition));
	}

	@Override
	public void finishingCollectionIndex(CollectionIndexDefinition collectionIndexDefinition) {
		testEvents.add(
				new TestEvent("finishingCollectionIndex").prop("collectionIndexDefinition", collectionIndexDefinition));
	}

	@Override
	public void startingCollectionElements(CollectionElementDefinition elementDefinition) {
		testEvents.add(new TestEvent("startingCollectionElements").prop("elementDefinition", elementDefinition));
	}

	@Override
	public void finishingCollectionElements(CollectionElementDefinition elementDefinition) {
		testEvents.add(new TestEvent("finishingCollectionElements").prop("elementDefinition", elementDefinition));
	}

	@Override
	public void startingComposite(CompositionDefinition compositionDefinition) {
		testEvents.add(new TestEvent("startingComposite").prop("compositionDefinition", compositionDefinition));
	}

	@Override
	public void finishingComposite(CompositionDefinition compositionDefinition) {
		testEvents.add(new TestEvent("finishingComposite").prop("compositionDefinition", compositionDefinition));
	}

	@Override
	public boolean startingAttribute(AttributeDefinition attributeDefinition) {
		testEvents.add(new TestEvent("startingAttribute").prop("attributeDefinition", attributeDefinition));
		if (startingAttributeRWA != null) {
			return startingAttributeRWA.run(attributeDefinition);
		}
		return false;
	}

	@Override
	public void finishingAttribute(AttributeDefinition attributeDefinition) {
		testEvents.add(new TestEvent("finishingAttribute").prop("attributeDefinition", attributeDefinition));

	}

	@Override
	public void foundAny(AnyMappingDefinition anyDefinition) {
		testEvents.add(new TestEvent("foundAny").prop("anyDefinition", anyDefinition));
	}

	@Override
	public void associationKeyRegistered(AssociationKey associationKey) {
		testEvents.add(new TestEvent("associationKeyRegistered").prop("associationKey", associationKey));
	}

	@Override
	public FetchSource registeredFetchSource(AssociationKey associationKey) {
		testEvents.add(new TestEvent("registeredFetchSource").prop("associationKey", associationKey));
		if (registeredFetchSourceRWA != null) {
			return registeredFetchSourceRWA.run(associationKey);
		}
		return null;
	}

	@Override
	public void foundCircularAssociation(AssociationAttributeDefinition attributeDefinition) {
		testEvents.add(new TestEvent("foundCircularAssociation").prop("attributeDefinition", attributeDefinition));
	}

	@Override
	public boolean isDuplicateAssociationKey(AssociationKey associationKey) {
		testEvents.add(new TestEvent("isDuplicateAssociationKey").prop("associationKey", associationKey));
		if (isDuplicateAssociationKeyRWA != null) {
			return isDuplicateAssociationKeyRWA.run(associationKey);
		}
		return false;
	}

	@Override
	public LoadPlan buildLoadPlan() {
		return loadPlan;
	}

	public void setLoadPlan(LoadPlan loadPlan) {
		this.loadPlan = loadPlan;
	}

}
