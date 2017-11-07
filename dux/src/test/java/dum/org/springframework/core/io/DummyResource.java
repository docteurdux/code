package dum.org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.springframework.core.io.Resource;

public class DummyResource implements Resource {

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contentLength() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Resource createRelative(String arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getFile() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long lastModified() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
