package dum.javax.xml.stream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class DummyXMLStreamReader implements XMLStreamReader {

	public static class Event {

		private int type;
		private String namespaceURI;
		private String localName;
		private String text;
		private String piTarget;
		private String piData;

		public Event(int type) {
			this.type = type;
		}

		public int getType() {
			return type;
		}

		public String getNamespaceURI() {
			return namespaceURI;
		}

		public Event namespaceURI(String namespaceURI) {
			this.namespaceURI = namespaceURI;
			return this;
		}

		public Event localName(String localName) {
			this.localName = localName;
			return this;
		}

		public String getLocalName() {
			return localName;
		}

		private Event text(String text) {
			this.text = text;
			return this;
		}

		public String getText() {
			return text;
		}

		private Event piTarget(String piTarget) {
			this.piTarget = piTarget;
			return this;
		}

		public String getPITarget() {
			return piTarget;
		}

		private Event piData(String piData) {
			this.piData = piData;
			return this;
		}

		public String getPIData() {
			return piData;
		}

		public static Event startElement(String namespaceURI, String localName) {
			return new Event(XMLStreamConstants.START_ELEMENT).namespaceURI(namespaceURI).localName(localName);
		}

		public static Event endElement() {
			return new Event(XMLStreamConstants.END_ELEMENT);
		}

		public static Event namespace() {
			return new Event(XMLStreamConstants.NAMESPACE);
		}

		public static Event attribute() {
			return new Event(XMLStreamConstants.ATTRIBUTE);
		}

		public static Event comment(String comment) {
			return new Event(XMLStreamConstants.COMMENT).text(comment);
		}

		public static Event cdata(String data) {
			return new Event(XMLStreamConstants.CDATA).text(data);
		}

		public static Event characters(String characters) {
			return new Event(XMLStreamConstants.CHARACTERS).text(characters);
		}

		public static Event processingInstruction(String piTarget, String piData) {
			return new Event(XMLStreamConstants.PROCESSING_INSTRUCTION).piTarget(piTarget).piData(piData);
		}

		public static Event entityReference(String piTarget, String piData) {
			return new Event(XMLStreamConstants.ENTITY_REFERENCE).piTarget(piTarget).piData(piData);
		}

	}

	private int pos;
	private List<Event> events = new ArrayList<>();

	@Override
	public Object getProperty(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int next() throws XMLStreamException {
		++pos;
		return (int) events.get(pos).getType();
	}

	@Override
	public void require(int type, String namespaceURI, String localName) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getElementText() throws XMLStreamException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextTag() throws XMLStreamException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasNext() throws XMLStreamException {
		return pos + 1 < events.size();
	}

	@Override
	public void close() throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStartElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEndElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCharacters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWhiteSpace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAttributeValue(String namespaceURI, String localName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttributeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QName getAttributeName(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeNamespace(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeLocalName(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributePrefix(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeType(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeValue(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAttributeSpecified(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNamespaceCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNamespacePrefix(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceURI(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamespaceContext getNamespaceContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEventType() {
		if (pos >= events.size()) {
			return -1;
		}
		return (int) events.get(pos).getType();
	}

	@Override
	public String getText() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).getText();
	}

	@Override
	public char[] getTextCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTextCharacters(int sourceStart, char[] target, int targetStart, int length)
			throws XMLStreamException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTextStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTextLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasText() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalName() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).getLocalName();
	}

	@Override
	public boolean hasName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNamespaceURI() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).getNamespaceURI();
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStandalone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean standaloneSet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCharacterEncodingScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPITarget() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).getPITarget();
	}

	@Override
	public String getPIData() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).getPIData();
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
