package dux.org.springframework.beans.factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.core.ResolvableType;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(ListableBeanFactory.class)
@Prerequisites(BeanFactoryTest.class)
public class ListableBeanFactoryTest extends AbstractTest {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface A {
		String value() default "value";
	}

	@A
	public static class C {

	}

	@Test
	public void test() {

		/*
		 * org.springframework.beans.factory.ListableBeanFactory extends
		 * org.springframework.beans.factory.BeanFactory with function to query the bean
		 * factory
		 */

		/*
		 * getBeanDefinitionCount() returns the number of bean definitions in the
		 * factory
		 */

		/*
		 * getBeanDefinitionNames() returns the list of bean names in the factory
		 */

		/*
		 * containsBeanDefinition(String) tells whether a bean of the given name is
		 * defined in the factory. This seems to duplicate containsBean(String) but it
		 * is said to be restricted to the current level in the hierarchy and to ignore
		 * singleton beans, or something.
		 */

		/*
		 * Four methods collect bean names. getBeanNamesForType(Class<?>) and
		 * getBeanNamesForType(ResolvableType) collect according to type, and
		 * getBeanNamesForAnnotation(Class<? extends Annotation>) collect according to
		 * the presence of annotations. getBeanNamesForType(Class<?>, boolean, boolean)
		 * offers more options with respect to singleton beans and eager initialization.
		 */

		/*
		 * getBeansOfType(Class<T>), getBeansWithAnnotation(Class<? extends Annotation>)
		 * and getBeansOfType(Class<T>, boolean, boolean) are similar to the former but
		 * return the actual beans, as a Map<String,Object>
		 */

		/*
		 * Finally, findAnnotationOnBean(String, Class<A>) retrieves the annotation on a
		 * bean
		 */

		/*
		 * As in dux.org.springframework.beans.factory.BeanFactoryTest, we will
		 * illustrate some of the concept with an instance of
		 * org.springframework.beans.factory.support.StaticListableBeanFactory
		 */

		/* First, we initialize the factory with a single bean */
		C bean = new C();
		Map<String, Object> beans = new HashMap<>();
		beans.put("bean", bean);
		StaticListableBeanFactory bf = new StaticListableBeanFactory(beans);

		/* The factory has only one bean definition */
		aeq(1, bf.getBeanDefinitionCount());

		/* The only bean name defined is "bean" */
		aeq(1, bf.getBeanDefinitionNames().length);
		aeq("bean", bf.getBeanDefinitionNames()[0]);

		/* The factory contains a bean named "bean" */
		aeq(true, bf.containsBeanDefinition("bean"));

		/* We defined "bean" as an instance of C which is annotated with annotation A */

		/* "bean" is part of the bean which have annotation A */

		/* bean names */
		aeq(1, bf.getBeanNamesForAnnotation(A.class).length);
		aeq("bean", bf.getBeanNamesForAnnotation(A.class)[0]);

		/* actual bean */
		aeq(1, bf.getBeansWithAnnotation(A.class).size());
		aeqr(bean, bf.getBeansWithAnnotation(A.class).get("bean"));

		/* We can get the instance of A for that bean */
		aeq("value", bf.findAnnotationOnBean("bean", A.class).value());

		/* "bean" is part of the bean which are of type C */

		/* bean names */
		aeq(1, bf.getBeanNamesForType(C.class).length);
		aeq("bean", bf.getBeanNamesForType(C.class)[0]);

		aeq(1, bf.getBeanNamesForType(ResolvableType.forClass(C.class)).length);
		aeq("bean", bf.getBeanNamesForType(ResolvableType.forClass(C.class))[0]);

		aeq(1, bf.getBeanNamesForType(C.class, false, false).length);
		aeq("bean", bf.getBeanNamesForType(C.class, false, false)[0]);

		/* actual beans */
		aeq(1, bf.getBeansOfType(C.class).size());
		aeqr(bean, bf.getBeansOfType(C.class).get("bean"));

		aeq(1, bf.getBeansOfType(C.class, false, false).size());
		aeqr(bean, bf.getBeansOfType(C.class, false, false).get("bean"));

		/*
		 * note that there is no corresponding method for getting beans of a given type
		 * from a org.springframework.core.ResolvableType ; this is probably an omission
		 */

	}
}
