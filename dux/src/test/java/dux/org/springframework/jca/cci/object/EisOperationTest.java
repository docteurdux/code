package dux.org.springframework.jca.cci.object;

import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.InteractionSpec;

import org.junit.Test;
import org.springframework.jca.cci.core.CciTemplate;
import org.springframework.jca.cci.object.EisOperation;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(EisOperation.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class EisOperationTest extends AbstractTest {
	@Test
	public void test() {
		EisOperation o = new EisOperation() {
		};

		CciTemplate cciTemplate = null;
		ConnectionFactory connectionFactory = null;
		InteractionSpec interactionSpec = null;
		
		o.afterPropertiesSet();
		o.getCciTemplate();
		o.getInteractionSpec();
		o.setCciTemplate(cciTemplate);
		o.setConnectionFactory(connectionFactory);
		o.setInteractionSpec(interactionSpec);
		
		/*-
		afterPropertiesSet()
		getCciTemplate()
		getInteractionSpec()
		setCciTemplate(CciTemplate)
		setConnectionFactory(ConnectionFactory)
		setInteractionSpec(InteractionSpec)
		 */
	}
}
