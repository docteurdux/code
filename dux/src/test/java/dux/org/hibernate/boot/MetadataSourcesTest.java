package dux.org.hibernate.boot;

import org.hibernate.boot.MetadataSources;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.java.io.DummyFile;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class MetadataSourcesTest extends AbstractTest {

	public static class A {

	}

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, MetadataSources.class);
	}

	@Test
	public void test() {

		MetadataSources md = new MetadataSources();

		md.addAnnotatedClass(A.class);
		md.addAnnotatedClassName("clazz");

		DummyFile f = new DummyFile("fileName");
		md.addCacheableFile(f);
		// addCacheableFile(String)
		// addCacheableFileStrictly(File)
		// addClass(Class)
		// addDirectory(File)
		// addDocument(Document)
		// addFile(File)
		// addFile(String)
		// addInputStream(InputStream)
		// addInputStream(InputStreamAccess)
		// addJar(File)
		// addPackage(Package)
		// addPackage(String)
		// addResource(String)
		// addURL(URL)
		// buildMetadata()
		// buildMetadata(StandardServiceRegistry)
		// getAnnotatedClasses()
		// getAnnotatedClassNames()
		// getAnnotatedPackages()
		// getMetadataBuilder()
		// getMetadataBuilder(StandardServiceRegistry)
		// getServiceRegistry()
		// getXmlBindings()
		// getXmlMappingBinderAccess()
	}
}
