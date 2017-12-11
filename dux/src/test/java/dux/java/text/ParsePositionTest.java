package dux.java.text;

import java.text.ParsePosition;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ParsePosition.class)
public class ParsePositionTest extends AbstractTest {
	@Test
	public void test() {

		/* java.text.ParsePosition maintains an index and an error index */

		/* The index must be supplied to the constructor */
		ParsePosition p = new ParsePosition(1);
		aeq(1, p.getIndex());

		/*
		 * But the error index is initially set to -1 and can be subsequently modified
		 */
		aeq(-1, p.getErrorIndex());
		p.setErrorIndex(2);
		aeq(2, p.getErrorIndex());

		/* The index can be modified too */
		p.setIndex(3);
		aeq(3, p.getIndex());

		/* toString() is overridden */

		aeq("java.text.ParsePosition[index=3,errorIndex=2]", p.toString());

		/* hashCode and equals are defined appropriately */

	}
}
