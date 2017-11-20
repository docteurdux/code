package dum.org.hibernate.resource.jdbc.spi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import org.hibernate.resource.jdbc.ResourceRegistry;
import org.hibernate.resource.jdbc.spi.LogicalConnectionImplementor;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.PhysicalJdbcTransaction;

public class DummyLogicalConnectionImplementor implements LogicalConnectionImplementor {

	private ResourceRegistry resourceRegistry;

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection close() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPhysicallyConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResourceRegistry getResourceRegistry() {
		return resourceRegistry;
	}

	public void setResourceRegistry(ResourceRegistry resourceRegistry) {
		this.resourceRegistry = resourceRegistry;
	}

	@Override
	public Connection getPhysicalConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhysicalConnectionHandlingMode getConnectionHandlingMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterStatement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public Connection manualDisconnect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void manualReconnect(Connection suppliedConnection) {
		// TODO Auto-generated method stub

	}

	@Override
	public LogicalConnectionImplementor makeShareableCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhysicalJdbcTransaction getPhysicalJdbcTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serialize(ObjectOutputStream oos) throws IOException {
		// TODO Auto-generated method stub

	}

}
