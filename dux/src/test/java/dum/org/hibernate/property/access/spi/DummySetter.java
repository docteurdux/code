package dum.org.hibernate.property.access.spi;

import java.lang.reflect.Method;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.property.access.spi.Setter;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummySetter implements Setter {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<Void> setRWA;
	private String methodName;
	private Method method;

	@Override
	public void set(Object target, Object value, SessionFactoryImplementor factory) {
		if (setRWA != null) {
			setRWA.run(target, value, factory);
		}
	}

	public void setSetRWA(RunnableWithArgs<Void> setRWA) {
		this.setRWA = setRWA;
	}

	@Override
	public String getMethodName() {
		return methodName;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
