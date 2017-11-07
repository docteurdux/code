package dux.org.apache.cxf.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.interceptor.CheckFaultInterceptor;
import org.apache.cxf.binding.soap.interceptor.EndpointSelectionInterceptor;
import org.apache.cxf.binding.soap.interceptor.MustUnderstandInterceptor;
import org.apache.cxf.binding.soap.interceptor.MustUnderstandInterceptor.MustUnderstandEndingInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCInInterceptor;
import org.apache.cxf.binding.soap.interceptor.RPCOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor;
import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor.CheckClosingTagsInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultInInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap12FaultOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor.SoapActionInAttemptTwoInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapHeaderOutFilterInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor.SoapOutEndingInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.binding.soap.interceptor.StartBodyInterceptor;
import org.apache.cxf.binding.soap.interceptor.TibcoSoapActionInterceptor;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor.SAAJPreInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor.SAAJOutEndingInterceptor;
import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.databinding.stax.StaxDataBindingInterceptor;
import org.apache.cxf.feature.transform.XSLTInInterceptor;
import org.apache.cxf.feature.transform.XSLTOutInterceptor;
import org.apache.cxf.interceptor.AttachmentInInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor.AttachmentOutEndingInterceptor;
import org.apache.cxf.interceptor.ClientFaultConverter;
import org.apache.cxf.interceptor.FIStaxInInterceptor;
import org.apache.cxf.interceptor.FIStaxOutInterceptor;
import org.apache.cxf.interceptor.FaultOutInterceptor;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor.MessageSenderEndingInterceptor;
import org.apache.cxf.interceptor.OneWayProcessorInterceptor;
import org.apache.cxf.interceptor.OutgoingChainInterceptor;
import org.apache.cxf.interceptor.ServiceInvokerInterceptor;
import org.apache.cxf.interceptor.StaxInEndingInterceptor;
import org.apache.cxf.interceptor.StaxInInterceptor;
import org.apache.cxf.interceptor.StaxOutEndingInterceptor;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.interceptor.security.AbstractUsernameTokenInInterceptor;
import org.apache.cxf.interceptor.security.DelegatingAuthenticationInterceptor;
import org.apache.cxf.interceptor.security.DepthRestrictingStreamInterceptor;
import org.apache.cxf.interceptor.security.JAASLoginInterceptor;
import org.apache.cxf.interceptor.security.OperationInfoAuthorizingInterceptor;
import org.apache.cxf.interceptor.security.SecureAnnotationsInterceptor;
import org.apache.cxf.interceptor.transform.TransformInInterceptor;
import org.apache.cxf.interceptor.transform.TransformOutInterceptor;
import org.apache.cxf.jaxb.attachment.JAXBAttachmentSchemaValidationHack;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.cxf.staxutils.validation.StaxSchemaValidationInInterceptor;
import org.apache.cxf.staxutils.validation.StaxSchemaValidationOutInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.transport.http.HttpAuthenticationFaultHandler;
import org.apache.cxf.transport.http.auth.WSDLGetAuthenticatorInterceptor;
import org.apache.cxf.transport.https.CertConstraintsInterceptor;
import org.apache.cxf.validation.BeanValidationInInterceptor;
import org.apache.cxf.validation.BeanValidationOutInterceptor;
import org.apache.cxf.validation.ClientBeanValidationOutInterceptor;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.soap.DecoupledFaultHandler;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.policy.ClientPolicyInFaultInterceptor;
import org.apache.cxf.ws.policy.PolicyInInterceptor;
import org.apache.cxf.ws.policy.PolicyOutInterceptor;
import org.apache.cxf.ws.policy.PolicyVerificationInFaultInterceptor;
import org.apache.cxf.ws.policy.PolicyVerificationInInterceptor;
import org.apache.cxf.ws.policy.PolicyVerificationOutInterceptor;
import org.apache.cxf.ws.policy.ServerPolicyOutFaultInterceptor;
import org.apache.cxf.ws.policy.mtom.MTOMPolicyInterceptor;
import org.apache.cxf.wsdl.interceptors.BareInInterceptor;
import org.apache.cxf.wsdl.interceptors.BareOutInterceptor;
import org.apache.cxf.wsdl.interceptors.DocLiteralInInterceptor;
import org.apache.cxf.wsdl.interceptors.WrappedOutInterceptor;
import org.apache.cxf.wsdl.interceptors.WrappedOutInterceptor.WrappedOutEndingInterceptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

