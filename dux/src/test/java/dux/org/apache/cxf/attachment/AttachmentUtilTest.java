package dux.org.apache.cxf.attachment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.activation.CommandInfo;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;

import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.attachment.Base64DecoderStream;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.attachment.LazyAttachmentCollection;
import org.apache.cxf.attachment.LazyDataSource;
import org.apache.cxf.attachment.QuotedPrintableDecoderStream;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Message;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.activation.DummyDataSource;
import dum.org.apache.cxf.message.DummyAttachment;
import dum.org.apache.cxf.message.DummyMessage;

@Done
public class AttachmentUtilTest extends AbstractTest {

	public static enum CCI {
		N, ID, CID, BRACKETS
	}

	@Test
	public void test1() {

		for (CCI cci : CCI.values()) {

			String input = null;
			String expectedOutput = "id";

			switch (cci) {
			case N:
				expectedOutput = "root.message@cxf.apache.org";
				break;
			case ID:
				input = "id";
				break;
			case CID:
				input = "cid:id";
				break;
			case BRACKETS:
				input = "<id>";
				break;
			}

			String actualOutput = AttachmentUtil.cleanContentId(input);
			aeq(expectedOutput, actualOutput);

		}

	}

	public static enum CA {
		BASE, ID, CT, CD, CTE, B64
	};

	@Test
	public void test2() throws Exception {

		for (CA value : CA.values()) {

			System.out.println(value);

			InputStream bais = new ByteArrayInputStream(new byte[] {});
			Map<String, List<String>> headers = new HashMap<>();

			String expectedAttachmentId = "root.message@cxf.apache.org";
			if (value == CA.ID) {
				headers.put("Content-ID", Collections.singletonList("id"));
				expectedAttachmentId = "id";
			}

			String expectedContentType = null;
			if (value == CA.CT) {
				headers.put("Content-Type", Collections.singletonList("contentType"));
				expectedContentType = "contentType";
			}

			String expectedDataSourceName = null;
			if (value == CA.CD) {
				headers.put("Content-Disposition", Collections.singletonList("attachment; filename=foo"));
				expectedDataSourceName = "foo";
			}

			boolean expectedXOP = false;
			boolean expectSameInputStream = true;
			boolean expectCTEHeaderInInput = false;
			boolean expectCTEHeaderInOutput = false;
			if (value == CA.CTE) {
				headers.put("Content-Transfer-Encoding", Collections.singletonList("binary"));
				expectedXOP = true;
				expectCTEHeaderInInput = true;
				expectCTEHeaderInOutput = true;
			} else if (value == CA.B64) {
				headers.put("Content-Transfer-Encoding", Collections.singletonList("base64"));
				expectSameInputStream = false;
				expectCTEHeaderInInput = false;
				expectCTEHeaderInOutput = true;
			}

			Attachment attachment = AttachmentUtil.createAttachment(bais, headers);

			Map<String, String> attachmentHeaders = new HashMap<>();
			Iterator<String> it = attachment.getHeaderNames();
			while (it.hasNext()) {
				String h = it.next();
				System.out.println(h);
				attachmentHeaders.put(h, attachment.getHeader(h));
			}

			DataHandler dataHandler = attachment.getDataHandler();
			AttachmentDataSource attachmentDataSource = (AttachmentDataSource) dataHandler.getDataSource();
			DelegatingInputStream attachementInputStream = (DelegatingInputStream) attachmentDataSource
					.getInputStream();

			Field ct = AttachmentDataSource.class.getDeclaredField("ct");
			ct.setAccessible(true);
			Object actualContentType = ct.get(attachmentDataSource);

			if (expectSameInputStream) {
				aeqr(bais, attachementInputStream.getInputStream());
			} else {

			}

			aeq(expectedAttachmentId, attachment.getId());
			aeq(expectedXOP, attachment.isXOP());
			aeq(expectedDataSourceName, attachmentDataSource.getName());
			aeq(expectedContentType, actualContentType);

			aeq(expectCTEHeaderInInput, headers.containsKey("Content-Transfer-Encoding"));
			aeq(expectCTEHeaderInOutput, attachmentHeaders.containsKey("Content-Transfer-Encoding"));

		}

	}

