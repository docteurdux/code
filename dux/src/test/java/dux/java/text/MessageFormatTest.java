package dux.java.text;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;
import com.ibm.icu.util.Calendar;

@Topic(MessageFormat.class)
public class MessageFormatTest extends AbstractTest {
	@Test
	public void test() {

		/* java.text.MessageFormat extends java.text.Format */

		String pattern = "";
		Locale locale = Locale.ENGLISH;

		MessageFormat f = new MessageFormat(pattern);
		aeqr(Locale.getDefault(Locale.Category.FORMAT), f.getLocale());

		f = new MessageFormat(pattern, locale);
		aeqr(locale, f.getLocale());

		f.setLocale(Locale.GERMAN);
		aeqr(Locale.GERMAN, f.getLocale());

		f.applyPattern("");

		aeq("hello", MessageFormat.format("{0}", "hello"));
		aeq("There is something",
				MessageFormat.format("There is {0,choice,0#nothing|1#something|2too many things}", 1));

		Date time = Calendar.getInstance().getTime();
		for (Locale l : Locale.getAvailableLocales()) {
			for (String p : new String[] { "{0,date, short}", "{0,date, medium}", "{0,date, long}", "{0,date, full}",
					"{0,time, short}", "{0,time, medium}", "{0,time, long}", "{0,time, full}" }) {
				System.out.println(new MessageFormat("{1} : {2} : " + p, l).format(new Object[] { time, l, p }));
			}
		}

		/*-
		format(String, Object...)
		applyPattern(String)
		clone()
		equals(Object)
		format(Object, StringBuffer, FieldPosition)
		format(Object[], StringBuffer, FieldPosition)
		formatToCharacterIterator(Object)
		getFormats()
		getFormatsByArgumentIndex()
		hashCode()
		parse(String)
		parse(String, ParsePosition)
		parseObject(String, ParsePosition)
		setFormat(int, Format)
		setFormatByArgumentIndex(int, Format)
		setFormats(Format[])
		setFormatsByArgumentIndex(Format[])
		toPattern()
		 */

	}
}
