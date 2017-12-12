package dux.org.springframework.context;

import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(MessageSourceAware.class)
public class MessageSourceAwareTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * A class that implements org.springframework.context.MessageSourceAware
		 * advertises that it can have a org.springframework.context.MessageSource set
		 * on itself
		 */

		new MessageSourceAware() {

			private MessageSource messageSource;

			@Override
			public void setMessageSource(MessageSource messageSource) {
				this.messageSource = messageSource;

			}
		}.setMessageSource(Recorder.create(MessageSource.class).p());

	}
}
