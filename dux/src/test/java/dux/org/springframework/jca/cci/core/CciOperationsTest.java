package dux.org.springframework.jca.cci.core;

import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;

import org.junit.Test;
import org.springframework.jca.cci.core.CciOperations;
import org.springframework.jca.cci.core.ConnectionCallback;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.jca.cci.core.RecordExtractor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CciOperations.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class CciOperationsTest extends AbstractTest {
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test() {
		
		ConnectionCallback action = null;
		InteractionCallback action1 = null;
		InteractionSpec spec = null;
		Record inputRecord = null;
		RecordCreator inputCreator = null;
		Record outputRecord = null;
		RecordExtractor outputExtractor = null;
		
		CciOperations o = Recorder.create(CciOperations.class).p();

		o.execute(action);
		o.execute(action1);
		o.execute(spec, inputRecord);
		o.execute(spec, inputCreator);
		o.execute(spec, inputRecord, outputRecord);
		o.execute(spec, inputRecord, outputExtractor);
		o.execute(spec, inputCreator, outputExtractor);

		/*-
		execute(InteractionSpec, Record)
		execute(InteractionSpec, Record, Record)
		execute(InteractionSpec, Record, RecordExtractor<T>)
		execute(InteractionSpec, RecordCreator)
		execute(InteractionSpec, RecordCreator, RecordExtractor<T>)
		execute(ConnectionCallback<T>)
		execute(InteractionCallback<T>)
		 */

	}
}
