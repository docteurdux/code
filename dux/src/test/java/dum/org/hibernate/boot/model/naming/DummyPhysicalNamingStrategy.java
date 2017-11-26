package dum.org.hibernate.boot.model.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyPhysicalNamingStrategy implements PhysicalNamingStrategy {

	private RunnableWithArgs<Identifier> toPhysicalNameRWA;

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		if (toPhysicalNameRWA != null) {
			return toPhysicalNameRWA.run(name, jdbcEnvironment, "catalog");
		}
		return null;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		if (toPhysicalNameRWA != null) {
			return toPhysicalNameRWA.run(name, jdbcEnvironment, "schema");
		}
		return null;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		if (toPhysicalNameRWA != null) {
			return toPhysicalNameRWA.run(name, jdbcEnvironment, "table");
		}
		return null;
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		if (toPhysicalNameRWA != null) {
			return toPhysicalNameRWA.run(name, jdbcEnvironment, "sequence");
		}
		return null;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		if (toPhysicalNameRWA != null) {
			return toPhysicalNameRWA.run(name, jdbcEnvironment, "column");
		}
		return null;
	}

	public void setToPhysicalNameRWA(RunnableWithArgs<Identifier> toPhysicalNameRWA) {
		this.toPhysicalNameRWA = toPhysicalNameRWA;
	}

}
