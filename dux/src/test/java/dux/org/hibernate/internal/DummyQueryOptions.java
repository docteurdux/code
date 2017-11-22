package dux.org.hibernate.internal;

import java.util.List;
import java.util.Map;

import org.hibernate.jpa.spi.HibernateEntityManagerImplementor.QueryOptions;
import org.hibernate.query.criteria.internal.ValueHandlerFactory.ValueHandler;

@SuppressWarnings("deprecation")
public class DummyQueryOptions implements QueryOptions {

	@Override
	public ResultMetadataValidator getResultMetadataValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ValueHandler> getValueHandlers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Class> getNamedParameterExplicitTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
