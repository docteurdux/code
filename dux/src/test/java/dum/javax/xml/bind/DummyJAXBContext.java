package dum.javax.xml.bind;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;

@SuppressWarnings("deprecation")
public class DummyJAXBContext extends JAXBContext {

	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	private Validator validator;

	@Override
	public Unmarshaller createUnmarshaller() throws JAXBException {
		return unmarshaller;
	}

	@Override
	public Marshaller createMarshaller() throws JAXBException {
		return marshaller;
	}

	@Override
	public Validator createValidator() throws JAXBException {
		return validator;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

}
