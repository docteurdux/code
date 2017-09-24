package dux.org.aopalliance.intercept;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

public class DummyMethodInvocation implements MethodInvocation {

	private Object[] arguments;
	private Object that;
	private AccessibleObject staticPart;
	private Method method;

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public Object proceed() throws Throwable {
		return method.invoke(that, arguments);
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