	public static enum CCID {
		NULL, EMPTY, NOSCHEME, SCHEME, INVALID
	}

	@Test
	public void test3() throws Exception {

		for (CCID ccid : CCID.values()) {

			System.out.println(ccid);

			String input = null;
			String expectedOutput = "ns";
			switch (ccid) {
			case NULL:
				expectedOutput = "cxf.apache.org";
				break;
			case EMPTY:
				input = "";
				expectedOutput = "cxf.apache.org";
				break;
			case NOSCHEME:
				input = "ns";
				break;
			case SCHEME:
				input = "scheme://ns";
				break;
			case INVALID:
				input = "@scheme://ns";
				break;
			}

			String actualOutput = AttachmentUtil.createContentID(input);

			at(actualOutput.endsWith(expectedOutput));

		}
	}

	public static enum CMA {
		NOTXOP, SMALL, NULLMIMETYPE, NONNULLMIMETYPE
	}

	@Test
	public void test4() {

		for (CMA cma : CMA.values()) {

			System.out.println(cma);

			boolean xop = true;
			boolean expectNull = false;

			byte[] bytes = "hello".getBytes();
			int threshold = 1;

			String mimeType = "application/octet-stream";
			String expectedMimeType = "application/octet-stream";

			switch (cma) {
			case NOTXOP:
				xop = false;
				expectNull = true;
				break;
			case SMALL:
				bytes = new byte[] {};
				expectNull = true;
				break;
			case NULLMIMETYPE:
				mimeType = null;
				break;
			case NONNULLMIMETYPE:
				mimeType = "mimeType";
				expectedMimeType = mimeType;
				break;
			}

			Attachment attachment = AttachmentUtil.createMtomAttachment(xop, mimeType, "ns", bytes, 0, bytes.length,
					threshold);

			if (expectNull) {
				an(attachment);
			} else {
				ann(attachment);
				at(attachment.isXOP());
				aeq(expectedMimeType, attachment.getDataHandler().getDataSource().getContentType());
				String id = attachment.getId();
				aeq("ns", id.substring(id.lastIndexOf('@') + 1));
			}
		}
	}

	public static enum CMAFDH {
		NOTXOP, XOP, HASNAME
	}

	@Test
	public void test5() {

		for (CMAFDH cmafdh : CMAFDH.values()) {

			System.out.println(cmafdh);

			DummyDataSource dataSource = new DummyDataSource();
			DummyDataHandler dataHandler = new DummyDataHandler(dataSource);

			boolean xop = true;
			boolean expectNull = false;
			boolean expectContentDisposition = false;

			switch (cmafdh) {
			case NOTXOP:
				xop = false;
				expectNull = true;
				break;
			case XOP:
				break;
			case HASNAME:
				dataHandler.setName("name");
				expectContentDisposition = true;
			}

			Attachment attachment = AttachmentUtil.createMtomAttachmentFromDH(xop, dataHandler, "ns", 0);
			if (expectNull) {
				an(attachment);
			} else {
				at(attachment.isXOP());
				aeqr(dataHandler, attachment.getDataHandler());
				String id = attachment.getId();
				aeq("ns", id.substring(id.lastIndexOf('@') + 1));
				if (expectContentDisposition) {
					aeq("attachment;name=\"name\"", attachment.getHeader("Content-Disposition"));
				} else {
					an(attachment.getHeader("Content-Disposition"));
				}
			}

		}
	}

	public static enum D {
		NULL, BINARY, BIT7, BIT8, BASE64, QUOTED_PRINTABLE, UNKNOWN
	}

	@Test
	public void test6() throws Exception {

		for (D d : D.values()) {

			System.out.println(d);

			InputStream inputStream = new ByteArrayInputStream(new byte[] {});
			String encoding = null;
			boolean expectSameInputStream = false;
			Class<?> expectedClass = null;
			boolean expectIOException = false;
			switch (d) {
			case NULL:
				expectSameInputStream = true;
				break;
			case BINARY:
				encoding = "binary";
				expectSameInputStream = true;
				break;
			case BIT7:
				encoding = "7bit";
				expectSameInputStream = true;
				break;
			case BIT8:
				encoding = "8bit";
				expectSameInputStream = true;
				break;
			case BASE64:
				encoding = "base64";
				expectedClass = Base64DecoderStream.class;
				break;
			case QUOTED_PRINTABLE:
				encoding = "quoted-printable";
				expectedClass = QuotedPrintableDecoderStream.class;
				break;
			case UNKNOWN:
				encoding = "unknown";
				expectIOException = true;
				break;

			}

			Object cex = null;
			try {
				InputStream is = AttachmentUtil.decode(inputStream, encoding);
				if (expectSameInputStream) {
					aeqr(inputStream, is);
				} else {
					aeq(expectedClass, is.getClass());
				}
			} catch (IOException ex) {
				cex = ex;
			}
			if (expectIOException) {
				ann(cex);
			} else {
				an(cex);
			}

		}
	}

