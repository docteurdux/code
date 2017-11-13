package dux.org.hibernate.type;

import org.hibernate.type.CalendarDateType;
import org.hibernate.type.descriptor.java.CalendarDateTypeDescriptor;
import org.hibernate.type.descriptor.sql.DateTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CalendarDateTypeTest extends AbstractTest {
	@Test
	public void test() {

		CalendarDateType instance = CalendarDateType.INSTANCE;

		aeq("calendar_date", instance.getName());
		aeqr(DateTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(CalendarDateTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());

	}
}
