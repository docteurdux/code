package com.github.docteurdux.spring.security.notes;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AfterInvocationProvider;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.PermissionCacheOptimizer;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.annotation.AnnotationMetadataExtractor;
import org.springframework.security.access.annotation.Jsr250MethodSecurityMetadataSource;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;
import org.springframework.security.access.annotation.Jsr250Voter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.DenyAllPermissionEvaluator;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.ExpressionBasedAnnotationAttributeFactory;
import org.springframework.security.access.expression.method.ExpressionBasedPostInvocationAdvice;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.hierarchicalroles.CycleInRoleHierarchyException;
import org.springframework.security.access.hierarchicalroles.NullRoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyAuthoritiesMapper;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyUtils;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.AfterInvocationManager;
import org.springframework.security.access.intercept.AfterInvocationProviderManager;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.access.intercept.MethodInvocationPrivilegeEvaluator;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityMetadataSourceAdvisor;
import org.springframework.security.access.intercept.aspectj.AspectJCallback;
import org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor;
import org.springframework.security.access.intercept.aspectj.MethodInvocationAdapter;
import org.springframework.security.access.method.AbstractFallbackMethodSecurityMetadataSource;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PostInvocationAdviceProvider;
import org.springframework.security.access.prepost.PostInvocationAttribute;
import org.springframework.security.access.prepost.PostInvocationAuthorizationAdvice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.access.prepost.PreInvocationAttribute;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdvice;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.access.prepost.PrePostAnnotationSecurityMetadataSource;
import org.springframework.security.access.prepost.PrePostInvocationAttributeFactory;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.access.vote.AbstractAclVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.ConsensusBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.afterinvocation.AbstractAclProvider;
import org.springframework.security.acls.afterinvocation.AclEntryAfterInvocationCollectionFilteringProvider;
import org.springframework.security.acls.afterinvocation.AclEntryAfterInvocationProvider;
import org.springframework.security.acls.domain.AbstractPermission;
import org.springframework.security.acls.domain.AccessControlEntryImpl;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.domain.AclFormattingUtils;
import org.springframework.security.acls.domain.AclImpl;
import org.springframework.security.acls.domain.AuditLogger;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.acls.domain.CumulativePermission;
import org.springframework.security.acls.domain.DefaultPermissionFactory;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.IdentityUnavailableException;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.ObjectIdentityRetrievalStrategyImpl;
import org.springframework.security.acls.domain.PermissionFactory;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.domain.SidRetrievalStrategyImpl;
import org.springframework.security.acls.domain.SpringCacheBasedAclCache;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcAclService;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.AccessControlEntry;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.AclDataAccessException;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.acls.model.AuditableAccessControlEntry;
import org.springframework.security.acls.model.AuditableAcl;
import org.springframework.security.acls.model.ChildrenExistException;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityGenerator;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;
import org.springframework.security.acls.model.OwnershipAcl;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.model.SidRetrievalStrategy;
import org.springframework.security.acls.model.UnloadedSidException;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.dao.SystemWideSaltSource;
import org.springframework.security.authentication.encoding.BaseDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.Md4PasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureCredentialsExpiredEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationFailureExpiredEvent;
import org.springframework.security.authentication.event.AuthenticationFailureLockedEvent;
import org.springframework.security.authentication.event.AuthenticationFailureProviderNotFoundEvent;
import org.springframework.security.authentication.event.AuthenticationFailureProxyUntrustedEvent;
import org.springframework.security.authentication.event.AuthenticationFailureServiceExceptionEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider;
import org.springframework.security.authentication.jaas.DefaultLoginExceptionResolver;
import org.springframework.security.authentication.jaas.JaasAuthenticationCallbackHandler;
import org.springframework.security.authentication.jaas.JaasAuthenticationProvider;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
import org.springframework.security.authentication.jaas.JaasNameCallbackHandler;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.security.authentication.jaas.LoginExceptionResolver;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.authentication.jaas.event.JaasAuthenticationEvent;
import org.springframework.security.authentication.jaas.event.JaasAuthenticationFailedEvent;
import org.springframework.security.authentication.jaas.event.JaasAuthenticationSuccessEvent;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.authentication.rcp.RemoteAuthenticationException;
import org.springframework.security.authentication.rcp.RemoteAuthenticationManager;
import org.springframework.security.authentication.rcp.RemoteAuthenticationManagerImpl;
import org.springframework.security.authentication.rcp.RemoteAuthenticationProvider;
import org.springframework.security.cas.SamlServiceProperties;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.cas.authentication.EhCacheBasedTicketCache;
import org.springframework.security.cas.authentication.NullStatelessTicketCache;
import org.springframework.security.cas.authentication.SpringCacheBasedTicketCache;
import org.springframework.security.cas.authentication.StatelessTicketCache;
import org.springframework.security.cas.jackson2.CasJackson2Module;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.cas.userdetails.GrantedAuthorityFromAssertionAttributesUserDetailsService;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetails;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.concurrent.DelegatingSecurityContextRunnable;
import org.springframework.security.concurrent.DelegatingSecurityContextScheduledExecutorService;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.DebugBeanDefinitionParser;
import org.springframework.security.config.Elements;
import org.springframework.security.config.SecurityNamespaceHandler;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.AlreadyBuiltException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.ProviderManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractConfigAttributeRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer;
import org.springframework.security.config.annotation.web.configurers.ChannelSecurityConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.configurers.JeeConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.annotation.web.configurers.PortMapperConfigurer;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.config.annotation.web.configurers.ServletApiConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.X509Configurer;
import org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.security.config.authentication.AbstractUserDetailsServiceBeanDefinitionParser;
import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser;
import org.springframework.security.config.authentication.CachingUserDetailsService;
import org.springframework.security.config.authentication.JdbcUserServiceBeanDefinitionParser;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.debug.SecurityDebugBeanFactoryPostProcessor;
import org.springframework.security.config.http.ChannelAttributeFactory;
import org.springframework.security.config.http.CorsBeanDefinitionParser;
import org.springframework.security.config.http.CsrfBeanDefinitionParser;
import org.springframework.security.config.http.DefaultFilterChainValidator;
import org.springframework.security.config.http.FilterChainBeanDefinitionParser;
import org.springframework.security.config.http.FilterChainMapBeanDefinitionDecorator;
import org.springframework.security.config.http.FilterInvocationSecurityMetadataSourceParser;
import org.springframework.security.config.http.FormLoginBeanDefinitionParser;
import org.springframework.security.config.http.HeadersBeanDefinitionParser;
import org.springframework.security.config.http.HttpFirewallBeanDefinitionParser;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.springframework.security.config.http.MatcherType;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.config.ldap.LdapProviderBeanDefinitionParser;
import org.springframework.security.config.ldap.LdapServerBeanDefinitionParser;
import org.springframework.security.config.ldap.LdapUserServiceBeanDefinitionParser;
import org.springframework.security.config.method.GlobalMethodSecurityBeanDefinitionParser;
import org.springframework.security.config.method.InterceptMethodsBeanDefinitionDecorator;
import org.springframework.security.config.method.MethodSecurityMetadataSourceBeanDefinitionParser;
import org.springframework.security.config.websocket.WebSocketMessageBrokerSecurityBeanDefinitionParser;
import org.springframework.security.context.DelegatingApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.MapBasedAttributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAttributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.authority.mapping.SimpleMappableAttributesRetriever;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.parameters.AnnotationParameterNameDiscoverer;
import org.springframework.security.core.parameters.DefaultSecurityParameterNameDiscoverer;
import org.springframework.security.core.session.SessionCreationEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.token.DefaultToken;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.SecureRandomFactoryBean;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.encrypt.BouncyCastleAesCbcBytesEncryptor;
import org.springframework.security.crypto.encrypt.BouncyCastleAesGcmBytesEncryptor;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.crypto.util.EncodingUtils;
import org.springframework.security.jackson2.CoreJackson2Module;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.LdapUsernameToDnMapper;
import org.springframework.security.ldap.LdapUtils;
import org.springframework.security.ldap.SpringSecurityLdapTemplate;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticator;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.authentication.NullLdapAuthoritiesPopulator;
import org.springframework.security.ldap.authentication.PasswordComparisonAuthenticator;
import org.springframework.security.ldap.authentication.SpringSecurityAuthenticationSource;
import org.springframework.security.ldap.authentication.UserDetailsServiceLdapAuthoritiesPopulator;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryAuthenticationException;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.ppolicy.PasswordPolicyAwareContextSource;
import org.springframework.security.ldap.ppolicy.PasswordPolicyControl;
import org.springframework.security.ldap.ppolicy.PasswordPolicyControlExtractor;
import org.springframework.security.ldap.ppolicy.PasswordPolicyControlFactory;
import org.springframework.security.ldap.ppolicy.PasswordPolicyData;
import org.springframework.security.ldap.ppolicy.PasswordPolicyErrorStatus;
import org.springframework.security.ldap.ppolicy.PasswordPolicyException;
import org.springframework.security.ldap.ppolicy.PasswordPolicyResponseControl;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.search.LdapUserSearch;
import org.springframework.security.ldap.server.ApacheDSContainer;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.security.ldap.userdetails.InetOrgPersonContextMapper;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;
import org.springframework.security.ldap.userdetails.NestedLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.security.ldap.userdetails.PersonContextMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.security.openid.AuthenticationCancelledException;
import org.springframework.security.openid.AxFetchListFactory;
import org.springframework.security.openid.NullAxFetchListFactory;
import org.springframework.security.openid.OpenID4JavaConsumer;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationFilter;
import org.springframework.security.openid.OpenIDAuthenticationProvider;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.openid.OpenIDConsumer;
import org.springframework.security.openid.OpenIDConsumerException;
import org.springframework.security.openid.RegexBasedAxFetchListFactory;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.remoting.dns.DnsEntryNotFoundException;
import org.springframework.security.remoting.dns.DnsLookupException;
import org.springframework.security.remoting.dns.DnsResolver;
import org.springframework.security.remoting.dns.InitialContextFactory;
import org.springframework.security.remoting.dns.JndiDnsResolver;
import org.springframework.security.remoting.httpinvoker.AuthenticationSimpleHttpInvokerRequestExecutor;
import org.springframework.security.remoting.rmi.ContextPropagatingRemoteInvocation;
import org.springframework.security.remoting.rmi.ContextPropagatingRemoteInvocationFactory;
import org.springframework.security.scheduling.DelegatingSecurityContextSchedulingTaskExecutor;
import org.springframework.security.taglibs.TagLibConfig;
import org.springframework.security.taglibs.authz.AbstractAuthorizeTag;
import org.springframework.security.taglibs.authz.AccessControlListTag;
import org.springframework.security.taglibs.authz.AuthenticationTag;
import org.springframework.security.taglibs.authz.JspAuthorizeTag;
import org.springframework.security.taglibs.csrf.CsrfInputTag;
import org.springframework.security.taglibs.csrf.CsrfMetaTagsTag;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextTaskExecutor;
import org.springframework.security.test.context.TestSecurityContextHolder;
import org.springframework.security.test.context.annotation.SecurityTestExecutionListeners;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.test.web.support.WebTestUtils;
import org.springframework.security.util.FieldUtils;
import org.springframework.security.util.InMemoryResource;
import org.springframework.security.util.MethodInvocationUtils;
import org.springframework.security.util.SimpleMethodInvocation;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.PortMapperImpl;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DefaultWebInvocationPrivilegeEvaluator;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.security.web.access.channel.AbstractRetryEntryPoint;
import org.springframework.security.web.access.channel.ChannelDecisionManager;
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl;
import org.springframework.security.web.access.channel.ChannelEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.channel.ChannelProcessor;
import org.springframework.security.web.access.channel.InsecureChannelProcessor;
import org.springframework.security.web.access.channel.RetryWithHttpEntryPoint;
import org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint;
import org.springframework.security.web.access.channel.SecureChannelProcessor;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.access.intercept.RequestKey;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.NullRememberMeServices;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.DelegatingLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.j2ee.J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.j2ee.WebXmlMappableAttributesRetriever;
import org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedWebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.x509.SubjectDnX509PrincipalExtractor;
import org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter;
import org.springframework.security.web.authentication.preauth.x509.X509PrincipalExtractor;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy;
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionEvent;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.security.web.authentication.switchuser.SwitchUserAuthorityChanger;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.web.authentication.www.NonceExpiredException;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.context.request.async.SecurityContextCallableProcessingInterceptor;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.debug.DebugFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;
import org.springframework.security.web.header.writers.HpkpHeaderWriter;
import org.springframework.security.web.header.writers.HstsHeaderWriter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.RegExpAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.jaasapi.JaasApiIntegrationFilter;
import org.springframework.security.web.jackson2.WebJackson2Module;
import org.springframework.security.web.method.annotation.CsrfTokenArgumentResolver;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.Enumerator;
import org.springframework.security.web.savedrequest.FastHttpDateFormat;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.savedrequest.SavedCookie;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.InvalidSessionAccessDeniedHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;
import org.springframework.security.web.util.OnCommittedResponseWrapper;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.security.web.util.ThrowableAnalyzer;
import org.springframework.security.web.util.ThrowableCauseExtractor;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcherEditor;
import org.springframework.security.web.util.matcher.RequestVariablesExtractor;

