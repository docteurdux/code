package dux.org.apache.neethi.builders.converters;

import java.util.Arrays;

import org.apache.neethi.builders.converters.StaxToDOMConverter;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.stream.DummyXMLStreamReader;
import dum.javax.xml.stream.DummyXMLStreamReader.Event;

@Done("good enough")
public class StaxToDOMConverterTest extends AbstractTest {

	private DummyXMLStreamReader reader;
	private String parentNS;
	private String parentLP;
	private String childNS;
	private String childLP;
	private String comment;
	private String cdata;
	private String characters;
	private String pitarget;
	private String pidata;
	private String entityTarget;
	private String entityData;

	@Before
	public void before() {

		parentNS = "parentNS";
		parentLP = "parentLP";

		childNS = "childNS";
		childLP = "childLP";

		comment = "comment";

		cdata = "cdata";

		characters = "cdata";

		pitarget = "pitarget";
		pidata = "pidata";

		entityTarget = "entityTarget";
		entityData = "entityData";

		reader = new DummyXMLStreamReader();

		reader.setEvents(Arrays.asList(new Event[] {

				Event.startElement(parentNS, parentLP),

				Event.startElement(childNS, childLP),

				Event.endElement(),

				Event.namespace(),

				Event.attribute(),

				Event.comment(comment),

				Event.cdata(cdata),

				Event.characters(characters),

				Event.processingInstruction(pitarget, pidata),

				Event.entityReference(entityTarget, entityData),

				Event.endElement(),

		}));

	}

	@Test
	public void test() throws Exception {

		StaxToDOMConverter converter = new StaxToDOMConverter();

		Element element = converter.convert(reader);

		aeq(parentNS, element.getNamespaceURI());
		aeq(parentLP, element.getLocalName());
		aeq(parentLP, element.getNodeName());
		aeq(parentLP, element.getTagName());

		at(element.getParentNode() instanceof Document);
	}

}
