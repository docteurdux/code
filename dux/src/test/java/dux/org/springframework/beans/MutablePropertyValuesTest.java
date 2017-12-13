package dux.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MutablePropertyValues.class)
@Related({ PropertyValuesTest.class })
public class MutablePropertyValuesTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		MutablePropertyValues()
		MutablePropertyValues(List<PropertyValue>)
		MutablePropertyValues(Map<?, ?>)
		MutablePropertyValues(PropertyValues)
		add(String, Object)
		addPropertyValue(String, Object)
		addPropertyValue(PropertyValue)
		addPropertyValues(Map<?, ?>)
		addPropertyValues(PropertyValues)
		changesSince(PropertyValues)
		clearProcessedProperty(String)
		contains(String)
		equals(Object)
		get(String)
		getPropertyValue(String)
		getPropertyValueList()
		getPropertyValues()
		hashCode()
		isConverted()
		isEmpty()
		registerProcessedProperty(String)
		removePropertyValue(String)
		removePropertyValue(PropertyValue)
		setConverted()
		setPropertyValueAt(PropertyValue, int)
		size()
		toString()
		 */
	}
}
