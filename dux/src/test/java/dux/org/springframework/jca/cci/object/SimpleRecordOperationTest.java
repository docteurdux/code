package dux.org.springframework.jca.cci.object;

import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;

import org.junit.Test;
import org.springframework.jca.cci.object.SimpleRecordOperation;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SimpleRecordOperation.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SimpleRecordOperationTest extends AbstractTest {
	@Test
	public void test() {

		ConnectionFactory connectionFactory = null;
		InteractionSpec interactionSpec = null;
		Record inputRecord = null;
		Record outputRecord = null;

		SimpleRecordOperation s = new SimpleRecordOperation(connectionFactory, interactionSpec);
		s.execute(inputRecord);
		s.execute(inputRecord, outputRecord);

		/*-
		SimpleRecordOperation()
		SimpleRecordOperation(ConnectionFactory, InteractionSpec)
		execute(Record)
		execute(Record, Record)
		 */
	}
}