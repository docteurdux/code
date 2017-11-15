package dux.org.hibernate.dialect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PostgreSQL94DialectTest extends AbstractTest {

	private Map<String, Object> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put("make_interval", StandardBasicTypes.TIMESTAMP);
		map.put("make_timestamp", StandardBasicTypes.TIMESTAMP);
		map.put("make_timestamptz", StandardBasicTypes.TIMESTAMP);
		map.put("make_date", StandardBasicTypes.DATE);
		map.put("make_time", StandardBasicTypes.TIME);

	}

	@Test
	public void test() {

		PostgreSQL94Dialect dialect = new PostgreSQL94Dialect();

		for (Entry<String, Object> entry : map.entrySet()) {
			String name = entry.getKey();
			Object type = entry.getValue();
			StandardSQLFunction function = (StandardSQLFunction) dialect.getFunctions().get(name);
			aeq(name, function.getName());
			aeqr(type, function.getType());

		}

	}
}
