package dux.org.springframework.jca.cci.connection;

import javax.resource.cci.Connection;

import org.junit.Test;
import org.springframework.jca.cci.connection.ConnectionHolder;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConnectionHolder.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionHolderTest extends AbstractTest {
	@Test
	public void test() {

		Connection connection = null;
		ConnectionHolder h = new ConnectionHolder(connection);
		h.getConnection();

	}
}
