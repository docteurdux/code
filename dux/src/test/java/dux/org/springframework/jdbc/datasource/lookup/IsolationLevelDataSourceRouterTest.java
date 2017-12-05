package dux.org.springframework.jdbc.datasource.lookup;

import org.junit.Test;
import org.springframework.core.Constants;
import org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(IsolationLevelDataSourceRouter.class)
@Related({ Constants.class, TransactionDefinition.class, DefaultTransactionDefinition.class,
		TransactionSynchronizationManager.class })
public class IsolationLevelDataSourceRouterTest extends AbstractTest {
	@Test
	public void test() {
		/* org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter */
	}
}
