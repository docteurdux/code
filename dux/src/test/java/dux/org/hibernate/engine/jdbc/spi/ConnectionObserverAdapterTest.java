package dux.org.hibernate.engine.jdbc.spi;

import java.sql.Connection;

import org.hibernate.engine.jdbc.spi.ConnectionObserverAdapter;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ConnectionObserverAdapterTest extends AbstractTest {
	private Connection connection;

	@Test
	public void test() {

		ConnectionObserverAdapter coa = new ConnectionObserverAdapter();

		// these methods do nothing
		coa.physicalConnectionObtained(connection);
		coa.physicalConnectionReleased();
		coa.logicalConnectionClosed();
		coa.statementPrepared();
	}
}
