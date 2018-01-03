package dux.org.springframework.jca.cci.object;

import java.io.IOException;

import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.InteractionSpec;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.object.MappingCommAreaOperation;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MappingCommAreaOperation.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class MappingCommAreaOperationTest extends AbstractTest {
	@Test
	public void test() {

		ConnectionFactory connectionFactory = null;
		InteractionSpec interactionSpec = null;

		MappingCommAreaOperation o = new MappingCommAreaOperation(connectionFactory, interactionSpec) {

			@Override
			protected byte[] objectToBytes(Object inObject) throws IOException, DataAccessException {
				return null;
			}

			@Override
			protected Object bytesToObject(byte[] bytes) throws IOException, DataAccessException {
				return null;
			}
		};
	}
}
