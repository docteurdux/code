package dux.org.springframework.dao.support;

import java.util.Collection;

import org.junit.Test;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(DataAccessUtils.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class DataAccessUtilsTest extends AbstractTest {
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		
		Collection<?> results=null;
		Class requiredType = null;
		RuntimeException rawException = null;
		PersistenceExceptionTranslator pet = null;
		
		DataAccessUtils.intResult(results);
		DataAccessUtils.longResult(results);
		DataAccessUtils.objectResult(results, requiredType);
		DataAccessUtils.requiredSingleResult(results);
		DataAccessUtils.requiredUniqueResult(results);
		DataAccessUtils.singleResult(results);
		DataAccessUtils.translateIfNecessary(rawException, pet);
		DataAccessUtils.uniqueResult(results);
		
	}
}