package dux.org.springframework.security.authentication;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

import dux.org.springframework.security.core.DummyAuthentication;

public class ProviderManagerTest {
	@Test
	public void test() {
		List<AuthenticationProvider> providers = new ArrayList<>();
		DummyAuthenticationProvider provider = new DummyAuthenticationProvider();
		provider.setSupports(true);
		DummyAuthentication authentication = new DummyAuthentication();
		provider.setAuthentication(authentication);
		providers.add(provider);
		ProviderManager pm = new ProviderManager(providers);
		pm.setEraseCredentialsAfterAuthentication(true);
		pm.authenticate(authentication);
	}
}
