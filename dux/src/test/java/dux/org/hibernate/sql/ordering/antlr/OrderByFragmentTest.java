package dux.org.hibernate.sql.ordering.antlr;

import org.hibernate.sql.ordering.antlr.NodeSupport;
import org.hibernate.sql.ordering.antlr.OrderByFragment;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class OrderByFragmentTest extends AbstractTest {
	@Test
	public void test() {
		aeq(NodeSupport.class, OrderByFragment.class.getSuperclass());
	}
}
