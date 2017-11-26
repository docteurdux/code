package dum.org.hibernate.engine.jdbc.dialect.spi;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.dialect.spi.DialectFactory;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfoSource;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyDialectFactory implements DialectFactory {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<Dialect> buildDialectRWA;

	@Override
	public Dialect buildDialect(Map configValues, DialectResolutionInfoSource resolutionInfoSource)
			throws HibernateException {
		if (buildDialectRWA != null) {
			return buildDialectRWA.run(configValues, resolutionInfoSource);
		}
		return null;
	}

	public void setBuildDialectRWA(RunnableWithArgs<Dialect> buildDialectRWA) {
		this.buildDialectRWA = buildDialectRWA;
	}

}
