package dum.javax.xml.transform;

import javax.xml.transform.Source;

public class DummySource implements Source {

	private String systemId;

	public DummySource() {
	}

	public DummySource(String systemId) {
		this.systemId = systemId;
	}

	@Override
	public void setSystemId(String systemId) {
		this.systemId = systemId;

	}

	@Override
	public String getSystemId() {
		return systemId;
	}

}
