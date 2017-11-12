package dum.org.hibernate.boot.jaxb.spi;

import java.io.InputStream;

import javax.xml.transform.Source;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.spi.Binder;
import org.hibernate.boot.jaxb.spi.Binding;

public class DummyBinder implements Binder {

	private Binding binding;

	@Override
	public Binding bind(Source source, Origin origin) {
		return binding;
	}

	@Override
	public Binding bind(InputStream stream, Origin origin) {
		return binding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

}
