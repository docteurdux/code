package dux.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(BeanMetadataElement.class)
public class BeanMetadataElementTest extends AbstractTest {
	@Test
	public void test() {

		/* org.springframework.beans.BeanMetadataElement define a getSource() method */

		/*
		 * For example,
		 * org.springframework.beans.factory.config.RuntimeBeanNameReference implements
		 * BeanMetadataElement to associate bean instances to bean names
		 */

		Object bean = new Object();

		RuntimeBeanNameReference beanMetadataElement = new RuntimeBeanNameReference("name");
		beanMetadataElement.setSource(bean);

		aeqr(bean, beanMetadataElement.getSource());
	}
}
