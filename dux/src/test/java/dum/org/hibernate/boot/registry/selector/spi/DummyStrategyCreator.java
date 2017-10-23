package dum.org.hibernate.boot.registry.selector.spi;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;

public class DummyStrategyCreator<T> implements StrategyCreator<T> {

	private T result;
	private Boolean natural;

	public T create(Class<? extends T> strategyClass) {
		if (Boolean.TRUE.equals(natural)) {
			try {
				return strategyClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public void setNatural() {
		natural = true;
	}

}
