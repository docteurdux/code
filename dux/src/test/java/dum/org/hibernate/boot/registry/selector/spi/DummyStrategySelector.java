package dum.org.hibernate.boot.registry.selector.spi;

import java.util.concurrent.Callable;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.hibernate.boot.registry.selector.spi.StrategySelector;

public class DummyStrategySelector implements StrategySelector {

	private static final long serialVersionUID = 1L;

	@Override
	public <T> void registerStrategyImplementor(Class<T> strategy, String name, Class<? extends T> implementation) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void unRegisterStrategyImplementor(Class<T> strategy, Class<? extends T> implementation) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> Class<? extends T> selectStrategyImplementor(Class<T> strategy, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T resolveStrategy(Class<T> strategy, Object strategyReference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T resolveDefaultableStrategy(Class<T> strategy, Object strategyReference, T defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T resolveDefaultableStrategy(Class<T> strategy, Object strategyReference, Callable<T> defaultResolver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T resolveStrategy(Class<T> strategy, Object strategyReference, Callable<T> defaultResolver,
			StrategyCreator<T> creator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T resolveStrategy(Class<T> strategy, Object strategyReference, T defaultValue,
			StrategyCreator<T> creator) {
		// TODO Auto-generated method stub
		return null;
	}

}
