package dum.org.hibernate.engine.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;

import org.hibernate.engine.jdbc.LobCreator;

public class DummyLobCreator implements LobCreator {

	public Blob wrap(Blob blob) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clob wrap(Clob clob) {
		// TODO Auto-generated method stub
		return null;
	}

	public NClob wrap(NClob nclob) {
		// TODO Auto-generated method stub
		return null;
	}

	public Blob createBlob(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}

	public Blob createBlob(InputStream stream, long length) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clob createClob(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clob createClob(Reader reader, long length) {
		// TODO Auto-generated method stub
		return null;
	}

	public NClob createNClob(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public NClob createNClob(Reader reader, long length) {
		// TODO Auto-generated method stub
		return null;
	}

}
