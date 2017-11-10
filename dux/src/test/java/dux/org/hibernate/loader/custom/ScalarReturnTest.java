package dux.org.hibernate.loader.custom;

import org.hibernate.loader.custom.ScalarReturn;
import org.hibernate.type.Type;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.DummyType;

@Done
public class ScalarReturnTest extends AbstractTest {
	@Test
	public void test() {

		Type type = new DummyType();
		String columnAlias = "columnAlias";

		ScalarReturn sr = new ScalarReturn(type, columnAlias);

		aeqr(type, sr.getType());
		aeqr(columnAlias, sr.getColumnAlias());
	}
}
