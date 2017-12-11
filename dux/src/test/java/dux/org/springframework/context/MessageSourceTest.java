package dux.org.springframework.context;

import java.util.Locale;

import org.apache.cxf.bus.spring.BusApplicationContext;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.AbstractResourceBasedMessageSource;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.jca.context.ResourceAdapterApplicationContext;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.GroovyWebApplicationContext;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(MessageSource.class)
public class MessageSourceTest extends AbstractTest {
	@Test
	public void test() throws NoSuchMessageException, InstantiationException, IllegalAccessException {
		/*-
		getMessage(String, Object[], String, Locale)
		getMessage(String, Object[], Locale)
		getMessage(MessageSourceResolvable, Locale)
		*/

		MessageSourceResolvable resolvable = new DefaultMessageSourceResolvable("code");
		Locale locale = Locale.getDefault();
		String[] classes = new String[] {
			
			AbstractMessageSource.class.newInstance().getMessage(resolvable, locale ), // complicated // AbstractMessageSource
			AbstractResourceBasedMessageSource.class.newInstance().getMessage(resolvable, locale ), // complicated  // AbstractMessageSource
			DelegatingMessageSource.class.newInstance().getMessage(resolvable, locale ), // mostly delegates
			ReloadableResourceBundleMessageSource.class.newInstance().getMessage(resolvable, locale ), // do something // AbstractMessageSource
			ResourceBundleMessageSource.class.newInstance().getMessage(resolvable, locale ), // do something // AbstractMessageSource
			SpringSecurityMessageSource.class.newInstance().getMessage(resolvable, locale ), // do something // AbstractMessageSource
			StaticMessageSource.class.newInstance().getMessage(resolvable, locale ), // do something // AbstractMessageSource

			AbstractApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			AbstractRefreshableApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			AbstractRefreshableWebApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			AbstractXmlApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			AnnotationConfigApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			AnnotationConfigWebApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			BusApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			ClassPathXmlApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			FileSystemXmlApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			GenericApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			GenericGroovyApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			GenericWebApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			GenericXmlApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			GroovyWebApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			ResourceAdapterApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			StaticApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			StaticWebApplicationContext.class.newInstance().getMessage(resolvable, locale ), // delegates
			XmlWebApplicationContext.class.newInstance().getMessage(resolvable, locale ) // delegates
			
		};
	}
}
