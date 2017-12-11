package dux.org.springframework.validation;

import org.junit.Test;
import org.springframework.validation.FieldError;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(FieldError.class)
@Related({ ObjectErrorTest.class })
public class FieldErrorTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.validation.FieldError extends
		 * org.springframework.validation.ObjectError with the notion of field name,
		 * rejected value and binding failure
		 */

		/* The most general constructor takes all the arguments */
		String objectName = "objectName";
		String fieldName = "fieldName";
		Object rejectedValue = "rejectedValue";
		boolean bindingFailure = false;
		String[] codes = new String[] { "code1", "code2" };
		Object[] arguments = new Object[] { "argument1", "argument2" };
		String defaultMessage = "defaultMessage";

		FieldError fieldError1 = new FieldError(objectName, fieldName, rejectedValue, bindingFailure, codes, arguments,
				defaultMessage);
		aeq(objectName, fieldError1.getObjectName());
		aeq(fieldName, fieldError1.getField());
		aeq(rejectedValue, fieldError1.getRejectedValue());
		aeq(bindingFailure, fieldError1.isBindingFailure());
		aeqr(codes, fieldError1.getCodes());
		aeqr(arguments, fieldError1.getArguments());
		aeq(defaultMessage, fieldError1.getDefaultMessage());

		/*
		 * There a simpler constructor that only takes an object name, a field name and
		 * a default message
		 */
		FieldError fieldError2 = new FieldError(objectName, fieldName, defaultMessage);
		aeq(objectName, fieldError2.getObjectName());
		aeq(fieldName, fieldError2.getField());
		aeq(null, fieldError2.getRejectedValue());
		aeq(false, fieldError2.isBindingFailure());
		aeqr(null, fieldError2.getCodes());
		aeqr(null, fieldError2.getArguments());
		aeq(defaultMessage, fieldError2.getDefaultMessage());

		/* The toString() method is redefined */

		aeq("Field error in object 'objectName' on field 'fieldName': rejected value [rejectedValue]; codes [code1,code2]; arguments [argument1,argument2]; default message [defaultMessage]",
				fieldError1.toString());

		/*
		 * and the hashCode and equals method are redefined to also use the new fields
		 */
	}
}
