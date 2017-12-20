package dux.java.nio.channels;

import java.nio.channels.ScatteringByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ScatteringByteChannel.class)
@Related({ ReadableByteChannelTest.class, ChannelTest.class })
public class ScatteringByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		read(ByteBuffer[])
		read(ByteBuffer[], int, int)
		 */
	}
}
