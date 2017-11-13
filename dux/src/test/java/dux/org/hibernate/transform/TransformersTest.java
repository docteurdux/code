package dux.org.hibernate.transform;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class TransformersTest extends AbstractTest {

	@Test
	public void test() {
		aeqr(AliasToEntityMapResultTransformer.INSTANCE, Transformers.ALIAS_TO_ENTITY_MAP);
		aeqr(ToListResultTransformer.INSTANCE, Transformers.TO_LIST);
		aeq(AliasToBeanResultTransformer.class, Transformers.aliasToBean(Object.class).getClass());
	}
}
