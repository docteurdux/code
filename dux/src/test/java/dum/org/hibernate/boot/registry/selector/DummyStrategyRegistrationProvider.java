package dum.org.hibernate.boot.registry.selector;

import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.hibernate.boot.registry.selector.StrategyRegistrationProvider;

public class DummyStrategyRegistrationProvider implements StrategyRegistrationProvider {

	public Iterable<StrategyRegistration> getStrategyRegistrations() {
		return null;
	}

}
