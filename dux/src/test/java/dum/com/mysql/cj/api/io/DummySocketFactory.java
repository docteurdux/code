package dum.com.mysql.cj.api.io;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;

import com.mysql.cj.api.io.SocketFactory;

public class DummySocketFactory implements SocketFactory {

	private static Socket afterHandshakeSocket;
	private static Socket beforeHandshakeSocket;
	private static Socket connectSocket;

	@Override
	public Socket afterHandshake() throws SocketException, IOException {
		return afterHandshakeSocket;
	}

	@Override
	public Socket beforeHandshake() throws SocketException, IOException {
		return beforeHandshakeSocket;
	}

	@Override
	public Socket connect(String host, int portNumber, Properties props, int loginTimeout)
			throws SocketException, IOException {
		return connectSocket;
	}

	public static void setAfterHandshakeSocket(Socket afterHandshakeSocket) {
		DummySocketFactory.afterHandshakeSocket = afterHandshakeSocket;
	}

	public static void setBeforeHandshakeSocket(Socket beforeHandshakeSocket) {
		DummySocketFactory.beforeHandshakeSocket = beforeHandshakeSocket;
	}

	public static void setConnectSocket(Socket connectSocket) {
		DummySocketFactory.connectSocket = connectSocket;
	}

}
