package dux.cxf.rt.bindings.soap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.binding.soap.HeaderUtil;
import org.apache.cxf.binding.soap.SOAPBindingUtil;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.binding.soap.SoapBindingConfiguration;
import org.apache.cxf.binding.soap.SoapBindingConstants;
import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.soap.SoapVersionEditor;
import org.apache.cxf.binding.soap.SoapVersionFactory;
import org.apache.cxf.binding.soap.blueprint.Activator;
import org.apache.cxf.binding.soap.blueprint.SoapBindingBPHandler;
import org.apache.cxf.binding.soap.blueprint.SoapBindingBPInfoConfigDefinitionParser;
import org.apache.cxf.binding.soap.blueprint.SoapVersionTypeConverter;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.CheckFaultInterceptor;
import org.apache.cxf.binding.soap.interceptor.EndpointSelectionInterceptor;
import org.apache.cxf.binding.soap.interceptor.MustUnderstandInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCInInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderOutFilterInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.StartBodyInterceptor;
import org.apache.cxf.binding.soap.interceptor.TibcoSoapActionInterceptor;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFault;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFaultFactory;
import org.apache.cxf.binding.soap.jms.interceptor.JMSFaultType;
import org.apache.cxf.binding.soap.jms.interceptor.SoapFaultFactory;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSConstants;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSInInterceptor;
import org.apache.cxf.binding.soap.model.SoapBindingInfo;
import org.apache.cxf.binding.soap.model.SoapBodyInfo;
import org.apache.cxf.binding.soap.model.SoapHeaderInfo;
import org.apache.cxf.binding.soap.model.SoapOperationInfo;
import org.apache.cxf.binding.soap.saaj.SAAJFactoryResolver;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJStreamWriter;
import org.apache.cxf.binding.soap.saaj.SAAJUtils;
import org.apache.cxf.binding.soap.spring.NamespaceHandler;
import org.apache.cxf.binding.soap.spring.SoapBindingInfoConfigBeanDefinitionParser;
import org.apache.cxf.binding.soap.spring.SoapVersionRegistrar;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapAddress;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapBody;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapHeaderFault;
import org.apache.cxf.binding.soap.wsdl.extensions.SoapOperation;
import org.apache.cxf.binding.soap.wsdl11.SoapAddressPlugin;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CXFRTBindingsSoapSummaryTest extends AbstractTest {
	@Test
	public void test() {
		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays.asList(new Class<?>[] { HeaderUtil.class, Soap11.class, Soap12.class, SoapBinding.class,
				SoapBindingConfiguration.class, SoapBindingConstants.class, SoapBindingFactory.class,
				SOAPBindingUtil.class, SoapFault.class, SoapHeader.class, SoapMessage.class, SoapTransportFactory.class,
				SoapVersion.class, SoapVersionEditor.class, SoapVersionFactory.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] {Activator.class,
//			SoapBindingBPHandler.class,
//			SoapBindingBPInfoConfigDefinitionParser.class,
//			SoapVersionTypeConverter.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {AbstractSoapInterceptor.class,
			CheckFaultInterceptor.class,
			EndpointSelectionInterceptor.class,
			MustUnderstandInterceptor.class,
			ReadHeadersInterceptor.class,
			RPCInInterceptor.class,
			RPCOutInterceptor.class,
			Soap11FaultInInterceptor.class,
			Soap11FaultOutInterceptor.class,
			Soap12FaultInInterceptor.class,
			Soap12FaultOutInterceptor.class,
			SoapActionInInterceptor.class,
			SoapHeaderInterceptor.class,
			SoapHeaderOutFilterInterceptor.class,
			SoapInterceptor.class,
			SoapOutInterceptor.class,
			SoapPreProtocolOutInterceptor.class,
			StartBodyInterceptor.class,
			TibcoSoapActionInterceptor.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {JMSFault.class,
			JMSFaultFactory.class,
			JMSFaultType.class,
			SoapFaultFactory.class,
			SoapJMSConstants.class,
			SoapJMSInInterceptor.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {SoapBindingInfo.class,
			SoapBodyInfo.class,
			SoapHeaderInfo.class,
			SoapOperationInfo.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {SAAJFactoryResolver.class,
			SAAJInInterceptor.class,
			SAAJOutInterceptor.class,
			SAAJStreamWriter.class,
			SAAJUtils.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {NamespaceHandler.class,
			SoapBindingInfoConfigBeanDefinitionParser.class,
			SoapVersionRegistrar.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {SoapAddress.class,
			org.apache.cxf.binding.soap.wsdl.extensions.SoapBinding.class,
			SoapBody.class,
			org.apache.cxf.binding.soap.wsdl.extensions.SoapFault.class,
			org.apache.cxf.binding.soap.wsdl.extensions.SoapHeader.class,
			SoapHeaderFault.class,
			SoapOperation.class}));

		classes.addAll(Arrays.asList(new Class<?>[] {SoapAddressPlugin.class}));


		summary(classes);
	}
}
