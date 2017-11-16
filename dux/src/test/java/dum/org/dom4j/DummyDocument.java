package dum.org.dom4j;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Branch;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.InvalidXPathException;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Visitor;
import org.dom4j.XPath;
import org.xml.sax.EntityResolver;

public class DummyDocument implements Document {

	@Override
	public Node node(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Element elementByID(String elementID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List content() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator nodeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContent(List content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendContent(Branch branch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public List processingInstructions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List processingInstructions(String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessingInstruction processingInstruction(String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProcessingInstructions(List listOfPIs) {
		// TODO Auto-generated method stub

	}

	@Override
	public Element addElement(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element addElement(QName qname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element addElement(String qualifiedName, String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProcessingInstruction(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Element element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(ProcessingInstruction pi) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Element element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(ProcessingInstruction pi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void normalize() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Element getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(Element parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDocument(Document document) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getStringValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath(Element context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniquePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniquePath(Element context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String asXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Writer writer) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public short getNodeType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNodeTypeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node detach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectNodes(String xpathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectObject(String xpathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectNodes(String xpathExpression, String comparisonXPathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectNodes(String xpathExpression, String comparisonXPathExpression, boolean removeDuplicates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node selectSingleNode(String xpathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String valueOf(String xpathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number numberValueOf(String xpathExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(String xpathExpression) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public XPath createXPath(String xpathExpression) throws InvalidXPathException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node asXPathResult(Element parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Element getRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRootElement(Element rootElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document addComment(String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document addProcessingInstruction(String target, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document addProcessingInstruction(String target, Map data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document addDocType(String name, String publicId, String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentType getDocType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDocType(DocumentType docType) {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityResolver getEntityResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEntityResolver(EntityResolver entityResolver) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getXMLEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setXMLEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
