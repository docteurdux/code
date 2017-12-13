package dux.org.springframework.beans;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(PropertyAccessor.class)
public class PropertyAccessorTest extends AbstractTest {
	@Test
	public void test() {

		BeanWrapperImpl w = new BeanWrapperImpl();

		String propertyName = null;
		w.getPropertyType(propertyName);
		w.getPropertyTypeDescriptor(propertyName);
		w.getPropertyValue(propertyName);
		w.isReadableProperty(propertyName);
		w.isWritableProperty(propertyName);
		PropertyValue pv = null;
		w.setPropertyValue(pv);
		Object value = null;
		w.setPropertyValue(propertyName, value);
		Map<?, ?> map = null;
		w.setPropertyValues(map);
		PropertyValues pvs = null;
		w.setPropertyValues(pvs);
		boolean ignoreUnknown = false;
		w.setPropertyValues(pvs, ignoreUnknown);
		boolean ignoreInvalid = false;
		w.setPropertyValues(pvs, ignoreUnknown, ignoreInvalid);

		/*-
		getPropertyType(String)
		getPropertyTypeDescriptor(String)
		getPropertyValue(String)
		isReadableProperty(String)
		isWritableProperty(String)
		setPropertyValue(String, Object)
		setPropertyValue(PropertyValue)
		setPropertyValues(Map<?, ?>)
		setPropertyValues(PropertyValues)
		setPropertyValues(PropertyValues, boolean)
		setPropertyValues(PropertyValues, boolean, boolean)
		 */
	}
}
