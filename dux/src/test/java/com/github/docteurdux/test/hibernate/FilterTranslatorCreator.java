package com.github.docteurdux.test.hibernate;

import java.util.Map;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.spi.FilterTranslator;

public interface FilterTranslatorCreator {

	FilterTranslator create(String queryIdentifier, String queryString, Map filters, SessionFactoryImplementor factory);

}
