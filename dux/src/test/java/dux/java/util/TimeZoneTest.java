package dux.java.util;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(TimeZone.class)
public class TimeZoneTest extends AbstractTest {
	@Test
	public void test() {

		String[] ids = TimeZone.getAvailableIDs();
		aeq(628, ids.length);

		for (String id : ids) {
			System.out.println(id);
		}
		/*-
		getAvailableIDs()
		getAvailableIDs(int)
		getDefault()
		getTimeZone(String)
		getTimeZone(ZoneId)
		setDefault(TimeZone)
		TimeZone()
		clone()
		getDisplayName()
		getDisplayName(boolean, int)
		getDisplayName(boolean, int, Locale)
		getDisplayName(Locale)
		getDSTSavings()
		getID()
		getOffset(int, int, int, int, int, int)
		getOffset(long)
		getRawOffset()
		hasSameRules(TimeZone)
		inDaylightTime(Date)
		observesDaylightTime()
		setID(String)
		setRawOffset(int)
		toZoneId()
		useDaylightTime()
		 */
	}

	@SuppressWarnings("unused")
	private static class TZ extends TimeZone {

		private static final long serialVersionUID = 1L;

		@Override
		public int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setRawOffset(int offsetMillis) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getRawOffset() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean useDaylightTime() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean inDaylightTime(Date date) {
			// TODO Auto-generated method stub
			return false;
		}

	}
}
