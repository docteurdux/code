package dux.org.springframework.security.config.http;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import duu.org.springframework.beans.factory.config.BeanDefinitionUtils;
import duu.org.springframework.beans.factory.config.BuiltBeanDefinition;
import duu.org.springframework.beans.factory.config.DummyBeanDefinitionBuilder;
import duu.org.springframework.beans.factory.xml.ParserContextUtils;

public class HttpSecurityBeanDefinitionParserTest {
	private static final String FILTER_CHAIN_PROXY = "org.springframework.security.filterChainProxy";
	private static final String DEFAULT_SECURITY_FILTER_CHAIN = "org.springframework.security.web.DefaultSecurityFilterChain#0";
	private static final String FILTER_CHAINS = "org.springframework.security.filterChains";

	@Test
	public void testSecurityNone() throws ParserConfigurationException {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element element = document.createElement("http");
		element.setAttribute("pattern", "/*");
		element.setAttribute("security", "none");
		document.appendChild(element);

		HttpSecurityBeanDefinitionParser parser = new HttpSecurityBeanDefinitionParser();
		ParserContext pc = ParserContextUtils.getParserContext();
		parser.parse(element, pc);

		// BeanDefinition bd = pc.getContainingBeanDefinition();
		// bd.getBeanClassName();
		// bd.getConstructorArgumentValues();
		// bd.getDependsOn();
		// bd.getDescription();
		// bd.getFactoryBeanName();
		// bd.getFactoryMethodName();
		// bd.getOriginatingBeanDefinition();
		// bd.getParentName();
		// bd.getPropertyValues();
		// bd.getResourceDescription();
		// bd.getRole();
		// bd.getScope();
		// bd.isAbstract();
		// bd.isAutowireCandidate();
		// bd.isLazyInit();
		// bd.isPrimary();
		// bd.isPrototype();
		// bd.isSingleton();
		// CompositeComponentDefinition c = pc.getContainingComponent();
		// c.getName();
		// c.getSource();
		// c.getNestedComponents();
		//
		// BeanDefinitionParserDelegate d = pc.getDelegate();
		// d.getAutowireCandidatePatterns();
		// d.getBeanDefinitionDefaults();
		// d.getDefaults();
		// d.getEnvironment();
		//
		// XmlReaderContext rc = pc.getReaderContext();
		BeanDefinitionRegistry registry = pc.getRegistry();
		Assert.assertNotNull(registry);
		Assert.assertEquals(3, registry.getBeanDefinitionCount());

		filterChains(registry);
		defaultSecurityFilterChain(registry);
		filterChainProxy(registry);

	}

	private void filterChains(BeanDefinitionRegistry registry) {
		Assert.assertTrue(registry.containsBeanDefinition(FILTER_CHAINS));
		BeanDefinition filterChains = registry.getBeanDefinition(FILTER_CHAINS);

		BuiltBeanDefinition expected = new DummyBeanDefinitionBuilder()
				.beanClassName("org.springframework.beans.factory.config.ListFactoryBean").singleton().notPrototype()
				.notPrimary().notLazyInit().autowireCandidate().notAbstract().scope("").role(0).description(null)
				.resourceDescription(null).factoryBeanName(null).factoryMethodName(null).parentName(null)
				.property("sourceList", ManagedList.class).dependsOn(null).originatingBeanDefinition(null)
				.constructorArgumentValues().attributes().source(null).build();
		BeanDefinitionUtils.match(expected, filterChains);

	}

	private void defaultSecurityFilterChain(BeanDefinitionRegistry registry) {
		Assert.assertTrue(registry.containsBeanDefinition(DEFAULT_SECURITY_FILTER_CHAIN));
		BeanDefinition defaultSecurityFilterChain = registry.getBeanDefinition(DEFAULT_SECURITY_FILTER_CHAIN);

		// There are some constructor argument values
		
		BuiltBeanDefinition expected = new DummyBeanDefinitionBuilder().singleton().notPrototype().notPrimary()
				.notLazyInit().autowireCandidate().notAbstract().role(0).scope("")
				.beanClassName("org.springframework.security.web.DefaultSecurityFilterChain").description(null)
				.resourceDescription(null).factoryBeanName(null).factoryMethodName(null).parentName(null).source(null)
				.attributes().dependsOn(null).originatingBeanDefinition(null).build();

		BeanDefinitionUtils.match(expected, defaultSecurityFilterChain);
	}

	private void filterChainProxy(BeanDefinitionRegistry registry) {
		Assert.assertTrue(registry.containsBeanDefinition(FILTER_CHAIN_PROXY));
		BeanDefinition filterChainProxy = registry.getBeanDefinition(FILTER_CHAIN_PROXY);
		
		// There are some constructor argument values
		BuiltBeanDefinition expected = new DummyBeanDefinitionBuilder().singleton().notPrototype().notPrimary()
				.notLazyInit().autowireCandidate().notAbstract().role(0).scope("")
				.beanClassName("org.springframework.security.web.FilterChainProxy").description(null)
				.resourceDescription(null).factoryBeanName(null).factoryMethodName(null).parentName(null).source(null)
				.property("filterChainValidator", RootBeanDefinition.class).attributes().dependsOn(null)
				.originatingBeanDefinition(null).build();
		;
		BeanDefinitionUtils.match(expected, filterChainProxy);
	}
}
