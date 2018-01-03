package dux.org.springframework.jca.cci.object;

import java.sql.SQLException;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.jca.cci.object.MappingRecordOperation;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MappingRecordOperation.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class MappingRecordOperationTest extends AbstractTest {
	@Test
	public void test() {

		ConnectionFactory connectionFactory = null;
		InteractionSpec interactionSpec = null;

		MappingRecordOperation o = new MappingRecordOperation(connectionFactory, interactionSpec) {

			@Override
			protected Object extractOutputData(Record outputRecord)
					throws ResourceException, SQLException, DataAccessException {
				return null;
			}

			@Override
			protected Record createInputRecord(RecordFactory recordFactory, Object inputObject)
					throws ResourceException, DataAccessException {
				return null;
			}
		};

		Object inputObject = null;
		RecordCreator creator = null;

		o.execute(inputObject);
		o.setOutputRecordCreator(creator);
		/*-
		MappingRecordOperation()
		MappingRecordOperation(ConnectionFactory, InteractionSpec)
		execute(Object)
		setOutputRecordCreator(RecordCreator)
		 */
	}
}
