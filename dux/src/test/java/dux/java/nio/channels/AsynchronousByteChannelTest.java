package dux.java.nio.channels;

import java.nio.channels.AsynchronousByteChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AsynchronousByteChannel.class)
@Related({ AsynchronousChannelTest.class, ChannelTest.class })
public class AsynchronousByteChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		read(ByteBuffer)
		read(ByteBuffer, A, CompletionHandler<Integer, ? super A>)
		write(ByteBuffer)
		write(ByteBuffer, A, CompletionHandler<Integer, ? super A>)
		 */
	}
}
