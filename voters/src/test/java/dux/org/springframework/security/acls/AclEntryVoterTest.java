package dux.org.springframework.security.acls;

import java.util.Collection;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.core.Authentication;

import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.acls.aclEntryVoter.S;

public class AclEntryVoterTest {

	@Test
	public void testSupport() {
		AclEntryVoter voter = S.getVoter(null);

		DummyConfigAttribute attribute = new DummyConfigAttribute(null);
		Assert.assertFalse(voter.supports(attribute));

		attribute.setAttribute("string");
		Assert.assertFalse(voter.supports(attribute));

		attribute.setAttribute(S.PROCESS_CONFIG_ATTRIBUTE);
		Assert.assertTrue(voter.supports(attribute));
	}

	@Test()
	public void testVoteAbstainNoAttribute() throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(null);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation();
		Collection<ConfigAttribute> attributes = S.getAttributes(null);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test()
	public void testVoteAbstainOtherAttributeName() throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(null);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation();
		Collection<ConfigAttribute> attributes = S.getAttributes("");
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test
	public void testVoteGranted() throws NoSuchMethodException, SecurityException {
		Acl acl = S.getAcl(true);
		AclEntryVoter voter = S.getVoter(acl);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();

		MethodInvocation methodInvocation = S.getMethodInvocation();
		Collection<ConfigAttribute> attributes = S.getAttributes(S.PROCESS_CONFIG_ATTRIBUTE);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_GRANTED, result);
	}

	@Test
	public void testVoteDenied() throws NoSuchMethodException, SecurityException {
		Acl acl = S.getAcl(false);
		AclEntryVoter voter = S.getVoter(acl);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation();
		Collection<ConfigAttribute> attributes = S.getAttributes(S.PROCESS_CONFIG_ATTRIBUTE);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

}
