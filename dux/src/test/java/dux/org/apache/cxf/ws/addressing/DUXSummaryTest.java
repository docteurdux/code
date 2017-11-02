package dux.org.apache.cxf.ws.addressing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.ws.addressing.impl.AddressingFeatureApplier;
import org.apache.cxf.ws.addressing.impl.AddressingWSDLExtensionLoader;
import org.apache.cxf.ws.addressing.impl.DefaultMessageIdCache;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImplLoader;
import org.apache.cxf.ws.addressing.policy.AddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.policy.AddressingPolicyInterceptorProvider;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.addressing.policy.UsingAddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.soap.DecoupledFaultHandler;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;
import org.apache.cxf.ws.addressing.spring.AddressingBeanDefinitionParser;
import org.apache.cxf.ws.addressing.spring.NamespaceHandler;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class DUXSummaryTest extends AbstractTest {
	@Test
	public void test() {
		List<Class<?>> classes = new ArrayList<>();

//		classes.addAll(Arrays.asList(new Class<?>[] { Activator.class, WsBPHandler.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { AddressingFeatureApplier.class, AddressingWSDLExtensionLoader.class,
						DefaultMessageIdCache.class, MAPAggregatorImpl.class, MAPAggregatorImplLoader.class }));

		classes.addAll(Arrays
				.asList(new Class<?>[] { AddressingAssertionBuilder.class, AddressingPolicyInterceptorProvider.class,
						MetadataConstants.class, UsingAddressingAssertionBuilder.class }));

		classes.addAll(Arrays
				.asList(new Class<?>[] { DecoupledFaultHandler.class, MAPCodec.class, VersionTransformer.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AddressingBeanDefinitionParser.class, NamespaceHandler.class }));

		summary(classes);
	}
}
