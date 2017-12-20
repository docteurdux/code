package dux.java.nio.channels;

import java.nio.channels.MulticastChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MulticastChannel.class)
@Related({ NetworkChannelTest.class, ChannelTest.class })
public class MulticastChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		close()
		join(InetAddress, NetworkInterface)
		join(InetAddress, NetworkInterface, InetAddress)
		 */
	}
}
