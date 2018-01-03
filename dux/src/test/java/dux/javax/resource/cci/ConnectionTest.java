package dux.javax.resource.cci;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(Connection.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		Connection c = Recorder.create(Connection.class).p();

		c.close();
		c.createInteraction();
		c.getLocalTransaction();
		c.getMetaData();
		c.getResultSetInfo();

		/*-
		close()
		createInteraction()
		getLocalTransaction()
		getMetaData()
		getResultSetInfo()
		 */
	}
}