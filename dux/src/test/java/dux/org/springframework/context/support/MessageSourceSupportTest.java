package dux.org.springframework.context.support;

import java.text.MessageFormat;
import java.util.Locale;

import org.junit.Test;
import org.springframework.context.support.MessageSourceSupport;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MessageSourceSupport.class)
@Related({ AbstractMessageSourceTest.class })
public class MessageSourceSupportTest extends AbstractTest {

	public static class MSS extends MessageSourceSupport {
		@Override
		public MessageFormat createMessageFormat(String msg, Locale locale) {
			return super.createMessageFormat(msg, locale);
		}

		@Override
		public String formatMessage(String msg, Object[] args, Locale locale) {
			return super.formatMessage(msg, args, locale);
		}

		@Override
		public boolean isAlwaysUseMessageFormat() {
			return super.isAlwaysUseMessageFormat();
		}

		@Override
		public String renderDefaultMessage(String defaultMessage, Object[] args, Locale locale) {
			return super.renderDefaultMessage(defaultMessage, args, locale);
		}

		@Override
		public Object[] resolveArguments(Object[] args, Locale locale) {
			return super.resolveArguments(args, locale);
		}
	}

	@Test
	public void test() {

		MSS s = new MSS();

		/*-
		s.setAlwaysUseMessageFormat(alwaysUseMessageFormat);
		s.createMessageFormat(msg, locale);
		s.formatMessage(msg, args, locale);
		s.isAlwaysUseMessageFormat();
		s.renderDefaultMessage(defaultMessage, args, locale);
		s.resolveArguments(args, locale);
		*/

		/*-
		MessageSourceSupport()
		setAlwaysUseMessageFormat(boolean)
		
		createMessageFormat(String, Locale)
		formatMessage(String, Object[], Locale)
		isAlwaysUseMessageFormat()
		renderDefaultMessage(String, Object[], Locale)
		resolveArguments(Object[], Locale)
		 */
	}
}
