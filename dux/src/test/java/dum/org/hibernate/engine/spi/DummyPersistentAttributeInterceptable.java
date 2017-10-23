package dum.org.hibernate.engine.spi;

import org.hibernate.engine.spi.PersistentAttributeInterceptable;
import org.hibernate.engine.spi.PersistentAttributeInterceptor;

public class DummyPersistentAttributeInterceptable implements PersistentAttributeInterceptable {

	private PersistentAttributeInterceptor interceptor;

	public PersistentAttributeInterceptor $$_hibernate_getInterceptor() {
		return interceptor;
	}

	public void $$_hibernate_setInterceptor(PersistentAttributeInterceptor interceptor) {
		this.interceptor = interceptor;
	}

}
