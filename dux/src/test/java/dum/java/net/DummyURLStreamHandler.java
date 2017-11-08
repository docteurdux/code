package dum.java.net;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class DummyURLStreamHandler extends URLStreamHandler {

	private URLConnection connection;

	@Override
	protected URLConnection openConnection(URL u) throws IOException {
		return connection;
	}

	public void setConnection(URLConnection connection) {
		this.connection = connection;
	}

}
