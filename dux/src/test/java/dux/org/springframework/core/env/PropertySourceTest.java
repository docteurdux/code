package dux.org.springframework.core.env;

import org.junit.Test;
import org.springframework.core.env.PropertySource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(PropertySource.class)
public class PropertySourceTest extends AbstractTest {

	@Test
	public void test() {
		PropertySource.named("name");

		Object source = new Object();
		String propertyName = "propertyName";
		Object property = new Object();

		PropertySource<Object> ps = new PropertySource<Object>("name", source) {
			@Override
			public Object getProperty(String name) {
				if (propertyName.equals(name)) {
					return property;
				}
				return null;
			}
		};

		aeqr(source, ps.getSource());
		aeq("name", ps.getName());
		aeq(true, ps.containsProperty(propertyName));
		aeqr(property, ps.getProperty(propertyName));

		aeq(" {name='name'}", ps.toString());

		/* hashcode and equality is based on name */
		aeq("name".hashCode(), ps.hashCode());

	}
}
