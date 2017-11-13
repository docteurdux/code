package org.hibernate.loader.plan.exec.process.internal;

import org.hibernate.engine.spi.EntityKey;
import org.hibernate.loader.plan.spi.EntityReference;

public class DummyHydratedEntityRegistration extends HydratedEntityRegistration {

	public DummyHydratedEntityRegistration(EntityReference entityReference, EntityKey key, Object instance) {
		super(entityReference, key, instance);
	}

}
