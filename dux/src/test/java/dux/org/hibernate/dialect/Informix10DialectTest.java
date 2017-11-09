package dux.org.hibernate.dialect;

import org.hibernate.dialect.Informix10Dialect;
import org.hibernate.dialect.InformixDialect;
import org.hibernate.dialect.pagination.Informix10LimitHandler;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Informix10DialectTest extends AbstractTest {
	@Test
	public void test() {
		aeq(InformixDialect.class, Informix10Dialect.class.getSuperclass());

		aeqr(Informix10LimitHandler.INSTANCE, new Informix10Dialect().getLimitHandler());
	}
}
