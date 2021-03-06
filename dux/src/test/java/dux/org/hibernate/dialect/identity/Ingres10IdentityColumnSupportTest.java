package dux.org.hibernate.dialect.identity;

import org.hibernate.MappingException;
import org.hibernate.dialect.identity.Ingres10IdentityColumnSupport;
import org.hibernate.dialect.identity.Ingres9IdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

@Done
public class Ingres10IdentityColumnSupportTest extends AbstractTest {

	private int anyType = 0;

	@Test
	public void test() {

		aeq(Ingres9IdentityColumnSupport.class, Ingres10IdentityColumnSupport.class.getSuperclass());

		Ingres9IdentityColumnSupport ics9 = new Ingres9IdentityColumnSupport();
		Ingres10IdentityColumnSupport ics10 = new Ingres10IdentityColumnSupport();

		// true in ics10
		af(ics9.supportsIdentityColumns());
		at(ics10.supportsIdentityColumns());

		// unchanged
		at(ics9.hasDataTypeInIdentityColumn());
		at(ics10.hasDataTypeInIdentityColumn());

		// throws in ics9
		expect(MappingException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				ics9.getIdentityColumnString(anyType);
			}
		});
		aeq("not null generated by default as identity", ics10.getIdentityColumnString(anyType));

		// null in ics9
		an(ics9.getIdentityInsertString());
		aeq("default", ics10.getIdentityInsertString());

	}
}
