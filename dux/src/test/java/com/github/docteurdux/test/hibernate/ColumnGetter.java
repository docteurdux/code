package com.github.docteurdux.test.hibernate;

import org.hibernate.Criteria;

public interface ColumnGetter {

	public String get(Criteria criteria, String propertyPath);

}
