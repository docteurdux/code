package dux.org.hibernate.cfg.annotations;

import org.hibernate.annotations.OrderBy;
import org.hibernate.cfg.annotations.SetBinder;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class SetBinderTest extends AbstractTest {

	private OrderBy orderBy;

	public static class A {
		@OrderBy(clause = "clause")
		public void foo() {

		}
	}

	public SetBinderTest() {
		orderBy = getAnnotation(A.class, "foo", new Class<?>[] {}, OrderBy.class);
	}

	@Test
	public void test() {
		
		SetBinder binder = new SetBinder(false);

		binder.setSqlOrderBy(orderBy);
		
		binder.bind();
		
		
	}
}
