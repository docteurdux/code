package dux.org.hibernate.tool.schema.extract.internal;

import java.sql.SQLException;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorNoOpImpl;
import org.hibernate.tool.schema.extract.spi.SequenceInformation;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.tool.schema.extract.spi.DummyExtractionContext;

@Done
public class SequenceInformationExtractorNoOpImplTest extends AbstractTest {

	private DummyExtractionContext extractionContext;

	@Before
	public void before() {
		extractionContext = new DummyExtractionContext();
	}

	@Test
	public void test() throws SQLException {

		SequenceInformationExtractorNoOpImpl instance = SequenceInformationExtractorNoOpImpl.INSTANCE;

		Iterable<SequenceInformation> metadata = instance.extractMetadata(extractionContext);

		af(metadata.iterator().hasNext());
	}
}
