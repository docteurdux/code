package dum.org.springframework.beans.factory.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class DummyBeanDefinitionRegistry implements BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();
	private Map<String, String> aliases = new HashMap<>();

	@Override
	public void registerAlias(String name, String alias) {
		aliases.put(alias, name);
	}

	@Override
	public void removeAlias(String alias) {
		aliases.remove(alias);
	}

	@Override
	public boolean isAlias(String name) {
		return aliases.containsKey(name);
	}

	@Override
	public String[] getAliases(String name) {
		if (name == null) {
			return new String[] {};
		}
		List<String> matches = new ArrayList<>();
		for (Entry<String, String> entry : aliases.entrySet()) {
			if (name.equals(entry.getValue())) {
				matches.add(entry.getKey());
			}
		}
		return matches.toArray(new String[] {});
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
			throws BeanDefinitionStoreException {
		beanDefinitions.put(beanName, beanDefinition);
	}

	@Override
	public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		beanDefinitions.remove(beanName);

	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		return beanDefinitions.get(beanName);
	}

	@Override
	public boolean containsBeanDefinition(String beanName) {
		return beanDefinitions.containsKey(beanName);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		int c = -1;
		String[] names = new String[beanDefinitions.size()];
		for (String name : beanDefinitions.keySet()) {
			names[++c] = name;
		}
		return null;
	}

	@Override
	public int getBeanDefinitionCount() {
		return beanDefinitions.size();
	}

	@Override
	public boolean isBeanNameInUse(String beanName) {

		return beanDefinitions.containsKey(beanName) || aliases.containsKey(beanName);
	}

}
