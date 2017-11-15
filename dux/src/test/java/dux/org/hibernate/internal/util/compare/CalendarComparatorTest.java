package dux.org.hibernate.internal.util.compare;

import java.util.Calendar;

import org.hibernate.internal.util.compare.CalendarComparator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CalendarComparatorTest extends AbstractTest {

	@Test
	public void test() {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal1.clone();

		aeq(0, CalendarComparator.INSTANCE.compare(cal1, cal2));

		cal2.add(Calendar.MILLISECOND, 1);
		aeq(-1, CalendarComparator.INSTANCE.compare(cal1, cal2));

		cal2.add(Calendar.MILLISECOND, -2);
		aeq(1, CalendarComparator.INSTANCE.compare(cal1, cal2));
	}
}
