package com.github.docteurdux.spring.security.dc;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;

import com.github.docteurdux.org.aopalliance.intercept.MethodInvocation.MethodInvocationDUX;
import com.github.docteurdux.spring.security.notes.TU;

public class HalAbelson {

	@Secured("FOO")
	public void foo() {
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		SecuredAnnotationSecurityMetadataSource sasms = new SecuredAnnotationSecurityMetadataSource();
		TU.nil(sasms.getAllConfigAttributes());
		sasms.supports(MethodInvocation.class);
		MethodInvocationDUX mi = new MethodInvocationDUX();
		mi.setMethod(HalAbelson.class.getMethod("foo"));
		TU.eq(sasms.getAttributes(mi).iterator().next().getAttribute(), "FOO");
		System.out.println(HalAbelson.class.getName() + ": Done.");
	}
}
