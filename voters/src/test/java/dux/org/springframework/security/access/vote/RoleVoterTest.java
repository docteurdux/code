package dux.org.springframework.security.access.vote;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;

import dum.org.springframework.security.core.DummyAuthentication;
import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.core.DummyGrantedAuthority;

public class RoleVoterTest {

	@Test
	public void test1() {
		RoleVoter voter = new RoleVoter();
		Authentication authentication = null;
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, voter.vote(authentication, null, attributes));
	}

	@Test
	public void test2() {
		RoleVoter voter = new RoleVoter();
		Authentication authentication = new DummyAuthentication();
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, voter.vote(authentication, null, attributes));
	}

	@Test
	public void test3() {
		RoleVoter voter = new RoleVoter();
		Authentication authentication = new DummyAuthentication();
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		attributes.add(new DummyConfigAttribute("ROLE_FOO"));
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, voter.vote(authentication, null, attributes));
	}
	
	@Test
	public void test31() {
		RoleVoter voter = new RoleVoter();
		Authentication authentication = new DummyAuthentication();
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		attributes.add(new DummyConfigAttribute("FOO"));
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, voter.vote(authentication, null, attributes));
	}

	@Test
	public void test4() {
		RoleVoter voter = new RoleVoter();
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.addAuthority(new DummyGrantedAuthority("ROLE_FOO"));
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		attributes.add(new DummyConfigAttribute("ROLE_FOO"));
		Assert.assertEquals(AccessDecisionVoter.ACCESS_GRANTED, voter.vote(authentication, null, attributes));
	}
	
	@Test
	public void test5() {
		RoleVoter voter = new RoleVoter();
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.addAuthority(new DummyGrantedAuthority("ROLE_FOO"));
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		attributes.add(new DummyConfigAttribute("ROLE_FOOBAR"));
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, voter.vote(authentication, null, attributes));
	}
}
