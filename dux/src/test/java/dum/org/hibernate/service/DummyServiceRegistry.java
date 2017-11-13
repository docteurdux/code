package dum.org.hibernate.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class DummyServiceRegistry implements ServiceRegistry {

	private ServiceRegistry parentServiceRegistry;
	private Map<Class<?>, Object> services = new HashMap<>();

	@Override
	public ServiceRegistry getParentServiceRegistry() {
		return parentServiceRegistry;
	}

	public void setParentServiceRegistry(ServiceRegistry parentServiceRegistry) {
		this.parentServiceRegistry = parentServiceRegistry;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Service> R getService(Class<R> serviceRole) {
		return (R) services.get(serviceRole);
	}

	public void setService(Class<?> clazz, Service service) {
		services.put(clazz, service);
	}

	public Map<Class<?>, Object> getServices() {
		return services;
	}

}
