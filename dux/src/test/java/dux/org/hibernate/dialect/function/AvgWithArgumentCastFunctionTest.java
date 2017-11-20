package dux.org.hibernate.dialect.function;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.function.AvgWithArgumentCastFunction;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.type.DummyType;

public class AvgWithArgumentCastFunctionTest extends AbstractTest {
	@Test
	public void test() {
		AvgWithArgumentCastFunction a = new AvgWithArgumentCastFunction("castType");
		DummyType firstArgumentType = new DummyType();
//		firstArgumentType.sqlTypes(mapping)
		List arguments = new ArrayList<>();
		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
		a.render(firstArgumentType, arguments, factory);

	}
}
