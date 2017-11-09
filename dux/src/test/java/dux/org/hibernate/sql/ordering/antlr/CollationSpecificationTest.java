package dux.org.hibernate.sql.ordering.antlr;

import org.hibernate.sql.ordering.antlr.CollationSpecification;
import org.hibernate.sql.ordering.antlr.NodeSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CollationSpecificationTest extends AbstractTest {
	@Test
	public void test() {
		aeq(NodeSupport.class, CollationSpecification.class.getSuperclass());
	}
}
