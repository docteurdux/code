package dux.org.apache.cxf.ws.addressing.impl;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.MessageIdCache;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.impl.AddressingFeatureApplier;
import org.apache.cxf.ws.addressing.impl.DefaultMessageIdCache;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.cxf.interceptor.DummyInterceptorProvider;
import dum.org.apache.cxf.ws.addressing.DummyMessageIdCache;

public class AddressingFeatureApplierTest extends AbstractTest {

	private Bus bus;
	private AddressingFeatureApplier applier;
	private WSAddressingFeature feature;
	private DummyInterceptorProvider provider;

	@Before
	public void before() {
		bus = BusFactory.getDefaultBus();
		applier = new AddressingFeatureApplier();
		feature = new WSAddressingFeature();
		provider = new DummyInterceptorProvider();
	}

	@Test
	public void testDefaultMessageIdCache() {

		applier.initializeProvider(feature, provider, bus);
		
		aeq(2, provider.getInInterceptors().size());
		aeq(2, provider.getOutInterceptors().size());
		aeq(2, provider.getInFaultInterceptors().size());
		aeq(2, provider.getOutFaultInterceptors().size());

		MAPAggregator aggregator = (MAPAggregatorImpl) got(provider.getInInterceptors(), MAPAggregator.class);
		MAPCodec codec = got(provider.getInInterceptors(), MAPCodec.class);

		aeq(aggregator, got(provider.getOutInterceptors(), MAPAggregator.class));
		aeq(codec, got(provider.getOutInterceptors(), MAPCodec.class));

		aeq(aggregator, got(provider.getInFaultInterceptors(), MAPAggregator.class));
		aeq(codec, got(provider.getInFaultInterceptors(), MAPCodec.class));

		aeq(aggregator, got(provider.getOutFaultInterceptors(), MAPAggregator.class));
		aeq(codec, got(provider.getOutFaultInterceptors(), MAPCodec.class));

		ai(aggregator.getMessageIdCache(), DefaultMessageIdCache.class);
	}

	@Test
	public void testCustomMessageIdCache() {

		MessageIdCache messageIdCache = new DummyMessageIdCache();
		feature.setMessageIdCache(messageIdCache);
		applier.initializeProvider(feature, provider, bus);

		MAPAggregator aggregator = (MAPAggregatorImpl) got(provider.getInInterceptors(), MAPAggregator.class);

		ai(aggregator.getMessageIdCache(), DummyMessageIdCache.class);
	}
}
