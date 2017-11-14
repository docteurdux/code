package dux.org.hibernate.dialect;

import java.util.Map;

import org.hibernate.dialect.MariaDB53Dialect;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StaticPrecisionFspTimestampFunction;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MariaDB53DialectTest extends AbstractTest {
	@Test
	public void test() {

		MariaDB53Dialect dialect = new MariaDB53Dialect();

		Map<String, SQLFunction> sqlFunctions = dialect.getFunctions();

		aeq(StaticPrecisionFspTimestampFunction.class, sqlFunctions.get("now").getClass());
		aeq(StaticPrecisionFspTimestampFunction.class, sqlFunctions.get("current_timestamp").getClass());
		aeq(StaticPrecisionFspTimestampFunction.class, sqlFunctions.get("localtime").getClass());
		aeq(StaticPrecisionFspTimestampFunction.class, sqlFunctions.get("localtimestamp").getClass());

		aeq(StaticPrecisionFspTimestampFunction.class, sqlFunctions.get("sysdate").getClass());

		at(dialect.isTypeNameRegistered("datetime(6)"));

	}
}
