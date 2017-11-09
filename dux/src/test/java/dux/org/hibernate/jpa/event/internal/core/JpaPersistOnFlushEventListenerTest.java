package dux.org.hibernate.jpa.event.internal.core;

import org.hibernate.engine.spi.CascadingActions;
import org.hibernate.jpa.event.internal.core.JpaPersistEventListener;
import org.hibernate.jpa.event.internal.core.JpaPersistOnFlushEventListener;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JpaPersistOnFlushEventListenerTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(JpaPersistEventListener.class, JpaPersistOnFlushEventListener.class.getSuperclass());

		aeq(CascadingActions.PERSIST_ON_FLUSH, invoke(new JpaPersistOnFlushEventListener(), "getCascadeAction"));
	}
}
