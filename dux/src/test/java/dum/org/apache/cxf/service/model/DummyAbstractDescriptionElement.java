package dum.org.apache.cxf.service.model;

import org.apache.cxf.service.model.AbstractDescriptionElement;
import org.apache.cxf.service.model.DescriptionInfo;

public class DummyAbstractDescriptionElement extends AbstractDescriptionElement {

	private DescriptionInfo description;

	@Override
	public DescriptionInfo getDescription() {
		return description;
	}

	public void setDescription(DescriptionInfo description) {
		this.description = description;
	}

}
