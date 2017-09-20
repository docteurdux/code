package com.github.docteurdux.spring.security.dc;

import java.util.ArrayList;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;
import org.springframework.security.access.annotation.Jsr250Voter;

import com.github.docteurdux.org.springframework.security.core.AuthenticationDUX;
import com.github.docteurdux.org.springframework.security.core.GrantedAuthorityDUX;
import com.github.docteurdux.spring.security.notes.TU;

public class ScottAaronson {
	public static void main(String[] args) {

		Jsr250SecurityConfig deny = Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE;
		Jsr250SecurityConfig permit = Jsr250SecurityConfig.PERMIT_ALL_ATTRIBUTE;
		Jsr250SecurityConfig hello = new Jsr250SecurityConfig("hello");

		Jsr250Voter v = new Jsr250Voter();
		TU.tru(v.supports(Object.class));
		TU.tru(v.supports(deny));
		TU.tru(v.supports(permit));
		TU.tru(v.supports(hello));

		permitAll(v);
		denyAll(v);
		customNotSet(v);
		customSet(v);
		notSet(v);

		TU.eq(deny.getAttribute(), "javax.annotation.security.DenyAll");
		TU.eq(permit.getAttribute(), "javax.annotation.security.PermitAll");
		TU.eq(hello.getAttribute(), "hello");

		System.out.println("Done.");
	}

	private static void permitAll(Jsr250Voter v) {
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(Jsr250SecurityConfig.PERMIT_ALL_ATTRIBUTE);
		TU.eq(v.vote(null, null, definition), AccessDecisionVoter.ACCESS_GRANTED);
	}

	private static void denyAll(Jsr250Voter v) {
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE);
		TU.eq(v.vote(null, null, definition), AccessDecisionVoter.ACCESS_DENIED);
	}

	private static void customNotSet(Jsr250Voter v) {
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(new Jsr250SecurityConfig("hello"));

		AuthenticationDUX authentication = new AuthenticationDUX();
		TU.eq(v.vote(authentication, null, definition), AccessDecisionVoter.ACCESS_DENIED);
	}

	private static void customSet(Jsr250Voter v) {
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(new Jsr250SecurityConfig("hello"));

		GrantedAuthorityDUX grantedAuthority = new GrantedAuthorityDUX();
		grantedAuthority.setAuthority("hello");

		AuthenticationDUX authentication = new AuthenticationDUX();
		authentication.addAuthority(grantedAuthority);

		TU.eq(v.vote(authentication, null, definition), AccessDecisionVoter.ACCESS_GRANTED);
	}

	private static void notSet(Jsr250Voter v) {
		TU.eq(v.vote(null, null, new ArrayList<>()), AccessDecisionVoter.ACCESS_ABSTAIN);
	}
}
