package dux.org.hibernate.query.internal;

import org.hibernate.query.internal.QueryParameterImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.query.internal.DummyQueryParameterImpl;
import dum.org.hibernate.type.DummyType;

@Done
public class QueryParameterImplTest extends AbstractTest {

	private DummyType type;

	@Before
	public void before() {
		type = new DummyType();
	}

	@Test
	public void test() {
		QueryParameterImpl<String> queryParameterImpl = new DummyQueryParameterImpl<String>(type);
		aeqr(type, queryParameterImpl.getType());
		aeq(String.class, queryParameterImpl.getParameterType());
	}
}
