package dux.org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.internal.CriteriaImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.hibernate.ColumnGetter;

import dum.org.hibernate.DummyCriteria;
import dum.org.hibernate.criterion.DummyCriteriaQuery;
import dum.org.hibernate.criterion.DummyPropertySubqueryExpression;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class PropertySubqueryExpressionTest extends AbstractTest {

	private String propertyName;
	private String op;
	private String quantifier;
	private String entityOrClassName;
	private String alias;
	private String column;

	private DummySharedSessionContractImplementor sharedSessionContractImplementor;
	private CriteriaImpl criteriaImpl;
	private DummyCriteria criteria;
	private DummyDetachedCriteria detachedCriteria;
	private DummyCriteriaQuery criteriaQuery;

	public PropertySubqueryExpressionTest() {
		propertyName = "propertyName";
		op = "op";
		quantifier = "quantifier";
		entityOrClassName = "entityOrClassName";
		alias = "alias";
		column = "column";

		sharedSessionContractImplementor = new DummySharedSessionContractImplementor();
		criteriaImpl = new CriteriaImpl(entityOrClassName, alias, sharedSessionContractImplementor);
		criteria = new DummyCriteria();
		detachedCriteria = new DummyDetachedCriteria(criteriaImpl, criteria);
		criteriaQuery = new DummyCriteriaQuery();
		criteriaQuery.setColumnGetter(new ColumnGetter() {

			@Override
			public String get(Criteria criteria, String propertyPath) {
				return column;
			}
		});
	}

	@Test
	public void test() {
		DummyPropertySubqueryExpression pse = new DummyPropertySubqueryExpression(propertyName, op, quantifier,
				detachedCriteria);
		aeq("column", pse.toLeftSqlString(criteria, criteriaQuery));
	}
}