@SuppressWarnings("deprecation")
public class Todos {

	public static void core(Notes n) {

		n.todo(AccessDecisionManager.class, AccessDecisionVoter.class, AccessDeniedException.class,
				AfterInvocationProvider.class, AuthorizationServiceException.class, ConfigAttribute.class,
				PermissionCacheOptimizer.class, PermissionEvaluator.class, SecurityConfig.class,
				SecurityMetadataSource.class);

		n.todo(AnnotationMetadataExtractor.class, Jsr250MethodSecurityMetadataSource.class, Jsr250SecurityConfig.class,
				Jsr250Voter.class, Secured.class, SecuredAnnotationSecurityMetadataSource.class);

		n.todo(AbstractAuthorizationEvent.class, AuthenticationCredentialsNotFoundEvent.class,
				AuthorizationFailureEvent.class, AuthorizedEvent.class, LoggerListener.class,
				PublicInvocationEvent.class);

		n.todo(AbstractSecurityExpressionHandler.class, DenyAllPermissionEvaluator.class, ExpressionUtils.class,
				SecurityExpressionHandler.class, SecurityExpressionOperations.class, SecurityExpressionRoot.class);

		n.todo(DefaultMethodSecurityExpressionHandler.class, ExpressionBasedAnnotationAttributeFactory.class,
				ExpressionBasedPostInvocationAdvice.class, ExpressionBasedPreInvocationAdvice.class,
				MethodSecurityExpressionHandler.class, MethodSecurityExpressionOperations.class);

		n.todo(CycleInRoleHierarchyException.class, NullRoleHierarchy.class, RoleHierarchy.class,
				RoleHierarchyAuthoritiesMapper.class, RoleHierarchyImpl.class, RoleHierarchyUtils.class);

		n.todo(AbstractSecurityInterceptor.class, AfterInvocationManager.class, AfterInvocationProviderManager.class,
				InterceptorStatusToken.class, MethodInvocationPrivilegeEvaluator.class,
				RunAsImplAuthenticationProvider.class, RunAsManager.class, RunAsManagerImpl.class,
				RunAsUserToken.class);

		n.todo(MethodSecurityInterceptor.class, MethodSecurityMetadataSourceAdvisor.class);

		n.todo(AspectJCallback.class, AspectJMethodSecurityInterceptor.class, MethodInvocationAdapter.class);

		n.todo(AbstractFallbackMethodSecurityMetadataSource.class, AbstractMethodSecurityMetadataSource.class,
				DelegatingMethodSecurityMetadataSource.class, MapBasedMethodSecurityMetadataSource.class,
				MethodSecurityMetadataSource.class, P.class);

		n.todo(PostAuthorize.class, PostFilter.class, PostInvocationAdviceProvider.class, PostInvocationAttribute.class,
				PostInvocationAuthorizationAdvice.class, PreAuthorize.class, PreFilter.class,
				PreInvocationAttribute.class, PreInvocationAuthorizationAdvice.class,
				PreInvocationAuthorizationAdviceVoter.class, PrePostAnnotationSecurityMetadataSource.class,
				PrePostInvocationAttributeFactory.class);

		n.todo(AbstractAccessDecisionManager.class, AbstractAclVoter.class, AffirmativeBased.class,
				AuthenticatedVoter.class, ConsensusBased.class, RoleHierarchyVoter.class, RoleVoter.class,
				UnanimousBased.class);

		n.todo(AbstractAuthenticationToken.class, AccountExpiredException.class, AccountStatusException.class,
				AccountStatusUserDetailsChecker.class, AnonymousAuthenticationProvider.class,
				AnonymousAuthenticationToken.class, AuthenticationCredentialsNotFoundException.class,
				AuthenticationDetailsSource.class, AuthenticationEventPublisher.class, AuthenticationManager.class,
				AuthenticationProvider.class, AuthenticationServiceException.class, AuthenticationTrustResolver.class,
				AuthenticationTrustResolverImpl.class, BadCredentialsException.class, CredentialsExpiredException.class,
				DefaultAuthenticationEventPublisher.class, DisabledException.class,
				InsufficientAuthenticationException.class, InternalAuthenticationServiceException.class,
				LockedException.class, ProviderManager.class, ProviderNotFoundException.class,
				RememberMeAuthenticationProvider.class, RememberMeAuthenticationToken.class,
				TestingAuthenticationProvider.class, TestingAuthenticationToken.class,
				UsernamePasswordAuthenticationToken.class);

		n.todo(AbstractUserDetailsAuthenticationProvider.class, DaoAuthenticationProvider.class,
				ReflectionSaltSource.class, SaltSource.class, SystemWideSaltSource.class);

		n.todo(BaseDigestPasswordEncoder.class, BasePasswordEncoder.class, LdapShaPasswordEncoder.class,
				Md4PasswordEncoder.class, Md5PasswordEncoder.class, MessageDigestPasswordEncoder.class,
				PasswordEncoder.class, PlaintextPasswordEncoder.class, ShaPasswordEncoder.class);

		n.todo(AbstractAuthenticationEvent.class, AbstractAuthenticationFailureEvent.class,
				AuthenticationFailureBadCredentialsEvent.class, AuthenticationFailureCredentialsExpiredEvent.class,
				AuthenticationFailureDisabledEvent.class, AuthenticationFailureExpiredEvent.class,
				AuthenticationFailureLockedEvent.class, AuthenticationFailureProviderNotFoundEvent.class,
				AuthenticationFailureProxyUntrustedEvent.class, AuthenticationFailureServiceExceptionEvent.class,
				AuthenticationSuccessEvent.class, InteractiveAuthenticationSuccessEvent.class,
				org.springframework.security.authentication.event.LoggerListener.class);

		n.todo(AbstractJaasAuthenticationProvider.class, AuthorityGranter.class,
				DefaultJaasAuthenticationProvider.class, DefaultLoginExceptionResolver.class,
				JaasAuthenticationCallbackHandler.class, JaasAuthenticationProvider.class,
				JaasAuthenticationToken.class, JaasGrantedAuthority.class, JaasNameCallbackHandler.class,
				JaasPasswordCallbackHandler.class, LoginExceptionResolver.class, SecurityContextLoginModule.class);

		n.todo(JaasAuthenticationEvent.class, JaasAuthenticationFailedEvent.class,
				JaasAuthenticationSuccessEvent.class);

		n.todo(InMemoryConfiguration.class);

		n.todo(RemoteAuthenticationException.class, RemoteAuthenticationManager.class,
				RemoteAuthenticationManagerImpl.class, RemoteAuthenticationProvider.class);

		n.todo(DelegatingSecurityContextCallable.class, DelegatingSecurityContextExecutor.class,
				DelegatingSecurityContextExecutorService.class, DelegatingSecurityContextRunnable.class,
				DelegatingSecurityContextScheduledExecutorService.class);

		n.todo(DelegatingApplicationListener.class);

		n.todo(Authentication.class, AuthenticationException.class, CredentialsContainer.class, GrantedAuthority.class,
				SpringSecurityCoreVersion.class, SpringSecurityMessageSource.class);

		n.todo(AuthenticationPrincipal.class);

		n.todo(AuthorityUtils.class, GrantedAuthoritiesContainer.class, SimpleGrantedAuthority.class);

		n.todo(Attributes2GrantedAuthoritiesMapper.class, GrantedAuthoritiesMapper.class,
				MapBasedAttributes2GrantedAuthoritiesMapper.class, MappableAttributesRetriever.class,
				NullAuthoritiesMapper.class, SimpleAttributes2GrantedAuthoritiesMapper.class,
				SimpleAuthorityMapper.class, SimpleMappableAttributesRetriever.class);

		n.todo(SecurityContext.class, SecurityContextHolder.class, SecurityContextHolderStrategy.class,
				SecurityContextImpl.class);

		n.todo(AnnotationParameterNameDiscoverer.class, DefaultSecurityParameterNameDiscoverer.class);

		n.todo(SessionCreationEvent.class, SessionDestroyedEvent.class, SessionInformation.class, SessionRegistry.class,
				SessionRegistryImpl.class);

		n.todo(DefaultToken.class, KeyBasedPersistenceTokenService.class, SecureRandomFactoryBean.class,
				Sha512DigestUtils.class, Token.class, TokenService.class);

		n.todo(AuthenticationUserDetailsService.class, User.class, UserCache.class, UserDetails.class,
				UserDetailsByNameServiceWrapper.class, UserDetailsChecker.class, UserDetailsService.class,
				UsernameNotFoundException.class);

		n.todo(EhCacheBasedUserCache.class, NullUserCache.class, SpringCacheBasedUserCache.class);

		n.todo(JdbcDaoImpl.class);

		n.todo(UserAttribute.class, UserAttributeEditor.class);

		n.todo(BCrypt.class, BCryptPasswordEncoder.class);

		n.todo(Base64.class, Hex.class, Utf8.class);

		n.todo(BouncyCastleAesCbcBytesEncryptor.class, BouncyCastleAesGcmBytesEncryptor.class, BytesEncryptor.class,
				Encryptors.class, TextEncryptor.class);

		n.todo(BytesKeyGenerator.class, KeyGenerators.class, StringKeyGenerator.class);

		n.todo(AbstractPasswordEncoder.class, NoOpPasswordEncoder.class, PasswordEncoder.class,
				Pbkdf2PasswordEncoder.class, StandardPasswordEncoder.class);

		n.todo(SCryptPasswordEncoder.class);

		n.todo(EncodingUtils.class);

		n.todo(CoreJackson2Module.class, SecurityJackson2Modules.class, SimpleGrantedAuthorityMixin.class);

		n.todo(GroupManager.class, InMemoryUserDetailsManager.class, JdbcUserDetailsManager.class,
				UserDetailsManager.class);

		n.todo(DelegatingSecurityContextSchedulingTaskExecutor.class);

		n.todo(DelegatingSecurityContextAsyncTaskExecutor.class, DelegatingSecurityContextTaskExecutor.class);

		n.todo(FieldUtils.class, InMemoryResource.class, MethodInvocationUtils.class, SimpleMethodInvocation.class);

	}

