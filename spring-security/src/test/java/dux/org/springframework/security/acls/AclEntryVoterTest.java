package dux.org.springframework.security.acls;

import java.util.Collection;
import java.util.logging.Level;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;
import org.springframework.security.acls.model.SidRetrievalStrategy;
import org.springframework.security.core.Authentication;

import com.github.docteurdux.test.TS;

import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.access.annotation.DummySidRetrievalStrategy;
import dux.org.springframework.security.acls.aclEntryVoter.S;
import dux.org.springframework.security.acls.model.DummyObjectIdentityRetrievalStrategy;

public class AclEntryVoterTest {

	@Test
	public void testInstantiation() {
		S.getVoter(1, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationIllegalArgumentEmptyPermissions() {
		S.getVoter(0, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstantiationIllegalArgumentNullPermissions() {
		S.getVoter(-1, null);
	}

	@Test
	public void testSetInternalMethod() {
		AclEntryVoter voter = S.getVoter(1, null);
		voter.setInternalMethod(S.INTERNAL_METHOD);
		// now what ?
	}

	@Test
	public void testSetObjectIdentityRetrievalStrategy() {
		AclEntryVoter voter = S.getVoter(1, null);
		ObjectIdentityRetrievalStrategy strategy = new DummyObjectIdentityRetrievalStrategy();
		voter.setObjectIdentityRetrievalStrategy(strategy);
		// now what ?
	}

	@Test
	public void testSetSidRetrievalStrategy() {
		AclEntryVoter voter = S.getVoter(1, null);
		SidRetrievalStrategy strategy = new DummySidRetrievalStrategy();
		voter.setSidRetrievalStrategy(strategy);
		// now what ?
	}

	@Test
	public void testSupport() {
		AclEntryVoter voter = S.getVoter(1, null);

		DummyConfigAttribute attribute = new DummyConfigAttribute();

		attribute.setAttribute(null);
		Assert.assertFalse(voter.supports(attribute));

		attribute.setAttribute("string");
		Assert.assertFalse(voter.supports(attribute));

		attribute.setAttribute(S.PROCESS_CONFIG_ATTRIBUTE);
		Assert.assertTrue(voter.supports(attribute));
	}

	@Test()
	public void testVoteNoAttributes() {
		AclEntryVoter voter = S.getVoter(1, null);

		Authentication authentication = null;
		MethodInvocation methodInvocation = null;
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NONE);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test()
	public void testVoteOneAttribute() {
		AclEntryVoter voter = S.getVoter(1, null);

		Authentication authentication = null;
		MethodInvocation methodInvocation = null;
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_NOT_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNullPoc() throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(1, null);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = null;
		MethodInvocation methodInvocation = S.getMethodInvocation(true);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNullPocDebug() throws NoSuchMethodException, SecurityException {
		Log log = LogFactory.getLog(AclEntryVoter.class);
		Level previousLevel = TS.setLogLevel(log, Level.ALL);
		Assert.assertTrue(log.isDebugEnabled());
		try {
			testVoteOneSupportedAttributeNullPoc();
		} finally {
			TS.setLogLevel(log, previousLevel);
		}
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocGranted() throws NoSuchMethodException, SecurityException {
		Acl acl = S.getAcl(true, false);
		AclEntryVoter voter = S.getVoter(1, acl);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();

		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_GRANTED, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocGrantedDebug() throws NoSuchMethodException, SecurityException {
		Log log = LogFactory.getLog(AclEntryVoter.class);
		Level previousLevel = TS.setLogLevel(log, Level.ALL);
		Assert.assertTrue(log.isDebugEnabled());
		try {
			testVoteOneSupportedAttributeNonNullPocGranted();
		} finally {
			TS.setLogLevel(log, previousLevel);
		}
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocNotGranted() throws NoSuchMethodException, SecurityException {
		Acl acl = S.getAcl(false, false);
		AclEntryVoter voter = S.getVoter(1, acl);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocNotGrantedDebug()
			throws NoSuchMethodException, SecurityException {
		Log log = LogFactory.getLog(AclEntryVoter.class);
		Level previousLevel = TS.setLogLevel(log, Level.ALL);
		Assert.assertTrue(log.isDebugEnabled());
		try {
			testVoteOneSupportedAttributeNonNullPocNotGranted();
		} finally {
			TS.setLogLevel(log, previousLevel);
		}
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocIsGrantedThrow()
			throws NoSuchMethodException, SecurityException {
		Acl acl = S.getAcl(false, true);
		AclEntryVoter voter = S.getVoter(1, acl);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocIsGrantedThrowDebug()
			throws NoSuchMethodException, SecurityException {
		Log log = LogFactory.getLog(AclEntryVoter.class);
		Level previousLevel = TS.setLogLevel(log, Level.ALL);
		Assert.assertTrue(log.isDebugEnabled());
		try {
			testVoteOneSupportedAttributeNonNullPocIsGrantedThrow();
		} finally {
			TS.setLogLevel(log, previousLevel);
		}
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocReadAclThrow() throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(1, null);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocReadAclThrowDebug()
			throws NoSuchMethodException, SecurityException {
		Log log = LogFactory.getLog(AclEntryVoter.class);
		Level previousLevel = TS.setLogLevel(log, Level.ALL);
		Assert.assertTrue(log.isDebugEnabled());
		try {
			testVoteOneSupportedAttributeNonNullPocReadAclThrow();
		} finally {
			TS.setLogLevel(log, previousLevel);
		}
	}

	@Test
	public void testVoteOneSupportedAttributeNonNullPocInternalMethod()
			throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(1, null);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);
		voter.setInternalMethod(S.INTERNAL_METHOD);

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

	@Test(expected = AuthorizationServiceException.class)
	public void testVoteOneSupportedAttributeNonNullPocInternalMethodNSM()
			throws NoSuchMethodException, SecurityException {
		AclEntryVoter voter = S.getVoter(1, null);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);
		voter.setInternalMethod(S.INTERNAL_METHOD + "nsm");

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);

		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

	@Test(expected = AuthorizationServiceException.class)
	public void testVoteOneSupportedAttributeNonNullPocInternalMethodIT()
			throws NoSuchMethodException, SecurityException {

		AclEntryVoter voter = S.getVoter(1, null);

		voter.setProcessDomainObjectClass(S.DummyProcessObjectClass.class);
		voter.setInternalMethod(S.INTERNAL_METHOD + "IT");

		Authentication authentication = S.getAuthentication();
		MethodInvocation methodInvocation = S.getMethodInvocation(false);
		Collection<ConfigAttribute> attributes = S.getAttributes(S.Attributes.NAME_SET);
		int result = voter.vote(authentication, methodInvocation, attributes);
		Assert.assertEquals(AccessDecisionVoter.ACCESS_DENIED, result);
	}

}
