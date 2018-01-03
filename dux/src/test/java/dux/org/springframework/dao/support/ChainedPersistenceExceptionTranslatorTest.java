package dux.org.springframework.dao.support;

import org.junit.Test;
import org.springframework.dao.support.ChainedPersistenceExceptionTranslator;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ChainedPersistenceExceptionTranslator.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ChainedPersistenceExceptionTranslatorTest extends AbstractTest {
	@Test
	public void test() {

		ChainedPersistenceExceptionTranslator t = new ChainedPersistenceExceptionTranslator();

		PersistenceExceptionTranslator pet = null;
		RuntimeException ex = null;

		t.addDelegate(pet);
		t.getDelegates();
		t.translateExceptionIfPossible(ex);

		/*-
		ChainedPersistenceExceptionTranslator()
		addDelegate(PersistenceExceptionTranslator)
		getDelegates()
		translateExceptionIfPossible(RuntimeException)
		 */
	}
}
