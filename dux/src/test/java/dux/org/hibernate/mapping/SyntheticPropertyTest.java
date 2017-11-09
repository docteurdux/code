package dux.org.hibernate.mapping;

import org.hibernate.mapping.Property;
import org.hibernate.mapping.SyntheticProperty;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SyntheticPropertyTest extends AbstractTest {
	@Test
	public void test() {
		aeq(Property.class, SyntheticProperty.class.getSuperclass());
		at(new SyntheticProperty().isSynthetic());
	}
}
