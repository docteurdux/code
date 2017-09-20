package com.github.docteurdux.org.springframework.expression;

import java.util.List;

import org.springframework.expression.BeanResolver;
import org.springframework.expression.ConstructorResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.OperatorOverloader;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypeComparator;
import org.springframework.expression.TypeConverter;
import org.springframework.expression.TypeLocator;
import org.springframework.expression.TypedValue;

public class EvaluationContextDUX implements EvaluationContext {

	private BeanResolver beanResolver;
	private List<ConstructorResolver> constructorResolvers;
	private List<MethodResolver> methodResolvers;
	private OperatorOverloader operatorOverloader;
	private List<PropertyAccessor> propertyAccessors;
	private TypedValue rootObject;
	private TypeComparator typeComparator;
	private TypeConverter typeConverter;
	private TypeLocator typeLocator;
	private Object variable;
	private Object setVariable;

	@Override
	public BeanResolver getBeanResolver() {
		return beanResolver;
	}

	@Override
	public List<ConstructorResolver> getConstructorResolvers() {
		return constructorResolvers;
	}

	@Override
	public List<MethodResolver> getMethodResolvers() {
		return methodResolvers;
	}

	@Override
	public OperatorOverloader getOperatorOverloader() {
		return operatorOverloader;
	}

	@Override
	public List<PropertyAccessor> getPropertyAccessors() {
		return propertyAccessors;
	}

	@Override
	public TypedValue getRootObject() {
		return rootObject;
	}

	@Override
	public TypeComparator getTypeComparator() {
		return typeComparator;
	}

	@Override
	public TypeConverter getTypeConverter() {
		return typeConverter;
	}

	@Override
	public TypeLocator getTypeLocator() {
		return typeLocator;
	}

	@Override
	public Object lookupVariable(String arg0) {
		return variable;
	}

	@Override
	public void setVariable(String arg0, Object arg1) {
		variable = setVariable;
	}

	public void setBeanResolver(BeanResolver beanResolver) {
		this.beanResolver = beanResolver;
	}

	public void setConstructorResolvers(List<ConstructorResolver> constructorResolvers) {
		this.constructorResolvers = constructorResolvers;
	}

	public void setMethodResolvers(List<MethodResolver> methodResolvers) {
		this.methodResolvers = methodResolvers;
	}

	public void setOperatorOverloader(OperatorOverloader operatorOverloader) {
		this.operatorOverloader = operatorOverloader;
	}

	public void setPropertyAccessors(List<PropertyAccessor> propertyAccessors) {
		this.propertyAccessors = propertyAccessors;
	}

	public void setRootObject(TypedValue rootObject) {
		this.rootObject = rootObject;
	}

	public void setTypeComparator(TypeComparator typeComparator) {
		this.typeComparator = typeComparator;
	}

	public void setTypeConverter(TypeConverter typeConverter) {
		this.typeConverter = typeConverter;
	}

	public void setTypeLocator(TypeLocator typeLocator) {
		this.typeLocator = typeLocator;
	}

	public void setVariable(Object variable) {
		this.variable = variable;
	}

	public void setSetVariable(Object setVariable) {
		this.setVariable = setVariable;
	}

}
