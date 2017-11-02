package dum.javax.xml.bind;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;

import org.apache.cxf.ws.addressing.v200408.AttributedURI;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class DummyUnmarshaller implements Unmarshaller {

	private Map<Class<?>, Object> unmarshalResults = new HashMap<>();

	@Override
	public Object unmarshal(File f) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(InputStream is) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(Reader reader) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(URL url) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(InputSource source) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(Node node) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> JAXBElement<T> unmarshal(Node node, Class<T> declaredType) throws JAXBException {
		return (JAXBElement<T>) unmarshalResults.get(declaredType);
	}

	public <T> void setUnmarshalResult(Class<T> declaredType, JAXBElement<T> result) {
		unmarshalResults.put(declaredType, result);
	}

	public <T> void createUnmarshalResult(Class<T> declaredType, T result) {
		QName name = new QName(declaredType.getSimpleName() + "NS", declaredType.getSimpleName() + "LP");
		unmarshalResults.put(declaredType, new JAXBElement<T>(name, declaredType, result));
	}

	@Override
	public Object unmarshal(Source source) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JAXBElement<T> unmarshal(Source source, Class<T> declaredType) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(XMLStreamReader reader) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JAXBElement<T> unmarshal(XMLStreamReader reader, Class<T> declaredType) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(XMLEventReader reader) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JAXBElement<T> unmarshal(XMLEventReader reader, Class<T> declaredType) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnmarshallerHandler getUnmarshallerHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValidating(boolean validating) throws JAXBException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValidating() throws JAXBException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEventHandler(ValidationEventHandler handler) throws JAXBException {
		// TODO Auto-generated method stub

	}

	@Override
	public ValidationEventHandler getEventHandler() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String name, Object value) throws PropertyException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getProperty(String name) throws PropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchema(Schema schema) {
		// TODO Auto-generated method stub

	}

	@Override
	public Schema getSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdapter(XmlAdapter adapter) {
		// TODO Auto-generated method stub

	}

	@Override
	public <A extends XmlAdapter> void setAdapter(Class<A> type, A adapter) {
		// TODO Auto-generated method stub

	}

	@Override
	public <A extends XmlAdapter> A getAdapter(Class<A> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttachmentUnmarshaller(AttachmentUnmarshaller au) {
		// TODO Auto-generated method stub

	}

	@Override
	public AttachmentUnmarshaller getAttachmentUnmarshaller() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListener(Listener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Listener getListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
