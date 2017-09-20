package com.github.docteurdux.spring.security.dc;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.security.access.PermissionCacheOptimizer;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;

import com.github.docteurdux.org.springframework.expression.EvaluationContextDUX;
import com.github.docteurdux.org.springframework.expression.ExpressionDUX;
import com.github.docteurdux.org.springframework.security.access.expression.method.MethodSecurityExpressionOperationsDUX;
import com.github.docteurdux.spring.security.notes.TU;

public class LeonardAdleman {
	public static void main(String[] args) {
		DefaultMethodSecurityExpressionHandler dmseh = new DefaultMethodSecurityExpressionHandler();

		TU.tru(dmseh.getExpressionParser() instanceof SpelExpressionParser);

		Object filterTarget = new Object();
		ExpressionDUX expression = new ExpressionDUX();
		EvaluationContextDUX ctx = new EvaluationContextDUX();
		MethodSecurityExpressionOperations mseo = new MethodSecurityExpressionOperationsDUX();
		TypedValue rootObject = new TypedValue(mseo);
		ctx.setRootObject(rootObject);
		dmseh.filter(filterTarget, expression, ctx);

		if (t()) {
			return;
		}

		Authentication auth = null;
		MethodInvocation mi = null;
		dmseh.createEvaluationContextInternal(auth, mi);

		String defaultRolePrefix = null;
		dmseh.setDefaultRolePrefix(defaultRolePrefix);
		ParameterNameDiscoverer parameterNameDiscoverer = null;
		dmseh.setParameterNameDiscoverer(parameterNameDiscoverer);
		PermissionCacheOptimizer permissionCacheOptimizer = null;
		dmseh.setPermissionCacheOptimizer(permissionCacheOptimizer);
		Object returnObject = null;
		dmseh.setReturnObject(returnObject, ctx);
		AuthenticationTrustResolver trustResolver = null;
		dmseh.setTrustResolver(trustResolver);

		Authentication authentication = null;
		MethodInvocation invocation = null;
		dmseh.createEvaluationContext(authentication, invocation);

		ApplicationContext applicationContext = null;
		dmseh.setApplicationContext(applicationContext);
		ExpressionParser expressionParser = null;
		dmseh.setExpressionParser(expressionParser);
		PermissionEvaluator permissionEvaluator = null;
		dmseh.setPermissionEvaluator(permissionEvaluator);
		RoleHierarchy roleHierarchy = null;
		dmseh.setRoleHierarchy(roleHierarchy);

	}

	private static boolean t() {
		return true;
	}
}
