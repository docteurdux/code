package dux.org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ExistsSubqueryExpression;
import org.hibernate.criterion.SubqueryExpression;
import org.hibernate.internal.CriteriaImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.DummyCriteria;
import dum.org.hibernate.criterion.DummyCriteriaQuery;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class ExistsSubqueryExpressionTest extends AbstractTest {

	private String entityOrClassName;
	private String quantifier;

	private DummySharedSessionContractImplementor sharedSessionContractImplementor;

	private CriteriaImpl criteriaImpl;

	private DummyCriteria criteria;

	private DetachedCriteria detachedCriteria;
	private Criteria anyCriteria;
	private CriteriaQuery anyCriteriaQuery;

	@Before
	public void before() {

		entityOrClassName = "entityOrClassName";
		quantifier = "quantifier";

		sharedSessionContractImplementor = new DummySharedSessionContractImplementor();

		criteriaImpl = new CriteriaImpl(entityOrClassName, sharedSessionContractImplementor);

		criteria = new DummyCriteria();

		detachedCriteria = new DetachedCriteria(criteriaImpl, criteria) {
			private static final long serialVersionUID = 1L;
		};

		anyCriteria = new DummyCriteria();
		anyCriteriaQuery = new DummyCriteriaQuery();
	}

	@Test
	public void test() throws Exception {

		aeq(SubqueryExpression.class, ExistsSubqueryExpression.class.getSuperclass());

		ExistsSubqueryExpression ese = instantiate(quantifier, detachedCriteria);

		aeq("", toLeftSqlString(ese, anyCriteria, anyCriteriaQuery));

		aeq(quantifier, getField(ese, "quantifier", SubqueryExpression.class));
		aeqr(criteriaImpl, getField(ese, "criteriaImpl", SubqueryExpression.class));

	}

	private ExistsSubqueryExpression instantiate(String quantifier2, DetachedCriteria detachedCriteria2) {
		return new ExistsSubqueryExpression(quantifier, detachedCriteria) {
			private static final long serialVersionUID = 1L;

		};
	}

	private Object toLeftSqlString(ExistsSubqueryExpression ese, Criteria anyCriteria, CriteriaQuery anyCriteriaQuery)
			throws Exception {
		return invoke(ese, "toLeftSqlString", ExistsSubqueryExpression.class,
				new Class<?>[] { Criteria.class, CriteriaQuery.class }, anyCriteria, anyCriteriaQuery);
	}

}
