package dux.org.springframework.beans;

import org.springframework.beans.ConfigurablePropertyAccessor;

import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConfigurablePropertyAccessor.class)
@Related({ PropertyAccessorTest.class, PropertyEditorRegistryTest.class, TypeConverterTest.class })
public class ConfigurablePropertyAccessorTest {

}
