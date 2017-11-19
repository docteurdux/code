package dum.org.hibernate.dialect.function;

import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummySQLFunction implements SQLFunction {

	private RunnableWithArgs<Type> getReturnTypeRWA;

	@Override
	public boolean hasArguments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasParenthesesIfNoArguments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getReturnType(Type firstArgumentType, Mapping mapping) throws QueryException {
		if (getReturnTypeRWA != null) {
			return getReturnTypeRWA.run(firstArgumentType, mapping);
		}
		return null;
	}

	public void setGetReturnTypeRWA(RunnableWithArgs<Type> getReturnTypeRWA) {
		this.getReturnTypeRWA = getReturnTypeRWA;
	}

	@Override
	public String render(Type firstArgumentType, List arguments, SessionFactoryImplementor factory)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

}
