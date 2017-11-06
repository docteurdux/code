package dux.org.apache.cxf.attachment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.message.Message;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.cxf.message.DummyMessage;

public class AttachmentDeserializerTest extends AbstractTest {

	@Test
	public void test1() throws IOException {

		AttachmentDeserializer ad = new AttachmentDeserializer(null);

		at(ad.isLazyLoading());
		ad.setLazyLoading(false);
		af(ad.isLazyLoading());

	}

	@Test(expected = IllegalStateException.class)
	public void test2() throws IOException {

		DummyMessage message = new DummyMessage();
		AttachmentDeserializer ad = new AttachmentDeserializer(message);

		ad.initializeAttachments();

	}

	@Test(expected = IllegalStateException.class)
	public void test3() throws IOException {

		DummyMessage message = new DummyMessage();

		message.put(Message.CONTENT_TYPE, "multipart/related");

		AttachmentDeserializer ad = new AttachmentDeserializer(message);

		ad.initializeAttachments();

	}

	@Test
	public void test5() throws IOException {

		DummyMessage message = new DummyMessage();

		message.put(Message.CONTENT_TYPE, "multipart/related;boundary=youpi");

		String content = "--youpi\n" + "HeaderName: HeaderValue\n" + "Content-Type:hello;charset=utf8";
		ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
		message.setContent(InputStream.class, bais);

		AttachmentDeserializer ad = new AttachmentDeserializer(message);

		ad.initializeAttachments();

		ann(message.get(AttachmentDeserializer.ATTACHMENT_PART_HEADERS));
		ann(message.get(Message.ENCODING));

	}
}
