package dum.org.hibernate.engine.config.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.engine.config.spi.ConfigurationService;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyConfigurationService implements ConfigurationService {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> settings = new HashMap<>();

	private RunnableWithArgs<Object> getSettingRWA;

	@SuppressWarnings("rawtypes")
	@Override
	public Map getSettings() {
		return settings;
	}

	@Override
	public <T> T getSetting(String name, Converter<T> converter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getSetting(String name, Converter<T> converter, T defaultValue) {
		if (getSettingRWA != null) {
			return (T) getSettingRWA.run(name, converter, defaultValue);
		}
		return null;
	}

	public void setGetSettingRWA(RunnableWithArgs<Object> getSettingRWA) {
		this.getSettingRWA = getSettingRWA;
	}

	@Override
	public <T> T getSetting(String name, Class<T> expected, T defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T cast(Class<T> expected, Object candidate) {
		// TODO Auto-generated method stub
		return null;
	}

}
