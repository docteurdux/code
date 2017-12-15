package dux.org.springframework.beans;

import java.beans.PropertyEditor;

import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.core.convert.support.DefaultConversionService;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(PropertyEditorRegistrySupport.class)
public class PropertyEditorRegistrySupportTest extends AbstractTest {
	@Test
	public void test() {

		PropertyEditorRegistrySupport s = new PropertyEditorRegistrySupport();

		aeq(null,s.getConversionService());
		
		DefaultConversionService conversionService = new DefaultConversionService();
		s.setConversionService(conversionService);
		aeqr(conversionService, s.getConversionService());
		
		
		if (t()) {
			return;
		}

		Class<?> requiredType = null;
		String propertyPath = null;
		Class<?> elementType = null;
		PropertyEditor propertyEditor = null;

		s.findCustomEditor(requiredType, propertyPath);
		s.getDefaultEditor(requiredType);
		s.hasCustomEditorForElement(elementType, propertyPath);
		s.overrideDefaultEditor(requiredType, propertyEditor);
		s.registerCustomEditor(requiredType, propertyEditor);
		s.registerCustomEditor(requiredType, propertyPath, propertyEditor);
		s.setConversionService(conversionService);
		s.useConfigValueEditors();

		/*-
		PropertyEditorRegistrySupport()
		findCustomEditor(Class<?>, String)
		getConversionService()
		getDefaultEditor(Class<?>)
		hasCustomEditorForElement(Class<?>, String)
		overrideDefaultEditor(Class<?>, PropertyEditor)
		registerCustomEditor(Class<?>, PropertyEditor)
		registerCustomEditor(Class<?>, String, PropertyEditor)
		setConversionService(ConversionService)
		useConfigValueEditors()
		 */
	}
}
