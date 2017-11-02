package dux.cxf.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.ws.addressing.AddressingConstants;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedAnyType;
import org.apache.cxf.ws.addressing.AttributedQNameType;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.AttributedUnsignedLongType;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.EndpointReferenceUtils;
import org.apache.cxf.ws.addressing.EndpointUtilsException;
import org.apache.cxf.ws.addressing.FaultAction;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.MessageIdCache;
import org.apache.cxf.ws.addressing.MetadataType;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.ObjectFactory;
import org.apache.cxf.ws.addressing.ProblemActionType;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer;
import org.apache.cxf.ws.addressing.WSAContextUtils;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.wsdl.Anonymous;
import org.apache.cxf.ws.addressing.wsdl.AnonymousType;
import org.apache.cxf.ws.addressing.wsdl.ServiceNameType;
import org.apache.cxf.ws.addressing.wsdl.UsingAddressing;
import org.apache.cxf.wsdl.http.AddressType;
import org.apache.cxf.wsdl.http.BindingType;
import org.apache.cxf.wsdl.http.OperationType;
import org.apache.cxf.wsdl.http.UrlEncoded;
import org.apache.cxf.wsdl.http.UrlReplacement;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CXFCoreSummaryTest extends AbstractTest {

	@Test
	public void test() {

		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays.asList(new Class<?>[] { AddressingConstants.class, AddressingProperties.class,
				AttributedAnyType.class, AttributedQNameType.class, AttributedUnsignedLongType.class,
				AttributedURIType.class, ContextUtils.class, EndpointReferenceType.class, EndpointReferenceUtils.class,
				EndpointUtilsException.class, FaultAction.class, JAXWSAConstants.class, MAPAggregator.class,
				MessageIdCache.class, MetadataType.class, Names.class, ObjectFactory.class, ProblemActionType.class,
				ReferenceParametersType.class, RelatesToType.class, VersionTransformer.class, WSAContextUtils.class,
				WSAddressingFeature.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Anonymous.class, AnonymousType.class,
				org.apache.cxf.ws.addressing.wsdl.AttributedQNameType.class,
				org.apache.cxf.ws.addressing.wsdl.ObjectFactory.class, ServiceNameType.class, UsingAddressing.class }));

		classes.addAll(Arrays.asList(
				new Class<?>[] { AddressType.class, BindingType.class, org.apache.cxf.wsdl.http.ObjectFactory.class,
						OperationType.class, UrlEncoded.class, UrlReplacement.class }));

		summary(classes);

	}
}
