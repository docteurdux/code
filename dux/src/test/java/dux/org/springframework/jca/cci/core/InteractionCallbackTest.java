package dux.org.springframework.jca.cci.core;

import java.sql.SQLException;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.core.InteractionCallback;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(InteractionCallback.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class InteractionCallbackTest extends AbstractTest {
	@Test
	@SuppressWarnings("rawtypes")
	public void test() throws DataAccessException, ResourceException, SQLException {

		Interaction interaction = null;
		ConnectionFactory connectionFactory = null;

		InteractionCallback o = Recorder.create(InteractionCallback.class).p();
		o.doInInteraction(interaction, connectionFactory);
	}
}