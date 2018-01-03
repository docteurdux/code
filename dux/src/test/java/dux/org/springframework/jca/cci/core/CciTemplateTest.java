package dux.org.springframework.jca.cci.core;

import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;

import org.junit.Test;
import org.springframework.jca.cci.core.CciTemplate;
import org.springframework.jca.cci.core.ConnectionCallback;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.jca.cci.core.RecordExtractor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CciTemplate.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class CciTemplateTest extends AbstractTest {
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test() {

		ConnectionFactory connectionFactory = null;
		ConnectionSpec connectionSpec = null;

		CciTemplate t = new CciTemplate();
		t = new CciTemplate(connectionFactory);
		t = new CciTemplate(connectionFactory, connectionSpec);

		ConnectionCallback action = null;
		InteractionCallback action1 = null;
		InteractionSpec spec = null;
		Record inputRecord = null;
		RecordCreator inputCreator = null;
		Record outputRecord = null;
		RecordExtractor outputExtractor = null;
		RecordCreator creator = null;
		String name = null;

		t.execute(action);
		t.execute(action1);
		t.execute(spec, inputRecord);
		t.execute(spec, inputCreator);
		t.execute(spec, inputRecord, outputRecord);
		t.execute(spec, inputRecord, outputExtractor);
		t.execute(spec, inputCreator, outputExtractor);

		t.afterPropertiesSet();
		t.createIndexedRecord(name);
		t.createMappedRecord(name);

		t.getConnectionFactory();
		t.getConnectionSpec();
		t.getDerivedTemplate(connectionSpec);
		t.getOutputRecordCreator();
		t.setConnectionFactory(connectionFactory);
		t.setConnectionSpec(connectionSpec);
		t.setOutputRecordCreator(creator);
		/*-
		afterPropertiesSet()
		createIndexedRecord(String)
		createMappedRecord(String)
		execute(InteractionSpec, Record)
		execute(InteractionSpec, Record, Record)
		execute(InteractionSpec, Record, RecordExtractor<T>)
		execute(InteractionSpec, RecordCreator)
		execute(InteractionSpec, RecordCreator, RecordExtractor<T>)
		execute(ConnectionCallback<T>)
		execute(InteractionCallback<T>)
		getConnectionFactory()
		getConnectionSpec()
		getDerivedTemplate(ConnectionSpec)
		getOutputRecordCreator()
		setConnectionFactory(ConnectionFactory)
		setConnectionSpec(ConnectionSpec)
		setOutputRecordCreator(RecordCreator)
		 */

	}
}