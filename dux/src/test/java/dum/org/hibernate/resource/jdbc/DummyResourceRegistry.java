package dum.org.hibernate.resource.jdbc;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.resource.jdbc.ResourceRegistry;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyResourceRegistry extends TestEventCollector implements ResourceRegistry {

	private RunnableWithArgs<Void> releaseRWA;

	@Override
	public boolean hasRegisteredResources() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void releaseResources() {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(Statement statement, boolean cancelable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(Statement statement) {
		testEvents.add(new TestEvent("release").prop("statement", statement));
		if (releaseRWA != null) {
			releaseRWA.run(statement);
		}
	}

	public void setReleaseRWA(RunnableWithArgs<Void> releaseRWA) {
		this.releaseRWA = releaseRWA;
	}

	@Override
	public void register(ResultSet resultSet, Statement statement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(ResultSet resultSet, Statement statement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(Blob blob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(Blob blob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(Clob clob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(Clob clob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(NClob nclob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void release(NClob nclob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelLastQuery() {
		// TODO Auto-generated method stub

	}

}
