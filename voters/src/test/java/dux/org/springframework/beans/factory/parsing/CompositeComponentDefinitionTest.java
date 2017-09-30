package dux.org.springframework.beans.factory.parsing;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.parsing.ComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;

public class CompositeComponentDefinitionTest {
	@Test
	public void test() {
		String name = "name";
		Object source = new Object();
		CompositeComponentDefinition definition = new CompositeComponentDefinition(name, source);
		Assert.assertEquals(name, definition.getName());
		Assert.assertEquals(source, definition.getSource());
		Assert.assertArrayEquals(new ComponentDefinition[] {}, definition.getNestedComponents());
	}
}
