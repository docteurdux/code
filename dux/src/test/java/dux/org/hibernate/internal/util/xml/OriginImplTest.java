package dux.org.hibernate.internal.util.xml;

import org.hibernate.internal.util.xml.OriginImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class OriginImplTest extends AbstractTest {
	@Test
	public void test() {

		String type = "type";
		String name = "name";

		OriginImpl originImpl = new OriginImpl(type, name);

		aeq(type, originImpl.getType());
		aeq(name, originImpl.getName());
	}
}
