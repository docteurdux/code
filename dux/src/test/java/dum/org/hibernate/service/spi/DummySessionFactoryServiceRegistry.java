package dum.org.hibernate.service.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceBinding;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class DummySessionFactoryServiceRegistry implements SessionFactoryServiceRegistry {

	private Map<Class<?>, Object> services = new HashMap<>();

	@Override
	public <R extends Service> ServiceBinding<R> locateServiceBinding(Class<R> serviceRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerChild(ServiceRegistryImplementor child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deRegisterChild(ServiceRegistryImplementor child) {
		// TODO Auto-generated method stub

	}

	@Override
	public ServiceRegistry getParentServiceRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Service> R getService(Class<R> serviceRole) {
		return (R) services.get(serviceRole);
	}

	public void setService(Class<?> clazz, Object o) {
		services.put(clazz, o);
	}

}