	public static void remoting(Notes n) {

		n.todo(DnsEntryNotFoundException.class, DnsLookupException.class, DnsResolver.class,
				InitialContextFactory.class, JndiDnsResolver.class);

		n.todo(AuthenticationSimpleHttpInvokerRequestExecutor.class);

		n.todo(ContextPropagatingRemoteInvocation.class, ContextPropagatingRemoteInvocationFactory.class);

	}

	public static void web(Notes n) {

		n.todo(AuthenticationEntryPoint.class, DefaultRedirectStrategy.class, DefaultSecurityFilterChain.class,
				FilterChainProxy.class, FilterInvocation.class, PortMapper.class, PortMapperImpl.class,
				PortResolver.class, PortResolverImpl.class, RedirectStrategy.class, SecurityFilterChain.class,
				WebAttributes.class);

		n.todo(AccessDeniedHandler.class, AccessDeniedHandlerImpl.class, DefaultWebInvocationPrivilegeEvaluator.class,
				DelegatingAccessDeniedHandler.class, ExceptionTranslationFilter.class,
				WebInvocationPrivilegeEvaluator.class);

		n.todo(AbstractRetryEntryPoint.class, ChannelDecisionManager.class, ChannelDecisionManagerImpl.class,
				ChannelEntryPoint.class, ChannelProcessingFilter.class, ChannelProcessor.class,
				InsecureChannelProcessor.class, RetryWithHttpEntryPoint.class, RetryWithHttpsEntryPoint.class,
				SecureChannelProcessor.class);

		n.todo(DefaultWebSecurityExpressionHandler.class, ExpressionBasedFilterInvocationSecurityMetadataSource.class,
				WebExpressionVoter.class, WebSecurityExpressionRoot.class);

		n.todo(DefaultFilterInvocationSecurityMetadataSource.class, FilterInvocationSecurityMetadataSource.class,
				FilterSecurityInterceptor.class, RequestKey.class);

		n.todo(AbstractAuthenticationProcessingFilter.class, AbstractAuthenticationTargetUrlRequestHandler.class,
				AnonymousAuthenticationFilter.class, AuthenticationFailureHandler.class,
				AuthenticationSuccessHandler.class, DelegatingAuthenticationEntryPoint.class,
				DelegatingAuthenticationFailureHandler.class, ExceptionMappingAuthenticationFailureHandler.class,
				ForwardAuthenticationFailureHandler.class, ForwardAuthenticationSuccessHandler.class,
				Http403ForbiddenEntryPoint.class, HttpStatusEntryPoint.class, LoginUrlAuthenticationEntryPoint.class,
				NullRememberMeServices.class, RememberMeServices.class,
				SavedRequestAwareAuthenticationSuccessHandler.class, SimpleUrlAuthenticationFailureHandler.class,
				SimpleUrlAuthenticationSuccessHandler.class, UsernamePasswordAuthenticationFilter.class,
				WebAuthenticationDetails.class, WebAuthenticationDetailsSource.class);

		n.todo(CompositeLogoutHandler.class, CookieClearingLogoutHandler.class, DelegatingLogoutSuccessHandler.class,
				HttpStatusReturningLogoutSuccessHandler.class, LogoutFilter.class, LogoutHandler.class,
				LogoutSuccessHandler.class, SecurityContextLogoutHandler.class, SimpleUrlLogoutSuccessHandler.class);

		n.todo(AbstractPreAuthenticatedProcessingFilter.class, PreAuthenticatedAuthenticationProvider.class,
				PreAuthenticatedAuthenticationToken.class, PreAuthenticatedCredentialsNotFoundException.class,
				PreAuthenticatedGrantedAuthoritiesUserDetailsService.class,
				PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails.class,
				RequestAttributeAuthenticationFilter.class, RequestHeaderAuthenticationFilter.class);

		n.todo(J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource.class,
				J2eePreAuthenticatedProcessingFilter.class, WebXmlMappableAttributesRetriever.class);

		n.todo(WebSpherePreAuthenticatedProcessingFilter.class,
				WebSpherePreAuthenticatedWebAuthenticationDetailsSource.class);

		n.todo(SubjectDnX509PrincipalExtractor.class, X509AuthenticationFilter.class, X509PrincipalExtractor.class);

		n.todo(AbstractRememberMeServices.class, CookieTheftException.class, InMemoryTokenRepositoryImpl.class,
				InvalidCookieException.class, JdbcTokenRepositoryImpl.class, PersistentRememberMeToken.class,
				PersistentTokenBasedRememberMeServices.class, PersistentTokenRepository.class,
				RememberMeAuthenticationException.class, RememberMeAuthenticationFilter.class,
				TokenBasedRememberMeServices.class);

		n.todo(ChangeSessionIdAuthenticationStrategy.class, CompositeSessionAuthenticationStrategy.class,
				ConcurrentSessionControlAuthenticationStrategy.class, NullAuthenticatedSessionStrategy.class,
				RegisterSessionAuthenticationStrategy.class, SessionAuthenticationException.class,
				SessionAuthenticationStrategy.class, SessionFixationProtectionEvent.class,
				SessionFixationProtectionStrategy.class);

		n.todo(AuthenticationSwitchUserEvent.class, SwitchUserAuthorityChanger.class, SwitchUserFilter.class,
				SwitchUserGrantedAuthority.class);

		n.todo(DefaultLoginPageGeneratingFilter.class);

		n.todo(BasicAuthenticationEntryPoint.class, BasicAuthenticationFilter.class,
				DigestAuthenticationEntryPoint.class, DigestAuthenticationFilter.class, NonceExpiredException.class);

		n.todo(AuthenticationPrincipal.class);

		n.todo(AuthenticationPrincipalArgumentResolver.class);

		n.todo(AbstractSecurityWebApplicationInitializer.class, HttpRequestResponseHolder.class,
				HttpSessionSecurityContextRepository.class, NullSecurityContextRepository.class,
				SaveContextOnUpdateOrErrorResponseWrapper.class, SecurityContextPersistenceFilter.class,
				SecurityContextRepository.class);

		n.todo(SecurityContextCallableProcessingInterceptor.class, WebAsyncManagerIntegrationFilter.class);

		n.todo(SecurityWebApplicationContextUtils.class);

		n.todo(CookieCsrfTokenRepository.class, CsrfAuthenticationStrategy.class, CsrfException.class, CsrfFilter.class,
				CsrfLogoutHandler.class, CsrfToken.class, CsrfTokenRepository.class, DefaultCsrfToken.class,
				HttpSessionCsrfTokenRepository.class, InvalidCsrfTokenException.class, LazyCsrfTokenRepository.class,
				MissingCsrfTokenException.class);

		n.todo(DebugFilter.class);

		n.todo(DefaultHttpFirewall.class, FirewalledRequest.class, HttpFirewall.class, RequestRejectedException.class);

		n.todo(Header.class, HeaderWriter.class, HeaderWriterFilter.class);

		n.todo(CacheControlHeadersWriter.class, ContentSecurityPolicyHeaderWriter.class,
				DelegatingRequestMatcherHeaderWriter.class, HpkpHeaderWriter.class, HstsHeaderWriter.class,
				ReferrerPolicyHeaderWriter.class, StaticHeadersWriter.class, XContentTypeOptionsHeaderWriter.class,
				XXssProtectionHeaderWriter.class);

		n.todo(AllowFromStrategy.class, RegExpAllowFromStrategy.class, StaticAllowFromStrategy.class,
				WhiteListedAllowFromStrategy.class, XFrameOptionsHeaderWriter.class);

		n.todo(JaasApiIntegrationFilter.class);

		n.todo(WebJackson2Module.class);

		n.todo(AuthenticationPrincipalArgumentResolver.class, CsrfTokenArgumentResolver.class);

		n.todo(DefaultSavedRequest.class, Enumerator.class, FastHttpDateFormat.class, HttpSessionRequestCache.class,
				NullRequestCache.class, RequestCache.class, RequestCacheAwareFilter.class, SavedCookie.class,
				SavedRequest.class);

		n.todo(CsrfRequestDataValueProcessor.class);

		n.todo(MvcRequestMatcher.class);

		n.todo(SecurityContextHolderAwareRequestFilter.class, SecurityContextHolderAwareRequestWrapper.class);

		n.todo(ConcurrentSessionFilter.class, HttpSessionCreatedEvent.class, HttpSessionDestroyedEvent.class,
				HttpSessionEventPublisher.class, InvalidSessionAccessDeniedHandler.class, InvalidSessionStrategy.class,
				SessionInformationExpiredEvent.class, SessionInformationExpiredStrategy.class,
				SessionManagementFilter.class, SimpleRedirectInvalidSessionStrategy.class,
				SimpleRedirectSessionInformationExpiredStrategy.class);

		n.todo(OnCommittedResponseWrapper.class, RedirectUrlBuilder.class, TextEscapeUtils.class,
				ThrowableAnalyzer.class, ThrowableCauseExtractor.class, UrlUtils.class);

		n.todo(AndRequestMatcher.class, AntPathRequestMatcher.class, AnyRequestMatcher.class, ELRequestMatcher.class,
				IpAddressMatcher.class, MediaTypeRequestMatcher.class, NegatedRequestMatcher.class,
				OrRequestMatcher.class, RegexRequestMatcher.class, RequestHeaderRequestMatcher.class,
				RequestMatcher.class, RequestMatcherEditor.class, RequestVariablesExtractor.class);

	}

