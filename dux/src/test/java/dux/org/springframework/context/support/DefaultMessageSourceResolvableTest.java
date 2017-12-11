package dux.org.springframework.context.support;

import org.junit.Test;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.MessageSourceResolvableTest;
import dux.org.springframework.validation.ObjectErrorTest;

@Topic(DefaultMessageSourceResolvable.class)
@Related({ MessageSourceResolvableTest.class, ObjectErrorTest.class })
public class DefaultMessageSourceResolvableTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.springframework.context.support.DefaultMessageSourceResolvable implements
		 * org.springframework.context.MessageSourceResolvable in an obvious way
		 */

		String[] codes = new String[] { "code1", "code2" };
		Object[] arguments = new Object[] { "argument1", "argument2" };
		String defaultMessage = "defaultMessage";

		/*
		 * The most general constructors takes an array of codes, an array of arguments,
		 * and a default message
		 */

		DefaultMessageSourceResolvable r = new DefaultMessageSourceResolvable(codes, arguments, defaultMessage);
		aeqr(codes, r.getCodes());
		aeqr(arguments, r.getArguments());
		aeq(defaultMessage, r.getDefaultMessage());

		/* The other constructors do the obvious thing */

		r = new DefaultMessageSourceResolvable(codes);
		aeqr(codes, r.getCodes());
		aeqr(null, r.getArguments());
		aeq(null, r.getDefaultMessage());

		r = new DefaultMessageSourceResolvable(codes, arguments);
		aeqr(codes, r.getCodes());
		aeqr(arguments, r.getArguments());
		aeq(null, r.getDefaultMessage());

		r = new DefaultMessageSourceResolvable(codes, defaultMessage);
		aeqr(codes, r.getCodes());
		aeqr(null, r.getArguments());
		aeq(defaultMessage, r.getDefaultMessage());

		/*
		 * This constructor takes another MessageSourceResolvable and just copy its
		 * fields
		 */
		r = new DefaultMessageSourceResolvable(new MessageSourceResolvable() {
			@Override
			public String[] getCodes() {
				return codes;
			}

			@Override
			public Object[] getArguments() {
				return arguments;
			}

			@Override
			public String getDefaultMessage() {
				return defaultMessage;
			}
		});
		aeqr(codes, r.getCodes());
		aeqr(arguments, r.getArguments());
		aeq(defaultMessage, r.getDefaultMessage());

		/*
		 * And there's a constructor that takes a single code and puts it in the array
		 */
		r = new DefaultMessageSourceResolvable("code1");
		aeq("code1", r.getCodes()[0]);
		aeqr(null, r.getArguments());
		aeq(null, r.getDefaultMessage());

		/* the getCode() method returns the last code when it's there */
		aeq("code2", new DefaultMessageSourceResolvable(codes).getCode());

		/* The toString() method is overload */
		aeq("org.springframework.context.support.DefaultMessageSourceResolvable: codes [code1,code2]; arguments [argument1,argument2]; default message [defaultMessage]",
				new DefaultMessageSourceResolvable(codes, arguments, defaultMessage).toString());

		/*
		 * The equals() and hashCode() methods are overloaded to, and use methods from
		 * org.springframework.util.ObjectUtils for their computations
		 */

	}
}
