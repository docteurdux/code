package dux.org.hibernate.type;

import org.hibernate.type.CalendarTimeType;
import org.hibernate.type.descriptor.java.CalendarTimeTypeDescriptor;
import org.hibernate.type.descriptor.sql.TimeTypeDescriptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CalendarTimeTypeTest extends AbstractTest {

	@Test
	public void test() {

		CalendarTimeType instance = CalendarTimeType.INSTANCE;

		aeq("calendar_time", instance.getName());
		aeqr(TimeTypeDescriptor.INSTANCE, instance.getSqlTypeDescriptor());
		aeqr(CalendarTimeTypeDescriptor.INSTANCE, instance.getJavaTypeDescriptor());
	}
}
