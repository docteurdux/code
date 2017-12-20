package dux.java.nio.channels;

import java.nio.channels.SeekableByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SeekableByteChannel.class)
@Related({ ByteChannelTest.class, FileChannelTest.class })
public class SeekableByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		position()
		position(long)
		read(ByteBuffer)
		size()
		truncate(long)
		write(ByteBuffer)
		 */
	}

}
