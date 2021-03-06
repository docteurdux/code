package dux.java.nio.channels;

import java.nio.channels.WritableByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(WritableByteChannel.class)
@Related({ ChannelTest.class, ByteChannelTest.class, GatheringByteChannelTest.class })
public class WritableByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		write(ByteBuffer)
		 */
	}
}
