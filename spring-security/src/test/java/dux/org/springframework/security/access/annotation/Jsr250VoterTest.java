package dux.org.springframework.security.access.annotation;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.Jsr250SecurityConfig;
import org.springframework.security.access.annotation.Jsr250Voter;
import org.springframework.security.core.GrantedAuthority;

import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.core.DummyAuthentication;
import dux.org.springframework.security.core.DummyGrantedAuthority;

public class Jsr250VoterTest {

	@Test
	public void none() {
		Jsr250Voter v = new Jsr250Voter();
		int result = v.vote(null, null, new ArrayList<>());
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test
	public void some() {
		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> attributes = new ArrayList<>();
		ConfigAttribute a = new DummyConfigAttribute();
		attributes.add(a);
		int result = v.vote(null, null, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test
	public void permitAll() {

		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(Jsr250SecurityConfig.PERMIT_ALL_ATTRIBUTE);

		int result = v.vote(null, null, definition);
		Assert.assertEquals(result, AccessDecisionVoter.ACCESS_GRANTED);
	}

	@Test
	public void denyAll() {

		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE);

		int result = v.vote(null, null, definition);
		Assert.assertEquals(result, AccessDecisionVoter.ACCESS_DENIED);
	}

	@Test
	public void someSupportNotSet() {

		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(new Jsr250SecurityConfig("hello"));

		DummyAuthentication authentication = new DummyAuthentication();

		int result = v.vote(authentication, null, definition);
		Assert.assertEquals(result, AccessDecisionVoter.ACCESS_DENIED);
	}

	@Test
	public void someSupportSomeAuthorityNotSet() {

		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(new Jsr250SecurityConfig("hello"));

		DummyAuthentication authentication = new DummyAuthentication();
		GrantedAuthority ga = new DummyGrantedAuthority();
		authentication.addAuthority(ga);

		int result = v.vote(authentication, null, definition);
		Assert.assertEquals(result, AccessDecisionVoter.ACCESS_DENIED);
	}

	@Test
	public void someSupportSomeAuthoritySet() {

		Jsr250Voter v = new Jsr250Voter();
		ArrayList<ConfigAttribute> definition = new ArrayList<>();
		definition.add(new Jsr250SecurityConfig("hello"));

		DummyAuthentication authentication = new DummyAuthentication();
		DummyGrantedAuthority ga = new DummyGrantedAuthority();
		ga.setAuthority("hello");
		authentication.addAuthority(ga);

		int result = v.vote(authentication, null, definition);
		Assert.assertEquals(result, AccessDecisionVoter.ACCESS_DENIED);
	}

	@Test
	public void support() {
		Jsr250Voter v = new Jsr250Voter();
		Assert.assertTrue(v.supports(Object.class));
	}

	@Test
	public void bonusAttributes() {

		Jsr250SecurityConfig deny = Jsr250SecurityConfig.DENY_ALL_ATTRIBUTE;
		Assert.assertEquals(deny.getAttribute(), "javax.annotation.security.DenyAll");

		Jsr250SecurityConfig permit = Jsr250SecurityConfig.PERMIT_ALL_ATTRIBUTE;
		Assert.assertEquals(permit.getAttribute(), "javax.annotation.security.PermitAll");

		Jsr250SecurityConfig hello = new Jsr250SecurityConfig("hello");
		Assert.assertEquals(hello.getAttribute(), "hello");
	}

}
