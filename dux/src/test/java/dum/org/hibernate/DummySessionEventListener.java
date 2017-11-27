package dum.org.hibernate;

import org.hibernate.SessionEventListener;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;
import com.github.docteurdux.test.TestEventCollectorI;

public class DummySessionEventListener extends TestEventCollector implements SessionEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void transactionCompletion(boolean successful) {
		testEvents.add(new TestEvent("transactionCompletion").prop("successful", successful));
	}

	@Override
	public void jdbcConnectionAcquisitionStart() {
		testEvents.add(new TestEvent("jdbcConnectionAcquisitionStart"));
	}

	@Override
	public void jdbcConnectionAcquisitionEnd() {
		testEvents.add(new TestEvent("jdbcConnectionAcquisitionEnd"));
	}

	@Override
	public void jdbcConnectionReleaseStart() {
		testEvents.add(new TestEvent("jdbcConnectionReleaseStart"));
	}

	@Override
	public void jdbcConnectionReleaseEnd() {
		testEvents.add(new TestEvent("jdbcConnectionReleaseEnd"));
	}

	@Override
	public void jdbcPrepareStatementStart() {
		testEvents.add(new TestEvent("jdbcPrepareStatementStart"));
	}

	@Override
	public void jdbcPrepareStatementEnd() {
		testEvents.add(new TestEvent("jdbcPrepareStatementEnd"));
	}

	@Override
	public void jdbcExecuteStatementStart() {
		testEvents.add(new TestEvent("jdbcExecuteStatementStart"));
	}

	@Override
	public void jdbcExecuteStatementEnd() {
		testEvents.add(new TestEvent("jdbcExecuteStatementEnd"));
	}

	@Override
	public void jdbcExecuteBatchStart() {
		testEvents.add(new TestEvent("jdbcExecuteBatchStart"));
	}

	@Override
	public void jdbcExecuteBatchEnd() {
		testEvents.add(new TestEvent("jdbcExecuteBatchEnd"));
	}

	@Override
	public void cachePutStart() {
		testEvents.add(new TestEvent("cachePutStart"));
	}

	@Override
	public void cachePutEnd() {
		testEvents.add(new TestEvent("cachePutEnd"));
	}

	@Override
	public void cacheGetStart() {
		testEvents.add(new TestEvent("cacheGetStart"));
	}

	@Override
	public void cacheGetEnd(boolean hit) {
		testEvents.add(new TestEvent("cacheGetEnd").prop("hit", hit));
	}

	@Override
	public void flushStart() {
		testEvents.add(new TestEvent("flushStart"));
	}

	@Override
	public void flushEnd(int numberOfEntities, int numberOfCollections) {
		testEvents.add(new TestEvent("flushEnd").prop("numberOfEntities", numberOfEntities).prop("numberOfCollections",
				numberOfCollections));
	}

	@Override
	public void partialFlushStart() {
		testEvents.add(new TestEvent("partialFlushStart"));
	}

	@Override
	public void partialFlushEnd(int numberOfEntities, int numberOfCollections) {
		testEvents.add(new TestEvent("partialFlushEnd").prop("numberOfEntities", numberOfEntities)
				.prop("numberOfCollections", numberOfCollections));
	}

	@Override
	public void dirtyCalculationStart() {
		testEvents.add(new TestEvent("dirtyCalculationStart"));
	}

	@Override
	public void dirtyCalculationEnd(boolean dirty) {
		testEvents.add(new TestEvent("dirtyCalculationEnd").prop("dirty", dirty));
	}

	@Override
	public void end() {
		testEvents.add(new TestEvent("end"));
	}

}
