package dux.org.apache.ws.commons.schema.utils;

import org.apache.ws.commons.schema.utils.XDOMUtil;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;

public class XDOMUtilTest extends AbstractTest {
	@Test
	public void test() {
		String uri = "uri";
		String name = "name";
		Element element = null;
		Node node = null;
		XDOMUtil.anyElementsWithNameNS(element, uri, name);
		XDOMUtil.getFirstChildElementNS(node, uri);
		XDOMUtil.getNextSiblingElementNS(node, uri);
	}
}
