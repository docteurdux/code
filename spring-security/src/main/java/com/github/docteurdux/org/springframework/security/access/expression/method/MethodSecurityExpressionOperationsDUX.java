package com.github.docteurdux.org.springframework.security.access.expression.method;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class MethodSecurityExpressionOperationsDUX implements MethodSecurityExpressionOperations {

	private Object filterObject;
	private Object returnObject;
	private Authentication authentication;
	private boolean hasAuthority;
	private boolean hasAnyAuthority;
	private boolean hasRole;
	private boolean hasAnyRole;
	private boolean permitAll;
	private boolean denyAll;
	private boolean isAnonymous;
	private boolean isAuthenticated;
	private boolean isRememberMe;
	private boolean isFullyAuthenticated;
	private boolean hasPermission;
	private Object that;

	@Override
	public Authentication getAuthentication() {
		return authentication;
	}

	@Override
	public boolean hasAuthority(String authority) {
		return hasAuthority;
	}

	@Override
	public boolean hasAnyAuthority(String... authorities) {
		return hasAnyAuthority;
	}

	@Override
	public boolean hasRole(String role) {
		return hasRole;
	}

	@Override
	public boolean hasAnyRole(String... roles) {
		return hasAnyRole;
	}

	@Override
	public boolean permitAll() {
		return permitAll;
	}

	@Override
	public boolean denyAll() {
		return denyAll;
	}

	@Override
	public boolean isAnonymous() {
		return isAnonymous;
	}

	@Override
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	@Override
	public boolean isRememberMe() {
		return isRememberMe;
	}

	@Override
	public boolean isFullyAuthenticated() {
		return isFullyAuthenticated;
	}

	@Override
	public boolean hasPermission(Object target, Object permission) {
		return hasPermission;
	}

	@Override
	public boolean hasPermission(Object targetId, String targetType, Object permission) {
		return hasPermission;
	}

	@Override
	public void setFilterObject(Object filterObject) {
		this.filterObject = filterObject;

	}

	@Override
	public Object getFilterObject() {
		return filterObject;
	}

	@Override
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;

	}

	@Override
	public Object getReturnObject() {
		return returnObject;
	}

	@Override
	public Object getThis() {
		return that;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public void setHasAuthority(boolean hasAuthority) {
		this.hasAuthority = hasAuthority;
	}

	public void setHasAnyAuthority(boolean hasAnyAuthority) {
		this.hasAnyAuthority = hasAnyAuthority;
	}

	public void setHasRole(boolean hasRole) {
		this.hasRole = hasRole;
	}

	public void setHasAnyRole(boolean hasAnyRole) {
		this.hasAnyRole = hasAnyRole;
	}

	public void setPermitAll(boolean permitAll) {
		this.permitAll = permitAll;
	}

	public void setDenyAll(boolean denyAll) {
		this.denyAll = denyAll;
	}

	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public void setRememberMe(boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	public void setFullyAuthenticated(boolean isFullyAuthenticated) {
		this.isFullyAuthenticated = isFullyAuthenticated;
	}

	public void setHasPermission(boolean hasPermission) {
		this.hasPermission = hasPermission;
	}

	public void setThis(Object that) {
		this.that = that;
	}

}
