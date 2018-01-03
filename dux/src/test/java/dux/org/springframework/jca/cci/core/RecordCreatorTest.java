package dux.org.springframework.jca.cci.core;

import javax.resource.ResourceException;
import javax.resource.cci.RecordFactory;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.RecordCreator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RecordCreator.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class RecordCreatorTest extends AbstractTest {
	@Test
	public void test() throws DataAccessException, ResourceException {

		RecordFactory recordFactory = null;

		RecordCreator o = Recorder.create(RecordCreator.class).p();
		o.createRecord(recordFactory);
	}
}