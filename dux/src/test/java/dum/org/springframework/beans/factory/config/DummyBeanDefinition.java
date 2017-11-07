package dum.org.springframework.beans.factory.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

public class DummyBeanDefinition implements BeanDefinition {

	private String scope = "";

	@Override
	public String[] attributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAttribute(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstructorArgumentValues getConstructorArgumentValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDependsOn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactoryBeanName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactoryMethodName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDefinition getOriginatingBeanDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParentName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutablePropertyValues getPropertyValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResourceDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRole() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getScope() {
		return scope;
	}

	@Override
	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutowireCandidate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLazyInit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrimary() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrototype() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAutowireCandidate(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBeanClassName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDependsOn(String... arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFactoryBeanName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFactoryMethodName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLazyInit(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParentName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPrimary(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setScope(String scope) {
		this.scope = scope;

	}

}
