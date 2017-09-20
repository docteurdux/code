package com.github.docteurdux.spring.security.dc;

import org.springframework.security.access.annotation.Jsr250MethodSecurityMetadataSource;
import org.springframework.security.access.intercept.aspectj.MethodInvocationAdapter;

import com.github.docteurdux.spring.security.notes.TU;

public class WilVanDerAlst {

	public static void main(String[] args) {
		
		Jsr250MethodSecurityMetadataSource o = new Jsr250MethodSecurityMetadataSource();
		
		TU.nil(o.getAllConfigAttributes());
		
		TU.tru(o.supports(MethodInvocationAdapter.class));
		
		o.getAttributes(o);
		
	}

}
