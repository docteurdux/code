package com.github.docteurdux.org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

public class MethodInvocationDUX implements MethodInvocation {

	private Object[] arguments;
	private Object proceedResult;
	private Object that;
	private AccessibleObject staticPart;
	private Method method;

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public Object proceed() throws Throwable {
		return proceedResult;
	}

	@Override
	public Object getThis() {
		return that;
	}

	@Override
	public AccessibleObject getStaticPart() {
		return staticPart;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	public void setProceedResult(Object proceedResult) {
		this.proceedResult = proceedResult;
	}

	public void setThis(Object that) {
		this.that = that;
	}

	public void setStaticPart(AccessibleObject staticPart) {
		this.staticPart = staticPart;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