	public static enum GADS {
		CID, NOSCHEME, SCHEME, INVALID_SCHEME
	}

	public void test7() {

		for (GADS gads : GADS.values()) {

			System.out.println(gads);

			String contentId = "id";
			Class<?> expectedClass = LazyDataSource.class;
			Class<?> expectedException = null;

			switch (gads) {
			case CID:
				contentId = "cid:id";
				break;
			case NOSCHEME:
				contentId = "id";
				break;
			case SCHEME:
				contentId = "http://id";
				expectedClass = URLDataSource.class;
				break;
			case INVALID_SCHEME:
				contentId = "scheme://id";
				expectedException = Fault.class;
				break;
			}

			Exception cex = null;
			try {
				Collection<Attachment> atts = new ArrayList<>();
				DataSource dataSource = AttachmentUtil.getAttachmentDataSource(contentId, atts);
				aeq(expectedClass, dataSource.getClass());
			} catch (Exception ex) {
				cex = ex;
			}
			if (expectedException != null) {
				aeq(expectedException, cex.getClass());
			}

		}
	}

	public static enum GAPH {
		BASE, NOXOP, NOBRACKET
	};

	@Test
	public void test8() {

		for (GAPH gaph : GAPH.values()) {

			System.out.println(gaph);

			DummyDataSource ds = new DummyDataSource();
			ds.setContentType("contentType");

			DummyDataHandler dh = new DummyDataHandler(ds);
			DummyAttachment attachment = new DummyAttachment();
			attachment.setDataHandler(dh);

			boolean xop = true;
			boolean expectCTE = true;

			String id = "<id>";
			switch (gaph) {
			case BASE:
				break;
			case NOXOP:
				xop = false;
				expectCTE = false;
				break;
			case NOBRACKET:
				id = "id";
				break;
			}

			attachment.setXop(xop);
			attachment.setId(id);

			String headerString = AttachmentUtil.getAttachmentPartHeader(attachment);

			Map<String, String> headers = new HashMap<>();

			Scanner scanner = new Scanner(headerString);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.indexOf(':') == -1) {
					continue;
				}
				String[] parts = line.split(":");
				headers.put(parts[0].trim(), parts[1].trim());
			}
			scanner.close();

