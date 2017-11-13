package com.github.docteurdux.test.hibernate;

import java.lang.reflect.InvocationHandler;

public interface ProxyGenerator {

	Object generateProxy(InvocationHandler handler, Class[] interfaces);

}
