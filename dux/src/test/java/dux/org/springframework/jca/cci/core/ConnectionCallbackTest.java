package dux.org.springframework.jca.cci.core;

import java.sql.SQLException;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.ConnectionCallback;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConnectionCallback.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionCallbackTest extends AbstractTest {
	@Test
	@SuppressWarnings("rawtypes")
	public void test() throws DataAccessException, ResourceException, SQLException {

		Connection connection = null;
		ConnectionFactory connectionFactory = null;

		ConnectionCallback o = Recorder.create(ConnectionCallback.class).p();
		o.doInConnection(connection, connectionFactory);
	}
}