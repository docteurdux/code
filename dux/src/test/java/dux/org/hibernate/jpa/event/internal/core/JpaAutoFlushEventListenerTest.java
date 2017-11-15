package dux.org.hibernate.jpa.event.internal.core;

import java.util.IdentityHashMap;

import org.hibernate.engine.spi.CascadingActions;
import org.hibernate.event.spi.AutoFlushEventListener;
import org.hibernate.jpa.event.internal.core.JpaAutoFlushEventListener;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JpaAutoFlushEventListenerTest extends AbstractTest {

	@Test
	@SuppressWarnings("rawtypes")
	public void test() throws Exception {
		
		AutoFlushEventListener instance = JpaAutoFlushEventListener.INSTANCE;
		
		aeqr(CascadingActions.PERSIST_ON_FLUSH, invoke(instance, "getCascadingAction"));
		aeq(0,((IdentityHashMap)invoke(instance, "getAnything")).size());
	}
}
