package dux.org.springframework.validation;

import org.junit.Test;
import org.springframework.validation.DataBinder;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(DataBinder.class)
public class DataBinderTest extends AbstractTest {
	@Test
	public void test() {

		Object target = new Object();
		DataBinder d = new DataBinder(target);

		aeqr(target, d.getTarget());
		aeq(DataBinder.DEFAULT_OBJECT_NAME, d.getObjectName());
		aeq("target", DataBinder.DEFAULT_OBJECT_NAME);

		aeq(true, d.isAutoGrowNestedPaths());
		aeq(DataBinder.DEFAULT_AUTO_GROW_COLLECTION_LIMIT, d.getAutoGrowCollectionLimit());
		aeq(256, DataBinder.DEFAULT_AUTO_GROW_COLLECTION_LIMIT);

		/*-
		findCustomEditor(Class<?>, String)
		registerCustomEditor(Class<?>, PropertyEditor)
		registerCustomEditor(Class<?>, String, PropertyEditor)
		 */

		/*-
		convertIfNecessary(Object, Class<T>)
		convertIfNecessary(Object, Class<T>, Field)
		convertIfNecessary(Object, Class<T>, MethodParameter)
		 */

		/*-
		DataBinder(Object)
		DataBinder(Object, String)
		addCustomFormatter(Formatter<?>)
		addCustomFormatter(Formatter<?>, Class<?>...)
		addCustomFormatter(Formatter<?>, String...)
		addValidators(Validator...)
		bind(PropertyValues)
		close()
		convertIfNecessary(Object, Class<T>)
		convertIfNecessary(Object, Class<T>, Field)
		convertIfNecessary(Object, Class<T>, MethodParameter)
		findCustomEditor(Class<?>, String)
		getAllowedFields()
		getAutoGrowCollectionLimit()
		getBindingErrorProcessor()
		getBindingResult()
		getConversionService()
		getDisallowedFields()
		getObjectName()
		getRequiredFields()
		getTarget()
		getValidator()
		getValidators()
		initBeanPropertyAccess()
		initDirectFieldAccess()
		isAutoGrowNestedPaths()
		isIgnoreInvalidFields()
		isIgnoreUnknownFields()
		registerCustomEditor(Class<?>, PropertyEditor)
		registerCustomEditor(Class<?>, String, PropertyEditor)
		replaceValidators(Validator...)
		setAllowedFields(String...)
		setAutoGrowCollectionLimit(int)
		setAutoGrowNestedPaths(boolean)
		setBindingErrorProcessor(BindingErrorProcessor)
		setConversionService(ConversionService)
		setDisallowedFields(String...)
		setExtractOldValueForEditor(boolean)
		setIgnoreInvalidFields(boolean)
		setIgnoreUnknownFields(boolean)
		setMessageCodesResolver(MessageCodesResolver)
		setRequiredFields(String...)
		setValidator(Validator)
		validate()
		validate(Object...)
		 */
	}
}
