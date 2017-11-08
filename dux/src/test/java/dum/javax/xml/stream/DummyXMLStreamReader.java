package dum.javax.xml.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class DummyXMLStreamReader implements XMLStreamReader {

	public static class Event {

		private Map<String, Object> map = new HashMap<>();

		public Event(int type) {
			map.put("type", type);
		}

		public Event namespaceURI(String namespaceURI) {
			map.put("namespaceURI", namespaceURI);
			return this;
		}

		public Event localName(String localName) {
			map.put("localName", localName);
			return this;
		}

		private Event text(String text) {
			map.put("text", text);
			return this;
		}

		private Event piTarget(String piTarget) {
			map.put("piTarget", piTarget);
			return this;
		}

		private Event piData(String piData) {
			map.put("piData", piData);
			return this;
		}

		public Map<String, Object> build() {
			return map;
		}

		@SuppressWarnings("rawtypes")
		public static Map startElement(String namespaceURI, String localName) {
			return new Event(XMLStreamConstants.START_ELEMENT).namespaceURI(namespaceURI).localName(localName).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map endElement() {
			return new Event(XMLStreamConstants.END_ELEMENT).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map namespace() {
			return new Event(XMLStreamConstants.NAMESPACE).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map attribute() {
			return new Event(XMLStreamConstants.ATTRIBUTE).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map comment(String comment) {
			return new Event(XMLStreamConstants.COMMENT).text(comment).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map cdata(String data) {
			return new Event(XMLStreamConstants.CDATA).text(data).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map characters(String characters) {
			return new Event(XMLStreamConstants.CHARACTERS).text(characters).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map processingInstruction(String piTarget, String piData) {
			return new Event(XMLStreamConstants.PROCESSING_INSTRUCTION).piTarget(piTarget).piData(piData).build();
		}

		@SuppressWarnings("rawtypes")
		public static Map entityReference(String piTarget, String piData) {
			return new Event(XMLStreamConstants.ENTITY_REFERENCE).piTarget(piTarget).piData(piData).build();
		}

	}

	private int pos;
	private List<Map<String, Object>> events = new ArrayList<>();

	@Override
	public Object getProperty(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int next() throws XMLStreamException {
		++pos;
		return (int) events.get(pos).get("type");
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
		return (int) events.get(pos).get("type");
	}

	@Override
	public String getText() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).get("text");
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
		return (String) events.get(pos).get("localName");
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
		return (String) events.get(pos).get("namespaceURI");
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
		return (String) events.get(pos).get("piTarget");
	}

	@Override
	public String getPIData() {
		if (pos >= events.size()) {
			return null;
		}
		return (String) events.get(pos).get("piData");
	}

	public void setEvents(List<Map<String, Object>> events) {
		this.events = events;
	}

}
