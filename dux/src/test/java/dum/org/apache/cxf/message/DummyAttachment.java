package dum.org.apache.cxf.message;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.activation.DataHandler;

import org.apache.cxf.message.Attachment;

public class DummyAttachment implements Attachment {

	private DataHandler dataHandler;
	private String id;
	private Map<String, String> headers = new HashMap<>();
	private boolean xop;

	@Override
	public DataHandler getDataHandler() {
		return dataHandler;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getHeader(String name) {
		return headers.get(name);
	}

	@Override
	public Iterator<String> getHeaderNames() {
		return headers.keySet().iterator();
	}

	@Override
	public boolean isXOP() {
		return xop;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setXop(boolean xop) {
		this.xop = xop;
	}

}
