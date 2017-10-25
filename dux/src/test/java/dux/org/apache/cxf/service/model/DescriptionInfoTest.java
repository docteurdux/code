package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.AbstractDescriptionElement;
import org.apache.cxf.service.model.DescriptionInfo;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.cxf.service.model.DummyAbstractDescriptionElement;

@Done
public class DescriptionInfoTest extends AbstractTest {

	@Test
	public void test() {

		QName diQn = new QName("diQn");
		String baseUri = "baseUri";
		AbstractDescriptionElement ade = new DummyAbstractDescriptionElement();

		DescriptionInfo di = new DescriptionInfo();
		an(di.getName());
		an(di.getBaseURI());
		aeq(0, di.getDescribed().size());

		di.setName(diQn);
		di.setBaseURI(baseUri);
		di.getDescribed().add(ade);

		aeq(diQn, di.getName());
		aeq(baseUri, di.getBaseURI());
		aeq(1, di.getDescribed().size());
		aeq(ade, di.getDescribed().get(0));

	}

}
