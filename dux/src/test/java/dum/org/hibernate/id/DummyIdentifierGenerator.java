package dum.org.hibernate.id;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyIdentifierGenerator implements IdentifierGenerator {

	private RunnableWithArgs<Serializable> generateRWA;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		if (generateRWA != null) {
			return generateRWA.run(session, object);
		}
		return null;
	}

	public void setGenerateRWA(RunnableWithArgs<Serializable> generateRWA) {
		this.generateRWA = generateRWA;
	}

}
