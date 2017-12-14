package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.AbstractRequestAttributes;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AbstractRequestAttributes.class)
@Related({ RequestAttributesTest.class, ServletRequestAttributesTest.class })
public class AbstractRequestAttributesTest extends AbstractTest {

	boolean updateAccessedSessionAttributesCalled = false;
	boolean destructCallbackCalled = false;

	private Runnable onDestruct = new Runnable() {
		@Override
		public void run() {
			destructCallbackCalled = true;
		}
	};

	@Test
	public void test() {

		/*
		 * org.springframework.web.context.request.AbstractRequestAttributes defines
		 * only a requestCompleted() method which will do each of the following
		 */

		/*-
		  - invoke the destruction callbacks
		  - call updateAccessedSessionAttributes()
		  - set the request active to false
		 */

		/*
		 * The structure of the object makes illustration of each of these steps a
		 * little complicated, but here's an attempt
		 */

		/*
		 * TestRequestAttributes is a custom implementation of
		 * AbstractRequestAttributes, which requires the destruction callback to be
		 * specified on the constructor. When called, this callback update the boolena
		 * field in destructed. The requestActive() delegates to isRequestActive()
		 * because isRequestActive() is protected final and cannot be overridden. And
		 * updateAccessedSessionAttributes() just sets
		 * updateAccessedSessionAttributesCalled.
		 */
		
		TestRequestAttributes attributes = new TestRequestAttributes(onDestruct);

		aeq(true, isRequestActive(attributes));
		aeq(false, destructCallbackCalled);
		aeq(false, updateAccessedSessionAttributesCalled);

		attributes.requestCompleted();

		aeq(false, isRequestActive(attributes));
		aeq(true, destructCallbackCalled);
		aeq(true, updateAccessedSessionAttributesCalled);

	}

	private boolean isRequestActive(TestRequestAttributes a) {
		return a.requestActive();
	}

	private class TestRequestAttributes extends AbstractRequestAttributes {

		public TestRequestAttributes(Runnable onDestruct) {
			registerRequestDestructionCallback("destuct", onDestruct);
		}

		@Override
		public Object getAttribute(String name, int scope) {
			return null;
		}

		@Override
		public void setAttribute(String name, Object value, int scope) {

		}

		@Override
		public void removeAttribute(String name, int scope) {

		}

		@Override
		public String[] getAttributeNames(int scope) {
			return null;
		}

		@Override
		public void registerDestructionCallback(String name, Runnable callback, int scope) {

		}

		@Override
		public Object resolveReference(String key) {
			return null;
		}

		@Override
		public String getSessionId() {
			return null;
		}

		@Override
		public Object getSessionMutex() {
			return null;
		}

		@Override
		protected void updateAccessedSessionAttributes() {
			updateAccessedSessionAttributesCalled = true;
		}

		public boolean requestActive() {
			return isRequestActive();
		}

	}
}
