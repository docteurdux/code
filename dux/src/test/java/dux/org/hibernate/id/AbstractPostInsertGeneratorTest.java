package dux.org.hibernate.id;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.id.AbstractPostInsertGenerator;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.PostInsertIdentityPersister;
import org.hibernate.id.insert.InsertGeneratedIdentifierDelegate;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class AbstractPostInsertGeneratorTest extends AbstractTest {

	private Object ignored;
	private DummySharedSessionContractImplementor ignoredSharedSessionContractImplementor;
	private Dialect ignoredDialect;
	private AbstractPostInsertGenerator abstractPostInsertGenerator;

	@Before
	public void before() {

		ignoredDialect = new Dialect() {
		};

		ignored = new Object();
		ignoredSharedSessionContractImplementor = new DummySharedSessionContractImplementor();

		abstractPostInsertGenerator = new AbstractPostInsertGenerator() {
			@Override
			public InsertGeneratedIdentifierDelegate getInsertGeneratedIdentifierDelegate(
					PostInsertIdentityPersister persister, Dialect dialect, boolean isGetGeneratedKeysEnabled)
					throws HibernateException {
				return null;
			}
		};
	}

	@Test
	public void test() {

		aeq(true, abstractPostInsertGenerator.supportsBulkInsertionIdentifierGeneration());

		aeq(null, abstractPostInsertGenerator.determineBulkInsertionIdentifierGenerationSelectFragment(ignoredDialect));

		aeqr(IdentifierGeneratorHelper.POST_INSERT_INDICATOR,
				abstractPostInsertGenerator.generate(ignoredSharedSessionContractImplementor, ignored));
	}
}
