package dux.org.apache.neethi.builders.converters;

import javax.xml.namespace.QName;

import org.apache.neethi.builders.converters.AbstractOMConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.axiom.om.DummyOMAttribute;
import dux.org.apache.axiom.om.DummyOMElement;

@Done("good enough")
public class AbstractOMConverterTest extends AbstractTest {
	private DummyOMAttribute attribute;
	private String attributeLP;
	private String attributeValue;
	private DummyOMElement child;

	@Before
	public void before() {

		attributeLP = "attributeLP";
		attributeValue = "attributeValue";

		attribute = new DummyOMAttribute();
		attribute.setLocalName(attributeLP);
		attribute.setAttributeValue(attributeValue);

		child = new DummyOMElement();
	}

	@Test
	public void test() {

		AbstractOMConverter converter = new AbstractOMConverter() {
		};

		DummyOMElement element = new DummyOMElement();
		element.setLocalName("elementLP");
		element.getAttributes().add(attribute);
		element.getChilds().add(child);

		aeq(new QName("elementLP"), converter.getQName(element));

		aeq(attributeValue, converter.getAttributes(element).get(new QName(attributeLP)));

		aeqr(child, converter.getChildren(element).next());
	}
}
