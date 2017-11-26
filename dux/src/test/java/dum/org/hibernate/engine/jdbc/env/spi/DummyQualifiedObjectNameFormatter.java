package dum.org.hibernate.engine.jdbc.env.spi;

import org.hibernate.boot.model.relational.QualifiedName;
import org.hibernate.boot.model.relational.QualifiedSequenceName;
import org.hibernate.boot.model.relational.QualifiedTableName;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.QualifiedObjectNameFormatter;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyQualifiedObjectNameFormatter implements QualifiedObjectNameFormatter {

	private RunnableWithArgs<String> formatRWA;

	@Override
	public String format(QualifiedTableName qualifiedTableName, Dialect dialect) {
		if (formatRWA != null) {
			return formatRWA.run(qualifiedTableName, dialect);
		}
		return null;
	}

	@Override
	public String format(QualifiedSequenceName qualifiedSequenceName, Dialect dialect) {
		if (formatRWA != null) {
			return formatRWA.run(qualifiedSequenceName, dialect);
		}
		return null;
	}

	@Override
	public String format(QualifiedName qualifiedName, Dialect dialect) {
		if (formatRWA != null) {
			return formatRWA.run(qualifiedName, dialect);
		}
		return null;
	}

	public void setFormatRWA(RunnableWithArgs<String> formatRWA) {
		this.formatRWA = formatRWA;
	}

}
