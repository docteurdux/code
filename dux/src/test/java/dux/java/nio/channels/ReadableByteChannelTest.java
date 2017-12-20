package dux.java.nio.channels;

import java.nio.channels.ReadableByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ReadableByteChannel.class)
@Related({ ChannelTest.class, ByteChannelTest.class, ScatteringByteChannelTest.class })
public class ReadableByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		read(ByteBuffer)
		 */
	}
}
