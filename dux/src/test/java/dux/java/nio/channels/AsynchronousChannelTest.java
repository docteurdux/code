package dux.java.nio.channels;

import java.nio.channels.AsynchronousChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AsynchronousChannel.class)
@Related({ ChannelTest.class, AsynchronousByteChannelTest.class })
public class AsynchronousChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		close()
		 */
	}
}
