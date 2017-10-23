package dum.org.hibernate.proxy;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

public class DummyHibernateProxy implements HibernateProxy {

	private static final long serialVersionUID = 1L;
	
	private Object writeReplace;
	private LazyInitializer lazyInitializer;

	public Object writeReplace() {
		return writeReplace;
	}

	public LazyInitializer getHibernateLazyInitializer() {
		return lazyInitializer;
	}

	public void setWriteReplace(Object writeReplace) {
		this.writeReplace = writeReplace;
	}

	public void setLazyInitializer(LazyInitializer lazyInitializer) {
		this.lazyInitializer = lazyInitializer;
	}

}
