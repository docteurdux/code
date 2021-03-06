package dum.org.hibernate.hql.spi.id;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyMultiTableBulkIdStrategy extends TestEventCollector implements MultiTableBulkIdStrategy {

	@Override
	public void prepare(JdbcServices jdbcServices, JdbcConnectionAccess connectionAccess, MetadataImplementor metadata,
			SessionFactoryOptions sessionFactoryOptions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(JdbcServices jdbcServices, JdbcConnectionAccess connectionAccess) {
		testEvents.add(
				new TestEvent("release").prop("jdbcServices", jdbcServices).prop("connectionAccess", connectionAccess));
	}

	@Override
	public UpdateHandler buildUpdateHandler(SessionFactoryImplementor factory, HqlSqlWalker walker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteHandler buildDeleteHandler(SessionFactoryImplementor factory, HqlSqlWalker walker) {
		// TODO Auto-generated method stub
		return null;
	}

}
