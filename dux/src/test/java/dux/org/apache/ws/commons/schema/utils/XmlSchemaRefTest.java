package dux.org.apache.ws.commons.schema.utils;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroup;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaGroup;
import org.apache.ws.commons.schema.XmlSchemaNotation;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.apache.ws.commons.schema.utils.XmlSchemaNamed;
import org.apache.ws.commons.schema.utils.XmlSchemaRef;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.ws.commons.schema.utils.DummyXmlSchemaNamed;

@Done
public class XmlSchemaRefTest extends AbstractTest {

	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;
	private XmlSchema schema;

	private String elementLP;
	private QName elementQn;
	private XmlSchemaElement element;

	private String attributeLP;
	private QName attributeQn;
	private XmlSchemaAttribute attribute;

	private String typeLP;
	private QName typeQn;
	private XmlSchemaType type;

	private String attributeGroupLP;
	private QName attributeGroupQn;
	private XmlSchemaAttributeGroup attributeGroup;

	private String groupLP;
	private QName groupQn;
	private XmlSchemaGroup group;

	private String notationLP;
	private QName notationQn;
	private XmlSchemaNotation notation;
	private QName dummyQn;
	private XmlSchemaNamed dummy;
	private String dummyLP;

	@Before
	public void before() {

		namespace = "namespace";
		systemId = "systemId";

		parent = new XmlSchemaCollection();

		schema = new XmlSchema(namespace, systemId, parent);

		elementLP = "elementLP";
		elementQn = new QName(namespace, elementLP);
		element = new XmlSchemaElement(schema, true);
		element.setName(elementLP);
		schema.getElements().put(elementQn, element);

		attributeLP = "attributeLP";
		attributeQn = new QName(namespace, attributeLP);
		attribute = new XmlSchemaAttribute(schema, true);
		attribute.setName(attributeLP);
		schema.getAttributes().put(attributeQn, attribute);

		typeLP = "typeLP";
		typeQn = new QName(namespace, typeLP);
		type = new XmlSchemaSimpleType(schema, true);
		type.setName(typeLP);
		schema.getSchemaTypes().put(typeQn, type);

		attributeGroupLP = "attributeGroupLP";
		attributeGroupQn = new QName(namespace, attributeGroupLP);
		attributeGroup = new XmlSchemaAttributeGroup(schema);
		attributeGroup.setName(attributeGroupLP);
		schema.getAttributeGroups().put(attributeGroupQn, attributeGroup);

		groupLP = "groupLP";
		groupQn = new QName(namespace, groupLP);
		group = new XmlSchemaGroup(schema);
		group.setName(groupLP);
		schema.getGroups().put(groupQn, group);

		notationLP = "notationLP";
		notationQn = new QName(namespace, notationLP);
		notation = new XmlSchemaNotation(schema);
		notation.setName(notationLP);
		schema.getNotations().put(notationQn, notation);

		dummyLP = "dummyLP";
		dummyQn = new QName(namespace, dummyLP);
		dummy = new DummyXmlSchemaNamed();
		dummy.setName(dummyLP);
	}

	@Test
	public void test1() {

		XmlSchemaRef<XmlSchemaElement> elementRef = new XmlSchemaRef<XmlSchemaElement>(schema, XmlSchemaElement.class);
		elementRef.setTargetQName(elementQn);
		aeqr(element, elementRef.getTarget());

		XmlSchemaRef<XmlSchemaAttribute> attributeRef = new XmlSchemaRef<XmlSchemaAttribute>(schema,
				XmlSchemaAttribute.class);
		attributeRef.setTargetQName(attributeQn);
		aeqr(attribute, attributeRef.getTarget());

		XmlSchemaRef<XmlSchemaType> typeRef = new XmlSchemaRef<XmlSchemaType>(schema, XmlSchemaType.class);
		typeRef.setTargetQName(typeQn);
		aeqr(type, typeRef.getTarget());

		XmlSchemaRef<XmlSchemaAttributeGroup> attributeGroupRef = new XmlSchemaRef<XmlSchemaAttributeGroup>(schema,
				XmlSchemaAttributeGroup.class);
		attributeGroupRef.setTargetQName(attributeGroupQn);
		aeqr(attributeGroup, attributeGroupRef.getTarget());

		XmlSchemaRef<XmlSchemaGroup> groupRef = new XmlSchemaRef<XmlSchemaGroup>(schema, XmlSchemaGroup.class);
		groupRef.setTargetQName(groupQn);
		aeqr(group, groupRef.getTarget());

		XmlSchemaRef<XmlSchemaNotation> notationRef = new XmlSchemaRef<XmlSchemaNotation>(schema,
				XmlSchemaNotation.class);
		notationRef.setTargetQName(notationQn);
		aeqr(notation, notationRef.getTarget());

		XmlSchemaRef<DummyXmlSchemaNamed> dummyRef = new XmlSchemaRef<DummyXmlSchemaNamed>(schema,
				DummyXmlSchemaNamed.class);
		an(dummyRef.getTarget());

		dummyRef.setTargetQName(dummyQn);
		an(dummyRef.getTarget());

		aeqr(notation, notationRef.getTarget());

		aeq("XmlSchemaRef: org.apache.ws.commons.schema.XmlSchemaNotation {namespace}notationLP",
				notationRef.toString());
	}

	/**
	 * Check that changing the target name after getTarget has been called works
	 **/
	@Test
	public void test2() {

		String attributeLP1 = "attributeLP1";
		String attributeLP2 = "attributeLP2";
		QName attributeQn1 = new QName(namespace, attributeLP1);
		QName attributeQn2 = new QName(namespace, attributeLP2);

		XmlSchemaAttribute attribute1 = new XmlSchemaAttribute(schema, true);
		attribute1.setName(attributeLP1);
		schema.getAttributes().put(attributeQn1, attribute1);

		XmlSchemaAttribute attribute2 = new XmlSchemaAttribute(schema, true);
		attribute2.setName(attributeLP2);
		schema.getAttributes().put(attributeQn2, attribute2);

		XmlSchemaRef<XmlSchemaAttribute> attributeRef = new XmlSchemaRef<XmlSchemaAttribute>(schema,
				XmlSchemaAttribute.class);
		attributeRef.setTargetQName(attributeQn1);
		aeqr(attribute1, attributeRef.getTarget());

		attributeRef.setTargetQName(attributeQn2);
		aeqr(attribute2, attributeRef.getTarget());
	}

}
