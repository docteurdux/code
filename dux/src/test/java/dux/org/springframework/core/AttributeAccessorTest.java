package dux.org.springframework.core;

import org.junit.Test;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.AttributeAccessor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AttributeAccessor.class)
public class AttributeAccessorTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.hibernate.annotations.AttributeAccessor defines a contract for setting
		 * and getting attributes
		 */

		String name = "name";
		Object value = new Object();

		/*
		 * We illustrate the interface on
		 * org.springframework.beans.factory.support.RootBeanDefinition
		 */

		AttributeAccessor attributeAccessor = new RootBeanDefinition();

		/* We can set an attribute to a value */
		attributeAccessor.setAttribute(name, value);

		/* And check that the attribute is there */
		aeq(true, attributeAccessor.hasAttribute(name));
		aeq(1, attributeAccessor.attributeNames().length);
		aeq("name", attributeAccessor.attributeNames()[0]);

		/* And it has the expected value */
		aeqr(value, attributeAccessor.getAttribute(name));

		/* And we can remove it */
		attributeAccessor.removeAttribute(name);
		aeq(false, attributeAccessor.hasAttribute(name));

	}
}
