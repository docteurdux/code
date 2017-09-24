package dux.org.springframework.security.access.vote;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.core.DummyAuthentication;
import dux.org.springframework.security.core.DummyGrantedAuthority;

public class AuthenticatedVoterTest {

	public static enum Kind {
		FULL, REME, ANON
	}

	@Test
	public void testVote() {

		testVote(Kind.FULL, Kind.FULL, AccessDecisionVoter.ACCESS_GRANTED);
		testVote(Kind.FULL, Kind.REME, AccessDecisionVoter.ACCESS_GRANTED);
		testVote(Kind.FULL, Kind.ANON, AccessDecisionVoter.ACCESS_GRANTED);

		testVote(Kind.REME, Kind.FULL, AccessDecisionVoter.ACCESS_DENIED);
		testVote(Kind.REME, Kind.REME, AccessDecisionVoter.ACCESS_GRANTED);
		testVote(Kind.REME, Kind.ANON, AccessDecisionVoter.ACCESS_GRANTED);

		testVote(Kind.ANON, Kind.FULL, AccessDecisionVoter.ACCESS_DENIED);
		testVote(Kind.ANON, Kind.REME, AccessDecisionVoter.ACCESS_DENIED);
		testVote(Kind.ANON, Kind.ANON, AccessDecisionVoter.ACCESS_GRANTED);

	}

	private void testVote(Kind authKind, Kind attrKind, int result) {
		AuthenticatedVoter voter = new AuthenticatedVoter();
		Authentication authentication = getAuthentication(authKind);
		Collection<ConfigAttribute> attributes = getAttributes(attrKind);
		Assert.assertEquals(result, voter.vote(authentication, null, attributes));
	}

	@Test
	public void testOther() {
		AuthenticatedVoter voter = new AuthenticatedVoter();
		Authentication authentication = new DummyAuthentication();
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		attributes.add(new DummyConfigAttribute(""));
		Assert.assertEquals(AccessDecisionVoter.ACCESS_ABSTAIN, voter.vote(authentication, null, attributes));
	}

	private Authentication getAuthentication(Kind kind) {
		switch (kind) {
		case FULL:
			return new DummyAuthentication();
		case REME:
			return new RememberMeAuthenticationToken("key", new Object(), null);
		case ANON: {
			ArrayList<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new DummyGrantedAuthority());
			return new AnonymousAuthenticationToken("key", new Object(), authorities);
		}
		default:
			break;
		}
		throw new IllegalArgumentException();
	}

	private Collection<ConfigAttribute> getAttributes(Kind kind) {
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		switch (kind) {
		case FULL:
			attributes.add(new DummyConfigAttribute(AuthenticatedVoter.IS_AUTHENTICATED_FULLY));
			break;
		case REME:
			attributes.add(new DummyConfigAttribute(AuthenticatedVoter.IS_AUTHENTICATED_REMEMBERED));
			break;
		case ANON:
			attributes.add(new DummyConfigAttribute(AuthenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY));
			break;
		default:
			break;
		}
		return attributes;
	}

}
