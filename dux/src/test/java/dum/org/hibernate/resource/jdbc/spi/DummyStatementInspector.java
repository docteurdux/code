package dum.org.hibernate.resource.jdbc.spi;

import org.hibernate.resource.jdbc.spi.StatementInspector;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyStatementInspector extends TestEventCollector implements StatementInspector {

	private static final long serialVersionUID = 1L;

	@Override
	public String inspect(String sql) {
		testEvents.add(new TestEvent("inspect").prop("sql", sql));
		return sql;
	}

}
