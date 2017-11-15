package dux.org.hibernate.tool.schema.internal;

import org.hibernate.tool.schema.internal.ExceptionHandlerCollectingImpl;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ExceptionHandlerCollectingImplTest extends AbstractTest {

	private CommandAcceptanceException commandAcceptanceException;

	@Before
	public void before() {
		commandAcceptanceException = new CommandAcceptanceException("message");
	}

	@Test
	public void test() {

		ExceptionHandlerCollectingImpl exceptionHandlerCollectingImpl = new ExceptionHandlerCollectingImpl();

		aeq(0, exceptionHandlerCollectingImpl.getExceptions().size());

		exceptionHandlerCollectingImpl.handleException(commandAcceptanceException);

		aeq(1, exceptionHandlerCollectingImpl.getExceptions().size());
		aeqr(commandAcceptanceException, exceptionHandlerCollectingImpl.getExceptions().get(0));
	}
}
