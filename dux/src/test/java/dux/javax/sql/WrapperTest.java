package dux.javax.sql;

import java.sql.SQLException;
import java.sql.Wrapper;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;

@Previous(CommonDataSourceTest.class)
@Next(DataSourceTest.class)
public class WrapperTest extends AbstractTest {

	public static interface A {
		public String foo();
	}

	public static class B implements A {
		@Override
		public String foo() {
			return "foo";
		}
	}

	public static class C implements Wrapper {

		B b = new B();

		@Override
		@SuppressWarnings("unchecked")
		public <T> T unwrap(Class<T> iface) throws SQLException {
			if (Wrapper.class.equals(iface)) {
				return (T) this;
			}
			if (A.class.equals(iface)) {
				return (T) b;
			}
			return null;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return Wrapper.class.equals(iface) || A.class.equals(iface);
		}

	}

	@Test
	public void test() throws SQLException {

		/*
		 * The java.sql.Wrapper interface defines the two methods isWrapperFor and
		 * unwrap
		 */

		/*
		 * The main idea is to allow classes that implement this interface to implement
		 * other interfaces that are not directly specified on the class.
		 */

		/*
		 * As an example, the interface A defines the single method foo and the class B
		 * is an implementation of A.
		 */

		/*
		 * And C is an implementation of java.sql.Wrapper which also claim to be a
		 * wrapper for A
		 */

		C c = new C();
		aeq(true, c.isWrapperFor(Wrapper.class));
		aeq(true, c.isWrapperFor(A.class));

		/*
		 * When asking to unwrap A, C actually returns an instance of B, i.e. C does not
		 * directly implement A
		 */
		aeq("foo", c.unwrap(A.class).foo());
		
		next(DataSourceTest.class);

	}
}
