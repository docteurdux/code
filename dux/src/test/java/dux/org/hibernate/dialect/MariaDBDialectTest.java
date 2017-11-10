package dux.org.hibernate.dialect;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MariaDBDialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MariaDBDialectTest extends AbstractTest {
	
	@Test
	public void test() throws Exception {

		aeq(MySQL5Dialect.class, MariaDBDialect.class.getSuperclass());

		MySQL5Dialect dialectMysql5 = new MySQL5Dialect();
		MariaDBDialect dialectMaria = new MariaDBDialect();

		af(dialectMysql5.supportsRowValueConstructorSyntaxInInList());
		at(dialectMaria.supportsRowValueConstructorSyntaxInInList());

		aeqr(InnoDBStorageEngine.INSTANCE, invoke(dialectMaria, "getDefaultMySQLStorageEngine"));

	}
}
