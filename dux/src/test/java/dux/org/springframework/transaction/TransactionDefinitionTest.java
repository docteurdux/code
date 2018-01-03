package dux.org.springframework.transaction;

import org.junit.Test;
import org.springframework.transaction.TransactionDefinition;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionDefinition.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionDefinitionTest extends AbstractTest {
	@Test
	public void test() {
		TransactionDefinition d = Recorder.create(TransactionDefinition.class).p();
		d.getIsolationLevel();
		d.getName();
		d.getPropagationBehavior();
		d.getTimeout();
		d.isReadOnly();
	}
}