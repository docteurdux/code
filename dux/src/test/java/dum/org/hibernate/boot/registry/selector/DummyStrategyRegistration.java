package dum.org.hibernate.boot.registry.selector;

import org.hibernate.boot.registry.selector.StrategyRegistration;

public class DummyStrategyRegistration<T> implements StrategyRegistration<T> {

	private Class<T> strategyRole;
	private Iterable<String> selectorNames;
	private Class<? extends T> strategyImplementation;

	public Class<T> getStrategyRole() {
		return strategyRole;
	}

	public Iterable<String> getSelectorNames() {
		return selectorNames;
	}

	public Class<? extends T> getStrategyImplementation() {
		return strategyImplementation;
	}

	public void setStrategyRole(Class<T> strategyRole) {
		this.strategyRole = strategyRole;
	}

	public void setSelectorNames(Iterable<String> selectorNames) {
		this.selectorNames = selectorNames;
	}

	public void setStrategyImplementation(Class<? extends T> strategyImplementation) {
		this.strategyImplementation = strategyImplementation;
	}

}
