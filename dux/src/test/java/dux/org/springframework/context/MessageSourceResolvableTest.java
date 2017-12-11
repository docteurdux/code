package dux.org.springframework.context;

import org.junit.Test;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.support.DefaultMessageSourceResolvableTest;
import dux.org.springframework.validation.FieldErrorTest;
import dux.org.springframework.validation.ObjectErrorTest;

@Topic(MessageSourceResolvable.class)
@Related({ DefaultMessageSourceResolvableTest.class, ObjectErrorTest.class, FieldErrorTest.class })
public class MessageSourceResolvableTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * The org.springframework.context.MessageSourceResolvable interface defines the
		 * three methods Object[] getArguments() ; String[] getCodes() and String
		 * getDefaultMessage()
		 */

		/*
		 * As an example,
		 * org.springframework.context.support.DefaultMessageSourceResolvable just sends
		 * back what is defined in its constructor
		 */

		DefaultMessageSourceResolvable messageSourceResolvable = new DefaultMessageSourceResolvable(
				new String[] { "code1", "code2" }, new Object[] { "hello" }, "default");

		aeq("code1", messageSourceResolvable.getCodes()[0]);
		aeq("code2", messageSourceResolvable.getCodes()[1]);

		aeq("hello", messageSourceResolvable.getArguments()[0]);

		aeq("default", messageSourceResolvable.getDefaultMessage());

	}
}
