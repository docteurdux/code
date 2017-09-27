package dux.org.springframework.expression;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;

public class DummyExpression implements Expression {

	private String string;
	private Object value;
	private Class<?> clazz;
	private TypeDescriptor typeDescriptor;
	private boolean writable;

	@Override
	public Object getValue() throws EvaluationException {
		return value;
	}

	@Override
	public Object getValue(Object rootObject) throws EvaluationException {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(Class<T> desiredResultType) throws EvaluationException {
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(Object rootObject, Class<T> desiredResultType) throws EvaluationException {
		return (T) value;
	}

	@Override
	public Object getValue(EvaluationContext context) throws EvaluationException {
		return value;
	}

	@Override
	public Object getValue(EvaluationContext context, Object rootObject) throws EvaluationException {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(EvaluationContext context, Class<T> desiredResultType) throws EvaluationException {
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(EvaluationContext context, Object rootObject, Class<T> desiredResultType)
			throws EvaluationException {
		return (T) value;
	}

	@Override
	public Class<?> getValueType() throws EvaluationException {
		return clazz;
	}

	@Override
	public Class<?> getValueType(Object rootObject) throws EvaluationException {
		return clazz;
	}

	@Override
	public Class<?> getValueType(EvaluationContext context) throws EvaluationException {
		return clazz;
	}

	@Override
	public Class<?> getValueType(EvaluationContext context, Object rootObject) throws EvaluationException {
		return clazz;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor() throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(Object rootObject) throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(EvaluationContext context) throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(EvaluationContext context, Object rootObject)
			throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public boolean isWritable(EvaluationContext context) throws EvaluationException {
		return writable;
	}

	@Override
	public boolean isWritable(EvaluationContext context, Object rootObject) throws EvaluationException {
		return writable;
	}

	@Override
	public boolean isWritable(Object rootObject) throws EvaluationException {
		return writable;
	}

	@Override
	public void setValue(EvaluationContext context, Object value) throws EvaluationException {

	}

	@Override
	public void setValue(Object rootObject, Object value) throws EvaluationException {

	}

	@Override
	public void setValue(EvaluationContext context, Object rootObject, Object value) throws EvaluationException {

	}

	@Override
	public String getExpressionString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void setTypeDescriptor(TypeDescriptor typeDescriptor) {
		this.typeDescriptor = typeDescriptor;
	}

	public void setWritable(boolean writable) {
		this.writable = writable;
	}

}
