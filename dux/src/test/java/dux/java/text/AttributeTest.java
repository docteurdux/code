package dux.java.text;

import java.io.InvalidObjectException;
import java.text.AttributedCharacterIterator.Attribute;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(Attribute.class)
public class AttributeTest extends AbstractTest {

	class A extends Attribute {

		private static final long serialVersionUID = 1L;

		public A(String name) {
			super(name);
		}

		@Override
		public String getName() {
			return super.getName();
		}

		@Override
		public Object readResolve() throws InvalidObjectException {
			return super.readResolve();
		}

	}

	@Test
	public void test() {

		/*
		 * A subclass of java.text.AttributedCharacterIterator.Attribute has a name, and
		 * also must implements a readResolve() method. Everything is protected, but
		 * protected method are exposed here for demonstration purposes.
		 */

		A a = new A("name");
		aeq("name", a.getName());

		/*
		 * The readResolve function must be overridden, the default implementation works
		 * for internal uses only
		 */
		expect(InvalidObjectException.class, "subclass didn't correctly implement readResolve",
				new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						a.readResolve();
					}
				});

	}
}
