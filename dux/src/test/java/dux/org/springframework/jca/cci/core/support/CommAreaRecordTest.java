package dux.org.springframework.jca.cci.core.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.springframework.jca.cci.core.support.CommAreaRecord;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CommAreaRecord.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class CommAreaRecordTest extends AbstractTest {
	@Test
	public void test() throws IOException {

		byte[] bytes = null;
		InputStream in = null;
		String recordName = null;
		String recordShortDescription = null;
		OutputStream out = null;

		CommAreaRecord r = new CommAreaRecord();
		r = new CommAreaRecord(bytes);
		r.clone();
		r.getRecordName();
		r.getRecordShortDescription();
		r.read(in);
		r.setRecordName(recordName);
		r.setRecordShortDescription(recordShortDescription);
		r.toByteArray();
		r.write(out);

		/*-
		CommAreaRecord()
		CommAreaRecord(byte[])
		clone()
		getRecordName()
		getRecordShortDescription()
		read(InputStream)
		setRecordName(String)
		setRecordShortDescription(String)
		toByteArray()
		write(OutputStream)
		 */
	}
}