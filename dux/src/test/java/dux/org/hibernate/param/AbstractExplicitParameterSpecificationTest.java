package dux.org.hibernate.param;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.param.DummyAbstractExplicitParameterSpecification;
import dum.org.hibernate.type.DummyType;

@Done
public class AbstractExplicitParameterSpecificationTest extends AbstractTest {

	private int sourceLine;
	private int sourceColumn;
	private DummyType expectedType;

	@Before
	public void before() {
		sourceLine = 0;
		sourceColumn = 1;
		expectedType = new DummyType();
	}

	@Test
	public void test() {

		DummyAbstractExplicitParameterSpecification abstractExplicitParameterSpecification = new DummyAbstractExplicitParameterSpecification(
				sourceLine, sourceColumn);
		aeq(sourceLine, abstractExplicitParameterSpecification.getSourceLine());
		aeq(sourceColumn, abstractExplicitParameterSpecification.getSourceColumn());

		an(abstractExplicitParameterSpecification.getExpectedType());
		abstractExplicitParameterSpecification.setExpectedType(expectedType);
		aeqr(expectedType, abstractExplicitParameterSpecification.getExpectedType());
	}
}