			aeq("contentType;", headers.get("content-type"));
			if (expectCTE) {
				aeq("binary", headers.get("Content-Transfer-Encoding"));
			} else {
				af(headers.containsKey("Content-Transfer-Encoding"));
			}
			aeq("<id>", headers.get("Content-ID"));

		}
	}

	public void test9() {
		CommandMap cm = AttachmentUtil.getCommandMap();

		aeq("org.apache.cxf.attachment.AttachmentUtil$EnhancedMailcapCommandMap", cm.getClass().getName());

		Map<String, Map<String, String>> mimeTypes = new HashMap<>();
		for (String mimeType : cm.getMimeTypes()) {
			System.out.println(mimeType);
			HashMap<String, String> commands = new HashMap<String, String>();
			CommandInfo[] cms = cm.getAllCommands(mimeType);
			for (CommandInfo ci : cms) {
				String commandName = ci.getCommandName();
				String commandClass = ci.getCommandClass();
				System.out.println(commandName);
				System.out.println(commandClass);
				commands.put(commandName, commandClass);
			}
			mimeTypes.put(mimeType, commands);
		}

		aeq(4, mimeTypes.size());

		aeq(2, mimeTypes.get("text/*").size());
		aeq("com.sun.activation.viewers.TextViewer", mimeTypes.get("text/*").get("view"));
		aeq("com.sun.activation.viewers.TextEditor", mimeTypes.get("text/*").get("edit"));

		aeq(1, mimeTypes.get("image/*").size());
		aeq("org.apache.cxf.attachment.ImageDataContentHandler", mimeTypes.get("image/*").get("content-handler"));

		aeq(2, mimeTypes.get("image/jpeg").size());
		aeq("org.apache.cxf.attachment.ImageDataContentHandler", mimeTypes.get("image/jpeg").get("content-handler"));
		aeq("com.sun.activation.viewers.ImageViewer", mimeTypes.get("image/jpeg").get("view"));

		aeq(2, mimeTypes.get("image/gif").size());
		aeq("org.apache.cxf.attachment.ImageDataContentHandler", mimeTypes.get("image/gif").get("content-handler"));
		aeq("com.sun.activation.viewers.ImageViewer", mimeTypes.get("image/gif").get("view"));

	}

	@Test
	public void test10() {

		Map<String, DataHandler> dhmap = AttachmentUtil.getDHMap(null);
		aeq(LinkedHashMap.class, dhmap.getClass());

		Collection<Attachment> attachments = new ArrayList<>();
		dhmap = AttachmentUtil.getDHMap(attachments);
		aeq("org.apache.cxf.attachment.AttachmentUtil$DHMap", dhmap.getClass().getName());

		Message message = new DummyMessage();
		AttachmentDeserializer deserializer = new AttachmentDeserializer(message);
		attachments = new LazyAttachmentCollection(deserializer);
		dhmap = AttachmentUtil.getDHMap(attachments);
		aeq("org.apache.cxf.attachment.LazyAttachmentCollection$LazyAttachmentMap", dhmap.getClass().getName());

	}

	@Test
	public void test11() {
		String ubv = AttachmentUtil.getUniqueBoundaryValue();
		at(ubv.startsWith("uuid:"));
	}

	@Test
	public void test12() {
		Message message = new DummyMessage();
		boolean mtom = AttachmentUtil.isMtomEnabled(message);
		af(mtom);
	}

	public static enum ITS {
		NULL, FOUND, NOTFOUND
	}

	@Test
	public void test13() {

		for (ITS its : ITS.values()) {

			String contentType = null;
			boolean expectedSupported = false;
			switch (its) {
			case NULL:
				break;
			case FOUND:
				contentType = "found";
				expectedSupported = true;
				break;
			case NOTFOUND:
				contentType = "other";
				break;
			}

			List<String> types = new ArrayList<>();
			types.add("found");
			boolean actualSupported = AttachmentUtil.isTypeSupported(contentType, types);
			aeq(expectedSupported, actualSupported);
		}
	}

	@Test
	public void test14() throws Exception {

		DummyMessage message = new DummyMessage();
		CachedOutputStream bos = new CachedOutputStream();
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_DIRECTORY, "outputDir");
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq("outputDir", ((File) getField(bos, "outputDir")).getPath());

		message = new DummyMessage();
		bos = new CachedOutputStream();
		File file = new File("outputDir");
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_DIRECTORY, file);
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeqr(file, (File) getField(bos, "outputDir"));

		message = new DummyMessage();
		bos = new CachedOutputStream();
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		an(getField(bos, "outputDir"));

		message = new DummyMessage();
		bos = new CachedOutputStream();
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_MEMORY_THRESHOLD, 10L);
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(10L, bos.getThreshold());

		message = new DummyMessage();
		bos = new CachedOutputStream();
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_MEMORY_THRESHOLD, "10");
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(10L, bos.getThreshold());

		message = new DummyMessage();
		bos = new CachedOutputStream();
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(102400L, bos.getThreshold());

		message = new DummyMessage();
		bos = new CachedOutputStream();
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_MAX_SIZE, 10L);
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(10L, getField(bos, "maxSize"));

		message = new DummyMessage();
		bos = new CachedOutputStream();
		message.getContextualProperties().put(AttachmentDeserializer.ATTACHMENT_MAX_SIZE, "10");
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(10L, getField(bos, "maxSize"));

		message = new DummyMessage();
		bos = new CachedOutputStream();
		AttachmentUtil.setStreamedAttachmentProperties(message, bos);
		aeq(-1L, getField(bos, "maxSize"));

	}
}
