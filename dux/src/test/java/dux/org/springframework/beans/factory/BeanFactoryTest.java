package dux.org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.core.ResolvableType;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.HTMLRenderer;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(BeanFactory.class)
public class BeanFactoryTest extends AbstractTest {
	@Test
	public void test() {

		/* first */
		
		new Runnable() {
			@Override
			public void run() {

			}
		}.run();

		/*
		 * The org.springframework.beans.factory.BeanFactory interface defines methods
		 * for obtaining beans.
		 */

		/*
		 * The most important method is containsBean(String) which tells whether the
		 * bean factory contains a bean of that name. It is important because when
		 * attempting to retrieve a bean that does not exist, the bean factory may throw
		 * org.springframework.beans.factory.NoSuchBeanDefinitionException
		 */

		/*
		 * Then a variety of getBean() methods allow retrieving beans in different
		 * cases.
		 * 
		 * getBean(String) retrieves the bean of that name.
		 * 
		 * getBean(String, Class<T>) cast the bean to the supplied class, usually after
		 * checking that the requested cast is valid.
		 * 
		 * getBean(Class<T>) retrieves any bean of the supplied type, but requires that
		 * one bean of that type be defined.
		 * 
		 * and finally, getBean(Class<T>, Object...) and getBean(String, Object...) are
		 * to be used with org.springframework.beans.factory.FactoryBean beans
		 */

		/*
		 * getType(String) just returns the class of the bean of the given name for
		 * standard beans, but can be smarter, e.g. in the case of
		 * org.springframework.beans.factory.FactoryBean
		 */

		/*
		 * isPrototype(String) and isSingleton(String) are supposed to delegate the
		 * query to org.springframework.beans.factory.FactoryBean
		 */

		/*
		 * isTypeMatch(String, Class<?>) and isTypeMatch(String, ResolvableType) check
		 * that the bean of the given name is compatible with the given type
		 */

		/* And finally, getAliases(String) returns the aliases of the beans */

		/*
		 * Since we are discussing an interface, it is difficult to be more specific
		 * here. A real world example requires a concrete type. We chose to illustrate
		 * the basic concepts with
		 * org.springframework.beans.factory.support.StaticListableBeanFactory
		 * 
		 */

		/*
		 * First we instanciate a StaticListableBeanFactory with a unique bean named
		 * "bean"
		 */

		Object bean = new Object();
		Map<String, Object> beans = new HashMap<>();
		beans.put("bean", bean);
		StaticListableBeanFactory bf = new StaticListableBeanFactory(beans);

		/* We check that the bean factory contains the bean */
		aeq(true, bf.containsBean("bean"));

		/* We check that we can get the bean in various ways */
		aeqr(bean, bf.getBean("bean"));
		aeqr(bean, bf.getBean("bean", Object.class));
		aeqr(bean, bf.getBean(Object.class));

		/* Object is the type of the bean */
		aeq(Object.class, bf.getType("bean"));
		aeq(true, bf.isTypeMatch("bean", Object.class));
		aeq(true, bf.isTypeMatch("bean", ResolvableType.forClass(Object.class)));

		/*
		 * The bean has no aliases, but StaticListableBeanFactory does not support
		 * aliases and always returns an empty list
		 */
		aeq(0, bf.getAliases("bean").length);

		/*
		 * The following are related to beans of type
		 * org.springframework.beans.factory.FactoryBean and are covered in details in
		 * the tests about the respective implementations
		 */

		aeq(false, bf.isSingleton("bean"));
		aeq(false, bf.isPrototype("bean"));

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				bf.getBean("bean", "arg0");
			}
		});

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				bf.getBean(Object.class, "arg0");
			}
		});

	}

	@Test
	public void test2() throws NoSuchMethodException, SecurityException, Exception {
		HTMLRenderer.renderToHTML2(getClass());
	}
}
