package dux.java.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(Format.class)
public class FormatTest extends AbstractTest {
	@Test
	public void test() throws ParseException {

		/*
		 * java.text.Format defines two public abstract methods to be implemented by
		 * concrete Formatters
		 */

		/*-
		  - java.lang.StringBuffer format(Object, java.lang.StringBuffer, java.text.FieldPosition)
		  - Object parseObject(String, java.text.ParsePosition)
		 */

		Object object = new Object();
		String source = "source";

		Format f = new Format() {

			private static final long serialVersionUID = 1L;

			@Override
			public StringBuffer format(Object obj, StringBuffer buf, FieldPosition pos) {
				return buf.append(source);
			}

			@Override
			public Object parseObject(String source, ParsePosition pos) {
				pos.setIndex(1);
				return object;
			}

		};

		/* It also defines simplified concrete methods that call the abstract ones */
		aeq("source", f.format(object));
		aeqr(object, f.parseObject(source));

		/*
		 * Finally, there's a version which returns a
		 * java.text.AttributedCharacterIterator for those who like that. This just wrap
		 * the conversion result in an java.text.AttributedString and return a
		 * java.text.AttributedCharacterIterator iterator on it.
		 */
		f.formatToCharacterIterator(object);

	}
}
