package dux.java.nio.channels;

import java.nio.channels.ByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ByteChannel.class)
@Related({ ReadableByteChannelTest.class, WritableByteChannelTest.class, ChannelTest.class,
		SeekableByteChannelTest.class, DatagramChannelTest.class, SocketChannelTest.class })
public class ByteChannelTest extends AbstractTest {
	@Test
	public void test() {

	}
}
