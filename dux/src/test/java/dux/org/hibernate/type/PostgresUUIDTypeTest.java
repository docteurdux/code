package dux.org.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import org.hibernate.type.PostgresUUIDType;
import org.hibernate.type.PostgresUUIDType.PostgresUUIDSqlTypeDescriptor;
import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyCallableStatement;
import dum.org.hibernate.type.descriptor.DummyWrapperOptions;
import dum.org.hibernate.type.descriptor.java.DummyJavaTypeDescriptor;

public class PostgresUUIDTypeTest extends AbstractTest {

	public static class A {

	}

	@Test
	public void test() throws SQLException {

		PostgresUUIDType instance = PostgresUUIDType.INSTANCE;

		aeq("pg-uuid", instance.getName());
		PostgresUUIDSqlTypeDescriptor s = PostgresUUIDSqlTypeDescriptor.INSTANCE;
		aeqr(s, instance.getSqlTypeDescriptor());
		aeqr(UUIDTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

		aeq(true, invoke(instance, "registerUnderJavaType"));

		aeq(Types.OTHER, s.getSqlType());
		aeq(true, s.canBeRemapped());

		DummyJavaTypeDescriptor<A> javaTypeDescriptor = new DummyJavaTypeDescriptor<A>();
		UUID uuid = new UUID(0, 0);
		javaTypeDescriptor.setUnwrapRWA(UUID.class, new RunnableWithArgs<UUID>() {
			@Override
			public UUID run(Object... args) {
				return uuid;
			}
		});
		DummyCallableStatement st = new DummyCallableStatement();
		A value = new A();
		String index = "index";
		DummyWrapperOptions options = new DummyWrapperOptions();
		ValueBinder<A> binder = s.getBinder(javaTypeDescriptor);
		binder.bind(st, value, index, options);
		aeqr(uuid, st.getTypedObject("index").getObject());
		
		PreparedStatement ps = new DummyPreparedStatement(); 
		binder.bind(ps, value, index, options);

	}
}
