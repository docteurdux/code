package dum.org.hibernate.boot.jaxb.spi;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.spi.Binder;
import org.hibernate.boot.jaxb.spi.Binding;
import org.hibernate.boot.jaxb.spi.XmlSource;

public class DummyXmlSource extends XmlSource {

	public DummyXmlSource(Origin origin) {
		super(origin);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Binding doBind(Binder binder) {
		return null;
	}

}
