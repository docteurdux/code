package dux.com.mysql.cj.jdbc;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.core.conf.url.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

import dum.com.mysql.cj.api.conf.DummyDatabaseUrlContainer;
import dum.com.mysql.cj.api.io.DummySocketFactory;
import dum.java.net.DummySocket;

public class ConnectionImplTest {

	@Before
	public void before() {
	}

	@After
	public void after() throws IOException {
	}

	@Test
	public void test1() throws SQLException {

		Socket connectSocket = new DummySocket();
		DummySocketFactory.setConnectSocket(connectSocket);
		DummySocketFactory.setBeforeHandshakeSocket(connectSocket);
		DummySocketFactory.setAfterHandshakeSocket(connectSocket);

		DummyDatabaseUrlContainer url = new DummyDatabaseUrlContainer();
		String databaseUrl = "databaseUrl";
		url.setDatabaseUrl(databaseUrl);
		String host = "host";
		int port = 2345;
		String user = "user";
		String password = "passowrd";
		Map<String, String> properties = new HashMap<>();
		properties.put("socketFactory", "dum.com.mysql.cj.api.io.DummySocketFactory");
		HostInfo hostInfo = new HostInfo(url, host, port, user, password, properties);
		ConnectionImpl connection = new ConnectionImpl(hostInfo);
	}
}
