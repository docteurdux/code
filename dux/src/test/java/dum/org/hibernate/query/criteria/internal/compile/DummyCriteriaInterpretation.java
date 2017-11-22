package dum.org.hibernate.query.criteria.internal.compile;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.query.criteria.internal.compile.CriteriaInterpretation;
import org.hibernate.query.criteria.internal.compile.InterpretedParameterMetadata;
import org.hibernate.query.spi.QueryImplementor;

public class DummyCriteriaInterpretation implements CriteriaInterpretation {

	@Override
	@SuppressWarnings("rawtypes")
	public QueryImplementor buildCompiledQuery(SessionImplementor entityManager,
			InterpretedParameterMetadata interpretedParameterMetadata) {
		// TODO Auto-generated method stub
		return null;
	}

}
