package dux.org.hibernate.event.internal;

import org.hibernate.engine.spi.CascadingActions;
import org.hibernate.event.internal.DefaultPersistEventListener;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DefaultPersistOnFlushEventListenerTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		aeq(DefaultPersistEventListener.class, DefaultPersistOnFlushEventListener.class.getSuperclass());

		DefaultPersistOnFlushEventListener listener = new DefaultPersistOnFlushEventListener();
		aeq(CascadingActions.PERSIST_ON_FLUSH, invoke(listener, "getCascadeAction"));
	}
}
