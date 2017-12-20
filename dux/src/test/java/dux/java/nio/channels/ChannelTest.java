package dux.java.nio.channels;

import java.nio.channels.Channel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.nio.channels.spi.AbstractInterruptibleChannelTest;

@Topic(Channel.class)
@Related({ AbstractInterruptibleChannelTest.class, SelectableChannelTest.class, AsynchronousChannelTest.class,
		InterruptibleChannelTest.class, NetworkChannelTest.class, ReadableByteChannelTest.class,
		WritableByteChannelTest.class })
public class ChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		close()
		isOpen()
		 */
	}
}
