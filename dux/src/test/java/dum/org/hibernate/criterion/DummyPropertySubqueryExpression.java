package dum.org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.PropertySubqueryExpression;

public class DummyPropertySubqueryExpression extends PropertySubqueryExpression {

	private static final long serialVersionUID = 1L;

	public DummyPropertySubqueryExpression(String propertyName, String op, String quantifier, DetachedCriteria dc) {
		super(propertyName, op, quantifier, dc);
	}

	@Override
	public String toLeftSqlString(Criteria criteria, CriteriaQuery criteriaQuery) {
		return super.toLeftSqlString(criteria, criteriaQuery);
	}

}
