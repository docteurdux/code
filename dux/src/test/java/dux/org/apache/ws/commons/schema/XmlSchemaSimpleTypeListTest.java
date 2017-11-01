package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaSimpleTypeList;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSimpleTypeListTest extends AbstractTest {

	private XmlSchema schema;
	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;

	@Before
	public void before() {
		namespace = "namespace";
		systemId = "systemId";
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);
	}

	@Test
	public void test1() {
		XmlSchemaSimpleTypeList list = new XmlSchemaSimpleTypeList();

		XmlSchemaSimpleType itemType = new XmlSchemaSimpleType(schema, true);
		an(list.getItemType());
		list.setItemType(itemType);

		QName itemTypeName = new QName("itemTypeNameNS", "itemTypeNameLP");
		an(list.getItemTypeName());
		list.setItemTypeName(itemTypeName);
		aeq(itemTypeName, list.getItemTypeName());
	}

}
