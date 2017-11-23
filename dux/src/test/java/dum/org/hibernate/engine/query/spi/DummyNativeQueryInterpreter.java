package dum.org.hibernate.engine.query.spi;

import org.hibernate.engine.query.spi.NativeQueryInterpreter;
import org.hibernate.engine.query.spi.NativeSQLQueryPlan;
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.internal.ParameterMetadataImpl;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyNativeQueryInterpreter implements NativeQueryInterpreter {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<NativeSQLQueryPlan> createQueryPlanRWA;

	@Override
	public ParameterMetadataImpl getParameterMetadata(String nativeQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NativeSQLQueryPlan createQueryPlan(NativeSQLQuerySpecification specification,
			SessionFactoryImplementor sessionFactory) {
		if (createQueryPlanRWA != null) {
			return createQueryPlanRWA.run(specification, sessionFactory);
		}
		return null;
	}

	public void setCreateQueryPlanRWA(RunnableWithArgs<NativeSQLQueryPlan> createQueryPlanRWA) {
		this.createQueryPlanRWA = createQueryPlanRWA;
	}

}
