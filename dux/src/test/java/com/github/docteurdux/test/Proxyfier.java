package com.github.docteurdux.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class Proxyfier {

	public static final Object HANDLE = new Object();
	private static Set<String> proxies = new HashSet<>();

	public static Object getHandle(Object o) {
		if (proxies.contains(TestEvents.getIdentity(o))) {
			try {
				return Proxy.getInvocationHandler(o).invoke(HANDLE, null, null);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}
		return o;
	}

	@SuppressWarnings("unchecked")
	public static <T> T proxify(Object delegate) {
		if (delegate == null) {
			return null;
		}
		Object proxy = Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (proxy == HANDLE) {
							return delegate;
						}
						if(args==null) {
							args = new Object[] {};
						}
						if (method.getReturnType() == Void.class) {
							TestEvents.record(delegate, method.getName(), args);
							method.invoke(delegate, args);
							return null;
						} else {
							return TestEvents.record(delegate, method.getName(), args)
									.result(method.invoke(delegate, args));
						}
					}
				});
		proxies.add(TestEvents.getIdentity(proxy));
		return (T) proxy;
	}

}
