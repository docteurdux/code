package dux.cxf.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.annotations.DataBinding;
import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.EvaluateAllEndpoints;
import org.apache.cxf.annotations.FactoryType;
import org.apache.cxf.annotations.FastInfoset;
import org.apache.cxf.annotations.GZIP;
import org.apache.cxf.annotations.Logging;
import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;
import org.apache.cxf.annotations.Provider;
import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.annotations.UseNio;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;
import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.AttachmentSerializer;
import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.attachment.Base64DecoderStream;
import org.apache.cxf.attachment.ByteDataSource;
import org.apache.cxf.attachment.ContentDisposition;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.attachment.ImageDataContentHandler;
import org.apache.cxf.attachment.LazyAttachmentCollection;
import org.apache.cxf.attachment.LazyDataSource;
import org.apache.cxf.attachment.MimeBodyPartInputStream;
import org.apache.cxf.attachment.QuotedPrintableDecoderStream;
import org.apache.cxf.attachment.Rfc5987Util;
import org.apache.cxf.binding.AbstractBindingFactory;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.bus.ManagedBus;
import org.apache.cxf.bus.blueprint.BlueprintBeanLocator;
import org.apache.cxf.bus.blueprint.BlueprintBus;
import org.apache.cxf.bus.blueprint.BlueprintNameSpaceHandlerFactory;
import org.apache.cxf.bus.blueprint.BundleDelegatingClassLoader;
import org.apache.cxf.bus.blueprint.BusDefinitionParser;
import org.apache.cxf.bus.blueprint.ConfigurerImpl;
import org.apache.cxf.bus.blueprint.NamespaceHandlerRegisterer;
import org.apache.cxf.bus.extension.Extension;
import org.apache.cxf.bus.extension.ExtensionException;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.bus.extension.ExtensionRegistry;
import org.apache.cxf.bus.extension.TextExtensionFragmentParser;
import org.apache.cxf.bus.managers.BindingFactoryManagerImpl;
import org.apache.cxf.bus.managers.CXFBusLifeCycleManager;
import org.apache.cxf.bus.managers.ClientLifeCycleManagerImpl;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.bus.managers.EndpointResolverRegistryImpl;
import org.apache.cxf.bus.managers.HeaderManagerImpl;
import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.bus.managers.ServerLifeCycleManagerImpl;
import org.apache.cxf.bus.managers.ServerRegistryImpl;
import org.apache.cxf.bus.managers.ServiceContractResolverRegistryImpl;
import org.apache.cxf.bus.managers.WorkQueueImplMBeanWrapper;
import org.apache.cxf.bus.managers.WorkQueueManagerImpl;
import org.apache.cxf.bus.managers.WorkQueueManagerImplMBeanWrapper;
//import org.apache.cxf.bus.osgi.CXFActivator;
//import org.apache.cxf.bus.osgi.CXFExtensionBundleListener;
//import org.apache.cxf.bus.osgi.ManagedWorkQueueList;
//import org.apache.cxf.bus.osgi.OSGIBusListener;
//import org.apache.cxf.bus.osgi.OSGiBeanLocator;
import org.apache.cxf.bus.resource.ResourceManagerImpl;
import org.apache.cxf.bus.spring.BusApplicationContext;
import org.apache.cxf.bus.spring.BusApplicationContextResourceResolver;
import org.apache.cxf.bus.spring.BusEntityResolver;
import org.apache.cxf.bus.spring.BusExtensionPostProcessor;
import org.apache.cxf.bus.spring.BusWiringBeanFactoryPostProcessor;
import org.apache.cxf.bus.spring.ControlledValidationXmlBeanDefinitionReader;
import org.apache.cxf.bus.spring.Jsr250BeanPostProcessor;
import org.apache.cxf.bus.spring.NamespaceHandler;
import org.apache.cxf.bus.spring.SpringBeanLocator;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.buslifecycle.BusCreationListener;
import org.apache.cxf.buslifecycle.BusLifeCycleListener;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.apache.cxf.catalog.CatalogXmlSchemaURIResolver;
import org.apache.cxf.catalog.OASISCatalogManager;
import org.apache.cxf.catalog.OASISCatalogManagerHelper;
import org.apache.cxf.common.CXFPermissions;
import org.apache.cxf.common.annotation.AbstractAnnotationVisitor;
import org.apache.cxf.common.annotation.AnnotationProcessor;
import org.apache.cxf.common.annotation.AnnotationVisitor;
import org.apache.cxf.common.classloader.ClassLoaderUtils;
import org.apache.cxf.common.i18n.BundleUtils;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.common.i18n.UncheckedException;
import org.apache.cxf.common.injection.NoJSR250Annotations;
import org.apache.cxf.common.injection.ResourceInjector;
import org.apache.cxf.common.logging.AbstractDelegatingLogger;
import org.apache.cxf.common.logging.Log4jLogger;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.common.logging.Slf4jLogger;
import org.apache.cxf.common.security.SecurityToken;
import org.apache.cxf.common.security.SimpleGroup;
import org.apache.cxf.common.security.SimplePrincipal;
import org.apache.cxf.common.security.SimpleSecurityContext;
import org.apache.cxf.common.security.TokenType;
import org.apache.cxf.common.security.UsernameToken;
import org.apache.cxf.common.util.ASMHelper;
import org.apache.cxf.common.util.Base64Exception;
import org.apache.cxf.common.util.Base64OutputStream;
import org.apache.cxf.common.util.Base64UrlOutputStream;
import org.apache.cxf.common.util.Base64UrlUtility;
import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.common.util.CacheMap;
import org.apache.cxf.common.util.CachedClass;
import org.apache.cxf.common.util.ClassHelper;
import org.apache.cxf.common.util.ClassUnwrapper;
import org.apache.cxf.common.util.ClasspathScanner;
import org.apache.cxf.common.util.CollectionUtils;
import org.apache.cxf.common.util.CompressionUtils;
import org.apache.cxf.common.util.ExtensionInvocationHandler;
import org.apache.cxf.common.util.MessageDigestInputStream;
import org.apache.cxf.common.util.ModCountCopyOnWriteArrayList;
import org.apache.cxf.common.util.PackageUtils;
import org.apache.cxf.common.util.PrimitiveUtils;
import org.apache.cxf.common.util.PropertiesLoaderUtils;
import org.apache.cxf.common.util.PropertyUtils;
import org.apache.cxf.common.util.ProxyClassLoader;
import org.apache.cxf.common.util.ProxyHelper;
import org.apache.cxf.common.util.ReflectionInvokationHandler;
import org.apache.cxf.common.util.ReflectionUtil;
import org.apache.cxf.common.util.SortedArraySet;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.common.util.SystemPropertyAction;
import org.apache.cxf.common.util.URIParserUtil;
import org.apache.cxf.common.util.UrlUtils;
import org.apache.cxf.common.util.WeakIdentityHashMap;
import org.apache.cxf.common.util.XmlSchemaPrimitiveUtils;
import org.apache.cxf.common.xmlschema.InvalidXmlSchemaReferenceException;
import org.apache.cxf.common.xmlschema.LSInputImpl;
import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.common.xmlschema.XmlSchemaInvalidOperation;
import org.apache.cxf.common.xmlschema.XmlSchemaUtils;
import org.apache.cxf.configuration.Configurable;
import org.apache.cxf.configuration.ConfigurationException;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.configuration.NullConfigurer;
import org.apache.cxf.configuration.jsse.MultiKeyPasswordKeyManager;
import org.apache.cxf.configuration.jsse.SSLUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.jsse.TLSClientParametersConfig;
import org.apache.cxf.configuration.jsse.TLSParameterBase;
import org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils;
import org.apache.cxf.configuration.jsse.TLSServerParameters;
import org.apache.cxf.configuration.jsse.TLSServerParametersConfig;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.configuration.security.CertStoreType;
import org.apache.cxf.configuration.security.CertificateConstraintsType;
import org.apache.cxf.configuration.security.CipherSuites;
import org.apache.cxf.configuration.security.ClientAuthentication;
import org.apache.cxf.configuration.security.CombinatorType;
import org.apache.cxf.configuration.security.DNConstraintsType;
import org.apache.cxf.configuration.security.ExcludeProtocols;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.configuration.security.IncludeProtocols;
import org.apache.cxf.configuration.security.KeyManagersType;
import org.apache.cxf.configuration.security.KeyStoreType;
import org.apache.cxf.configuration.security.ObjectFactory;
import org.apache.cxf.configuration.security.ProxyAuthorizationPolicy;
import org.apache.cxf.configuration.security.SecureRandomParameters;
import org.apache.cxf.configuration.security.TLSClientParametersType;
import org.apache.cxf.configuration.security.TLSServerParametersType;
import org.apache.cxf.configuration.security.TrustManagersType;
import org.apache.cxf.configuration.spring.AbstractBeanDefinitionParser;
import org.apache.cxf.configuration.spring.AbstractFactoryBeanDefinitionParser;
import org.apache.cxf.configuration.spring.BusWiringType;
import org.apache.cxf.configuration.spring.JAXBBeanFactory;
import org.apache.cxf.configuration.spring.MappingBeanDefinitionParser;
import org.apache.cxf.configuration.spring.SimpleBeanDefinitionParser;
import org.apache.cxf.configuration.spring.StringBeanDefinitionParser;
import org.apache.cxf.continuations.Continuation;
import org.apache.cxf.continuations.ContinuationCallback;
import org.apache.cxf.continuations.ContinuationProvider;
import org.apache.cxf.continuations.SuspendedInvocationException;
import org.apache.cxf.databinding.AbstractDataBinding;
import org.apache.cxf.databinding.AbstractInterceptorProvidingDataBinding;
import org.apache.cxf.databinding.AbstractWrapperHelper;
import org.apache.cxf.databinding.DataReader;
import org.apache.cxf.databinding.DataWriter;
import org.apache.cxf.databinding.WrapperCapableDatabinding;
import org.apache.cxf.databinding.WrapperHelper;
import org.apache.cxf.databinding.source.NodeDataReader;
import org.apache.cxf.databinding.source.NodeDataWriter;
import org.apache.cxf.databinding.source.SourceDataBinding;
import org.apache.cxf.databinding.source.XMLStreamDataReader;
import org.apache.cxf.databinding.source.XMLStreamDataWriter;
import org.apache.cxf.databinding.source.mime.CustomExtensionRegistry;
import org.apache.cxf.databinding.source.mime.MimeAttribute;
import org.apache.cxf.databinding.source.mime.MimeSerializer;
import org.apache.cxf.databinding.stax.StaxDataBinding;
import org.apache.cxf.databinding.stax.StaxDataBindingFeature;
import org.apache.cxf.databinding.stax.StaxDataBindingInterceptor;
import org.apache.cxf.databinding.stax.XMLStreamWriterCallback;
import org.apache.cxf.endpoint.AbstractConduitSelector;
import org.apache.cxf.endpoint.AbstractEndpointFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientCallback;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.ClientLifeCycleListener;
import org.apache.cxf.endpoint.ClientLifeCycleManager;
import org.apache.cxf.endpoint.ConduitSelector;
import org.apache.cxf.endpoint.ConduitSelectorHolder;
import org.apache.cxf.endpoint.DeferredConduitSelector;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.EndpointImplFactory;
import org.apache.cxf.endpoint.EndpointResolver;
import org.apache.cxf.endpoint.EndpointResolverRegistry;
import org.apache.cxf.endpoint.ManagedEndpoint;
import org.apache.cxf.endpoint.NullConduitSelector;
import org.apache.cxf.endpoint.PreexistingConduitSelector;
import org.apache.cxf.endpoint.Retryable;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerImpl;
import org.apache.cxf.endpoint.ServerLifeCycleListener;
import org.apache.cxf.endpoint.ServerLifeCycleManager;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.endpoint.ServiceContractResolver;
import org.apache.cxf.endpoint.ServiceContractResolverRegistry;
import org.apache.cxf.endpoint.SimpleEndpointImplFactory;
import org.apache.cxf.endpoint.UpfrontConduitSelector;
import org.apache.cxf.extension.BusExtension;
import org.apache.cxf.extension.Registry;
import org.apache.cxf.extension.RegistryImpl;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.feature.FastInfosetFeature;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.feature.StaxTransformFeature;
import org.apache.cxf.feature.WrappedFeature;
import org.apache.cxf.feature.transform.AbstractXSLTInterceptor;
import org.apache.cxf.feature.transform.XSLTFeature;
import org.apache.cxf.feature.transform.XSLTInInterceptor;
import org.apache.cxf.feature.transform.XSLTOutInterceptor;
import org.apache.cxf.feature.transform.XSLTUtils;
import org.apache.cxf.feature.validation.DefaultSchemaValidationTypeProvider;
import org.apache.cxf.feature.validation.SchemaValidationFeature;
import org.apache.cxf.feature.validation.SchemaValidationTypeProvider;
import org.apache.cxf.headers.Header;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.headers.HeaderProcessor;
import org.apache.cxf.interceptor.AbstractAttributedInterceptorProvider;
import org.apache.cxf.interceptor.AbstractBasicInterceptorProvider;
import org.apache.cxf.interceptor.AbstractFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.AnnotationInterceptors;
import org.apache.cxf.interceptor.AttachmentInInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.interceptor.ClientFaultConverter;
import org.apache.cxf.interceptor.ClientOutFaultObserver;
import org.apache.cxf.interceptor.FIStaxInInterceptor;
import org.apache.cxf.interceptor.FIStaxOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.FaultOutInterceptor;
import org.apache.cxf.interceptor.InFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.InFaultInterceptors;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.interceptor.OneWayProcessorInterceptor;
import org.apache.cxf.interceptor.OutFaultChainInitiatorObserver;
import org.apache.cxf.interceptor.OutFaultInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.interceptor.OutgoingChainInterceptor;
import org.apache.cxf.interceptor.ServiceInvokerInterceptor;
import org.apache.cxf.interceptor.StaxInEndingInterceptor;
import org.apache.cxf.interceptor.StaxInInterceptor;
import org.apache.cxf.interceptor.StaxOutEndingInterceptor;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.interceptor.security.AbstractAuthorizingInInterceptor;
import org.apache.cxf.interceptor.security.AbstractSecurityContextInInterceptor;
import org.apache.cxf.interceptor.security.AbstractUsernameTokenInInterceptor;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import org.apache.cxf.interceptor.security.AuthenticationException;
import org.apache.cxf.interceptor.security.DefaultSecurityContext;
import org.apache.cxf.interceptor.security.DelegatingAuthenticationInterceptor;
import org.apache.cxf.interceptor.security.DepthRestrictingStreamInterceptor;
import org.apache.cxf.interceptor.security.JAASAuthenticationFeature;
import org.apache.cxf.interceptor.security.JAASLoginInterceptor;
import org.apache.cxf.interceptor.security.NameDigestPasswordCallbackHandler;
import org.apache.cxf.interceptor.security.NamePasswordCallbackHandler;
import org.apache.cxf.interceptor.security.OperationInfoAuthorizingInterceptor;
import org.apache.cxf.interceptor.security.RolePrefixSecurityContextImpl;
import org.apache.cxf.interceptor.security.SecureAnnotationsInterceptor;
import org.apache.cxf.interceptor.security.SimpleAuthorizingInterceptor;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProvider;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProviderAuthPol;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerProviderUsernameToken;
import org.apache.cxf.interceptor.security.callback.CallbackHandlerTlsCert;
import org.apache.cxf.interceptor.security.callback.CertKeyToUserNameMapper;
import org.apache.cxf.interceptor.security.callback.CertificateToNameMapper;
import org.apache.cxf.interceptor.security.callback.NameToPasswordMapper;
import org.apache.cxf.interceptor.transform.TransformInInterceptor;
import org.apache.cxf.interceptor.transform.TransformOutInterceptor;
import org.apache.cxf.io.AbstractThresholdOutputStream;
import org.apache.cxf.io.AbstractWrappedOutputStream;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CacheSizeExceededException;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.io.CachedWriter;
import org.apache.cxf.io.CachedWriterCallback;
import org.apache.cxf.io.CipherPair;
import org.apache.cxf.io.CopyingOutputStream;
import org.apache.cxf.io.Transferable;
import org.apache.cxf.io.WriteOnCloseOutputStream;
import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.logging.NoOpFaultListener;
import org.apache.cxf.management.InstrumentationManager;
import org.apache.cxf.management.ManagedComponent;
import org.apache.cxf.management.ManagementConstants;
import org.apache.cxf.management.annotation.ManagedAttribute;
import org.apache.cxf.management.annotation.ManagedNotification;
import org.apache.cxf.management.annotation.ManagedNotifications;
import org.apache.cxf.management.annotation.ManagedOperation;
import org.apache.cxf.management.annotation.ManagedOperationParameter;
import org.apache.cxf.management.annotation.ManagedOperationParameters;
import org.apache.cxf.management.annotation.ManagedResource;
import org.apache.cxf.message.AbstractWrappedMessage;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.FaultMode;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.message.StringMap;
import org.apache.cxf.message.StringMapImpl;
import org.apache.cxf.message.XMLMessage;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseChainCache;
import org.apache.cxf.phase.PhaseComparator;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.phase.PhaseManager;
import org.apache.cxf.policy.PolicyCalculator;
import org.apache.cxf.policy.PolicyDataEngine;
import org.apache.cxf.resource.ClassLoaderResolver;
import org.apache.cxf.resource.ClasspathResolver;
import org.apache.cxf.resource.DefaultResourceManager;
import org.apache.cxf.resource.ExtendedURIResolver;
import org.apache.cxf.resource.ObjectTypeResolver;
import org.apache.cxf.resource.PropertiesResolver;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.resource.ResourceResolver;
import org.apache.cxf.resource.SinglePropertyResolver;
import org.apache.cxf.resource.URIResolver;
import org.apache.cxf.security.LoginSecurityContext;
import org.apache.cxf.security.SecurityContext;
import org.apache.cxf.security.claims.authorization.Claim;
import org.apache.cxf.security.claims.authorization.ClaimMode;
import org.apache.cxf.security.claims.authorization.Claims;
import org.apache.cxf.security.transport.TLSSessionInfo;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.ServiceBuilder;
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.ServiceModelSchemaValidator;
import org.apache.cxf.service.ServiceModelVisitor;
import org.apache.cxf.service.factory.AbstractServiceFactoryBean;
import org.apache.cxf.service.factory.AnnotationsFactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.factory.OldLoggingFactoryBeanListener;
import org.apache.cxf.service.factory.ServiceConstructionException;
import org.apache.cxf.service.factory.SimpleMethodDispatcher;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.apache.cxf.service.invoker.BeanInvoker;
import org.apache.cxf.service.invoker.Factory;
import org.apache.cxf.service.invoker.FactoryInvoker;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.invoker.PerRequestFactory;
import org.apache.cxf.service.invoker.PooledFactory;
import org.apache.cxf.service.invoker.SessionFactory;
import org.apache.cxf.service.invoker.SingletonFactory;
import org.apache.cxf.service.invoker.spring.SpringBeanFactory;
import org.apache.cxf.service.model.AbstractDescriptionElement;
import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.AbstractPropertiesHolder;
import org.apache.cxf.service.model.BindingFaultInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.Extensible;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.NamedItem;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceModelUtil;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.apache.cxf.service.model.UnwrappedOperationInfo;
import org.apache.cxf.staxutils.AbstractDOMStreamReader;
import org.apache.cxf.staxutils.CachingXmlEventWriter;
import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;
import org.apache.cxf.staxutils.DepthExceededStaxException;
import org.apache.cxf.staxutils.DepthRestrictingStreamReader;
import org.apache.cxf.staxutils.DepthXMLStreamReader;
import org.apache.cxf.staxutils.DocumentDepthProperties;
import org.apache.cxf.staxutils.FastStack;
import org.apache.cxf.staxutils.FragmentStreamReader;
import org.apache.cxf.staxutils.OverlayW3CDOMStreamWriter;
import org.apache.cxf.staxutils.PartialXMLStreamReader;
import org.apache.cxf.staxutils.PrettyPrintXMLStreamWriter;
import org.apache.cxf.staxutils.PropertiesExpandingStreamReader;
import org.apache.cxf.staxutils.StaxSource;
import org.apache.cxf.staxutils.StaxStreamFilter;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.staxutils.StreamWriterContentHandler;
import org.apache.cxf.staxutils.W3CDOMStreamReader;
import org.apache.cxf.staxutils.W3CDOMStreamWriter;
import org.apache.cxf.staxutils.W3CNamespaceContext;
import org.apache.cxf.staxutils.XMLStreamReaderWrapper;
import org.apache.cxf.staxutils.transform.DelegatingNamespaceContext;
import org.apache.cxf.staxutils.transform.IgnoreNamespacesWriter;
import org.apache.cxf.staxutils.transform.InTransformReader;
import org.apache.cxf.staxutils.transform.OutTransformWriter;
import org.apache.cxf.staxutils.transform.TransformUtils;
import org.apache.cxf.staxutils.validation.EmbeddedSchema;
import org.apache.cxf.staxutils.validation.ResolvingGrammarReaderController;
import org.apache.cxf.staxutils.validation.StaxSchemaValidationInInterceptor;
import org.apache.cxf.staxutils.validation.StaxSchemaValidationOutInterceptor;
import org.apache.cxf.staxutils.validation.W3CMultiSchemaFactory;
import org.apache.cxf.staxutils.validation.WoodstoxValidationImpl;
import org.apache.cxf.transport.AbstractConduit;
import org.apache.cxf.transport.AbstractDestination;
import org.apache.cxf.transport.AbstractMultiplexDestination;
import org.apache.cxf.transport.AbstractObservable;
import org.apache.cxf.transport.AbstractTransportFactory;
import org.apache.cxf.transport.Assertor;
import org.apache.cxf.transport.ChainInitiationObserver;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.DestinationWithEndpoint;
import org.apache.cxf.transport.HttpUriMapper;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.transport.MultipleEndpointObserver;
import org.apache.cxf.transport.MultiplexDestination;
import org.apache.cxf.transport.Observable;
import org.apache.cxf.transport.Session;
import org.apache.cxf.transport.TransportFinder;
import org.apache.cxf.transport.TransportURIResolver;
import org.apache.cxf.transport.common.gzip.GZIPFeature;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.validation.AbstractBeanValidationInterceptor;
import org.apache.cxf.validation.AbstractValidationInterceptor;
import org.apache.cxf.validation.BeanValidationFeature;
import org.apache.cxf.validation.BeanValidationInInterceptor;
import org.apache.cxf.validation.BeanValidationOutInterceptor;
import org.apache.cxf.validation.BeanValidationProvider;
import org.apache.cxf.validation.ClientBeanValidationFeature;
import org.apache.cxf.validation.ClientBeanValidationOutInterceptor;
import org.apache.cxf.validation.ResponseConstraintViolationException;
import org.apache.cxf.validation.ValidationConfiguration;
import org.apache.cxf.version.Version;
import org.apache.cxf.workqueue.AutomaticWorkQueue;
import org.apache.cxf.workqueue.AutomaticWorkQueueImpl;
import org.apache.cxf.workqueue.OneShotAsyncExecutor;
import org.apache.cxf.workqueue.SynchronousExecutor;
import org.apache.cxf.workqueue.WorkQueue;
import org.apache.cxf.workqueue.WorkQueueManager;
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
import org.apache.cxf.ws.addressing.ProblemActionType;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer;
import org.apache.cxf.ws.addressing.WSAContextUtils;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.v200403.AttributedQName;
import org.apache.cxf.ws.addressing.v200403.AttributedURI;
import org.apache.cxf.ws.addressing.v200403.ReferencePropertiesType;
import org.apache.cxf.ws.addressing.v200403.Relationship;
import org.apache.cxf.ws.addressing.v200403.ReplyAfterType;
import org.apache.cxf.ws.addressing.v200403.ServiceNameType;
import org.apache.cxf.ws.addressing.wsdl.Anonymous;
import org.apache.cxf.ws.addressing.wsdl.AnonymousType;
import org.apache.cxf.ws.addressing.wsdl.UsingAddressing;
import org.apache.cxf.wsdl.http.AddressType;
import org.apache.cxf.wsdl.http.BindingType;
import org.apache.cxf.wsdl.http.OperationType;
import org.apache.cxf.wsdl.http.UrlEncoded;
import org.apache.cxf.wsdl.http.UrlReplacement;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

