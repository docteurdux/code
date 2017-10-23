package dum.org.hibernate.engine.spi;

import java.util.Set;

import org.hibernate.engine.spi.PersistentAttributeInterceptor;

public class DummyPersistentAttributeInterceptor implements PersistentAttributeInterceptor {

	public Set<String> getInitializedLazyAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public void attributeInitialized(String name) {
		// TODO Auto-generated method stub

	}

	public boolean readBoolean(Object obj, String name, boolean oldValue) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean writeBoolean(Object obj, String name, boolean oldValue, boolean newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	public byte readByte(Object obj, String name, byte oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte writeByte(Object obj, String name, byte oldValue, byte newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public char readChar(Object obj, String name, char oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public char writeChar(Object obj, String name, char oldValue, char newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public short readShort(Object obj, String name, short oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public short writeShort(Object obj, String name, short oldValue, short newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int readInt(Object obj, String name, int oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int writeInt(Object obj, String name, int oldValue, int newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float readFloat(Object obj, String name, float oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float writeFloat(Object obj, String name, float oldValue, float newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double readDouble(Object obj, String name, double oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double writeDouble(Object obj, String name, double oldValue, double newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long readLong(Object obj, String name, long oldValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long writeLong(Object obj, String name, long oldValue, long newValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object readObject(Object obj, String name, Object oldValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object writeObject(Object obj, String name, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
