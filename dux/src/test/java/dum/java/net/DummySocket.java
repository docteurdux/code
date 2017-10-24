package dum.java.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

public class DummySocket extends Socket {

	private InputStream inputStream = new ByteArrayInputStream(new byte[] {});
	private OutputStream outputStream = new ByteArrayOutputStream();

	public DummySocket() {
		super();
	}

	public DummySocket(String a, int b) throws UnknownHostException, IOException {
		super(a, b);
	}

	@SuppressWarnings("deprecation")
	public DummySocket(String a, int b, boolean c) throws IOException {
		super(a, b, c);
	}

	public DummySocket(String a, int b, InetAddress c, int d) throws IOException {
		super(a, b, c, d);
	}

	public DummySocket(InetAddress a, int b) throws IOException {
		super(a, b);
	}

	@SuppressWarnings("deprecation")
	public DummySocket(InetAddress a, int b, boolean c) throws IOException {
		super(a, b, c);
	}

	public DummySocket(InetAddress a, int b, InetAddress c, int d) throws IOException {
		super(a, b, c, d);
	}

	public DummySocket(Proxy a) {
		super(a);
	}

	@Override
	public void bind(SocketAddress bindpoint) throws IOException {
		// TODO Auto-generated method stub
		super.bind(bindpoint);
	}

	@Override
	public synchronized void close() throws IOException {
		// TODO Auto-generated method stub
		super.close();
	}

	@Override
	public void connect(SocketAddress endpoint) throws IOException {
		// TODO Auto-generated method stub
		super.connect(endpoint);
	}

	@Override
	public void connect(SocketAddress endpoint, int timeout) throws IOException {
		// TODO Auto-generated method stub
		super.connect(endpoint, timeout);
	}

	@Override
	public SocketChannel getChannel() {
		// TODO Auto-generated method stub
		return super.getChannel();
	}

	@Override
	public InetAddress getInetAddress() {
		// TODO Auto-generated method stub
		return super.getInetAddress();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public boolean getKeepAlive() throws SocketException {
		// TODO Auto-generated method stub
		return super.getKeepAlive();
	}

	@Override
	public InetAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return super.getLocalAddress();
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return super.getLocalPort();
	}

	@Override
	public SocketAddress getLocalSocketAddress() {
		// TODO Auto-generated method stub
		return super.getLocalSocketAddress();
	}

	@Override
	public boolean getOOBInline() throws SocketException {
		// TODO Auto-generated method stub
		return super.getOOBInline();
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return super.getPort();
	}

	@Override
	public synchronized int getReceiveBufferSize() throws SocketException {
		// TODO Auto-generated method stub
		return super.getReceiveBufferSize();
	}

	@Override
	public SocketAddress getRemoteSocketAddress() {
		// TODO Auto-generated method stub
		return super.getRemoteSocketAddress();
	}

	@Override
	public boolean getReuseAddress() throws SocketException {
		// TODO Auto-generated method stub
		return super.getReuseAddress();
	}

	@Override
	public synchronized int getSendBufferSize() throws SocketException {
		// TODO Auto-generated method stub
		return super.getSendBufferSize();
	}

	@Override
	public int getSoLinger() throws SocketException {
		// TODO Auto-generated method stub
		return super.getSoLinger();
	}

	@Override
	public synchronized int getSoTimeout() throws SocketException {
		// TODO Auto-generated method stub
		return super.getSoTimeout();
	}

	@Override
	public boolean getTcpNoDelay() throws SocketException {
		// TODO Auto-generated method stub
		return super.getTcpNoDelay();
	}

	@Override
	public int getTrafficClass() throws SocketException {
		// TODO Auto-generated method stub
		return super.getTrafficClass();
	}

	@Override
	public boolean isBound() {
		// TODO Auto-generated method stub
		return super.isBound();
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return super.isClosed();
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return super.isConnected();
	}

	@Override
	public boolean isInputShutdown() {
		// TODO Auto-generated method stub
		return super.isInputShutdown();
	}

	@Override
	public boolean isOutputShutdown() {
		// TODO Auto-generated method stub
		return super.isOutputShutdown();
	}

	@Override
	public void sendUrgentData(int data) throws IOException {
		// TODO Auto-generated method stub
		super.sendUrgentData(data);
	}

	@Override
	public void setKeepAlive(boolean on) throws SocketException {
		// TODO Auto-generated method stub
		super.setKeepAlive(on);
	}

	@Override
	public void setOOBInline(boolean on) throws SocketException {
		// TODO Auto-generated method stub
		super.setOOBInline(on);
	}

	@Override
	public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
		// TODO Auto-generated method stub
		super.setPerformancePreferences(connectionTime, latency, bandwidth);
	}

	@Override
	public synchronized void setReceiveBufferSize(int size) throws SocketException {
		// TODO Auto-generated method stub
		super.setReceiveBufferSize(size);
	}

	@Override
	public void setReuseAddress(boolean on) throws SocketException {
		// TODO Auto-generated method stub
		super.setReuseAddress(on);
	}

	@Override
	public synchronized void setSendBufferSize(int size) throws SocketException {
		// TODO Auto-generated method stub
		super.setSendBufferSize(size);
	}

	@Override
	public void setSoLinger(boolean on, int linger) throws SocketException {
		// TODO Auto-generated method stub
		super.setSoLinger(on, linger);
	}

	@Override
	public synchronized void setSoTimeout(int timeout) throws SocketException {
		// TODO Auto-generated method stub
		super.setSoTimeout(timeout);
	}

	@Override
	public void setTcpNoDelay(boolean on) throws SocketException {
		// TODO Auto-generated method stub
		super.setTcpNoDelay(on);
	}

	@Override
	public void setTrafficClass(int tc) throws SocketException {
		// TODO Auto-generated method stub
		super.setTrafficClass(tc);
	}

	@Override
	public void shutdownInput() throws IOException {
		// TODO Auto-generated method stub
		super.shutdownInput();
	}

	@Override
	public void shutdownOutput() throws IOException {
		// TODO Auto-generated method stub
		super.shutdownOutput();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
