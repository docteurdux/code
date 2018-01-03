package dux.javax.resource.cci;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConnectionFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionFactoryTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		ConnectionSpec properties = null;

		ConnectionFactory f = Recorder.create(ConnectionFactory.class).p();

		Connection con = f.getConnection();
		f.getConnection(properties);
		f.getMetaData();
		f.getRecordFactory();

		/*-
		getConnection()
		getConnection(ConnectionSpec)
		getMetaData()
		getRecordFactory()
		 */

	}
}