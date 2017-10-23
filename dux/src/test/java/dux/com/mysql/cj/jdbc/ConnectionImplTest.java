package dux.com.mysql.cj.jdbc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.api.conf.DatabaseUrlContainer;
import com.mysql.cj.core.conf.url.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

import dum.com.mysql.cj.api.conf.DummyDatabaseUrlContainer;

public class ConnectionImplTest {

	private ServerSocket serverSocket;
	

	@Before
	public void before() throws IOException {

		serverSocket = new ServerSocket(2345);
		new Thread() {
			public void run() {
				try {
					Socket clientSocket = serverSocket.accept();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(clientSocket.getInputStream(), baos);
					clientSocket.close();
					
				} catch (IOException e) {
				}
			};
		}.start();

	}

	@After
	public void after() throws IOException {
		serverSocket.close();
	}

	@Test
	public void test1() throws SQLException {
		DatabaseUrlContainer url = new DummyDatabaseUrlContainer();
		String host = "host";
		int port = 2345;
		String user = "user";
		String password = "passowrd";
		Map<String, String> properties = new HashMap<>();
		HostInfo hostInfo = new HostInfo(url, host, port, user, password, properties);
		ConnectionImpl connection = new ConnectionImpl(hostInfo);
	}
}
