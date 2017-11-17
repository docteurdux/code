package dux.org.hibernate.type;

import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import org.hibernate.type.PostgresUUIDType;
import org.hibernate.type.PostgresUUIDType.PostgresUUIDSqlTypeDescriptor;
import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;

import dum.java.sql.DummyCallableStatement;
import dum.java.sql.DummyPreparedStatement;
import dum.java.sql.DummyResultSet;
import dum.org.hibernate.type.descriptor.DummyWrapperOptions;
import dum.org.hibernate.type.descriptor.java.DummyJavaTypeDescriptor;

@Done
public class PostgresUUIDTypeTest extends AbstractTest {

	private DummyWrapperOptions wrapperOptions;
	private UUID uuid;
	private RunnableWithArgs<UUID> unwrapRWA;
	private DummyJavaTypeDescriptor<A> aJavaTypeDescriptor;
	private DummyCallableStatement callableStatement;
	private DummyPreparedStatement preparedStatement;
	private A a;
	private RunnableWithArgs<A> wrapRWA;
	private DummyResultSet resultSet;

	public static class A {

	}

	public PostgresUUIDTypeTest() {
	}

	@Before
	public void before() {

		wrapperOptions = new DummyWrapperOptions();

		a = new A();
		uuid = new UUID(0, 0);

		unwrapRWA = new RunnableWithArgs<UUID>() {
			@Override
			public UUID run(Object... args) {
				return uuid;
			}
		};

		wrapRWA = new RunnableWithArgs<A>() {
			@Override
			public A run(Object... args) {
				return a;
			}
		};

		aJavaTypeDescriptor = new DummyJavaTypeDescriptor<A>();
		aJavaTypeDescriptor.setUnwrapRWA(unwrapRWA);
		aJavaTypeDescriptor.setWrapRWA(wrapRWA);

		callableStatement = new DummyCallableStatement();
		preparedStatement = new DummyPreparedStatement();
		resultSet = new DummyResultSet();
	}

	@Test
	public void test1() {
		PostgresUUIDType type = PostgresUUIDType.INSTANCE;
		aeq("pg-uuid", type.getName());
		aeqr(PostgresUUIDSqlTypeDescriptor.INSTANCE, type.getSqlTypeDescriptor());
		aeqr(UUIDTypeDescriptor.INSTANCE, type.getJavaTypeDescriptor());
		aeq(true, invoke(type, "registerUnderJavaType"));
	}

	@Test
	public void test2() {
		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;
		aeq(Types.OTHER, sqlTypeDescriptor.getSqlType());
		aeq(true, sqlTypeDescriptor.canBeRemapped());
	}

	@Test
	public void test3() throws SQLException {

		callableStatement.setSetObjectRWA(new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				aeq("parameter", args[0]);
				aeqr(uuid, args[1]);
				return null;
			}
		});

		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;

		ValueBinder<A> binder = sqlTypeDescriptor.getBinder(aJavaTypeDescriptor);

		binder.bind(callableStatement, new A(), "parameter", wrapperOptions);

		aeq(1, callableStatement.getTestEvents().size());

		TestEvent testEvent = getTestEvent(callableStatement, 0);
		aeq("setObject", testEvent.getName());
		aeqr("parameter", testEvent.prop("parameter"));
		aeqr(uuid, testEvent.prop("object"));
	}

	@Test
	public void test4() throws SQLException {

		preparedStatement.setSetObjectRWA(new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				aeq(1, args[0]);
				aeqr(uuid, args[1]);
				return null;
			}
		});

		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;

		ValueBinder<A> binder = sqlTypeDescriptor.getBinder(aJavaTypeDescriptor);

		binder.bind(preparedStatement, new A(), 1, wrapperOptions);

		aeq(1, preparedStatement.getTestEvents().size());
		TestEvent testEvent = getTestEvent(preparedStatement, 0);
		aeq("setObject", testEvent.getName());
		aeqr(1, testEvent.prop("parameter"));
		aeqr(uuid, testEvent.prop("object"));
	}

	@Test
	public void test5() throws SQLException {

		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;

		ValueExtractor<A> extractor = sqlTypeDescriptor.getExtractor(aJavaTypeDescriptor);

		A result = extractor.extract(callableStatement, 7, wrapperOptions);

		aeq(1, callableStatement.getTestEvents().size());
		TestEvent testEvent = getTestEvent(callableStatement, 0);
		aeq("getObject", testEvent.getName());
		aeq(7, testEvent.prop("parameter"));

		aeqr(a, result);

	}

	@Test
	public void test6() throws SQLException {

		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;

		ValueExtractor<A> extractor = sqlTypeDescriptor.getExtractor(aJavaTypeDescriptor);

		A result = extractor.extract(callableStatement, new String[] { "name" }, wrapperOptions);

		aeq(1, callableStatement.getTestEvents().size());
		TestEvent testEvent = getTestEvent(callableStatement, 0);
		aeq("getObject", testEvent.getName());
		aeq("name", testEvent.prop("parameter"));

		aeqr(a, result);

	}

	@Test
	public void test7() throws SQLException {

		PostgresUUIDSqlTypeDescriptor sqlTypeDescriptor = PostgresUUIDSqlTypeDescriptor.INSTANCE;

		ValueExtractor<A> extractor = sqlTypeDescriptor.getExtractor(aJavaTypeDescriptor);

		A result = extractor.extract(resultSet, "name", wrapperOptions);

		aeq(1, resultSet.getTestEvents().size());
		TestEvent testEvent = getTestEvent(resultSet, 0);
		aeq("getObject", testEvent.getName());
		aeq("name", testEvent.prop("column"));

		aeqr(a, result);

	}
}
