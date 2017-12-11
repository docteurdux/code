package dux.java.text;

import java.text.Format.Field;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(Field.class)
@Related({ AttributeTest.class })
public class FieldTest extends AbstractTest {

	class F extends Field {

		private static final long serialVersionUID = 1L;

		public F(String name) {
			super(name);
		}

		@Override
		public String getName() {
			return super.getName();
		}
	}

	@Test
	public void test() {

		/*
		 * java.text.Format.Field extends
		 * java.text.AttributedCharacterIterator.Attribute, but the only thing it adds
		 * is a serialization id
		 */

		F f = new F("name");
		aeq("name", f.getName());

	}
}
