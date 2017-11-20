package dum.org.hibernate.property.access.spi;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.property.access.spi.Getter;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyGetter implements Getter {

	private static final long serialVersionUID = 1L;

	private String methodName;
	private Method method;
	private Member member;

	@SuppressWarnings("rawtypes")
	private Class returnType;

	private RunnableWithArgs<Object> getRWA;
	private RunnableWithArgs<Object> getForInsertRWA;

	@Override
	public Object get(Object owner) {
		if (getRWA != null) {
			return getRWA.run(owner);
		}
		return null;
	}

	public void setGetRWA(RunnableWithArgs<Object> getRWA) {
		this.getRWA = getRWA;
	}

	@Override
	public Object getForInsert(Object owner, @SuppressWarnings("rawtypes") Map mergeMap,
			SharedSessionContractImplementor session) {
		if (getForInsertRWA != null) {
			return getForInsertRWA.run(owner, mergeMap, session);
		}
		return null;
	}

	public void setGetForInsertRWA(RunnableWithArgs<Object> getForInsertRWA) {
		this.getForInsertRWA = getForInsertRWA;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class getReturnType() {
		return returnType;
	}

	public void setReturnType(@SuppressWarnings("rawtypes") Class returnType) {
		this.returnType = returnType;
	}

	@Override
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
