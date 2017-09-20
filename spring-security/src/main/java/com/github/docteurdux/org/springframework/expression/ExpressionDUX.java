package com.github.docteurdux.org.springframework.expression;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;

public class ExpressionDUX implements Expression {

	private String expressionString;
	private Object value;
	private Class<?> valueType;
	private TypeDescriptor typeDescriptor;
	private boolean writable;
	private Object setValue;

	@Override
	public String getExpressionString() {
		return expressionString;
	}

	@Override
	public Object getValue() throws EvaluationException {
		return value;
	}

	@Override
	public Object getValue(Object arg0) throws EvaluationException {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(Class<T> arg0) throws EvaluationException {
		return (T) value;
	}

	@Override
	public Object getValue(EvaluationContext arg0) throws EvaluationException {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(Object arg0, Class<T> arg1) throws EvaluationException {
		return (T) value;
	}

	@Override
	public Object getValue(EvaluationContext arg0, Object arg1) throws EvaluationException {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(EvaluationContext arg0, Class<T> arg1) throws EvaluationException {
		return (T) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(EvaluationContext arg0, Object arg1, Class<T> arg2) throws EvaluationException {
		return (T) value;
	}

	@Override
	public Class<?> getValueType() throws EvaluationException {
		return valueType;
	}

	@Override
	public Class<?> getValueType(Object arg0) throws EvaluationException {
		return valueType;
	}

	@Override
	public Class<?> getValueType(EvaluationContext arg0) throws EvaluationException {
		return valueType;
	}

	@Override
	public Class<?> getValueType(EvaluationContext arg0, Object arg1) throws EvaluationException {
		return valueType;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor() throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(Object arg0) throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(EvaluationContext arg0) throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public TypeDescriptor getValueTypeDescriptor(EvaluationContext arg0, Object arg1) throws EvaluationException {
		return typeDescriptor;
	}

	@Override
	public boolean isWritable(EvaluationContext arg0) throws EvaluationException {
		return writable;
	}

	@Override
	public boolean isWritable(Object arg0) throws EvaluationException {
		return writable;
	}

	@Override
	public boolean isWritable(EvaluationContext arg0, Object arg1) throws EvaluationException {
		return writable;
	}

	@Override
	public void setValue(EvaluationContext arg0, Object arg1) throws EvaluationException {
		value = setValue;
	}

	@Override
	public void setValue(Object arg0, Object arg1) throws EvaluationException {
		value = setValue;

	}

	@Override
	public void setValue(EvaluationContext arg0, Object arg1, Object arg2) throws EvaluationException {
		value = setValue;

	}

	public void setExpressionString(String expressionString) {
		this.expressionString = expressionString;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setValueType(Class<?> valueType) {
		this.valueType = valueType;
	}

	public void setTypeDescriptor(TypeDescriptor typeDescriptor) {
		this.typeDescriptor = typeDescriptor;
	}

	public void setWritable(boolean writable) {
		this.writable = writable;
	}

	public void setSetValue(Object setValue) {
		this.setValue = setValue;
	}

}
