package dux.com.mysql.cj.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.InfiniteInputStream;
import com.mysql.cj.core.conf.url.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.mysqla.io.DefaultPacketHeader;
import com.mysql.cj.mysqla.io.MysqlaServerSession;

import dum.com.mysql.cj.api.conf.DummyDatabaseUrlContainer;
import dum.com.mysql.cj.api.io.DummySocketFactory;
import dum.java.net.DummySocket;

public class ConnectionImplTest extends AbstractTest {

	private InfiniteInputStream inputStream;

	@Before
	public void before() {
		inputStream = new InfiniteInputStream();
		inputStream.setSkyLimit(1000000);
	}

	@After
	public void after() throws IOException {
	}

	private void assertBufferSize(byte[] packetLength, byte[] packetSequence, byte[][] parts) {

		int bufferSize = 0;
		for (byte[] buf : parts) {
			bufferSize += buf.length;
		}

		DefaultPacketHeader dph = new DefaultPacketHeader();
		byte[] buf = dph.getBuffer();
		buf[0] = packetLength[0];
		buf[1] = packetLength[1];
		buf[2] = packetLength[2];
		buf[3] = packetSequence[0];

		aeq(bufferSize, dph.getPacketLength());

	}

	@Test
	public void test1() throws SQLException, IOException {

		byte[] packetLength = new byte[] { (byte) (60 & 0xff), 0, 0 };
		byte[] packetSequence = new byte[] { 1 };

		byte[] protocolVersion = new byte[] { 1 };
		byte[] serverVersion = new byte[] { '0', '.', '0', '.', '0', 0 };
		byte[] threadId = new byte[] { 0, 0, 0, 0 };
		byte[] seed = new byte[] { 'h', 'e', 'l', 'l', 'o', 't', 'h', 'e' };
		byte[] filler1 = new byte[] { 0 };
		byte[] serverDefaultCollationIndex = new byte[] { 2 };
		byte[] statusFlags = new byte[] { 3, 4 };
		byte[] reserved = new byte[10];
		byte[] seedPart2 = new byte[] { 's', 'e', 'e', 'd', 'p', 'a', 'r' };
		byte[] authPluginDataLength = new byte[] { (byte) ((seedPart2.length + 8) & 0xff) };
		byte[] whatever = new byte[] { 's', 'h', 'a', '2', '5', '6', '_', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

		int flags = 0;
		flags ^= MysqlaServerSession.CLIENT_SECURE_CONNECTION;
		flags &= ~MysqlaServerSession.CLIENT_COMPRESS;
		flags ^= MysqlaServerSession.CLIENT_PLUGIN_AUTH;

		at((flags & MysqlaServerSession.CLIENT_SECURE_CONNECTION) > 0);
		af((flags & MysqlaServerSession.CLIENT_COMPRESS) > 0);
		at((flags & MysqlaServerSession.CLIENT_PLUGIN_AUTH) > 0);

		byte flags1 = (byte) (flags & 0xff);
		byte flags2 = (byte) ((flags >> 8) & 0xff);
		byte flags3 = (byte) ((flags >> 16) & 0xff);
		byte flags4 = (byte) ((flags >> 24) & 0xff);

		byte[] flags12 = new byte[] { flags1, flags2 };
		byte[] flags34 = new byte[] { flags3, flags4 };

		assertBufferSize(packetLength, packetSequence,
				new byte[][] { protocolVersion, serverVersion, threadId, seed, filler1, flags12,
						serverDefaultCollationIndex, statusFlags, flags34, authPluginDataLength, reserved, seedPart2,
						whatever });

		inputStream.add(packetLength);
		inputStream.add(packetSequence);

		inputStream.add(protocolVersion);
		inputStream.add(serverVersion);
		inputStream.add(threadId);
		inputStream.add(seed);
		inputStream.add(filler1);
		inputStream.add(flags12);
		inputStream.add(serverDefaultCollationIndex);
		inputStream.add(statusFlags);
		inputStream.add(flags34);
		inputStream.add(authPluginDataLength);
		inputStream.add(reserved);
		inputStream.add(seedPart2);
		inputStream.add(whatever);
		inputStream.addEOF();
		inputStream.add(new byte[] {0,0,0,0});
		inputStream.addEOF();
		
		DummySocket socket = new DummySocket();
		socket.setInputStream(inputStream);

		InputStream otherInputStream = new InfiniteInputStream();
		DummySocket otherSocket = new DummySocket();
		otherSocket.setInputStream(otherInputStream);

		DummySocketFactory.setConnectSocket(otherSocket);
		DummySocketFactory.setBeforeHandshakeSocket(socket);
		DummySocketFactory.setAfterHandshakeSocket(otherSocket);

		DummyDatabaseUrlContainer url = new DummyDatabaseUrlContainer();
		String databaseUrl = "databaseUrl";
		url.setDatabaseUrl(databaseUrl);
		String host = "host";
		int port = 2345;
		String user = "user";
		String password = "passowrd";
		Map<String, String> properties = new HashMap<>();
		properties.put("socketFactory", "dum.com.mysql.cj.api.io.DummySocketFactory");
		properties.put("useSSL", "false");
		HostInfo hostInfo = new HostInfo(url, host, port, user, password, properties);

		try {
			ConnectionImpl connection = new ConnectionImpl(hostInfo);
		} finally {
			System.out.println("Infinite count : " + inputStream.getInfiniteCount());
			ByteArrayOutputStream baos = (ByteArrayOutputStream) socket.getOutputStream();
			byte[] bytes = baos.toByteArray();
			System.out.println("Bytes written : ");
			boolean sep = false;
			for (byte b : bytes) {
				if (sep) {
					System.out.print(", ");
				}
				System.out.print(b);
				sep = true;
			}
			System.out.println();
			System.out.println(new String(bytes, "ASCII"));

		}
	}

}
