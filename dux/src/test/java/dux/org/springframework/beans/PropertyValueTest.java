package dux.org.springframework.beans;

import org.junit.Test;
import org.springframework.beans.PropertyValue;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(PropertyValue.class)
@Related({ BeanMetadataAttributeAccessorTest.class })
public class PropertyValueTest extends AbstractTest {
	@Test
	public void test() {

		/* org.springframework.beans.PropertyValue is quite a complicated object */

		/*
		 * It extends org.springframework.beans.BeanMetadataAttributeAccessor and so
		 * delegate the behaviour of org.springframework.core.AttributeAccessor to
		 * instances of org.springframework.beans.BeanMetadataAttribute
		 */

		/* But it also introduces an independent hierarchical behavior */

		/*
		 * First, as in BeanMetadataAttributeAccessor, a PropertyValue has a name, a
		 * value, and a source.
		 */
		String name = "name";
		Object originalValue = new Object();
		Object originalSource = new Object();
		PropertyValue originalLevel = new PropertyValue(name, originalValue);
		originalLevel.setSource(originalSource);

		/* No surprise here */
		aeq(name, originalLevel.getName());
		aeqr(originalSource, originalLevel.getSource());

		/* It can also be optional */
		aeq(false, originalLevel.isOptional());
		originalLevel.setOptional(true);
		aeq(true, originalLevel.isOptional());

		/* And it can take a converted value */
		Object convertedValue = new Object();
		aeq(null, originalLevel.getConvertedValue());
		aeq(false, originalLevel.isConverted());
		originalLevel.setConvertedValue(convertedValue);
		aeq(true, originalLevel.isConverted());
		aeqr(convertedValue, originalLevel.getConvertedValue());
		/*
		 * Once the converted value as be set, there's no way to have isConverted()
		 * return false later
		 */

		/* there's also a getOriginalPropertyValue() method which returns itself */
		aeq(originalLevel, originalLevel.getOriginalPropertyValue());

		/*
		 * And so far, no attributes have been defined. Refer to
		 * BeanMetadataAttributeAccessorTest for that aspect.
		 */
		aeq(0, originalLevel.attributeNames().length);

		/*
		 * Now we introduce a new instance of PropertyValue on 'originalLevel', with a
		 * new value 'firstLevelValue'
		 */
		Object firstLevelValue = new Object();
		PropertyValue firstLevel = new PropertyValue(originalLevel, firstLevelValue);
		/* The source is the underlying property value */
		aeqr(originalLevel, firstLevel.getSource());
		/* The value is the top level value */
		aeqr(firstLevelValue, firstLevel.getValue());
		/*
		 * And if we ask for the original property value, we get the underlying property
		 * value
		 */
		aeqr(originalLevel, firstLevel.getOriginalPropertyValue());

		/*
		 * Now, we introduce yet another instance of PropertyValue based on the previous
		 * level
		 */
		Object secondLevelValue = new Object();
		PropertyValue secondLevel = new PropertyValue(firstLevel, secondLevelValue);
		/* The source is as expected */
		aeqr(firstLevel, secondLevel.getSource());
		/* And so is the vlaue */
		aeqr(secondLevelValue, secondLevel.getValue());
		/* The originalPropertyValue walks back to the bottom */
		aeqr(originalLevel, secondLevel.getOriginalPropertyValue());

		/*
		 * And now, we do the same thing as before, on the original level, with no value
		 * this time
		 */
		PropertyValue bonusLevel = new PropertyValue(originalLevel);
		/* The source is as expected */
		aeqr(originalSource, bonusLevel.getSource());
		/*
		 * ut this time, the source is the source of originalLevel, and not
		 * originalLevel. This is surprising.
		 */
		aeqr(originalValue, bonusLevel.getValue());
		/*
		 * And the original property value is the bonus level, and not the original
		 * level
		 */
		aeqr(bonusLevel, bonusLevel.getOriginalPropertyValue());

		// TODO : illustrate why theses differences are useful
	}
}
