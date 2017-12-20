package dux.java.nio.channels;

import java.nio.channels.NetworkChannel;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(NetworkChannel.class)
@Related({ ChannelTest.class, MulticastChannelTest.class })
public class NetworkChannelTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		bind(SocketAddress)
		getLocalAddress()
		getOption(SocketOption<T>)
		setOption(SocketOption<T>, T)
		supportedOptions()
		 */
	}
}
