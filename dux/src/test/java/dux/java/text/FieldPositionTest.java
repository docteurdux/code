package dux.java.text;

import java.text.FieldPosition;
import java.text.Format.Field;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(FieldPosition.class)
public class FieldPositionTest extends AbstractTest {

	public static class F extends Field {

		private static final long serialVersionUID = 1L;

		public F(String name) {
			super(name);
		}

	}

	@Test
	public void test() {

		/* java.text.FieldPosition has three constructors */

		/* The most general takes two arguments */

		int position = 1;
		Field field = new F("name");

		FieldPosition p1 = new FieldPosition(field, position);
		aeqr(field, p1.getFieldAttribute());
		aeq(position, p1.getField());

		/* If only the position is given, the field attribute is null */

		FieldPosition p2 = new FieldPosition(position);
		aeq(null, p2.getFieldAttribute());
		aeq(position, p2.getField());

		/* If only the field attribute is given, the field position is -1 */

		FieldPosition p3 = new FieldPosition(field);
		aeqr(field, p3.getFieldAttribute());
		aeq(-1, p3.getField());

		/* The begin and end indices are set to 0 by default */
		aeq(0, p1.getBeginIndex());
		aeq(0, p1.getEndIndex());

		/* But they have setters */
		p1.setBeginIndex(1);
		p1.setEndIndex(2);
		aeq(1, p1.getBeginIndex());
		aeq(2, p1.getEndIndex());

		/* toString is overridden */
		aeq("java.text.FieldPosition[field=1,attribute=dux.java.text.FieldPositionTest$F(name),beginIndex=1,endIndex=2]",
				p1.toString());
		System.out.println(p1.toString());

		/* and equals and hashCode perform comparison on all the fields */

	}
}
