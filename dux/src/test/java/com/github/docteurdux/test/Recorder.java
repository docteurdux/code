package com.github.docteurdux.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.powermock.reflect.internal.TypeUtils;

import com.github.docteurdux.test.TestEvents.Identity;

public class Recorder<T> {

	private T proxy;

	private Map<String, Object> values = new HashMap<>();

	@SuppressWarnings("rawtypes")
	private Map<String, RunnableWithArgs> rwa = new HashMap<>();

	@SuppressWarnings("unchecked")
	public Recorder(String name, Class<?> clazz) {

		Identity identity = new Identity(name);

		proxy = (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[] { clazz },
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (proxy == Proxyfier.HANDLE) {
							return identity;
						}
						String m = method.getName();
						TestEvents.record(identity, m, args);
						if (rwa.containsKey(m)) {
							return rwa.get(m).run(args);
						}
						if (values.containsKey(m)) {
							return values.get(m);
						}
						return TypeUtils.getDefaultValue(method.getReturnType());
					}
				});
		Proxyfier.addProxy(proxy);
	}

	public Recorder<T> v(String m, Object v) {
		values.put(m, v);
		return this;
	}

	public Recorder<T> r(String m, @SuppressWarnings("rawtypes") RunnableWithArgs r) {
		rwa.put(m, r);
		return this;
	}

	public T p() {
		return proxy;
	}

	public static <T> Recorder<T> create(String name, AbstractTest t, Class<T> clazz) {
		Recorder<T> r = new Recorder<T>(name, clazz);
		if (t != null) {
			t.recorders.put(name, r);
		}
		return r;
	}

}
