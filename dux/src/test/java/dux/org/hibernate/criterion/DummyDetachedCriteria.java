package dux.org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.internal.CriteriaImpl;

public class DummyDetachedCriteria extends DetachedCriteria {

	private static final long serialVersionUID = 1L;
	
	protected DummyDetachedCriteria(CriteriaImpl impl, Criteria criteria) {
		super(impl, criteria);
	}


}
