package dum.org.apache.ws.commons.schema.utils;

import org.apache.ws.commons.schema.utils.XmlSchemaRefBase;

public class DummyXmlSchemaRefBase extends XmlSchemaRefBase {

	private int forgetCount;

	@Override
	protected void forgetTargetObject() {
		++forgetCount;
	}

	public int getForgetCount() {
		return forgetCount;
	}

}
