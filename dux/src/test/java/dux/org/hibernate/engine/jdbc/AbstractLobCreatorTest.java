package dux.org.hibernate.engine.jdbc;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.sql.NClob;

import org.hibernate.engine.jdbc.WrappedBlob;
import org.hibernate.engine.jdbc.WrappedClob;
import org.hibernate.engine.jdbc.WrappedNClob;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

import dum.java.sql.DummyBlob;
import dum.java.sql.DummyClob;
import dum.java.sql.DummyNClob;
import dum.org.hibernate.engine.jdbc.DummyAbstractLobCreator;

@Done("found a possible bug in there")
public class AbstractLobCreatorTest extends AbstractTest {

	private DummyBlob blob;
	private DummyClob clob;
	private NClob nclob;

	@Before
	public void before() {
		blob = new DummyBlob();
		clob = new DummyClob();
		nclob = new DummyNClob();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {

		DummyAbstractLobCreator abstractLobCreator = new DummyAbstractLobCreator();
		WrappedBlob wrappedBlob = (WrappedBlob) abstractLobCreator.wrap(blob);
		WrappedClob wrappedClob = (WrappedClob) abstractLobCreator.wrap(clob);
		WrappedNClob wrappedNClob = (WrappedNClob) abstractLobCreator.wrap(nclob);

		for (Object wrapped : new Object[] { wrappedBlob, wrappedClob, wrappedNClob }) {
			at(wrapped instanceof Proxy);
			at(wrapped instanceof Serializable);
		}

		aeqr(blob, ((WrappedBlob) wrappedBlob).getWrappedBlob());
		aeqr(clob, ((WrappedClob) wrappedClob).getWrappedClob());
		aeqr(nclob, ((WrappedNClob) wrappedNClob).getWrappedClob());

		expect(IllegalArgumentException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				// bug
				((WrappedNClob) wrappedNClob).getWrappedNClob();
			}
		});

	}
}
