package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.CUBRIDIdentityColumnSupport;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CUBRIDIdentityColumnSupportTest extends AbstractTest {

	private String anyTable;
	private String anyColumn;
	private int anyType;

	@Before
	public void before() {
		anyTable = "anyTable";
		anyColumn = "anyColumn";
		anyType = 0;
	}

	@Test
	public void test() {

		CUBRIDIdentityColumnSupport ics = new CUBRIDIdentityColumnSupport();

		at(ics.supportsIdentityColumns());
		aeq("NULL", ics.getIdentityInsertString());
		aeq("select last_insert_id()", ics.getIdentitySelectString(anyTable, anyColumn, anyType));
		aeq("not null auto_increment", ics.getIdentityColumnString(anyType));
	}
}
