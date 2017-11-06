package dux.org.apache.cxf.attachment;

import javax.activation.DataHandler;
import javax.activation.DataSource;

public class DummyDataHandler extends DataHandler {

	private String name;

	public DummyDataHandler(DataSource ds) {
		super(ds);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
