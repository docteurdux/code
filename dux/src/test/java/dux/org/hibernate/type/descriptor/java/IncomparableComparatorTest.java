package dux.org.hibernate.type.descriptor.java;

import org.hibernate.type.descriptor.java.IncomparableComparator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IncomparableComparatorTest extends AbstractTest {
	@Test
	public void test() {
		aeq(0, IncomparableComparator.INSTANCE.compare(new Object(), new Object()));
	}
}
