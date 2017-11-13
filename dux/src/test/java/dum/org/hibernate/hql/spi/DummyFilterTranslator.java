package dum.org.hibernate.hql.spi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.QueryException;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.event.spi.EventSource;
import org.hibernate.hql.spi.FilterTranslator;
import org.hibernate.hql.spi.ParameterTranslations;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.type.Type;

public class DummyFilterTranslator implements FilterTranslator {

	private Set<Serializable> querySpaces = new HashSet<>();
	private List<String> sqlStrings = new ArrayList<>();
	private ParameterTranslations parameterTranslations;

	@Override
	public void compile(Map replacements, boolean shallow) throws QueryException, MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public List list(SharedSessionContractImplementor session, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterate(QueryParameters queryParameters, EventSource session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScrollableResultsImplementor scroll(QueryParameters queryParameters,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(QueryParameters queryParameters, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Serializable> getQuerySpaces() {
		return querySpaces;
	}

	@Override
	public String getQueryIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQLString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> collectSqlStrings() {
		return sqlStrings;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getEnabledFilters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type[] getReturnTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getReturnAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterTranslations getParameterTranslations() {
		return parameterTranslations;
	}

	public void setParameterTranslations(ParameterTranslations parameterTranslations) {
		this.parameterTranslations = parameterTranslations;
	}

	@Override
	public void validateScrollability() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsCollectionFetches() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isManipulationStatement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class getDynamicInstantiationResultType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void compile(String collectionRole, Map replacements, boolean shallow)
			throws QueryException, MappingException {
		// TODO Auto-generated method stub

	}

}
