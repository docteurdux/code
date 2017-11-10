package dux.org.hibernate.jpa.event.internal.jpa;

import org.hibernate.jpa.event.internal.jpa.AbstractCallback;
import org.hibernate.jpa.event.spi.jpa.CallbackType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class AbstractCallbackTest extends AbstractTest {

	private CallbackType anyCallbackType;

	@Before
	public void before() {
		anyCallbackType = CallbackType.POST_LOAD;
	}

	@Test
	public void test() {

		AbstractCallback ac = getInstance(anyCallbackType);

		at(ac.isActive());
		aeq(anyCallbackType, ac.getCallbackType());
	}

	private AbstractCallback getInstance(CallbackType type) {

		return new AbstractCallback(type) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean performCallback(Object entity) {
				return false;
			}
		};

	}
}
