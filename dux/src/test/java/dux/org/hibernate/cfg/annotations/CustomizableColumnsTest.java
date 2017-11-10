package dux.org.hibernate.cfg.annotations;

import javax.persistence.Column;

import org.hibernate.annotations.Columns;
import org.hibernate.cfg.annotations.CustomizableColumns;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CustomizableColumnsTest extends AbstractTest {
	@Test
	public void test() {

		Column[] columns = new Column[] {};

		CustomizableColumns cc = new CustomizableColumns(columns);

		aeq(Columns.class, cc.annotationType());
		aeqr(columns, cc.columns());
	}
}
