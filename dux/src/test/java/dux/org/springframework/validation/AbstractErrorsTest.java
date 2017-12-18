package dux.org.springframework.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.validation.AbstractErrors;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AbstractErrors.class)
public class AbstractErrorsTest extends AbstractTest {

	private static ObjectError globalError = new ObjectError("objectName", "defaultMessage");
	private static FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");

	@Test
	public void test() {
		AE e = new AE();
		e.getAllErrors();

		aeq(2, e.getErrorCount());
		aeq(1, e.getFieldErrorCount());
		aeq(1, e.getGlobalErrorCount());

		aeq(true, e.hasErrors());
		aeq(2, e.getAllErrors().size());

		aeqr(globalError, e.getGlobalError());
		aeqr(fieldError, e.getFieldError());

		aeqr(fieldError, e.getFieldError("field"));
		aeqr(1, e.getFieldErrorCount("field"));

		aeq(fieldError, e.getFieldErrors().get(0));

		aeq(true, e.hasFieldErrors());
		aeq(true, e.hasFieldErrors("field"));
		aeq(true, e.hasGlobalErrors());

		e.pushNestedPath("path");
		aeq("path.", e.getNestedPath());
		e.popNestedPath();
		aeq("", e.getNestedPath());
		e.setNestedPath("path");
		aeq("path.", e.getNestedPath());

		aeq(null, e.getFieldType("field"));

		e.reject("error");
		e.reject("error", "message");
		e.rejectValue("field", "error");
		e.rejectValue("field", "error", "message");

		System.out.println(e.toString());

	}

	private static class AE extends AbstractErrors {

		private static final long serialVersionUID = 1L;

		private List<ObjectError> globalErrors = new ArrayList<>();
		private List<FieldError> fieldErrors = new ArrayList<>();

		public AE() {
			globalErrors.add(globalError);
			fieldErrors.add(fieldError);
		}

		@Override
		public String getObjectName() {
			return "objectName";
		}

		@Override
		public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
		}

		@Override
		public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {
		}

		@Override
		public void addAllErrors(Errors errors) {
		}

		@Override
		public List<ObjectError> getGlobalErrors() {
			return globalErrors;
		}

		@Override
		public List<FieldError> getFieldErrors() {
			return fieldErrors;
		}

		@Override
		public Object getFieldValue(String field) {
			return null;
		}

	}
}
