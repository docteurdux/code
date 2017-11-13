package dux.org.hibernate.transform;

import java.util.List;

import org.hibernate.transform.ToListResultTransformer;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ToListResultTransformerTest extends AbstractTest {

	private Object object;
	private Object[] tuples;
	private String[] anyAliases;

	public ToListResultTransformerTest() {
		object = new Object();
		tuples = new Object[] { object };
		anyAliases = new String[] {};
	}

	@Test
	public void test() {

		ToListResultTransformer instance = ToListResultTransformer.INSTANCE;

		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) instance.transformTuple(tuples, anyAliases);

		aeq(1, list.size());
		aeqr(object, list.get(0));
	}
}
