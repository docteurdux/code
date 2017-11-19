package dux.org.hibernate.boot.internal;

import org.hibernate.boot.internal.ClassmateContext;
import org.junit.Test;

import com.fasterxml.classmate.MemberResolver;
import com.fasterxml.classmate.TypeResolver;
import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

@Done
public class ClassmateContextTest extends AbstractTest {
	@Test
	public void test() {

		ClassmateContext classmateContext = new ClassmateContext();
		aeq(TypeResolver.class, classmateContext.getTypeResolver().getClass());
		aeq(MemberResolver.class, classmateContext.getMemberResolver().getClass());

		classmateContext.release();

		expect(IllegalStateException.class, "Classmate context has been released", new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				classmateContext.getTypeResolver();
			}

		});

		expect(IllegalStateException.class, "Classmate context has been released", new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				classmateContext.getMemberResolver();
			}
		});
	}
}
