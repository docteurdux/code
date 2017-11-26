package dum.org.hibernate.id.factory.spi;

import java.util.Properties;

import org.hibernate.dialect.Dialect;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
import org.hibernate.type.Type;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyMutableIdentifierGeneratorFactory implements MutableIdentifierGeneratorFactory {

	private RunnableWithArgs<IdentifierGenerator> createIdentifierGeneratorRWA;

	@Override
	public Dialect getDialect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDialect(Dialect dialect) {
		// TODO Auto-generated method stub

	}

	@Override
	public IdentifierGenerator createIdentifierGenerator(String strategy, Type type, Properties config) {
		if (createIdentifierGeneratorRWA != null) {
			return createIdentifierGeneratorRWA.run(strategy, type, config);
		}
		return null;
	}

	public void setCreateIdentifierGeneratorRWA(RunnableWithArgs<IdentifierGenerator> createIdentifierGeneratorRWA) {
		this.createIdentifierGeneratorRWA = createIdentifierGeneratorRWA;
	}

	@Override
	public Class getIdentifierGeneratorClass(String strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(String strategy, Class generatorClass) {
		// TODO Auto-generated method stub

	}

}
