package dum.org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class DummyBeanDefinitionRegistry implements BeanDefinitionRegistry {

	@Override
	public String[] getAliases(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlias(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerAlias(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAlias(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsBeanDefinition(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BeanDefinition getBeanDefinition(String arg0) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBeanDefinitionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getBeanDefinitionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBeanNameInUse(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerBeanDefinition(String arg0, BeanDefinition arg1) throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBeanDefinition(String arg0) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub

	}

}
