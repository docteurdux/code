package dux.org.springframework.security.config.http;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues.ValueHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.springframework.security.web.DefaultSecurityFilterChain;
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

				.beanClassName("org.springframework.beans.factory.config.ListFactoryBean")

				.singleton().autowireCandidate().notPrototype().notPrimary().notLazyInit().notAbstract()

				.property("sourceList", ManagedList.class)

				.scope("").role(0).description(null).resourceDescription(null).factoryBeanName(null)
				.factoryMethodName(null).parentName(null).dependsOn(null).originatingBeanDefinition(null)
				.constructorArgumentValues().attributes().source(null)

				.build();

		BeanDefinitionUtils.match(expected, filterChains);
		
		ManagedList ml = (ManagedList) filterChains.getPropertyValues().get("sourceList");
		Assert.assertEquals(ml.size(), 1);
		RuntimeBeanReference rbr = (RuntimeBeanReference) ml.get(0);
		

	}

	private void defaultSecurityFilterChain(BeanDefinitionRegistry registry) {
		Assert.assertTrue(registry.containsBeanDefinition(DEFAULT_SECURITY_FILTER_CHAIN));
		BeanDefinition defaultSecurityFilterChain = registry.getBeanDefinition(DEFAULT_SECURITY_FILTER_CHAIN);

		BuiltBeanDefinition expected = new DummyBeanDefinitionBuilder()

				.beanClassName("org.springframework.security.web.DefaultSecurityFilterChain")

				.singleton().autowireCandidate().notPrototype().notPrimary().notLazyInit().notAbstract()

				.indexedArgumentValues(0, RootBeanDefinition.class)

				.indexedArgumentValues(1, AbstractList.class)

				.role(0).scope("").description(null).resourceDescription(null).factoryBeanName(null)
				.factoryMethodName(null).parentName(null).source(null).attributes().dependsOn(null)
				.originatingBeanDefinition(null)

				.build();

		BeanDefinitionUtils.match(expected, defaultSecurityFilterChain);
	}

	private void filterChainProxy(BeanDefinitionRegistry registry) {
		Assert.assertTrue(registry.containsBeanDefinition(FILTER_CHAIN_PROXY));
		BeanDefinition filterChainProxy = registry.getBeanDefinition(FILTER_CHAIN_PROXY);

		BuiltBeanDefinition expected = new DummyBeanDefinitionBuilder()

				.beanClassName("org.springframework.security.web.FilterChainProxy")

				.singleton().autowireCandidate().notPrototype().notPrimary().notLazyInit().notAbstract()

				.property("filterChainValidator", RootBeanDefinition.class)

				.indexedArgumentValues(0, RuntimeBeanReference.class)

				.role(0).scope("").description(null).resourceDescription(null).factoryBeanName(null)
				.factoryMethodName(null).parentName(null).source(null)

				.attributes().dependsOn(null).originatingBeanDefinition(null)

				.build();

		BeanDefinitionUtils.match(expected, filterChainProxy);
		
		RootBeanDefinition rbd=(RootBeanDefinition) filterChainProxy.getPropertyValues().get("filterChainValidator");
		
		
		
		
	}
}
