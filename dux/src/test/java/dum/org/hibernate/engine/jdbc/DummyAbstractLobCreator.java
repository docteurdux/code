package dum.org.hibernate.engine.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;

import org.hibernate.engine.jdbc.AbstractLobCreator;

public class DummyAbstractLobCreator extends AbstractLobCreator {

	@Override
	public Blob createBlob(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob(InputStream stream, long length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob(Reader reader, long length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob(Reader reader, long length) {
		// TODO Auto-generated method stub
		return null;
	}

}
