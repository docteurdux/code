package dux.org.springframework.core;

import org.junit.Test;
import org.springframework.core.AttributeAccessorSupport;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AttributeAccessorSupport.class)
@Related({ AttributeAccessorTest.class })
public class AttributeAccessorSupportTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.core.AttributeAccessorSupport defines a common behavior
		 * for classes that want to implement org.springframework.core.AttributeAccessor
		 */

		AttributeAccessorSupport attributeAccessor = new AttributeAccessorSupport() {
			private static final long serialVersionUID = 1L;
		};

		String name = "name";
		Object value = new Object();

		/* Set the attribute */
		attributeAccessor.setAttribute(name, value);

		/* Check the attribute exists with the expected value */
		aeq(true, attributeAccessor.hasAttribute(name));
		aeq(1, attributeAccessor.attributeNames().length);
		aeq("name", attributeAccessor.attributeNames()[0]);
		aeqr(value, attributeAccessor.getAttribute(name));

		/* Remove the attribute */
		attributeAccessor.removeAttribute(name);
		aeq(false, attributeAccessor.hasAttribute(name));

	}
}