@SuppressWarnings("deprecation")
public class CXFCoreSummaryTest extends AbstractTest {

	@Test
	public void test() {

		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays.asList(new Class<?>[] { Bus.class, BusException.class, BusFactory.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { DataBinding.class, EndpointProperties.class,
				EndpointProperty.class, EvaluateAllEndpoints.class, FactoryType.class, FastInfoset.class, GZIP.class,
				Logging.class, Policies.class, Policy.class, Provider.class, SchemaValidation.class,
				UseAsyncMethod.class, UseNio.class, WSDLDocumentation.class, WSDLDocumentationCollection.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AttachmentDataSource.class, AttachmentDeserializer.class,
				AttachmentImpl.class, AttachmentSerializer.class, AttachmentUtil.class, Base64DecoderStream.class,
				ByteDataSource.class, ContentDisposition.class, DelegatingInputStream.class,
				ImageDataContentHandler.class, LazyAttachmentCollection.class, LazyDataSource.class,
				MimeBodyPartInputStream.class, QuotedPrintableDecoderStream.class, Rfc5987Util.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractBindingFactory.class, Binding.class,
				BindingConfiguration.class, BindingFactory.class, BindingFactoryManager.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { CXFBusFactory.class, ManagedBus.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { BlueprintBeanLocator.class, BlueprintBus.class,
				BlueprintNameSpaceHandlerFactory.class, BundleDelegatingClassLoader.class, BusDefinitionParser.class,
				ConfigurerImpl.class, NamespaceHandlerRegisterer.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Extension.class, ExtensionException.class, ExtensionManager.class,
				ExtensionManagerBus.class, ExtensionManagerImpl.class, ExtensionRegistry.class,
				TextExtensionFragmentParser.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { BindingFactoryManagerImpl.class, ClientLifeCycleManagerImpl.class,
				ConduitInitiatorManagerImpl.class, CXFBusLifeCycleManager.class, DestinationFactoryManagerImpl.class,
				EndpointResolverRegistryImpl.class, HeaderManagerImpl.class, PhaseManagerImpl.class,
				ServerLifeCycleManagerImpl.class, ServerRegistryImpl.class, ServiceContractResolverRegistryImpl.class,
				WorkQueueImplMBeanWrapper.class, WorkQueueManagerImpl.class, WorkQueueManagerImplMBeanWrapper.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { CXFActivator.class, CXFExtensionBundleListener.class,
//				ManagedWorkQueueList.class, OSGiBeanLocator.class, OSGIBusListener.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { ResourceManagerImpl.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { BusApplicationContext.class,
				BusApplicationContextResourceResolver.class, org.apache.cxf.bus.spring.BusDefinitionParser.class,
				BusEntityResolver.class, BusExtensionPostProcessor.class, BusWiringBeanFactoryPostProcessor.class,
				ControlledValidationXmlBeanDefinitionReader.class, Jsr250BeanPostProcessor.class,
				NamespaceHandler.class, SpringBeanLocator.class, SpringBus.class, SpringBusFactory.class }));

		classes.addAll(Arrays.asList(
				new Class<?>[] { BusCreationListener.class, BusLifeCycleListener.class, BusLifeCycleManager.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { CatalogXmlSchemaURIResolver.class, OASISCatalogManager.class,
				OASISCatalogManagerHelper.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { CXFPermissions.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractAnnotationVisitor.class, AnnotationProcessor.class,
				AnnotationVisitor.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { ClassLoaderUtils.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { BundleUtils.class, org.apache.cxf.common.i18n.Exception.class,
				Message.class, UncheckedException.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { NoJSR250Annotations.class, ResourceInjector.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { JAXBBeanInfo.class, JAXBContextCache.class,
//				JAXBContextProxy.class, JAXBUtils.class, NamespaceMapper.class, SchemaCollectionContextProxy.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractDelegatingLogger.class, Log4jLogger.class, LogUtils.class,
				Slf4jLogger.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { SecurityToken.class, SimpleGroup.class, SimplePrincipal.class,
				SimpleSecurityContext.class, TokenType.class, UsernameToken.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { ASMHelper.class, Base64Exception.class, Base64OutputStream.class,
				Base64UrlOutputStream.class, Base64UrlUtility.class, Base64Utility.class, CachedClass.class,
				CacheMap.class, ClassHelper.class, ClasspathScanner.class, ClassUnwrapper.class, CollectionUtils.class,
				Compiler.class, CompressionUtils.class, ExtensionInvocationHandler.class,
				MessageDigestInputStream.class, ModCountCopyOnWriteArrayList.class, PackageUtils.class,
				PrimitiveUtils.class, PropertiesLoaderUtils.class, PropertyUtils.class, ProxyClassLoader.class,
				ProxyHelper.class, ReflectionInvokationHandler.class, ReflectionUtil.class, SortedArraySet.class,
				StringUtils.class, SystemPropertyAction.class, URIParserUtil.class, UrlUtils.class,
				WeakIdentityHashMap.class, XmlSchemaPrimitiveUtils.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { InvalidXmlSchemaReferenceException.class, LSInputImpl.class,
				SchemaCollection.class, XmlSchemaInvalidOperation.class, XmlSchemaUtils.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Configurable.class, ConfigurationException.class,
				ConfiguredBeanLocator.class, Configurer.class, NullConfigurer.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { AbstractBPBeanDefinitionParser.class,
//				InterceptorTypeConverter.class, SimpleBPBeanDefinitionParser.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { MultiKeyPasswordKeyManager.class, SSLUtils.class,
				TLSClientParameters.class, TLSClientParametersConfig.class, TLSParameterBase.class,
				TLSParameterJaxBUtils.class, TLSServerParameters.class, TLSServerParametersConfig.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AuthorizationPolicy.class, CertificateConstraintsType.class,
				CertStoreType.class, CipherSuites.class, ClientAuthentication.class, CombinatorType.class,
				DNConstraintsType.class, ExcludeProtocols.class, FiltersType.class, IncludeProtocols.class,
				KeyManagersType.class, KeyStoreType.class, ObjectFactory.class, ProxyAuthorizationPolicy.class,
				SecureRandomParameters.class, TLSClientParametersType.class, TLSServerParametersType.class,
				TrustManagersType.class }));

		classes.addAll(Arrays
				.asList(new Class<?>[] { AbstractBeanDefinitionParser.class, AbstractFactoryBeanDefinitionParser.class,
						BusWiringType.class, org.apache.cxf.configuration.spring.ConfigurerImpl.class,
						JAXBBeanFactory.class, MappingBeanDefinitionParser.class, SimpleBeanDefinitionParser.class,
						StringBeanDefinitionParser.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Continuation.class, ContinuationCallback.class,
				ContinuationProvider.class, SuspendedInvocationException.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { AbstractDataBinding.class, AbstractInterceptorProvidingDataBinding.class,
						AbstractWrapperHelper.class, org.apache.cxf.databinding.DataBinding.class, DataReader.class,
						DataWriter.class, WrapperCapableDatabinding.class, WrapperHelper.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { NodeDataReader.class, NodeDataWriter.class,
				SourceDataBinding.class, XMLStreamDataReader.class, XMLStreamDataWriter.class }));

		classes.addAll(Arrays
				.asList(new Class<?>[] { CustomExtensionRegistry.class, MimeAttribute.class, MimeSerializer.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { StaxDataBinding.class, StaxDataBindingFeature.class,
				StaxDataBindingInterceptor.class, XMLStreamWriterCallback.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractConduitSelector.class, AbstractEndpointFactory.class,
				Client.class, ClientCallback.class, ClientImpl.class, ClientLifeCycleListener.class,
				ClientLifeCycleManager.class, ConduitSelector.class, ConduitSelectorHolder.class,
				DeferredConduitSelector.class, Endpoint.class, EndpointException.class, EndpointImpl.class,
				EndpointImplFactory.class, EndpointResolver.class, EndpointResolverRegistry.class,
				ManagedEndpoint.class, NullConduitSelector.class, PreexistingConduitSelector.class, Retryable.class,
				Server.class, ServerImpl.class, ServerLifeCycleListener.class, ServerLifeCycleManager.class,
				ServerRegistry.class, ServiceContractResolver.class, ServiceContractResolverRegistry.class,
				SimpleEndpointImplFactory.class, UpfrontConduitSelector.class, }));

		classes.addAll(Arrays.asList(new Class<?>[] { BusExtension.class, Registry.class, RegistryImpl.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractFeature.class, FastInfosetFeature.class, Feature.class,
				Features.class, LoggingFeature.class, StaxTransformFeature.class, WrappedFeature.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractXSLTInterceptor.class, XSLTFeature.class,
				XSLTInInterceptor.class, XSLTOutInterceptor.class, XSLTUtils.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { DefaultSchemaValidationTypeProvider.class,
				SchemaValidationFeature.class, SchemaValidationTypeProvider.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Header.class, HeaderManager.class, HeaderProcessor.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { BaseNamespaceHandler.class, CastUtils.class, DOMUtils.class,
//				FileUtils.class, HttpHeaderHelper.class, IOUtils.class, JavaUtils.class,
//				LoadingByteArrayOutputStream.class, MapNamespaceContext.class, NSDecl.class, NSStack.class,
//				ServiceUtils.class, XPathUtils.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractAttributedInterceptorProvider.class,
				AbstractBasicInterceptorProvider.class, AbstractFaultChainInitiatorObserver.class,
				AbstractInDatabindingInterceptor.class, AbstractLoggingInterceptor.class,
				AbstractOutDatabindingInterceptor.class, AnnotationInterceptors.class, AttachmentInInterceptor.class,
				AttachmentOutInterceptor.class, ClientFaultConverter.class, ClientOutFaultObserver.class, Fault.class,
				FaultOutInterceptor.class, FIStaxInInterceptor.class, FIStaxOutInterceptor.class,
				InFaultChainInitiatorObserver.class, InFaultInterceptors.class, InInterceptors.class, Interceptor.class,
				InterceptorChain.class, InterceptorProvider.class, LoggingInInterceptor.class, LoggingMessage.class,
				LoggingOutInterceptor.class, MessageSenderInterceptor.class, OneWayProcessorInterceptor.class,
				OutFaultChainInitiatorObserver.class, OutFaultInterceptors.class, OutgoingChainInterceptor.class,
				OutInterceptors.class, ServiceInvokerInterceptor.class, StaxInEndingInterceptor.class,
				StaxInInterceptor.class, StaxOutEndingInterceptor.class, StaxOutInterceptor.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractAuthorizingInInterceptor.class,
				AbstractSecurityContextInInterceptor.class, AbstractUsernameTokenInInterceptor.class,
				AccessDeniedException.class, AuthenticationException.class, DefaultSecurityContext.class,
				DelegatingAuthenticationInterceptor.class, DepthRestrictingStreamInterceptor.class,
				JAASAuthenticationFeature.class, JAASLoginInterceptor.class, NameDigestPasswordCallbackHandler.class,
				NamePasswordCallbackHandler.class, OperationInfoAuthorizingInterceptor.class,
				RolePrefixSecurityContextImpl.class, SecureAnnotationsInterceptor.class,
				SimpleAuthorizingInterceptor.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { CallbackHandlerProvider.class, CallbackHandlerProviderAuthPol.class,
						CallbackHandlerProviderUsernameToken.class, CallbackHandlerTlsCert.class,
						CertificateToNameMapper.class, CertKeyToUserNameMapper.class, NameToPasswordMapper.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { TransformInInterceptor.class, TransformOutInterceptor.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { CXFAPINamespaceHandler.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractThresholdOutputStream.class,
				AbstractWrappedOutputStream.class, CacheAndWriteOutputStream.class, CachedOutputStream.class,
				CachedOutputStreamCallback.class, CachedWriter.class, CachedWriterCallback.class,
				CacheSizeExceededException.class, CipherPair.class, CopyingOutputStream.class,
				org.apache.cxf.io.DelegatingInputStream.class, Transferable.class, WriteOnCloseOutputStream.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { FaultListener.class, NoOpFaultListener.class }));

		classes.addAll(Arrays.asList(
				new Class<?>[] { InstrumentationManager.class, ManagedComponent.class, ManagementConstants.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { ManagedAttribute.class, ManagedNotification.class,
				ManagedNotifications.class, ManagedOperation.class, ManagedOperationParameter.class,
				ManagedOperationParameters.class, ManagedResource.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractWrappedMessage.class, Attachment.class, Exchange.class,
				ExchangeImpl.class, FaultMode.class, org.apache.cxf.message.Message.class, MessageContentsList.class,
				MessageImpl.class, MessageUtils.class, StringMap.class, StringMapImpl.class, XMLMessage.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractPhaseInterceptor.class, Phase.class,
				PhaseChainCache.class, PhaseComparator.class, PhaseInterceptor.class, PhaseInterceptorChain.class,
				PhaseManager.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { PolicyCalculator.class, PolicyDataEngine.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { ClassLoaderResolver.class, ClasspathResolver.class,
				DefaultResourceManager.class, ExtendedURIResolver.class, ObjectTypeResolver.class,
				PropertiesResolver.class, ResourceManager.class, ResourceResolver.class, SinglePropertyResolver.class,
				URIResolver.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { LoginSecurityContext.class, SecurityContext.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Claim.class, ClaimMode.class, Claims.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { TLSSessionInfo.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Service.class, ServiceBuilder.class, ServiceImpl.class,
				ServiceModelSchemaValidator.class, ServiceModelVisitor.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractServiceFactoryBean.class,
				AnnotationsFactoryBeanListener.class, FactoryBeanListener.class, FactoryBeanListenerManager.class,
				OldLoggingFactoryBeanListener.class, ServiceConstructionException.class,
				SimpleMethodDispatcher.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractInvoker.class, BeanInvoker.class, Factory.class,
				FactoryInvoker.class, Invoker.class, MethodDispatcher.class, PerRequestFactory.class,
				PooledFactory.class, SessionFactory.class, SingletonFactory.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { SpringBeanFactory.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractDescriptionElement.class, AbstractMessageContainer.class,
				AbstractPropertiesHolder.class, BindingFaultInfo.class, BindingInfo.class, BindingMessageInfo.class,
				BindingOperationInfo.class, DescriptionInfo.class, EndpointInfo.class, Extensible.class,
				FaultInfo.class, InterfaceInfo.class, MessageInfo.class, MessagePartInfo.class, NamedItem.class,
				OperationInfo.class, SchemaInfo.class, ServiceInfo.class, ServiceModelUtil.class,
				ServiceSchemaInfo.class, UnwrappedOperationInfo.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractDOMStreamReader.class, CachingXmlEventWriter.class,
				DelegatingXMLStreamWriter.class, DepthExceededStaxException.class, DepthRestrictingStreamReader.class,
				DepthXMLStreamReader.class, DocumentDepthProperties.class, FastStack.class, FragmentStreamReader.class,
				OverlayW3CDOMStreamWriter.class, PartialXMLStreamReader.class, PrettyPrintXMLStreamWriter.class,
				PropertiesExpandingStreamReader.class, StaxSource.class, StaxStreamFilter.class, StaxUtils.class,
				StreamWriterContentHandler.class, W3CDOMStreamReader.class, W3CDOMStreamWriter.class,
				W3CNamespaceContext.class, XMLStreamReaderWrapper.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { DelegatingNamespaceContext.class, IgnoreNamespacesWriter.class,
				InTransformReader.class, OutTransformWriter.class, TransformUtils.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { EmbeddedSchema.class, ResolvingGrammarReaderController.class,
//				StaxSchemaValidationInInterceptor.class, StaxSchemaValidationOutInterceptor.class,
//				W3CMultiSchemaFactory.class, WoodstoxValidationImpl.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractConduit.class, AbstractDestination.class,
				AbstractMultiplexDestination.class, AbstractObservable.class, AbstractTransportFactory.class,
				Assertor.class, ChainInitiationObserver.class, Conduit.class, ConduitInitiator.class,
				ConduitInitiatorManager.class, Destination.class, DestinationFactory.class,
				DestinationFactoryManager.class, DestinationWithEndpoint.class, HttpUriMapper.class,
				MessageObserver.class, MultipleEndpointObserver.class, MultiplexDestination.class, Observable.class,
				Session.class, TransportFinder.class, TransportURIResolver.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { GZIPFeature.class, GZIPInInterceptor.class, GZIPOutInterceptor.class }));

//		classes.addAll(Arrays.asList(new Class<?>[] { AbstractBeanValidationInterceptor.class,
//				AbstractValidationInterceptor.class, BeanValidationFeature.class, BeanValidationInInterceptor.class,
//				BeanValidationOutInterceptor.class, BeanValidationProvider.class, ClientBeanValidationFeature.class,
//				ClientBeanValidationOutInterceptor.class, ResponseConstraintViolationException.class,
//				ValidationConfiguration.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Version.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AutomaticWorkQueue.class, AutomaticWorkQueueImpl.class,
				OneShotAsyncExecutor.class, SynchronousExecutor.class, WorkQueue.class, WorkQueueManager.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AddressingConstants.class, AddressingProperties.class,
				AttributedAnyType.class, AttributedQNameType.class, AttributedUnsignedLongType.class,
				AttributedURIType.class, ContextUtils.class, EndpointReferenceType.class, EndpointReferenceUtils.class,
				EndpointUtilsException.class, FaultAction.class, JAXWSAConstants.class, MAPAggregator.class,
				MessageIdCache.class, MetadataType.class, Names.class, org.apache.cxf.ws.addressing.ObjectFactory.class,
				ProblemActionType.class, ReferenceParametersType.class, RelatesToType.class, VersionTransformer.class,
				WSAContextUtils.class, WSAddressingFeature.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AttributedQName.class, AttributedURI.class,
				org.apache.cxf.ws.addressing.v200403.EndpointReferenceType.class,
				org.apache.cxf.ws.addressing.v200403.ObjectFactory.class, ReferencePropertiesType.class,
				Relationship.class, ReplyAfterType.class, ServiceNameType.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { org.apache.cxf.ws.addressing.v200408.AttributedQName.class,
				org.apache.cxf.ws.addressing.v200408.AttributedURI.class,
				org.apache.cxf.ws.addressing.v200408.EndpointReferenceType.class,
				org.apache.cxf.ws.addressing.v200408.ObjectFactory.class,
				org.apache.cxf.ws.addressing.v200408.ReferenceParametersType.class,
				org.apache.cxf.ws.addressing.v200408.ReferencePropertiesType.class,
				org.apache.cxf.ws.addressing.v200408.Relationship.class,
				org.apache.cxf.ws.addressing.v200408.ReplyAfterType.class,
				org.apache.cxf.ws.addressing.v200408.ServiceNameType.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { Anonymous.class, AnonymousType.class,
				org.apache.cxf.ws.addressing.wsdl.AttributedQNameType.class,
				org.apache.cxf.ws.addressing.wsdl.ObjectFactory.class,
				org.apache.cxf.ws.addressing.wsdl.ServiceNameType.class, UsingAddressing.class }));

		classes.addAll(Arrays.asList(
				new Class<?>[] { AddressType.class, BindingType.class, org.apache.cxf.wsdl.http.ObjectFactory.class,
						OperationType.class, UrlEncoded.class, UrlReplacement.class }));

		summary(classes);

	}
}
