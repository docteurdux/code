package dux.org.apache.neethi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.neethi.util.Service;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.lang.DummyClassLoader;
import dum.java.net.DummyURLConnection;
import dum.java.net.DummyURLStreamHandler;

@Done
public class ServiceTest extends AbstractTest {

	private Class<?> clazz;

	@Before
	public void before() throws Exception {

		DummyClassLoader cl = new DummyClassLoader();
		cl.setParent(this.getClass().getClassLoader());
		putClass(cl, A.class);
		putClass(cl, B.class);
		putResource(cl, "META-INF/services/" + A.class.getName(), B.class.getName());

		clazz = cl.loadClass(A.class.getName());

		aeqr(cl, clazz.getClassLoader());

	}

	@Test
	public void test() {
		List<?> providers = Service.providers(clazz);
		aeq(1, providers.size());
		aeq(B.class.getName(), providers.get(0).getClass().getName());
	}

	private void putClass(DummyClassLoader cl, Class<?> clazz) throws Exception {

		String fileName = clazz.getName().replaceAll("\\.", "/") + ".class";
		InputStream byteStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(byteStream, baos);

		cl.getClasses().put(clazz.getName(), baos.toByteArray());
	}

	private void putResource(DummyClassLoader cl, String name, String content) throws Exception {

		InputStream bais = new ByteArrayInputStream(content.getBytes());

		DummyURLStreamHandler handler = new DummyURLStreamHandler();
		URL url = new URL("", "", 0, "", handler);
		DummyURLConnection connection = new DummyURLConnection(url);
		connection.setInputStream(bais);
		handler.setConnection(connection);

		cl.getResources().put(name, url);
	}
}
