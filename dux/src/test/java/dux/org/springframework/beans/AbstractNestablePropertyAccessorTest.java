package dux.org.springframework.beans;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.AbstractNestablePropertyAccessor;
import org.springframework.beans.NotWritablePropertyException;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AbstractNestablePropertyAccessor.class)
public class AbstractNestablePropertyAccessorTest extends AbstractTest {

	@Test
	public void test() {

		C c = new C();
		Optional<C> optional = Optional.of(c);

		A a = new A(optional, null, null);

		aeqr(c, a.getWrappedInstance());
		aeq("", a.getNestedPath());
		aeqr(c, a.getRootInstance());

		/*-
		getAutoGrowCollectionLimit()
		getPropertyType(String)
		getPropertyTypeDescriptor(String)
		getPropertyValue(String)
		getRootClass()
		getRootInstance()
		getWrappedClass()
		isReadableProperty(String)
		isWritableProperty(String)
		setAutoGrowCollectionLimit(int)
		setPropertyValue(String, Object)
		setPropertyValue(PropertyValue)
		setWrappedInstance(Object)
		setWrappedInstance(Object, String, Object)
		toString()
		 */

	}

	private static class A extends AbstractNestablePropertyAccessor {

		public A(Object object, String nestedPath, Object rootObject) {
			super(object, nestedPath, rootObject);
		}

		@Override
		protected PropertyHandler getLocalPropertyHandler(String propertyName) {
			return null;
		}

		@Override
		protected AbstractNestablePropertyAccessor newNestedPropertyAccessor(Object object, String nestedPath) {
			return null;
		}

		@Override
		protected NotWritablePropertyException createNotWritablePropertyException(String propertyName) {
			return null;
		}

	}

	private static class C {

	}

}
