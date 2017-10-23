package dum.org.hibernate.service.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceBinding;
import org.hibernate.service.spi.ServiceRegistryImplementor;

public class DummyServiceRegistryImplementor implements ServiceRegistryImplementor {

	private Map<Class<?>, Object> services = new HashMap<Class<?>, Object>();

	public ServiceRegistry getParentServiceRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public <R extends Service> R getService(Class<R> serviceRole) {
		return (R) services.get(serviceRole);
	}

	public <R extends Service> ServiceBinding<R> locateServiceBinding(Class<R> serviceRole) {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void registerChild(ServiceRegistryImplementor child) {
		// TODO Auto-generated method stub

	}

	public void deRegisterChild(ServiceRegistryImplementor child) {
		// TODO Auto-generated method stub

	}

	public Map<Class<?>, Object> getServices() {
		return services;
	}

}
