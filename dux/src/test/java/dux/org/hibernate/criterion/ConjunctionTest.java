package dux.org.hibernate.criterion;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Junction.Nature;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ConjunctionTest extends AbstractTest {
	@Test
	public void test() {

		Conjunction conjunction = new Conjunction();
		aeq(Nature.AND, conjunction.getNature());
	}
}
