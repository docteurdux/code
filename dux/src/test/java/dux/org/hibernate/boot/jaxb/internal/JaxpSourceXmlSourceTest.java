package dux.org.hibernate.boot.jaxb.internal;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.internal.JaxpSourceXmlSource;
import org.hibernate.boot.jaxb.spi.Binding;
import org.hibernate.boot.jaxb.spi.XmlSource;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.transform.DummySource;
import dum.org.hibernate.boot.jaxb.spi.DummyBinder;

@Done
public class JaxpSourceXmlSourceTest extends AbstractTest {

	private SourceType sourceType;
	private String name;
	private Origin origin;
	private DummySource source;
	private DummyBinder binder;
	private Object bindingRoot;
	private Binding<Object> binding;

	@Before
	public void before() {

		sourceType = SourceType.OTHER;
		name = "name";
		origin = new Origin(sourceType, name);
		source = new DummySource();

		bindingRoot = new Object();
		binding = new Binding<Object>(bindingRoot, origin);

		binder = new DummyBinder();
		binder.setBinding(binding);
	}

	@Test
	public void test() {

		aeq(XmlSource.class, JaxpSourceXmlSource.class.getSuperclass());

		JaxpSourceXmlSource jaxpSourceXmlSource = new JaxpSourceXmlSource(origin, source);

		aeqr(source, getField(jaxpSourceXmlSource, "jaxpSource"));

		XmlSource xmlSource = jaxpSourceXmlSource;
		aeqr(origin, xmlSource.getOrigin());

		aeqr(binding, jaxpSourceXmlSource.doBind(binder));

	}
}
