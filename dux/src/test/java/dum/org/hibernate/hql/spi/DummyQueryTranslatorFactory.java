package dum.org.hibernate.hql.spi;

import java.util.Map;

import org.hibernate.engine.query.spi.EntityGraphQueryHint;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.spi.FilterTranslator;
import org.hibernate.hql.spi.QueryTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.hibernate.FilterTranslatorCreator;

public class DummyQueryTranslatorFactory implements QueryTranslatorFactory {

	private static final long serialVersionUID = 1L;
	private FilterTranslatorCreator filterTranslatorCreator;
	private RunnableWithArgs<QueryTranslator> createQueryTranslatorRWA;

	@Override
	public QueryTranslator createQueryTranslator(String queryIdentifier, String queryString, Map filters,
			SessionFactoryImplementor factory, EntityGraphQueryHint entityGraphQueryHint) {
		if (createQueryTranslatorRWA != null) {
			return createQueryTranslatorRWA.run(queryIdentifier, queryString, filters, factory, entityGraphQueryHint);
		}
		return null;
	}

	public void setCreateQueryTranslatorRWA(RunnableWithArgs<QueryTranslator> createQueryTranslatorRWA) {
		this.createQueryTranslatorRWA = createQueryTranslatorRWA;
	}

	@Override
	public FilterTranslator createFilterTranslator(String queryIdentifier, String queryString, Map filters,
			SessionFactoryImplementor factory) {
		return filterTranslatorCreator.create(queryIdentifier, queryString, filters, factory);
	}

	public void setFilterTranslatorCreator(FilterTranslatorCreator filterTranslatorCreator) {
		this.filterTranslatorCreator = filterTranslatorCreator;
	}

}
