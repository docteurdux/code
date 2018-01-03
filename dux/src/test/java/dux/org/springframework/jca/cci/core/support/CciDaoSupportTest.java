package dux.org.springframework.jca.cci.core.support;

import javax.resource.cci.ConnectionFactory;

import org.junit.Test;
import org.springframework.jca.cci.core.CciTemplate;
import org.springframework.jca.cci.core.support.CciDaoSupport;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CciDaoSupport.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class CciDaoSupportTest extends AbstractTest {
	@Test
	public void test() {

		CciTemplate cciTemplate = null;
		ConnectionFactory connectionFactory = null;

		CciDaoSupport s = new CciDaoSupport() {
		};
		s.getCciTemplate();
		s.getConnectionFactory();
		s.setCciTemplate(cciTemplate);
		s.setConnectionFactory(connectionFactory);
		
		/*-
		CciDaoSupport()
		getCciTemplate()
		getConnectionFactory()
		setCciTemplate(CciTemplate)
		setConnectionFactory(ConnectionFactory)
		 */
	}
}
