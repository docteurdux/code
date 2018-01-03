package dux.org.springframework.jca.cci.core;

import java.sql.SQLException;

import javax.resource.ResourceException;
import javax.resource.cci.Record;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.RecordExtractor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RecordExtractor.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class RecordExtractorTest extends AbstractTest {
	@Test
	@SuppressWarnings("rawtypes")
	public void test() throws DataAccessException, ResourceException, SQLException {
		Record record = null;

		RecordExtractor o = Recorder.create(RecordExtractor.class).p();
		o.extractData(record);
	}
}