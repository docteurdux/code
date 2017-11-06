package dux.org.apache.cxf.attachment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.message.Message;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.cxf.message.DummyMessage;

@Done
public class AttachmentDataSourceTest extends AbstractTest {
	private String contentType;
	private InputStream bais;
	private AttachmentDataSource ads;

	@Before
	public void before() throws IOException {
		contentType = "contentType";
		bais = new ByteArrayInputStream(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		ads = new AttachmentDataSource(contentType, bais);
	}

	@Test
	public void test1() throws IOException {

		af(ads.isCached());

		InputStream inputStream = ads.getInputStream();

		af(ads.isCached());
		aeq(DelegatingInputStream.class, inputStream.getClass());

		Message message = new DummyMessage();
		ads.cache(message);
		inputStream = ads.getInputStream();

		at(ads.isCached());
		aeq("org.apache.cxf.helpers.LoadingByteArrayOutputStream$LoadedByteArrayInputStream",
				inputStream.getClass().getName());

		ads.hold(message);
		ads.release();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void test2() throws IOException {
		ads.getOutputStream();

	}

	@Test
	public void test3() throws IOException {
		an(ads.getName());
		ads.setName("name");
		aeq("name", ads.getName());
	}

	@Test
	public void test4() throws IOException {
		aeq(contentType, ads.getContentType());
	}

}
