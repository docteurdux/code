package dux.org.springframework.beans;

import java.security.AccessControlContext;

import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BeanWrapperImpl.class)
@Related({AbstractNestablePropertyAccessorTest.class})
public class BeanWrapperImplTest extends AbstractTest {

	private static class C {

	}

	@Test
	public void test() {

		BeanWrapperImpl b4 = new BeanWrapperImpl(C.class);

		if (t()) {
			return;
		}
		BeanWrapperImpl b1 = new BeanWrapperImpl();
		BeanWrapperImpl b2 = new BeanWrapperImpl(true);
		BeanWrapperImpl b3 = new BeanWrapperImpl(false);
		BeanWrapperImpl b5 = new BeanWrapperImpl(new C());
		Object object = new C();
		String nestedPath = "nestedPath";
		Object rootObject = new C();
		BeanWrapperImpl b6 = new BeanWrapperImpl(object, nestedPath, rootObject);

		Object value = null;
		String propertyName = null;
		AccessControlContext acc = null;

		b1.convertForProperty(value, propertyName);
		b1.getPropertyDescriptor(propertyName);
		b1.getPropertyDescriptors();
		b1.getSecurityContext();
		b1.setBeanInstance(rootObject);
		b1.setSecurityContext(acc);
		b1.setWrappedInstance(object, nestedPath, rootObject);

		/*-
		BeanWrapperImpl()
		BeanWrapperImpl(boolean)
		BeanWrapperImpl(Class<?>)
		BeanWrapperImpl(Object)
		BeanWrapperImpl(Object, String, Object)
		convertForProperty(Object, String)
		getPropertyDescriptor(String)
		getPropertyDescriptors()
		getSecurityContext()
		setBeanInstance(Object)
		setSecurityContext(AccessControlContext)
		setWrappedInstance(Object, String, Object)
		 */
	}
}
