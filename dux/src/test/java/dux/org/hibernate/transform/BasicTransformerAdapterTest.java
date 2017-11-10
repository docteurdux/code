package dux.org.hibernate.transform;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.BasicTransformerAdapter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BasicTransformerAdapterTest extends AbstractTest {

	private Object[] tuples;
	private String[] aliases;

	@SuppressWarnings("rawtypes")
	private List list;

	@Before
	public void before() {
		tuples = new Object[] {};
		aliases = new String[] {};
		list = new ArrayList<>();
	}

	@Test
	public void test() {

		BasicTransformerAdapter bta = getInstance();

		aeqr(tuples, bta.transformTuple(tuples, aliases));
		aeqr(list, bta.transformList(list));

	}

	private BasicTransformerAdapter getInstance() {

		return new BasicTransformerAdapter() {
			private static final long serialVersionUID = 1L;
		};

	}
}