@SuppressWarnings("deprecation")
public class InterceptorTest extends AbstractTest {
	@Test
	public void test() {

		Interceptor.class.getName();

		Class<?>[] classes = new Class<?>[] {

				OperationInfoAuthorizingInterceptor.class, SecureAnnotationsInterceptor.class,
				EndpointSelectionInterceptor.class, BareInInterceptor.class, ClientFaultConverter.class,
				DocLiteralInInterceptor.class, RPCInInterceptor.class, SoapHeaderInterceptor.class,
				StaxDataBindingInterceptor.class, LoggingInInterceptor.class, LoggingOutInterceptor.class,
				BareOutInterceptor.class, RPCOutInterceptor.class, WrappedOutEndingInterceptor.class,
				WrappedOutInterceptor.class, ClientPolicyInFaultInterceptor.class, PolicyInInterceptor.class,
				PolicyOutInterceptor.class, PolicyVerificationInFaultInterceptor.class,
				PolicyVerificationInInterceptor.class, PolicyVerificationOutInterceptor.class,
				ServerPolicyOutFaultInterceptor.class, AbstractUsernameTokenInInterceptor.class,
				CheckClosingTagsInterceptor.class, CheckFaultInterceptor.class, DecoupledFaultHandler.class,
				MAPCodec.class, MustUnderstandEndingInterceptor.class, MustUnderstandInterceptor.class,
				ReadHeadersInterceptor.class, SAAJInInterceptor.class, SAAJOutEndingInterceptor.class,
				SAAJOutInterceptor.class, SAAJPreInInterceptor.class, Soap11FaultInInterceptor.class,
				Soap11FaultOutInterceptor.class, Soap12FaultInInterceptor.class, Soap12FaultOutInterceptor.class,
				SoapActionInAttemptTwoInterceptor.class, SoapActionInInterceptor.class,
				SoapHeaderOutFilterInterceptor.class, SoapJMSInInterceptor.class, SoapOutEndingInterceptor.class,
				SoapOutInterceptor.class, SoapPreProtocolOutInterceptor.class, StartBodyInterceptor.class,
				BeanValidationInInterceptor.class, ClientBeanValidationOutInterceptor.class,
				BeanValidationOutInterceptor.class, XSLTInInterceptor.class, XSLTOutInterceptor.class,
				AttachmentInInterceptor.class, AttachmentOutEndingInterceptor.class, AttachmentOutInterceptor.class,
				CertConstraintsInterceptor.class, DelegatingAuthenticationInterceptor.class,
				DepthRestrictingStreamInterceptor.class, FaultOutInterceptor.class, FIStaxInInterceptor.class,
				FIStaxOutInterceptor.class, GZIPInInterceptor.class, GZIPOutInterceptor.class,
				HttpAuthenticationFaultHandler.class, JAASLoginInterceptor.class,
				JAXBAttachmentSchemaValidationHack.class, MAPAggregatorImpl.class, MessageSenderEndingInterceptor.class,
				MessageSenderInterceptor.class, MTOMPolicyInterceptor.class, OneWayProcessorInterceptor.class,
				OutgoingChainInterceptor.class, ServiceInvokerInterceptor.class, StaxInEndingInterceptor.class,
				StaxInInterceptor.class, StaxOutEndingInterceptor.class, StaxOutInterceptor.class,
				StaxSchemaValidationInInterceptor.class, StaxSchemaValidationOutInterceptor.class,
				TibcoSoapActionInterceptor.class, TransformInInterceptor.class, TransformOutInterceptor.class,
				WSDLGetAuthenticatorInterceptor.class

		};

		Map<String, List<String>> flop = new HashMap<>();
		for (Class<?> clazz : classes) {
			try {
				@SuppressWarnings("rawtypes")
				PhaseInterceptor pi = (PhaseInterceptor) clazz.getConstructor().newInstance();
				String phase = pi.getPhase();
				// System.out.println(pi.getClass().getName() + " " + phase);
				if (!flop.containsKey(phase)) {
					flop.put(phase, new ArrayList<>());
				}
				flop.get(phase).add(pi.getClass().getName());
			} catch (Exception ex) {

			} catch (Error e) {

			}
		}

		PhaseManagerImpl pmi = new PhaseManagerImpl();

		for (Phase p : pmi.getInPhases()) {
			System.out.println(p.getName());
			List<String> bzom = flop.get(p.getName());
			if (bzom != null) {
				for (String clazz : bzom) {
					System.out.println(clazz);
				}
			}
		}

		for (Phase p : pmi.getOutPhases()) {
			System.out.println(p.getName());
			List<String> bzom = flop.get(p.getName());
			if (bzom != null) {
				for (String clazz : bzom) {
					System.out.println(clazz);
				}
			}
		}

	}
}
