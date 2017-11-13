package dum.org.hibernate.engine.jndi.spi;

import java.util.HashMap;
import java.util.Map;

import javax.naming.event.NamespaceChangeListener;

import org.hibernate.engine.jndi.spi.JndiService;

public class DummyJndiService implements JndiService {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> objects = new HashMap<>();

	@Override
	public Object locate(String jndiName) {
		return objects.get(jndiName);
	}

	@Override
	public void bind(String jndiName, Object value) {
		objects.put(jndiName, value);

	}

	@Override
	public void unbind(String jndiName) {
		objects.remove(jndiName);
	}

	@Override
	public void addListener(String jndiName, NamespaceChangeListener listener) {
		// TODO Auto-generated method stub
	}

}
