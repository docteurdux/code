package dum.org.hibernate.boot.registry.selector.spi;

import java.util.concurrent.Callable;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.hibernate.boot.registry.selector.spi.StrategySelector;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyStrategySelector implements StrategySelector {

	private static final long serialVersionUID = 1L;
	private RunnableWithArgs<Object> resolveDefaultableStrategyRWA;

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
	@SuppressWarnings("unchecked")
	public <T> T resolveDefaultableStrategy(Class<T> strategy, Object strategyReference, T defaultValue) {
		if (resolveDefaultableStrategyRWA != null) {
			return (T) resolveDefaultableStrategyRWA.run(strategy, strategyReference, defaultValue);
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T resolveDefaultableStrategy(Class<T> strategy, Object strategyReference, Callable<T> defaultResolver) {
		if (resolveDefaultableStrategyRWA != null) {
			return (T) resolveDefaultableStrategyRWA.run(strategy, strategyReference, defaultResolver);
		}
		return null;
	}

	public void setResolveDefaultableStrategyRWA(RunnableWithArgs<Object> resolveDefaultableStrategyRWA) {
		this.resolveDefaultableStrategyRWA = resolveDefaultableStrategyRWA;
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
