package dux.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.model.source.internal.hbm.SizeSourceImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SizeSourceImplTest extends AbstractTest {

	@Test
	public void test() {

		Integer length = 1;
		Integer scale = 2;
		Integer precision = 3;

		SizeSourceImpl sizeSourceImpl = new SizeSourceImpl(length, scale, precision);

		aeq(length, sizeSourceImpl.getLength());
		aeq(scale, sizeSourceImpl.getScale());
		aeq(precision, sizeSourceImpl.getPrecision());
	}
}
