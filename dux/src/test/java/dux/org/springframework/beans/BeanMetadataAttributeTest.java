package dux.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.BeanMetadataAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(BeanMetadataAttribute.class)
public class BeanMetadataAttributeTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * A org.springframework.beans.BeanMetadataAttribute has a name, a value, and a
		 * source
		 */

		String name = "name";
		Object value = new Object();
		Object source = new Object();

		/* The name and the value must be specified on the constructor */
		BeanMetadataAttribute bma = new BeanMetadataAttribute(name, value);
		aeq(name, bma.getName());
		aeqr(value, bma.getValue());

		/*
		 * The source, inherited from org.springframework.beans.BeanMetadataElement, is
		 * initially null, but can be set
		 */
		aeq(null, bma.getSource());
		bma.setSource(source);
		aeqr(source, bma.getSource());

		/* toString() does something */
		aeq("metadata attribute 'name'", bma.toString());

		/* equals and hashCode are defined over the name, the value and the source */

	}
}
