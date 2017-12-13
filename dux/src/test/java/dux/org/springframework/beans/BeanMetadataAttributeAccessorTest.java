package dux.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanMetadataAttributeAccessor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(BeanMetadataAttributeAccessor.class)
public class BeanMetadataAttributeAccessorTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.beans.BeanMetadataAttributeAccessor delegates
		 * org.springframework.core.AttributeAccessor methods to instances of
		 * org.springframework.beans.BeanMetadataAttribute
		 */

		BeanMetadataAttributeAccessor accessor = new BeanMetadataAttributeAccessor();

		/* Let's create a new BeanMetadataAttribute */
		Object value = new Object();
		String name = "name";
		BeanMetadataAttribute attribute = new BeanMetadataAttribute(name, value);

		/* We add the attribute using addMetadataAttribute() */
		accessor.addMetadataAttribute(attribute);

		/* We can retrieve beanMetadataAttribute1 with getMetadataAttribute() */
		aeqr(attribute, accessor.getMetadataAttribute(name));

		/*
		 * getAttribute() returns the value of the metadataAttribute, and hasAttribute()
		 * is positive for "name1"
		 */
		aeq(true, accessor.hasAttribute(name));
		aeqr(value, accessor.getAttribute(name));

		/*
		 * If we remove attribute "name1", then getMetadataAttribute() returns null for
		 * "name1"
		 */
		accessor.removeAttribute(name);
		aeq(null, accessor.getMetadataAttribute(name));

		/* If we use setAttribute(), then a new metaDataAttribute is created */
		accessor.setAttribute(name, value);
		aeq(true, accessor.getMetadataAttribute(name) != null);
		aeq(true, accessor.getMetadataAttribute(name) != attribute);

		/*
		 * Also, because BeanMetadataAttributeAccessor implements
		 * org.springframework.beans.BeanMetadataElement, it has a source, which is
		 * null, but can be set
		 */

		Object source = new Object();
		aeq(null, accessor.getSource());
		accessor.setSource(source);
		aeqr(source, accessor.getSource());

		/*
		 * BeanMetadataAttribute also implements BeanMetadataElement, but the sources
		 * are used by neither BeanMetadataAttributeAccessor nor BeanMetadataAttribute
		 */

		aeq(true, accessor.getSource() != accessor.getMetadataAttribute(name).getSource());
	}
}
