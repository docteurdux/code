package dux.org.hibernate.dialect;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.PostgreSQL92Dialect;
import org.hibernate.dialect.PostgreSQL93Dialect;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PostgreSQL93DialectTest extends AbstractTest {
	private List<String> tableTypesList;

	@Before
	public void before() {
		tableTypesList = new ArrayList<>();
	}

	@Test
	public void test() {

		aeq(PostgreSQL92Dialect.class, PostgreSQL93Dialect.class.getSuperclass());

		PostgreSQL93Dialect dialect = new PostgreSQL93Dialect();

		dialect.augmentRecognizedTableTypes(tableTypesList);

		aeq(1, tableTypesList.size());
		aeq("MATERIALIZED VIEW", tableTypesList.get(0));

	}
}
