package dux.org.springframework.web.bind.support;

import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(ConfigurableWebBindingInitializer.class)
public class ConfigurableWebBindingInitializerTest extends AbstractTest {
	@Test
	public void test() {
		ConfigurableWebBindingInitializer c = new ConfigurableWebBindingInitializer();

		ConversionService conversionService = new DefaultConversionService();
		aeq(null, c.getConversionService());
		c.setConversionService(conversionService);
		aeqr(conversionService, c.getConversionService());

		Validator validator = Recorder.create(Validator.class).p();
		aeq(null, c.getValidator());
		c.setValidator(validator);
		aeqr(validator, c.getValidator());

		BindingErrorProcessor bindingErrorProcessor = Recorder.create(BindingErrorProcessor.class).p();
		aeq(null, c.getBindingErrorProcessor());
		c.setBindingErrorProcessor(bindingErrorProcessor);
		aeqr(bindingErrorProcessor, c.getBindingErrorProcessor());

		aeq(true, c.isAutoGrowNestedPaths());
		c.setAutoGrowNestedPaths(false);
		aeq(false, c.isAutoGrowNestedPaths());

		aeq(false, c.isDirectFieldAccess());
		c.setDirectFieldAccess(true);
		aeq(true, c.isDirectFieldAccess());

		MessageCodesResolver messageCodesResolver = Recorder.create(MessageCodesResolver.class).p();
		aeq(null, c.getMessageCodesResolver());
		c.setMessageCodesResolver(messageCodesResolver);
		aeqr(messageCodesResolver, c.getMessageCodesResolver());

		PropertyEditorRegistrar propertyEditorRegistrar = Recorder.create(PropertyEditorRegistrar.class).p();
		aeq(null, c.getPropertyEditorRegistrars());
		c.setPropertyEditorRegistrar(propertyEditorRegistrar);
		aeqr(propertyEditorRegistrar, c.getPropertyEditorRegistrars()[0]);
		c.setPropertyEditorRegistrars(new PropertyEditorRegistrar[] { propertyEditorRegistrar });
		aeqr(propertyEditorRegistrar, c.getPropertyEditorRegistrars()[0]);

		Object target = new Object();
		WebDataBinder binder = new WebDataBinder(target);
		WebRequest request = Recorder.create(WebRequest.class).p();
		c.initBinder(binder, request);
		/*-
		ConfigurableWebBindingInitializer()
		getPropertyEditorRegistrars()
		initBinder(WebDataBinder, WebRequest)
		setPropertyEditorRegistrar(PropertyEditorRegistrar)
		setPropertyEditorRegistrars(PropertyEditorRegistrar[])
		 */
	}
}
