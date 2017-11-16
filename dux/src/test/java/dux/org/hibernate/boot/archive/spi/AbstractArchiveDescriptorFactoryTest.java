package dux.org.hibernate.boot.archive.spi;

import java.net.URL;

import org.hibernate.boot.archive.spi.ArchiveDescriptor;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.net.DummyURLStreamHandler;
import dum.org.hibernate.boot.archive.spi.DummyAbstractArchiveDescriptorFactory;

@Done
public class AbstractArchiveDescriptorFactoryTest extends AbstractTest {

	private DummyURLStreamHandler urlStreamHandler;
	private URL url;
	private String entry;
	private String jarPath;

	@Before
	public void before() throws Exception {

		entry = "entry";
		jarPath = "jarPath";

		urlStreamHandler = new DummyURLStreamHandler();
		url = new URL("scheme", "host", 0, "/path/entry", urlStreamHandler);
	}

	@Test
	public void test() {

		DummyAbstractArchiveDescriptorFactory abstractArchiveDescriptorFactory = new DummyAbstractArchiveDescriptorFactory();

		ArchiveDescriptor archiveDescriptor = abstractArchiveDescriptorFactory.buildArchiveDescriptor(url);
		an(archiveDescriptor); // always null

		URL jarURLFromURLEntry = abstractArchiveDescriptorFactory.getJarURLFromURLEntry(url, entry);
		aeq("scheme://host:0/path/entry", jarURLFromURLEntry.toString());

		URL urlFromPath = abstractArchiveDescriptorFactory.getURLFromPath(jarPath);
		aeq("file:jarPath", urlFromPath.toString());
	}
}
