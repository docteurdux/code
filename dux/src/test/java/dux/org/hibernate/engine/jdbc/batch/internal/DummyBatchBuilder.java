package dux.org.hibernate.engine.jdbc.batch.internal;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.hibernate.engine.jdbc.batch.spi.BatchBuilder;
import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyBatchBuilder implements BatchBuilder {

	private static final long serialVersionUID = 1L;
	private RunnableWithArgs<Batch> buildBatchRWA;

	@Override
	public Batch buildBatch(BatchKey key, JdbcCoordinator jdbcCoordinator) {
		if (buildBatchRWA != null) {
			return buildBatchRWA.run(key, jdbcCoordinator);
		}
		return null;
	}

	public void setBuildBatchRWA(RunnableWithArgs<Batch> buildBatchRWA) {
		this.buildBatchRWA = buildBatchRWA;
	}

}