	public static void ldap(Notes n) {

		n.todo(DefaultLdapUsernameToDnMapper.class, DefaultSpringSecurityContextSource.class,
				LdapUsernameToDnMapper.class, LdapUtils.class, SpringSecurityLdapTemplate.class);

		n.todo(AbstractLdapAuthenticationProvider.class, AbstractLdapAuthenticator.class, BindAuthenticator.class,
				LdapAuthenticationProvider.class, LdapAuthenticator.class, NullLdapAuthoritiesPopulator.class,
				PasswordComparisonAuthenticator.class, SpringSecurityAuthenticationSource.class,
				UserDetailsServiceLdapAuthoritiesPopulator.class);

		n.todo(ActiveDirectoryAuthenticationException.class, ActiveDirectoryLdapAuthenticationProvider.class);

		n.todo(PasswordPolicyAwareContextSource.class, PasswordPolicyControl.class,
				PasswordPolicyControlExtractor.class, PasswordPolicyControlFactory.class, PasswordPolicyData.class,
				PasswordPolicyErrorStatus.class, PasswordPolicyException.class, PasswordPolicyResponseControl.class);

		n.todo(FilterBasedLdapUserSearch.class, LdapUserSearch.class);

		n.todo(ApacheDSContainer.class);

		n.todo(DefaultLdapAuthoritiesPopulator.class, InetOrgPerson.class, InetOrgPersonContextMapper.class,
				LdapAuthoritiesPopulator.class, LdapAuthority.class, LdapUserDetails.class, LdapUserDetailsImpl.class,
				LdapUserDetailsManager.class, LdapUserDetailsMapper.class, LdapUserDetailsService.class,
				NestedLdapAuthoritiesPopulator.class, Person.class, PersonContextMapper.class,
				UserDetailsContextMapper.class);

	}

