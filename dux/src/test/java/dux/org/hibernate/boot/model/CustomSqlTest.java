package dux.org.hibernate.boot.model;

import org.hibernate.boot.model.CustomSql;
import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CustomSqlTest extends AbstractTest {

	private String sql;
	private boolean callable;
	private ExecuteUpdateResultCheckStyle checkStyle;

	@Before
	public void before() {
		sql = "sql";
		callable = true;
		checkStyle = ExecuteUpdateResultCheckStyle.NONE;
	}

	@Test
	public void test() {

		CustomSql customSql = new CustomSql(sql, callable, checkStyle);
		aeq(sql, customSql.getSql());
		aeq(callable, customSql.isCallable());
		aeq(checkStyle, customSql.getCheckStyle());
	}
}
