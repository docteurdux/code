package dux.org.hibernate.dialect;

import org.hibernate.dialect.Sybase11Dialect;
import org.hibernate.dialect.SybaseDialect;
import org.hibernate.sql.ANSIJoinFragment;
import org.hibernate.sql.JoinFragment;
import org.hibernate.sql.Sybase11JoinFragment;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Sybase11DialectTest extends AbstractTest {
	@Test
	public void test() {

		aeq(SybaseDialect.class, Sybase11Dialect.class.getSuperclass());

		SybaseDialect dialect = new SybaseDialect();
		Sybase11Dialect dialect11 = new Sybase11Dialect();

		aeq(" cross join ", dialect.getCrossJoinSeparator());
		aeq(", ", dialect11.getCrossJoinSeparator());

		JoinFragment joinFragment = dialect.createOuterJoinFragment();
		aeq(ANSIJoinFragment.class, joinFragment.getClass());

		JoinFragment joinFragment11 = dialect11.createOuterJoinFragment();
		aeq(Sybase11JoinFragment.class, joinFragment11.getClass());
	}
}
