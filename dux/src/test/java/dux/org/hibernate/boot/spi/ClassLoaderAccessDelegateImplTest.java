package dux.org.hibernate.boot.spi;

import java.net.URL;

import org.hibernate.boot.spi.ClassLoaderAccess;
import org.hibernate.boot.spi.ClassLoaderAccessDelegateImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.net.DummyURLStreamHandler;
import dum.org.hibernate.boot.spi.DummyClassLoaderAccess;

@Done
public class ClassLoaderAccessDelegateImplTest extends AbstractTest {

	private String name;
	private Class<Object> clazz;
	private URL url;

	private DummyClassLoaderAccess classLoaderAccess;

	@Before
	public void before() throws Exception {

		name = "name";
		clazz = Object.class;
		url = new URL("", "", 0, "", new DummyURLStreamHandler());

		classLoaderAccess = new DummyClassLoaderAccess();

		classLoaderAccess.setClass(name, clazz);
		classLoaderAccess.setURL(name, url);
	}

	@Test
	public void test() {

		ClassLoaderAccessDelegateImpl classLoaderAccessDelegateImpl = new ClassLoaderAccessDelegateImpl() {
			@Override
			protected ClassLoaderAccess getDelegate() {
				return classLoaderAccess;
			}
		};

		aeq(clazz, classLoaderAccessDelegateImpl.classForName(name));
		aeqr(url, classLoaderAccessDelegateImpl.locateResource(name));

	}

}
