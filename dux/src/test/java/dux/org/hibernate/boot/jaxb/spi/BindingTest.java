package dux.org.hibernate.boot.jaxb.spi;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.spi.Binding;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BindingTest extends AbstractTest {

	private Object root;
	private Origin origin;

	@Before
	public void before() {
		root = new Object();
		origin = new Origin(SourceType.OTHER, "name");
	}

	@Test
	public void test() {

		Binding<Object> binding = new Binding<>(root, origin);
		aeqr(root, binding.getRoot());
		aeqr(origin, binding.getOrigin());

	}
}
