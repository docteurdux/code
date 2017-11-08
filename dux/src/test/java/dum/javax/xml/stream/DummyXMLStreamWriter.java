package dum.javax.xml.stream;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyXMLStreamWriter extends TestEventCollector implements XMLStreamWriter {

	private Map<String, String> prefixes = new HashMap<>();
	private String defaultNamespace;
	private NamespaceContext namespaceContext;
	private Map<String, Object> properties = new HashMap<>();

	@Override
	public void writeStartElement(String localName) throws XMLStreamException {
		testEvents.add(new TestEvent("writeStartElement").prop("localName", localName));
	}

	@Override
	public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
		testEvents.add(
				new TestEvent("writeStartElement").prop("namespaceURI", namespaceURI).prop("localName", localName));

	}

	@Override
	public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
		testEvents.add(new TestEvent("writeStartElement").prop("prefix", prefix).prop("namespaceURI", namespaceURI)
				.prop("localName", localName));

	}

	@Override
	public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
		testEvents.add(
				new TestEvent("writeEmptyElement").prop("namespaceURI", namespaceURI).prop("localName", localName));

	}

	@Override
	public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
		testEvents.add(new TestEvent("writeEmptyElement").prop("prefix", prefix).prop("namespaceURI", namespaceURI)
				.prop("localName", localName));

	}

	@Override
	public void writeEmptyElement(String localName) throws XMLStreamException {
		testEvents.add(new TestEvent("writeEmptyElement").prop("localName", localName));

	}

	@Override
	public void writeEndElement() throws XMLStreamException {
		testEvents.add(new TestEvent("writeEndElement"));

	}

	@Override
	public void writeEndDocument() throws XMLStreamException {
		testEvents.add(new TestEvent("writeEndDocument"));

	}

	@Override
	public void close() throws XMLStreamException {
		testEvents.add(new TestEvent("close"));

	}

	@Override
	public void flush() throws XMLStreamException {
		testEvents.add(new TestEvent("flush"));

	}

	@Override
	public void writeAttribute(String localName, String value) throws XMLStreamException {
		testEvents.add(new TestEvent("writeAttribute").prop("localName", localName).prop("value", value));

	}

	@Override
	public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
			throws XMLStreamException {
		testEvents.add(new TestEvent("writeAttribute").prop("prefix", prefix).prop("localName", localName).prop("value",
				value));

	}

	@Override
	public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
		testEvents.add(new TestEvent("writeAttribute").prop("localName", localName).prop("value", value));

	}

	@Override
	public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
		testEvents.add(new TestEvent("writeNamespace").prop("prefix", prefix).prop("namespaceURI", namespaceURI));

	}

	@Override
	public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
		testEvents.add(new TestEvent("writeDefaultNamespace").prop("namespaceURI", namespaceURI));

	}

	@Override
	public void writeComment(String data) throws XMLStreamException {
		testEvents.add(new TestEvent("writeComment").prop("data", data));

	}

	@Override
	public void writeProcessingInstruction(String target) throws XMLStreamException {
		testEvents.add(new TestEvent("writeProcessingInstruction").prop("target", target));

	}

	@Override
	public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
		testEvents.add(new TestEvent("writeProcessingInstruction").prop("target", target).prop("data", data));

	}

	@Override
	public void writeCData(String data) throws XMLStreamException {
		testEvents.add(new TestEvent("writeCData").prop("data", data));

	}

	@Override
	public void writeDTD(String dtd) throws XMLStreamException {
		testEvents.add(new TestEvent("writeDTD").prop("dtd", dtd));

	}

	@Override
	public void writeEntityRef(String name) throws XMLStreamException {
		testEvents.add(new TestEvent("writeEntityRef").prop("name", name));

	}

	@Override
	public void writeStartDocument() throws XMLStreamException {
		testEvents.add(new TestEvent("writeStartDocument"));

	}

	@Override
	public void writeStartDocument(String version) throws XMLStreamException {
		testEvents.add(new TestEvent("writeStartDocument").prop("version", version));

	}

	@Override
	public void writeStartDocument(String encoding, String version) throws XMLStreamException {
		testEvents.add(new TestEvent("writeStartDocument").prop("encoding", encoding).prop("version", version));

	}

	@Override
	public void writeCharacters(String text) throws XMLStreamException {
		testEvents.add(new TestEvent("writeCharacters").prop("text", text));

	}

	@Override
	public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
		testEvents.add(new TestEvent("writeCharacters").prop("text", text).prop("start", start).prop("len", len));
	}

	@Override
	public String getPrefix(String uri) throws XMLStreamException {
		testEvents.add(new TestEvent("getPrefix").prop("uri", uri));
		return prefixes.get(uri);
	}

	@Override
	public void setPrefix(String prefix, String uri) throws XMLStreamException {
		testEvents.add(new TestEvent("setPrefix").prop("prefix", prefix).prop("uri", uri));
		prefixes.put(prefix, uri);

	}

	public String getDefaultNamespace() {
		return defaultNamespace;
	}

	@Override
	public void setDefaultNamespace(String uri) throws XMLStreamException {
		testEvents.add(new TestEvent("setDefaultNamespace").prop("uri", uri));
		this.defaultNamespace = uri;
	}

	@Override
	public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
		testEvents.add(new TestEvent("setNamespaceContext").prop("context", context));
		this.namespaceContext = context;
	}

	@Override
	public NamespaceContext getNamespaceContext() {
		testEvents.add(new TestEvent("getNamespaceContext"));
		return namespaceContext;
	}

	@Override
	public Object getProperty(String name) throws IllegalArgumentException {
		testEvents.add(new TestEvent("getProperty").prop("name", name));
		return properties.get(name);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

}
