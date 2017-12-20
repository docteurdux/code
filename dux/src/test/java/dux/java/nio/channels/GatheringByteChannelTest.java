package dux.java.nio.channels;

import java.nio.channels.GatheringByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(GatheringByteChannel.class)
@Related({ WritableByteChannelTest.class, ChannelTest.class })
public class GatheringByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		 write(ByteBuffer[])
		write(ByteBuffer[], int, int)
		 */
	}
}
