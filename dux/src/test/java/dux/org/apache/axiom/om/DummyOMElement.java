package dux.org.apache.axiom.om;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMCloneOptions;
import org.apache.axiom.om.OMContainer;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMInformationItem;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMOutputFormat;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.om.OMXMLStreamReaderConfiguration;

public class DummyOMElement implements OMElement {

	private XMLStreamReader xmlStreamReader;

	@Override
	public void buildWithAttachments() {
		// TODO Auto-generated method stub

	}

	@Override
	public OMNode detach() throws OMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void discard() throws OMException {
		// TODO Auto-generated method stub

	}

	@Override
	public OMNode getNextOMSibling() throws OMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMContainer getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNode getPreviousOMSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertSiblingAfter(OMNode arg0) throws OMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSiblingBefore(OMNode arg0) throws OMException {
		// TODO Auto-generated method stub

	}

	@Override
	public void build() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serialize(XMLStreamWriter arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serialize(XMLStreamWriter arg0, boolean arg1) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeAndConsume(XMLStreamWriter arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public OMInformationItem clone(OMCloneOptions arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMFactory getOMFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChild(OMNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public OMXMLParserWrapper getBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getChildrenWithLocalName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getChildrenWithName(QName arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getChildrenWithNamespaceURI(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getDescendants(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMElement getFirstChildWithName(QName arg0) throws OMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNode getFirstOMChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAXResult getSAXResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAXSource getSAXSource(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XMLStreamReader getXMLStreamReader() {
		return xmlStreamReader;
	}

	public void setXmlStreamReader(XMLStreamReader xmlStreamReader) {
		this.xmlStreamReader = xmlStreamReader;
	}

	@Override
	public XMLStreamReader getXMLStreamReader(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XMLStreamReader getXMLStreamReader(boolean arg0, OMXMLStreamReaderConfiguration arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XMLStreamReader getXMLStreamReaderWithoutCaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeChildren() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace getNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName getQName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasName(QName arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLocalName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNamespace(OMNamespace arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public OMAttribute addAttribute(OMAttribute arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMAttribute addAttribute(String arg0, String arg1, OMNamespace arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMElement cloneOMElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace declareDefaultNamespace(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace declareNamespace(OMNamespace arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace declareNamespace(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace findNamespace(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace findNamespaceURI(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator getAllAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator getAllDeclaredNamespaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMAttribute getAttribute(QName arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeValue(QName arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getChildElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMNamespace getDefaultNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMElement getFirstElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NamespaceContext getNamespaceContext(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getNamespacesInScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName getTextAsQName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getTextAsStream(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAttribute(OMAttribute arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public QName resolveQName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serialize(OutputStream arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serialize(Writer arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serialize(OutputStream arg0, OMOutputFormat arg1) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serialize(Writer arg0, OMOutputFormat arg1) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeAndConsume(OutputStream arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeAndConsume(Writer arg0) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeAndConsume(OutputStream arg0, OMOutputFormat arg1) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeAndConsume(Writer arg0, OMOutputFormat arg1) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLineNumber(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNamespace(OMNamespace arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNamespaceWithNoFindInCurrentScope(OMNamespace arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setText(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setText(QName arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toStringWithConsume() throws XMLStreamException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undeclarePrefix(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeTextTo(Writer arg0, boolean arg1) throws IOException {
		// TODO Auto-generated method stub

	}

}
