package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.Chache71IdentityColumnSupport;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Chache71IdentityColumnSupportTest extends AbstractTest {

	private int anyType;
	private String anyTable;
	private String anyColumn;

	@Before
	public void before() {
		anyType = 0;
		anyTable = "anyTable";
		anyColumn = "anyColumn";
	}

	@Test
	public void test() {

		Chache71IdentityColumnSupport ics = new Chache71IdentityColumnSupport();

		at(ics.supportsIdentityColumns());
		at(ics.hasDataTypeInIdentityColumn());
		aeq("identity", ics.getIdentityColumnString(anyType));
		aeq("SELECT LAST_IDENTITY() FROM %TSQL_sys.snf", ics.getIdentitySelectString(anyTable, anyColumn, anyType));
	}
}
