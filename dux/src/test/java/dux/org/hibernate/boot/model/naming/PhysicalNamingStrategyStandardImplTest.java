package dux.org.hibernate.boot.model.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;

@Done
public class PhysicalNamingStrategyStandardImplTest extends AbstractTest {

	private Identifier identifier;
	private DummyJdbcEnvironment ignoredJdbcEnvironment;

	@Before
	public void before() {
		identifier = new Identifier("identifier", false);
		ignoredJdbcEnvironment = new DummyJdbcEnvironment();
	}

	@Test
	public void test() {

		PhysicalNamingStrategyStandardImpl instance = PhysicalNamingStrategyStandardImpl.INSTANCE;

		aeqr(identifier, instance.toPhysicalCatalogName(identifier, ignoredJdbcEnvironment));
		aeqr(identifier, instance.toPhysicalSchemaName(identifier, ignoredJdbcEnvironment));
		aeqr(identifier, instance.toPhysicalTableName(identifier, ignoredJdbcEnvironment));
		aeqr(identifier, instance.toPhysicalSequenceName(identifier, ignoredJdbcEnvironment));
		aeqr(identifier, instance.toPhysicalColumnName(identifier, ignoredJdbcEnvironment));
	}
}
