package dux.org.hibernate.cfg;

import org.hibernate.cfg.UniqueConstraintHolder;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class UniqueConstraintHolderTest extends AbstractTest {
	@Test
	public void test() {

		UniqueConstraintHolder uch = new UniqueConstraintHolder();

		String name = "name";
		an(uch.getName());
		uch.setName(name);
		aeq(name, uch.getName());

		String[] columns = new String[] {};
		an(uch.getColumns());
		uch.setColumns(columns);
		aeqr(columns, uch.getColumns());

	}
}
