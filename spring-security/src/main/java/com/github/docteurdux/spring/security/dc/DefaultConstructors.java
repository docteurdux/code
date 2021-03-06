package com.github.docteurdux.spring.security.dc;

import java.time.Clock;

import org.springframework.security.access.annotation.Jsr250Voter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.access.expression.DenyAllPermissionEvaluator;

import com.github.docteurdux.spring.security.notes.N;

public class DefaultConstructors {

	public static void main(String[] args) throws Exception {

		// https://en.wikipedia.org/wiki/List_of_computer_scientists

		WilVanDerAlst.main(null);
		ScottAaronson.main(null);
		HalAbelson.main(null);
		SergeAbiteboul.main(null);
		SamsonAbramsky.main(null);
		LeonardAdleman.main(null);
		
		Clock clock = Clock.systemUTC();
		if (clock.millis() < 0) {
			return;
		}

		
		org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice x210 = new org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice();
		org.springframework.security.access.hierarchicalroles.NullRoleHierarchy x209 = new org.springframework.security.access.hierarchicalroles.NullRoleHierarchy();
		org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl x208 = new org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl();
		org.springframework.security.access.intercept.AfterInvocationProviderManager x207 = new org.springframework.security.access.intercept.AfterInvocationProviderManager();
		org.springframework.security.access.intercept.MethodInvocationPrivilegeEvaluator x206 = new org.springframework.security.access.intercept.MethodInvocationPrivilegeEvaluator();
		org.springframework.security.access.intercept.RunAsImplAuthenticationProvider x205 = new org.springframework.security.access.intercept.RunAsImplAuthenticationProvider();
		org.springframework.security.access.intercept.RunAsManagerImpl x204 = new org.springframework.security.access.intercept.RunAsManagerImpl();
		org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor x203 = new org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor();
		org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor x202 = new org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor();
		org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource x201 = new org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource();
		org.springframework.security.access.vote.AuthenticatedVoter x200 = new org.springframework.security.access.vote.AuthenticatedVoter();
		org.springframework.security.access.vote.RoleVoter x199 = new org.springframework.security.access.vote.RoleVoter();
		org.springframework.security.acls.domain.ConsoleAuditLogger x198 = new org.springframework.security.acls.domain.ConsoleAuditLogger();
		org.springframework.security.acls.domain.CumulativePermission x197 = new org.springframework.security.acls.domain.CumulativePermission();
		org.springframework.security.acls.domain.DefaultPermissionFactory x196 = new org.springframework.security.acls.domain.DefaultPermissionFactory();
		org.springframework.security.acls.domain.ObjectIdentityRetrievalStrategyImpl x195 = new org.springframework.security.acls.domain.ObjectIdentityRetrievalStrategyImpl();
		org.springframework.security.acls.domain.SidRetrievalStrategyImpl x194 = new org.springframework.security.acls.domain.SidRetrievalStrategyImpl();
		org.springframework.security.authentication.AccountStatusUserDetailsChecker x193 = new org.springframework.security.authentication.AccountStatusUserDetailsChecker();
		org.springframework.security.authentication.AuthenticationTrustResolverImpl x192 = new org.springframework.security.authentication.AuthenticationTrustResolverImpl();
		org.springframework.security.authentication.DefaultAuthenticationEventPublisher x191 = new org.springframework.security.authentication.DefaultAuthenticationEventPublisher();
		org.springframework.security.authentication.TestingAuthenticationProvider x190 = new org.springframework.security.authentication.TestingAuthenticationProvider();
		org.springframework.security.authentication.dao.DaoAuthenticationProvider x189 = new org.springframework.security.authentication.dao.DaoAuthenticationProvider();
		org.springframework.security.authentication.dao.ReflectionSaltSource x188 = new org.springframework.security.authentication.dao.ReflectionSaltSource();
		org.springframework.security.authentication.dao.SystemWideSaltSource x187 = new org.springframework.security.authentication.dao.SystemWideSaltSource();
		org.springframework.security.authentication.encoding.LdapShaPasswordEncoder x186 = new org.springframework.security.authentication.encoding.LdapShaPasswordEncoder();
		org.springframework.security.authentication.encoding.Md4PasswordEncoder x185 = new org.springframework.security.authentication.encoding.Md4PasswordEncoder();
		org.springframework.security.authentication.encoding.Md5PasswordEncoder x184 = new org.springframework.security.authentication.encoding.Md5PasswordEncoder();
		org.springframework.security.authentication.encoding.PlaintextPasswordEncoder x183 = new org.springframework.security.authentication.encoding.PlaintextPasswordEncoder();
		org.springframework.security.authentication.encoding.ShaPasswordEncoder x182 = new org.springframework.security.authentication.encoding.ShaPasswordEncoder();
		org.springframework.security.authentication.event.LoggerListener x181 = new org.springframework.security.authentication.event.LoggerListener();
		org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider x180 = new org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider();
		org.springframework.security.authentication.jaas.DefaultLoginExceptionResolver x179 = new org.springframework.security.authentication.jaas.DefaultLoginExceptionResolver();
		org.springframework.security.authentication.jaas.JaasAuthenticationProvider x178 = new org.springframework.security.authentication.jaas.JaasAuthenticationProvider();
		org.springframework.security.authentication.jaas.JaasNameCallbackHandler x177 = new org.springframework.security.authentication.jaas.JaasNameCallbackHandler();
		org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler x176 = new org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler();
		org.springframework.security.authentication.jaas.SecurityContextLoginModule x175 = new org.springframework.security.authentication.jaas.SecurityContextLoginModule();
		org.springframework.security.authentication.rcp.RemoteAuthenticationManagerImpl x174 = new org.springframework.security.authentication.rcp.RemoteAuthenticationManagerImpl();
		org.springframework.security.authentication.rcp.RemoteAuthenticationProvider x173 = new org.springframework.security.authentication.rcp.RemoteAuthenticationProvider();
		org.springframework.security.cas.SamlServiceProperties x172 = new org.springframework.security.cas.SamlServiceProperties();
		org.springframework.security.cas.ServiceProperties x171 = new org.springframework.security.cas.ServiceProperties();
		org.springframework.security.cas.authentication.CasAuthenticationProvider x170 = new org.springframework.security.cas.authentication.CasAuthenticationProvider();
		org.springframework.security.cas.authentication.EhCacheBasedTicketCache x169 = new org.springframework.security.cas.authentication.EhCacheBasedTicketCache();
		org.springframework.security.cas.authentication.NullStatelessTicketCache x168 = new org.springframework.security.cas.authentication.NullStatelessTicketCache();
		org.springframework.security.cas.jackson2.CasJackson2Module x167 = new org.springframework.security.cas.jackson2.CasJackson2Module();
		org.springframework.security.cas.web.CasAuthenticationEntryPoint x166 = new org.springframework.security.cas.web.CasAuthenticationEntryPoint();
		org.springframework.security.cas.web.CasAuthenticationFilter x165 = new org.springframework.security.cas.web.CasAuthenticationFilter();
		org.springframework.security.config.DebugBeanDefinitionParser x164 = new org.springframework.security.config.DebugBeanDefinitionParser();
		org.springframework.security.config.SecurityNamespaceHandler x163 = new org.springframework.security.config.SecurityNamespaceHandler();
		org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer x162 = new org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer();
		org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer x161 = new org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer();
		org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer x160 = new org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer();
		org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration x159 = new org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration();
		org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration x158 = new org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration();
		org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer x157 = new org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer();
		org.springframework.security.config.annotation.web.configurers.CorsConfigurer x156 = new org.springframework.security.config.annotation.web.configurers.CorsConfigurer();
		org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer x155 = new org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer();
		org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer x154 = new org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer();
		org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer x153 = new org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer();
		org.springframework.security.config.annotation.web.configurers.HeadersConfigurer x152 = new org.springframework.security.config.annotation.web.configurers.HeadersConfigurer();
		org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer x151 = new org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer();
		org.springframework.security.config.annotation.web.configurers.JeeConfigurer x150 = new org.springframework.security.config.annotation.web.configurers.JeeConfigurer();
		org.springframework.security.config.annotation.web.configurers.LogoutConfigurer x149 = new org.springframework.security.config.annotation.web.configurers.LogoutConfigurer();
		org.springframework.security.config.annotation.web.configurers.PortMapperConfigurer x148 = new org.springframework.security.config.annotation.web.configurers.PortMapperConfigurer();
		org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer x147 = new org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer();
		org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer x146 = new org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer();
		org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer x145 = new org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer();
		org.springframework.security.config.annotation.web.configurers.ServletApiConfigurer x144 = new org.springframework.security.config.annotation.web.configurers.ServletApiConfigurer();
		org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer x143 = new org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer();
		org.springframework.security.config.annotation.web.configurers.X509Configurer x142 = new org.springframework.security.config.annotation.web.configurers.X509Configurer();
		org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer x141 = new org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer();
		org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry x140 = new org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry();
		org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration x139 = new org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration();
		org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser x138 = new org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser();
		org.springframework.security.config.authentication.AuthenticationManagerFactoryBean x137 = new org.springframework.security.config.authentication.AuthenticationManagerFactoryBean();
		org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser x136 = new org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser();
		org.springframework.security.config.authentication.JdbcUserServiceBeanDefinitionParser x135 = new org.springframework.security.config.authentication.JdbcUserServiceBeanDefinitionParser();
		org.springframework.security.config.authentication.UserServiceBeanDefinitionParser x134 = new org.springframework.security.config.authentication.UserServiceBeanDefinitionParser();
		org.springframework.security.config.debug.SecurityDebugBeanFactoryPostProcessor x133 = new org.springframework.security.config.debug.SecurityDebugBeanFactoryPostProcessor();
		org.springframework.security.config.http.CorsBeanDefinitionParser x132 = new org.springframework.security.config.http.CorsBeanDefinitionParser();
		org.springframework.security.config.http.CsrfBeanDefinitionParser x131 = new org.springframework.security.config.http.CsrfBeanDefinitionParser();
		org.springframework.security.config.http.DefaultFilterChainValidator x130 = new org.springframework.security.config.http.DefaultFilterChainValidator();
		org.springframework.security.config.http.FilterChainBeanDefinitionParser x129 = new org.springframework.security.config.http.FilterChainBeanDefinitionParser();
		org.springframework.security.config.http.FilterChainMapBeanDefinitionDecorator x128 = new org.springframework.security.config.http.FilterChainMapBeanDefinitionDecorator();
		org.springframework.security.config.http.FilterInvocationSecurityMetadataSourceParser x127 = new org.springframework.security.config.http.FilterInvocationSecurityMetadataSourceParser();
		org.springframework.security.config.http.HeadersBeanDefinitionParser x126 = new org.springframework.security.config.http.HeadersBeanDefinitionParser();
		org.springframework.security.config.http.HttpFirewallBeanDefinitionParser x125 = new org.springframework.security.config.http.HttpFirewallBeanDefinitionParser();
		org.springframework.security.config.http.HttpSecurityBeanDefinitionParser x124 = new org.springframework.security.config.http.HttpSecurityBeanDefinitionParser();
		org.springframework.security.config.http.UserDetailsServiceFactoryBean x123 = new org.springframework.security.config.http.UserDetailsServiceFactoryBean();
		org.springframework.security.config.ldap.LdapProviderBeanDefinitionParser x122 = new org.springframework.security.config.ldap.LdapProviderBeanDefinitionParser();
		org.springframework.security.config.ldap.LdapServerBeanDefinitionParser x121 = new org.springframework.security.config.ldap.LdapServerBeanDefinitionParser();
		org.springframework.security.config.ldap.LdapUserServiceBeanDefinitionParser x120 = new org.springframework.security.config.ldap.LdapUserServiceBeanDefinitionParser();
		org.springframework.security.config.method.GlobalMethodSecurityBeanDefinitionParser x119 = new org.springframework.security.config.method.GlobalMethodSecurityBeanDefinitionParser();
		org.springframework.security.config.method.InterceptMethodsBeanDefinitionDecorator x118 = new org.springframework.security.config.method.InterceptMethodsBeanDefinitionDecorator();
		org.springframework.security.config.method.MethodSecurityMetadataSourceBeanDefinitionParser x117 = new org.springframework.security.config.method.MethodSecurityMetadataSourceBeanDefinitionParser();
		org.springframework.security.config.websocket.WebSocketMessageBrokerSecurityBeanDefinitionParser x116 = new org.springframework.security.config.websocket.WebSocketMessageBrokerSecurityBeanDefinitionParser();
		org.springframework.security.context.DelegatingApplicationListener x115 = new org.springframework.security.context.DelegatingApplicationListener();
		org.springframework.security.core.authority.mapping.MapBasedAttributes2GrantedAuthoritiesMapper x114 = new org.springframework.security.core.authority.mapping.MapBasedAttributes2GrantedAuthoritiesMapper();
		org.springframework.security.core.authority.mapping.NullAuthoritiesMapper x113 = new org.springframework.security.core.authority.mapping.NullAuthoritiesMapper();
		org.springframework.security.core.authority.mapping.SimpleAttributes2GrantedAuthoritiesMapper x112 = new org.springframework.security.core.authority.mapping.SimpleAttributes2GrantedAuthoritiesMapper();
		org.springframework.security.core.authority.mapping.SimpleAuthorityMapper x111 = new org.springframework.security.core.authority.mapping.SimpleAuthorityMapper();
		org.springframework.security.core.authority.mapping.SimpleMappableAttributesRetriever x110 = new org.springframework.security.core.authority.mapping.SimpleMappableAttributesRetriever();
		org.springframework.security.core.context.SecurityContextImpl x109 = new org.springframework.security.core.context.SecurityContextImpl();
		org.springframework.security.core.parameters.DefaultSecurityParameterNameDiscoverer x108 = new org.springframework.security.core.parameters.DefaultSecurityParameterNameDiscoverer();
		org.springframework.security.core.session.SessionRegistryImpl x107 = new org.springframework.security.core.session.SessionRegistryImpl();
		org.springframework.security.core.token.KeyBasedPersistenceTokenService x106 = new org.springframework.security.core.token.KeyBasedPersistenceTokenService();
		org.springframework.security.core.token.SecureRandomFactoryBean x105 = new org.springframework.security.core.token.SecureRandomFactoryBean();
		org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper x104 = new org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper();
		org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache x103 = new org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache();
		org.springframework.security.core.userdetails.cache.NullUserCache x102 = new org.springframework.security.core.userdetails.cache.NullUserCache();
		org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl x101 = new org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl();
		org.springframework.security.core.userdetails.memory.UserAttribute x100 = new org.springframework.security.core.userdetails.memory.UserAttribute();
		org.springframework.security.core.userdetails.memory.UserAttributeEditor x99 = new org.springframework.security.core.userdetails.memory.UserAttributeEditor();
		org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder x98 = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		org.springframework.security.crypto.password.Pbkdf2PasswordEncoder x97 = new org.springframework.security.crypto.password.Pbkdf2PasswordEncoder();
		org.springframework.security.crypto.password.StandardPasswordEncoder x96 = new org.springframework.security.crypto.password.StandardPasswordEncoder();
		org.springframework.security.crypto.scrypt.SCryptPasswordEncoder x95 = new org.springframework.security.crypto.scrypt.SCryptPasswordEncoder();
		org.springframework.security.jackson2.CoreJackson2Module x94 = new org.springframework.security.jackson2.CoreJackson2Module();
		org.springframework.security.ldap.authentication.NullLdapAuthoritiesPopulator x93 = new org.springframework.security.ldap.authentication.NullLdapAuthoritiesPopulator();
		org.springframework.security.ldap.authentication.SpringSecurityAuthenticationSource x92 = new org.springframework.security.ldap.authentication.SpringSecurityAuthenticationSource();
		org.springframework.security.ldap.ppolicy.PasswordPolicyControl x91 = new org.springframework.security.ldap.ppolicy.PasswordPolicyControl();
		org.springframework.security.ldap.userdetails.InetOrgPerson x90 = new org.springframework.security.ldap.userdetails.InetOrgPerson();
		org.springframework.security.ldap.userdetails.InetOrgPersonContextMapper x89 = new org.springframework.security.ldap.userdetails.InetOrgPersonContextMapper();
		org.springframework.security.ldap.userdetails.LdapUserDetailsMapper x88 = new org.springframework.security.ldap.userdetails.LdapUserDetailsMapper();
		org.springframework.security.ldap.userdetails.PersonContextMapper x87 = new org.springframework.security.ldap.userdetails.PersonContextMapper();
		org.springframework.security.openid.NullAxFetchListFactory x86 = new org.springframework.security.openid.NullAxFetchListFactory();
		org.springframework.security.openid.OpenID4JavaConsumer x85 = new org.springframework.security.openid.OpenID4JavaConsumer();
		org.springframework.security.openid.OpenIDAuthenticationFilter x84 = new org.springframework.security.openid.OpenIDAuthenticationFilter();
		org.springframework.security.openid.OpenIDAuthenticationProvider x83 = new org.springframework.security.openid.OpenIDAuthenticationProvider();
		org.springframework.security.provisioning.InMemoryUserDetailsManager x82 = new org.springframework.security.provisioning.InMemoryUserDetailsManager();
		org.springframework.security.provisioning.JdbcUserDetailsManager x81 = new org.springframework.security.provisioning.JdbcUserDetailsManager();
		org.springframework.security.remoting.dns.JndiDnsResolver x80 = new org.springframework.security.remoting.dns.JndiDnsResolver();
		org.springframework.security.remoting.httpinvoker.AuthenticationSimpleHttpInvokerRequestExecutor x79 = new org.springframework.security.remoting.httpinvoker.AuthenticationSimpleHttpInvokerRequestExecutor();
		org.springframework.security.remoting.rmi.ContextPropagatingRemoteInvocationFactory x78 = new org.springframework.security.remoting.rmi.ContextPropagatingRemoteInvocationFactory();
		org.springframework.security.taglibs.authz.JspAuthorizeTag x77 = new org.springframework.security.taglibs.authz.JspAuthorizeTag();
		org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener x76 = new org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener();
		org.springframework.security.util.SimpleMethodInvocation x75 = new org.springframework.security.util.SimpleMethodInvocation();
		org.springframework.security.web.DefaultRedirectStrategy x74 = new org.springframework.security.web.DefaultRedirectStrategy();
		org.springframework.security.web.FilterChainProxy x73 = new org.springframework.security.web.FilterChainProxy();
		org.springframework.security.web.PortMapperImpl x72 = new org.springframework.security.web.PortMapperImpl();
		org.springframework.security.web.PortResolverImpl x71 = new org.springframework.security.web.PortResolverImpl();
		org.springframework.security.web.WebAttributes x70 = new org.springframework.security.web.WebAttributes();
		org.springframework.security.web.access.AccessDeniedHandlerImpl x69 = new org.springframework.security.web.access.AccessDeniedHandlerImpl();
		org.springframework.security.web.access.channel.ChannelDecisionManagerImpl x68 = new org.springframework.security.web.access.channel.ChannelDecisionManagerImpl();
		org.springframework.security.web.access.channel.ChannelProcessingFilter x67 = new org.springframework.security.web.access.channel.ChannelProcessingFilter();
		org.springframework.security.web.access.channel.InsecureChannelProcessor x66 = new org.springframework.security.web.access.channel.InsecureChannelProcessor();
		org.springframework.security.web.access.channel.RetryWithHttpEntryPoint x65 = new org.springframework.security.web.access.channel.RetryWithHttpEntryPoint();
		org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint x64 = new org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint();
		org.springframework.security.web.access.channel.SecureChannelProcessor x63 = new org.springframework.security.web.access.channel.SecureChannelProcessor();
		org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler x62 = new org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler();
		org.springframework.security.web.access.expression.WebExpressionVoter x61 = new org.springframework.security.web.access.expression.WebExpressionVoter();
		org.springframework.security.web.access.intercept.FilterSecurityInterceptor x60 = new org.springframework.security.web.access.intercept.FilterSecurityInterceptor();
		org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler x59 = new org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler();
		org.springframework.security.web.authentication.Http403ForbiddenEntryPoint x58 = new org.springframework.security.web.authentication.Http403ForbiddenEntryPoint();
		org.springframework.security.web.authentication.NullRememberMeServices x57 = new org.springframework.security.web.authentication.NullRememberMeServices();
		org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler x56 = new org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler();
		org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler x55 = new org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler();
		org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler x54 = new org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler();
		org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter x53 = new org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter();
		org.springframework.security.web.authentication.WebAuthenticationDetailsSource x52 = new org.springframework.security.web.authentication.WebAuthenticationDetailsSource();
		org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler x51 = new org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler();
		org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler x50 = new org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler();
		org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler x49 = new org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler();
		org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider x48 = new org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider();
		org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService x47 = new org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService();
		org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter x46 = new org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter();
		org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter x45 = new org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter();
		org.springframework.security.web.authentication.preauth.j2ee.J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource x44 = new org.springframework.security.web.authentication.preauth.j2ee.J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource();
		org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter x43 = new org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter();
		org.springframework.security.web.authentication.preauth.j2ee.WebXmlMappableAttributesRetriever x42 = new org.springframework.security.web.authentication.preauth.j2ee.WebXmlMappableAttributesRetriever();
		org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedProcessingFilter x41 = new org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedProcessingFilter();
		org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedWebAuthenticationDetailsSource x40 = new org.springframework.security.web.authentication.preauth.websphere.WebSpherePreAuthenticatedWebAuthenticationDetailsSource();
		org.springframework.security.web.authentication.preauth.x509.SubjectDnX509PrincipalExtractor x39 = new org.springframework.security.web.authentication.preauth.x509.SubjectDnX509PrincipalExtractor();
		org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter x38 = new org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter();
		org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl x37 = new org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl();
		org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl x36 = new org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl();
		org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy x35 = new org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy();
		org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy x34 = new org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy();
		org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy x33 = new org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy();
		org.springframework.security.web.authentication.switchuser.SwitchUserFilter x32 = new org.springframework.security.web.authentication.switchuser.SwitchUserFilter();
		org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter x31 = new org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter();
		org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint x30 = new org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint();
		org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint x29 = new org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint();
		org.springframework.security.web.authentication.www.DigestAuthenticationFilter x28 = new org.springframework.security.web.authentication.www.DigestAuthenticationFilter();
		org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver x27 = new org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver();
		org.springframework.security.web.context.HttpSessionSecurityContextRepository x26 = new org.springframework.security.web.context.HttpSessionSecurityContextRepository();
		org.springframework.security.web.context.NullSecurityContextRepository x25 = new org.springframework.security.web.context.NullSecurityContextRepository();
		org.springframework.security.web.context.SecurityContextPersistenceFilter x24 = new org.springframework.security.web.context.SecurityContextPersistenceFilter();
		org.springframework.security.web.context.request.async.SecurityContextCallableProcessingInterceptor x23 = new org.springframework.security.web.context.request.async.SecurityContextCallableProcessingInterceptor();
		org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter x22 = new org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter();
		org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository x21 = new org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository();
		org.springframework.security.web.firewall.DefaultHttpFirewall x20 = new org.springframework.security.web.firewall.DefaultHttpFirewall();
		org.springframework.security.web.header.writers.CacheControlHeadersWriter x19 = new org.springframework.security.web.header.writers.CacheControlHeadersWriter();
		org.springframework.security.web.header.writers.HpkpHeaderWriter x18 = new org.springframework.security.web.header.writers.HpkpHeaderWriter();
		org.springframework.security.web.header.writers.HstsHeaderWriter x17 = new org.springframework.security.web.header.writers.HstsHeaderWriter();
		org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter x16 = new org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter();
		org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter x15 = new org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter();
		org.springframework.security.web.header.writers.XXssProtectionHeaderWriter x14 = new org.springframework.security.web.header.writers.XXssProtectionHeaderWriter();
		org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter x13 = new org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter();
		org.springframework.security.web.jaasapi.JaasApiIntegrationFilter x12 = new org.springframework.security.web.jaasapi.JaasApiIntegrationFilter();
		org.springframework.security.web.jackson2.WebJackson2Module x11 = new org.springframework.security.web.jackson2.WebJackson2Module();
		org.springframework.security.web.method.annotation.CsrfTokenArgumentResolver x10 = new org.springframework.security.web.method.annotation.CsrfTokenArgumentResolver();
		org.springframework.security.web.savedrequest.HttpSessionRequestCache x9 = new org.springframework.security.web.savedrequest.HttpSessionRequestCache();
		org.springframework.security.web.savedrequest.NullRequestCache x8 = new org.springframework.security.web.savedrequest.NullRequestCache();
		org.springframework.security.web.savedrequest.RequestCacheAwareFilter x7 = new org.springframework.security.web.savedrequest.RequestCacheAwareFilter();
		org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor x6 = new org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor();
		org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter x5 = new org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter();
		org.springframework.security.web.session.HttpSessionEventPublisher x4 = new org.springframework.security.web.session.HttpSessionEventPublisher();
		org.springframework.security.web.util.RedirectUrlBuilder x3 = new org.springframework.security.web.util.RedirectUrlBuilder();
		org.springframework.security.web.util.matcher.RequestMatcherEditor x2 = new org.springframework.security.web.util.matcher.RequestMatcherEditor();

	}

	public void notes(N n) {
		n.k(ScottAaronson.class).s(" is about ").k(Jsr250Voter.class);
		n.k(HalAbelson.class).s(" is about ").k(SecuredAnnotationSecurityMetadataSource.class, Secured.class);
		n.k(SergeAbiteboul.class).s(" is about ").k(LoggerListener.class, PublicInvocationEvent.class,
				AuthorizedEvent.class, AuthorizationFailureEvent.class, AuthenticationCredentialsNotFoundEvent.class);
		n.k(SamsonAbramsky.class).s(" is about ").k(DenyAllPermissionEvaluator.class);

	}

}
