package dux.org.springframework.validation;

import java.util.Map;

import org.junit.Test;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.ObjectError;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AbstractBindingResult.class)
public class AbstractBindingResultTest extends AbstractTest {

	private static Object target = new Object();

	@Test
	public void test() {

		ABR abr = new ABR("objectName");

		ObjectError error = new ObjectError("objectName", "message");
		abr.addError(error);
		aeq("objectName", abr.getObjectName());

		aeq(true, abr.hasErrors());

		Map<String, Object> model = abr.getModel();
		aeqr(target, model.get("objectName"));
		aeqr(abr, model.get("org.springframework.validation.BindingResult.objectName"));
		
		

		/*-
		addAllErrors(Errors)
		addError(ObjectError)
		equals(Object)
		findEditor(String, Class<?>)
		getAllErrors()
		getErrorCount()
		getFieldError()
		getFieldError(String)
		getFieldErrors()
		getFieldErrors(String)
		getFieldType(String)
		getFieldValue(String)
		getGlobalError()
		getGlobalErrors()
		getMessageCodesResolver()
		getPropertyEditorRegistry()
		getRawFieldValue(String)
		getSuppressedFields()
		hashCode()
		recordSuppressedField(String)
		reject(String, Object[], String)
		rejectValue(String, String, Object[], String)
		resolveMessageCodes(String)
		resolveMessageCodes(String, String)
		setMessageCodesResolver(MessageCodesResolver)
		 */
	}

	private static class ABR extends AbstractBindingResult {

		private static final long serialVersionUID = 1L;

		protected ABR(String objectName) {
			super(objectName);
		}

		@Override
		public Object getTarget() {
			return target;
		}

		@Override
		protected Object getActualFieldValue(String field) {
			return null;
		}

	}
}
