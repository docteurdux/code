package dux.org.hibernate.criterion;

import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.AvgProjection;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class AvgProjectionTest extends AbstractTest {
	@Test
	public void test() {

		aeq(AggregateProjection.class, AvgProjection.class.getSuperclass());

		AvgProjection projection = new AvgProjection("propertyName");
		aeq("avg", projection.getFunctionName());
		aeq("propertyName", projection.getPropertyName());

	}

}