	public static void config(Notes n) {

		n.todo(BeanIds.class, DebugBeanDefinitionParser.class, Elements.class, SecurityNamespaceHandler.class);

		n.todo(AbstractConfiguredSecurityBuilder.class, AbstractSecurityBuilder.class, AlreadyBuiltException.class,
				ObjectPostProcessor.class, SecurityBuilder.class, SecurityConfigurer.class,
				SecurityConfigurerAdapter.class);

		n.todo(ProviderManagerBuilder.class);

		n.todo(AuthenticationManagerBuilder.class);

		n.todo(AuthenticationConfiguration.class, EnableGlobalAuthentication.class);

		n.todo(GlobalAuthenticationConfigurerAdapter.class);

		n.todo(LdapAuthenticationProviderConfigurer.class);

		n.todo(InMemoryUserDetailsManagerConfigurer.class, JdbcUserDetailsManagerConfigurer.class,
				UserDetailsManagerConfigurer.class);

		n.todo(DaoAuthenticationConfigurer.class, UserDetailsAwareConfigurer.class, UserDetailsServiceConfigurer.class);

		n.todo(ObjectPostProcessorConfiguration.class);

		n.todo(EnableGlobalMethodSecurity.class, GlobalMethodSecurityConfiguration.class);

		n.todo(AbstractRequestMatcherRegistry.class, HttpSecurityBuilder.class, WebSecurityConfigurer.class);

		n.todo(HttpSecurity.class, WebSecurity.class);

		n.todo(EnableWebSecurity.class, WebSecurityConfiguration.class, WebSecurityConfigurerAdapter.class);

		n.todo(AbstractAuthenticationFilterConfigurer.class, AbstractConfigAttributeRequestMatcherRegistry.class,
				AbstractHttpConfigurer.class, AnonymousConfigurer.class, ChannelSecurityConfigurer.class,
				CorsConfigurer.class, CsrfConfigurer.class, DefaultLoginPageConfigurer.class,
				ExceptionHandlingConfigurer.class, ExpressionUrlAuthorizationConfigurer.class,
				FormLoginConfigurer.class, HeadersConfigurer.class, HttpBasicConfigurer.class, JeeConfigurer.class,
				LogoutConfigurer.class, PortMapperConfigurer.class, RememberMeConfigurer.class,
				RequestCacheConfigurer.class, SecurityContextConfigurer.class, ServletApiConfigurer.class,
				SessionManagementConfigurer.class, UrlAuthorizationConfigurer.class, X509Configurer.class);

		n.todo(OpenIDLoginConfigurer.class);

		n.todo(MessageSecurityMetadataSourceRegistry.class);

		n.todo(EnableWebMvcSecurity.class, WebMvcSecurityConfiguration.class);

		n.todo(AbstractSecurityWebSocketMessageBrokerConfigurer.class);

		n.todo(AbstractUserDetailsServiceBeanDefinitionParser.class, AuthenticationManagerBeanDefinitionParser.class,
				AuthenticationManagerFactoryBean.class, AuthenticationProviderBeanDefinitionParser.class,
				CachingUserDetailsService.class, JdbcUserServiceBeanDefinitionParser.class, PasswordEncoderParser.class,
				UserServiceBeanDefinitionParser.class);

		n.todo(GrantedAuthorityDefaults.class);

		n.todo(SecurityDebugBeanFactoryPostProcessor.class);

		n.todo(ChannelAttributeFactory.class, CorsBeanDefinitionParser.class, CsrfBeanDefinitionParser.class,
				DefaultFilterChainValidator.class, FilterChainBeanDefinitionParser.class,
				FilterChainMapBeanDefinitionDecorator.class, FilterInvocationSecurityMetadataSourceParser.class,
				FormLoginBeanDefinitionParser.class, HeadersBeanDefinitionParser.class,
				HttpFirewallBeanDefinitionParser.class, HttpSecurityBeanDefinitionParser.class, MatcherType.class,
				SessionCreationPolicy.class, UserDetailsServiceFactoryBean.class);

		n.todo(LdapProviderBeanDefinitionParser.class, LdapServerBeanDefinitionParser.class,
				LdapUserServiceBeanDefinitionParser.class);

		n.todo(GlobalMethodSecurityBeanDefinitionParser.class, InterceptMethodsBeanDefinitionDecorator.class,
				MethodSecurityMetadataSourceBeanDefinitionParser.class);

		n.todo(WebSocketMessageBrokerSecurityBeanDefinitionParser.class);

	}

