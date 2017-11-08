package dux.org.apache.neethi;

import org.apache.neethi.AssertionBuilderFactoryImpl;
import org.apache.neethi.PolicyBuilder;
import org.apache.neethi.builders.converters.ConverterRegistry;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class AssertionBuilderFactoryImplTest extends AbstractTest {
	@Test
	public void test() {
		PolicyBuilder policyBuilder = new PolicyBuilder();
		ConverterRegistry converterRegistry = new ConverterRegistry();
		AssertionBuilderFactoryImpl factory = new AssertionBuilderFactoryImpl(policyBuilder, converterRegistry);
	}
}
