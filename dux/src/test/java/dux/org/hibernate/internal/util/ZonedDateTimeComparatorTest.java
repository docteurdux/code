package dux.org.hibernate.internal.util;

import java.time.ZonedDateTime;
import java.util.Comparator;

import org.hibernate.internal.util.ZonedDateTimeComparator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ZonedDateTimeComparatorTest extends AbstractTest {
	@Test
	public void test() {

		ZonedDateTime o1 = ZonedDateTime.now();

		@SuppressWarnings("unchecked")
		Comparator<ZonedDateTime> instance = (Comparator<ZonedDateTime>) ZonedDateTimeComparator.INSTANCE;

		aeq(0, instance.compare(o1, o1));
	}
}
