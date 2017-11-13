package dux.org.hibernate.boot.internal;

import java.io.Serializable;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.boot.internal.StandardEntityNotFoundDelegate;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class StandardEntityNotFoundDelegateTest extends AbstractTest {

	private String anyEntityName;
	private Serializable anyId;

	@Before
	public void before() {
		anyEntityName = "anyEntityName";
		anyId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
	}

	@Test(expected = ObjectNotFoundException.class)
	public void test() {
		StandardEntityNotFoundDelegate.INSTANCE.handleEntityNotFound(anyEntityName, anyId);
	}
}
