package dux.org.springframework.dao.support;

import org.junit.Test;
import org.springframework.dao.support.DaoSupport;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.InitializingBeanTest;

@Topic(DaoSupport.class)
@Extends({InitializingBeanTest.class})
@ExtendedBy({})
@Related({})
public class DaoSupportTest extends AbstractTest {
	@Test
	public void test() {

		DaoSupport dao = new DaoSupport() {

			@Override
			protected void checkDaoConfig() throws IllegalArgumentException {
				// TODO Auto-generated method stub

			}
		};

		dao.afterPropertiesSet();

	}
}