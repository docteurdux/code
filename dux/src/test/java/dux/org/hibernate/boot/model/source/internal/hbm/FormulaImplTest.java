package dux.org.hibernate.boot.model.source.internal.hbm;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class FormulaImplTest extends AbstractTest {
	@Test
	public void test() throws ClassNotFoundException {
		aeq(true, isPackage(Class.forName("org.hibernate.boot.model.source.internal.hbm.FormulaImpl")));

	}
}
