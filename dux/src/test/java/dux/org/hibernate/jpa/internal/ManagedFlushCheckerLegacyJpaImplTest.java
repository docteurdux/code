package dux.org.hibernate.jpa.internal;

import org.hibernate.FlushMode;
import org.hibernate.jpa.internal.ManagedFlushCheckerLegacyJpaImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionImplementor;

@Done
public class ManagedFlushCheckerLegacyJpaImplTest extends AbstractTest {

	private ManagedFlushCheckerLegacyJpaImpl instance;
	private DummySessionImplementor sessionImplementor;

	@Before
	public void before() {

		instance = ManagedFlushCheckerLegacyJpaImpl.INSTANCE;

		sessionImplementor = new DummySessionImplementor();
	}

	/**
	 * Only case that yields positive
	 */
	@Test
	public void test1() {

		sessionImplementor.setClosed(false);
		sessionImplementor.setHibernateFlushMode(FlushMode.MANUAL);

		aeq(true, instance.shouldDoManagedFlush(sessionImplementor));

	}

	/**
	 * Testing all cases cover more possibilities, but makes the mechanism less
	 * obvious
	 */
	@Test
	public void test2() {

		for (boolean closed : booleans) {
			for (FlushMode flushMode : FlushMode.values()) {
				sessionImplementor.setClosed(closed);
				sessionImplementor.setHibernateFlushMode(flushMode);

				boolean expectShouldDoManagedFlush;
				if (sessionImplementor.isClosed()) {
					expectShouldDoManagedFlush = false;
				} else {
					switch (sessionImplementor.getHibernateFlushMode()) {
					case MANUAL:
						expectShouldDoManagedFlush = true;
						break;
					case ALWAYS:
					case AUTO:
					case COMMIT:
					default:
						expectShouldDoManagedFlush = false;

					}
				}

				aeq(expectShouldDoManagedFlush, instance.shouldDoManagedFlush(sessionImplementor));

			}
		}

	}

	/**
	 * Manual enumeration may be more readable for some cases, but does not always
	 * make things more obvious
	 */
	@Test
	public void test3() {

		test(true, FlushMode.ALWAYS, false);
		test(true, FlushMode.AUTO, false);
		test(true, FlushMode.COMMIT, false);
		test(true, FlushMode.MANUAL, false);

		test(false, FlushMode.ALWAYS, false);
		test(false, FlushMode.AUTO, false);
		test(false, FlushMode.COMMIT, false);
		test(false, FlushMode.MANUAL, true);

	}

	/**
	 * Here are cases which are sufficient for complete coverage, this does not tell
	 * much
	 */
	@Test
	public void test4() {

		test(true, FlushMode.ALWAYS, false);

		test(false, FlushMode.ALWAYS, false);

		test(false, FlushMode.MANUAL, true);

	}

	private void test(boolean closed, FlushMode flushMode, boolean expectShouldDoManagedFlush) {
		sessionImplementor.setClosed(closed);
		sessionImplementor.setHibernateFlushMode(flushMode);
		aeq(expectShouldDoManagedFlush, instance.shouldDoManagedFlush(sessionImplementor));

	}
}