	public static void acl(Notes n) {

		n.todo(AclEntryVoter.class, AclPermissionCacheOptimizer.class, AclPermissionEvaluator.class);

		n.todo(AbstractAclProvider.class, AclEntryAfterInvocationCollectionFilteringProvider.class,
				AclEntryAfterInvocationProvider.class);

		n.todo(AbstractPermission.class, AccessControlEntryImpl.class, AclAuthorizationStrategy.class,
				AclAuthorizationStrategyImpl.class, AclFormattingUtils.class, AclImpl.class, AuditLogger.class,
				BasePermission.class, ConsoleAuditLogger.class, CumulativePermission.class,
				DefaultPermissionFactory.class, DefaultPermissionGrantingStrategy.class, EhCacheBasedAclCache.class,
				GrantedAuthoritySid.class, IdentityUnavailableException.class, ObjectIdentityImpl.class,
				ObjectIdentityRetrievalStrategyImpl.class, PermissionFactory.class, PrincipalSid.class,
				SidRetrievalStrategyImpl.class, SpringCacheBasedAclCache.class);

		n.todo(BasicLookupStrategy.class, JdbcAclService.class, JdbcMutableAclService.class, LookupStrategy.class);

		n.todo(AccessControlEntry.class, Acl.class, AclCache.class, AclDataAccessException.class, AclService.class,
				AlreadyExistsException.class, AuditableAccessControlEntry.class, AuditableAcl.class,
				ChildrenExistException.class, MutableAcl.class, MutableAclService.class, NotFoundException.class,
				ObjectIdentity.class, ObjectIdentityGenerator.class, ObjectIdentityRetrievalStrategy.class,
				OwnershipAcl.class, Permission.class, PermissionGrantingStrategy.class, Sid.class,
				SidRetrievalStrategy.class, UnloadedSidException.class);
	}

