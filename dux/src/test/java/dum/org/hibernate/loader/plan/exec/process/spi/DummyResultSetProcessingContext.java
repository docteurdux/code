package dum.org.hibernate.loader.plan.exec.process.spi;

import org.hibernate.LockMode;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.loader.plan.exec.process.spi.ResultSetProcessingContext;
import org.hibernate.loader.plan.spi.EntityReference;
import org.hibernate.loader.plan.spi.Fetch;
import org.hibernate.loader.plan.spi.LoadPlan;

public class DummyResultSetProcessingContext implements ResultSetProcessingContext {

	@Override
	public LockMode resolveLockMode(EntityReference entityReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SharedSessionContractImplementor getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryParameters getQueryParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldUseOptionalEntityInformation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldReturnProxies() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoadPlan getLoadPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityReferenceProcessingState getProcessingState(EntityReference entityReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityReferenceProcessingState getOwnerProcessingState(Fetch fetch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerHydratedEntity(EntityReference entityReference, EntityKey entityKey, Object entityInstance) {
		// TODO Auto-generated method stub

	}

}
