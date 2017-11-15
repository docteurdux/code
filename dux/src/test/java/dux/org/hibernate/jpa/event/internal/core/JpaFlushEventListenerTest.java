package dux.org.hibernate.jpa.event.internal.core;

import java.util.IdentityHashMap;

import org.hibernate.engine.spi.CascadingActions;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.jpa.event.internal.core.JpaFlushEventListener;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JpaFlushEventListenerTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		FlushEventListener jfel = JpaFlushEventListener.INSTANCE;
		aeq(CascadingActions.PERSIST_ON_FLUSH, invoke(jfel, "getCascadingAction", JpaFlushEventListener.class));
		aeq(IdentityHashMap.class, invoke(jfel, "getAnything", JpaFlushEventListener.class).getClass());
	}
}
