package dum.org.hibernate.resource.jdbc;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.resource.jdbc.ResourceRegistry;

public class DummyResourceRegistry implements ResourceRegistry {

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
		// TODO Auto-generated method stub

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