	public static void cas(Notes n) {

		n.todo(SamlServiceProperties.class, ServiceProperties.class);

		n.todo(CasAssertionAuthenticationToken.class, CasAuthenticationProvider.class, CasAuthenticationToken.class,
				EhCacheBasedTicketCache.class, NullStatelessTicketCache.class, SpringCacheBasedTicketCache.class,
				StatelessTicketCache.class);

		n.todo(CasJackson2Module.class);

		n.todo(AbstractCasAssertionUserDetailsService.class,
				GrantedAuthorityFromAssertionAttributesUserDetailsService.class);

		n.todo(CasAuthenticationEntryPoint.class, CasAuthenticationFilter.class);

		n.todo(ServiceAuthenticationDetails.class, ServiceAuthenticationDetailsSource.class);

	}

	public static void openid(Notes n) {

		n.todo(AuthenticationCancelledException.class, AxFetchListFactory.class, NullAxFetchListFactory.class,
				OpenID4JavaConsumer.class, OpenIDAttribute.class, OpenIDAuthenticationFilter.class,
				OpenIDAuthenticationProvider.class, OpenIDAuthenticationStatus.class, OpenIDAuthenticationToken.class,
				OpenIDConsumer.class, OpenIDConsumerException.class, RegexBasedAxFetchListFactory.class);

	}

	public static void taglibs(Notes n) {

		n.todo(TagLibConfig.class);

		n.todo(AbstractAuthorizeTag.class, AccessControlListTag.class, AuthenticationTag.class, JspAuthorizeTag.class);

		n.todo(CsrfInputTag.class, CsrfMetaTagsTag.class);

	}

	public static void test(Notes n) {

		n.todo(TestSecurityContextHolder.class);

		n.todo(SecurityTestExecutionListeners.class);

		n.todo(WithAnonymousUser.class, WithMockUser.class, WithSecurityContext.class, WithSecurityContextFactory.class,
				WithSecurityContextTestExecutionListener.class, WithUserDetails.class);

		n.todo(SecurityMockMvcRequestBuilders.class, SecurityMockMvcRequestPostProcessors.class);

		n.todo(SecurityMockMvcResultMatchers.class);

		n.todo(SecurityMockMvcConfigurers.class);

		n.todo(WebTestUtils.class);

	}

}
