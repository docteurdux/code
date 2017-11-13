package dux.org.hibernate.sql.ordering.antlr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.sql.ordering.antlr.CollationSpecification;
import org.hibernate.sql.ordering.antlr.Factory;
import org.hibernate.sql.ordering.antlr.NodeSupport;
import org.hibernate.sql.ordering.antlr.OrderByFragment;
import org.hibernate.sql.ordering.antlr.OrderByTemplateTokenTypes;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import org.hibernate.sql.ordering.antlr.SortKey;
import org.hibernate.sql.ordering.antlr.SortSpecification;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class FactoryTest extends AbstractTest {

	private Map<Integer, Class<?>> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(OrderByTemplateTokenTypes.ORDER_BY, OrderByFragment.class);
		map.put(OrderByTemplateTokenTypes.SORT_SPEC, SortSpecification.class);
		map.put(OrderByTemplateTokenTypes.ORDER_SPEC, OrderingSpecification.class);
		map.put(OrderByTemplateTokenTypes.COLLATE, CollationSpecification.class);
		map.put(OrderByTemplateTokenTypes.SORT_KEY, SortKey.class);
	}

	@Test
	public void test() {

		Factory factory = new Factory();

		Integer max = null;
		for (Entry<Integer, Class<?>> entry : map.entrySet()) {

			Integer code = entry.getKey();
			Class<?> clazz = entry.getValue();

			aeq(clazz, factory.getASTNodeType(code));

			if (max == null || max < code) {
				max = code;
			}
		}

		aeq(NodeSupport.class, factory.getASTNodeType(max + 1));
	}
}
