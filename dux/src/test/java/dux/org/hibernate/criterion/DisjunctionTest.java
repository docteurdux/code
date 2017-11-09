package dux.org.hibernate.criterion;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Junction.Nature;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.criterion.DummyCriterion;

@Done
public class DisjunctionTest extends AbstractTest {
	private DummyCriterion criterion;
	private Criterion[] conditions;

	@Before
	public void before() {
		criterion = new DummyCriterion();
		conditions = new Criterion[] { criterion };
	}

	@Test
	public void test() {

		aeq(Junction.class, Disjunction.class.getSuperclass());

		Disjunction disjunction = new Disjunction(conditions) {
			private static final long serialVersionUID = 1L;
		};

		aeq(Nature.OR, disjunction.getNature());
		Criterion condition = disjunction.conditions().iterator().next();
		aeqr(criterion, condition);
	}
}
