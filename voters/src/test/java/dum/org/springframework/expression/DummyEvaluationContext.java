package dum.org.springframework.expression;

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

public class DummyEvaluationContext implements EvaluationContext {

	private TypedValue rootObject;
	private List<PropertyAccessor> propertyAccessors;
	private TypeLocator typeLocator;

	@Override
	public TypedValue getRootObject() {
		return rootObject;
	}

	public void setRootObject(TypedValue rootObject) {
		this.rootObject = rootObject;
	}

	@Override
	public List<ConstructorResolver> getConstructorResolvers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MethodResolver> getMethodResolvers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyAccessor> getPropertyAccessors() {
		return propertyAccessors;
	}

	public void setPropertyAccessors(List<PropertyAccessor> propertyAccessors) {
		this.propertyAccessors = propertyAccessors;
	}

	@Override
	public TypeLocator getTypeLocator() {
		return typeLocator;
	}

	public void setTypeLocator(TypeLocator typeLocator) {
		this.typeLocator = typeLocator;
	}

	@Override
	public TypeConverter getTypeConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeComparator getTypeComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatorOverloader getOperatorOverloader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanResolver getBeanResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariable(String name, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object lookupVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
