package dux.org.hibernate.internal.util.compare;

import org.hibernate.internal.util.compare.ComparableComparator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ComparableComparatorTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	private Comparable comparator1;

	@SuppressWarnings("rawtypes")
	private Comparable comparator2;

	@SuppressWarnings("rawtypes")
	public ComparableComparatorTest() {

		comparator1 = new Comparable() {
			@Override
			public int compareTo(Object o) {
				return 30;
			}
		};

		comparator2 = null;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		aeq(30, ComparableComparator.INSTANCE.compare(comparator1, comparator2));
	}
}
