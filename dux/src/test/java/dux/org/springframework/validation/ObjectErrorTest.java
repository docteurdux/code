package dux.org.springframework.validation;

import org.junit.Test;
import org.springframework.validation.ObjectError;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.support.DefaultMessageSourceResolvableTest;

@Topic(ObjectError.class)
@Related({ DefaultMessageSourceResolvableTest.class, FieldErrorTest.class })
public class ObjectErrorTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.validation.ObjectError extends
		 * org.springframework.context.support.DefaultMessageSourceResolvable with the
		 * notion of object name
		 */

		/*
		 * The most general constructor adds the objectNames to the arguments of the
		 * most general constructor of DefaultMessageSourceResolvable
		 */

		String objectName = "objectName";
		String[] codes = new String[] { "code1", "code2" };
		String[] arguments = new String[] { "argument1", "argument2" };
		String defaultMessage = "defaultMessage";

		ObjectError objectError1 = new ObjectError(objectName, codes, arguments, defaultMessage);

		aeq(objectName, objectError1.getObjectName());
		aeqr(codes, objectError1.getCodes());
		aeqr(arguments, objectError1.getArguments());
		aeq(defaultMessage, objectError1.getDefaultMessage());

		/* Another constructor uses no codes and no arguments */

		ObjectError objectError2 = new ObjectError(objectName, defaultMessage);
		aeq(objectName, objectError2.getObjectName());
		aeqr(null, objectError2.getCodes());
		aeqr(null, objectError2.getArguments());
		aeq(defaultMessage, objectError2.getDefaultMessage());

		/* The toString() method is redefined */
		aeq("Error in object 'objectName': codes [code1,code2]; arguments [argument1,argument2]; default message [defaultMessage]",
				objectError1.toString());

		/*
		 * and the hashCode and equals method are redefined to also use the object name
		 */

	}
}
