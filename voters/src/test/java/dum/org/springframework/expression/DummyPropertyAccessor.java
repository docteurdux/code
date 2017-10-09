package dum.org.springframework.expression;

import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;

public class DummyPropertyAccessor implements PropertyAccessor {

	private boolean canWrite;
	private Object newValue;

	@Override
	public Class<?>[] getSpecificTargetClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canRead(EvaluationContext context, Object target, String name) throws AccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypedValue read(EvaluationContext context, Object target, String name) throws AccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canWrite(EvaluationContext context, Object target, String name) throws AccessException {
		return canWrite;
	}

	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}

	@Override
	public void write(EvaluationContext context, Object target, String name, Object newValue) throws AccessException {
		this.newValue = newValue;
	}

	public Object getNewValue() {
		return newValue;
	}

}
