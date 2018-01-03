package com.github.docteurdux.gl.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

	private StringBuffer buf;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String get() {
		buf = new StringBuffer();
		s("In WEB-INF/web.xml we map org.springframework.web.servlet.DispatcherServlet to /ds/*, with the contextConfigLocation servlet initialization parameter set to WEB-INF/ds.xml, and in WEB-INF/ds.xml, we define a single bean whose class is "
				+ this.getClass().getName());
		s("DispatcherServlet extends org.springframework.web.servlet.FrameworkServlet, which itself extends org.springframework.web.servlet.HttpServletBean, which extends javax.servlet.http.HttpServlet");
		s("Initialization happens in org.springframework.web.servlet.HttpServletBean.init()");
		s("An instance of org.springframework.web.servlet.HttpServletBean.ServletConfigPropertyValues which extends org.springframework.beans.MutablePropertyValues, is created with the servlet config and an empty set of required properties");
		s("Upon instanciation, the servlet configuration parameters are iterated over and instance of org.springframework.beans.PropertyValue are defined for each name/value pair.");
		s("These property values are collected using org.springframework.beans.MutablePropertyValues.addPropertyValue(PropertyValue)");
		s("Since all initialization parameters are usually different and all values must be strings at this point, none of them are instances of org.springframework.beans.Mergeable and merging never occurs.");
		s("An exception can be thrown when some of the required properties are missing, but all properties are optional here");
		s("Next, if at least one property is defined, an instance of org.springframework.beans.BeanWrapperImpl.BeanWrapperImpl is instanciated over the servlet class.");
		s("org.springframework.beans.BeanWrapperImpl extends org.springframework.beans.AbstractNestablePropertyAccessor which extends org.springframework.beans.AbstractPropertyAccessor which extends org.springframework.beans.TypeConverterSupport which extends org.springframework.beans.PropertyEditorRegistrySupport, so this is quite complicated.");
		s("Instanciation is actually delegated to org.springframework.beans.AbstractNestablePropertyAccessor, in which default editors are registered, and the wrapped instance is set");
		s("Registering the default editors means setting the defaultEditorsActive variable, which is initally false, to true");
		s("Setting the wrapped instance means setting wrappedObject to the actual instance. If the object is an instance of java.util.Optional, then the actual value of the optional is used, but the instance is not in an optional here.");
		s("Also, the nested path is set to the empty string, the root object is the same as the wrapped object, there are no nested property accessors, and the type converter delegate is set to be a new instance of org.springframework.beans.TypeConverterDelegate");
		s("The type converter delegate is instantiated over the bean wrapper and the wrapped instance, which means that some of the work will be delegated to the bean wrapper");
		s("Also, the introspection class is initialized with the wrapped class, which actually does nothing because it just resets the cachedIntrospectionResults variable, which is already null.");
		s("Next, an instance of org.springframework.web.context.support.ServletContextResourceLoader is created on the servlet context, which extends org.springframework.core.io.DefaultResourceLoader");
		s("This only involves setting the class loader and the servlet context variables");
		s("Next, a custom editor is registered on the bean wrapper for the org.springframework.core.io.Resource class, with an instance of org.springframework.core.io.ResourceEditor which is defined other the resource loader and an instance of ?? which is actually an instance of org.springframework.web.context.support.StandardServletEnvironment instantiated on the fly");
		s("org.springframework.web.context.support.StandardServletEnvironment extends org.springframework.core.env.StandardEnvironment which extends org.springframework.core.env.AbstractEnvironment");
		s("\"default\" is the only reserved default profile");
		s("There's also an instance fo org.springframework.core.env.PropertySourcesPropertyResolver");
		s("${...} can be used for placeholders and ':' is the value separator");
		s("Property sources are customized");
		s("Two org.springframework.core.env.PropertySource.StubPropertySource are defined for servletConfigInitParams and servletContextInitParams");
		s("The default JNDI environment is also available, because \"spring.jndi.ignore\" is not set to false in \"spring.properties\" nor in the System properties, and calling getEnvironment() on a new javax.naming.InitialContext does not throw.");
		s("Therefore, a org.springframework.jndi.JndiPropertySource.JndiPropertySource is defined with \"jndiProperties\" as name.");
		s("org.springframework.jndi.JndiLocatorDelegate is used to create the resource ref locator.");
		s("A new org.springframework.jndi.JndiLocatorDelegate is instantiated.");
		s("A new org.springframework.jndi.JndiTemplate.JndiTemplate is instantiated.");
		s("The resourceRef variable is set to true in the JNDI locator delegate.");
		s("Then, at the standard environment level, two other property sources are defined");
		s("One is a org.springframework.core.env.MapPropertySource over the system properties, with \"systemProperties\" as its name, which looks in System.getProperties().");
		s("The other is a org.springframework.core.env.SystemEnvironmentPropertySource.SystemEnvironmentPropertySource other the system environment, with \"systemEnvironment\" as its name.");
		s("The \"spring.getenv.ignore\" spring flag can be use to effectively disabled this property source, but since it is enabled here, System.getEnv() is used.");
		s("Unresolvable placeholders are set to be ignored");
		s("The source of the java.beans.PropertyEditorSupport is set to be the actual resource editor which extends the support class");
		s("Then, because the property path is null upon registering the custom editor, the resource editor is added to the list of custom editors for the Resource class, and not to the list of \"custom editors for path\".");
		s("Next, the bean wrapper is initialized, which does nothing.");
		s("And next, property values are set. Although the process only call a setter with a string value, it is actually very complicated in the general case");
		s("Unknowns are set to be ignored, but not invalids");
		s("A list of property values is obtained and iterated over. There is only one property value in this case.");
		s("The property value has no resolved token. Once the value will be resolved, the resolved token will be set to the result, so that future accesses are faster.");
		
		
		
		
		return buf.toString();

	}

	private void s(String text) {
		buf.append(text);
		buf.append("\n\n");
	}
}
