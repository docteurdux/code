package dux.org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(FactoryBean.class)
public class FactoryBeanTest extends AbstractTest {
	@Test
	public void test() {

		FactoryBean fb = new FactoryBean<Object>() {

			@Override
			public Object getObject() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Class<?> getObjectType() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		aeq(true, fb.isSingleton());
		
		

		/*-
		getObject()
		getObjectType()
		isSingleton()
		*/
	}
}
