package dum.org.hibernate.boot.archive.spi;

import java.net.URL;

import org.hibernate.boot.archive.spi.ArchiveDescriptor;
import org.hibernate.boot.archive.spi.ArchiveDescriptorFactory;

public class DummyArchiveDescriptorFactory implements ArchiveDescriptorFactory {

	@Override
	public ArchiveDescriptor buildArchiveDescriptor(URL url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArchiveDescriptor buildArchiveDescriptor(URL url, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getJarURLFromURLEntry(URL url, String entry) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURLFromPath(String jarPath) {
		// TODO Auto-generated method stub
		return null;
	}

}
