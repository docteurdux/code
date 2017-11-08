package dus.neethi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.neethi.AbstractPolicyOperator;
import org.apache.neethi.All;
import org.apache.neethi.Assertion;
import org.apache.neethi.AssertionBuilderFactory;
import org.apache.neethi.AssertionBuilderFactoryImpl;
import org.apache.neethi.Constants;
import org.apache.neethi.ExactlyOne;
import org.apache.neethi.IntersectableAssertion;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyBuilder;
import org.apache.neethi.PolicyComponent;
import org.apache.neethi.PolicyContainingAssertion;
import org.apache.neethi.PolicyEngine;
import org.apache.neethi.PolicyOperator;
import org.apache.neethi.PolicyReference;
import org.apache.neethi.PolicyRegistry;
import org.apache.neethi.PolicyRegistryImpl;
import org.apache.neethi.builders.AssertionBuilder;
import org.apache.neethi.builders.PolicyContainingPrimitiveAssertion;
import org.apache.neethi.builders.PrimitiveAssertion;
import org.apache.neethi.builders.converters.AbstractDOMConverter;
import org.apache.neethi.builders.converters.AbstractOMConverter;
import org.apache.neethi.builders.converters.AbstractStaxConverter;
import org.apache.neethi.builders.converters.Converter;
import org.apache.neethi.builders.converters.ConverterException;
import org.apache.neethi.builders.converters.ConverterRegistry;
import org.apache.neethi.builders.converters.DOMToDOMConverter;
import org.apache.neethi.builders.converters.DOMToOMConverter;
import org.apache.neethi.builders.converters.DOMToStaxConverter;
import org.apache.neethi.builders.converters.OMToDOMConverter;
import org.apache.neethi.builders.converters.OMToOMConverter;
import org.apache.neethi.builders.converters.OMToStaxConverter;
import org.apache.neethi.builders.converters.StaxToDOMConverter;
import org.apache.neethi.builders.converters.StaxToOMConverter;
import org.apache.neethi.builders.converters.StaxToStaxConverter;
import org.apache.neethi.builders.xml.XMLPrimitiveAssertionBuilder;
import org.apache.neethi.builders.xml.XmlPrimitiveAssertion;
import org.apache.neethi.util.PolicyComparator;
import org.apache.neethi.util.PolicyIntersector;
import org.apache.neethi.util.Service;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class NeethiSummaryTest extends AbstractTest {

	@Test
	public void test() {

		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractPolicyOperator.class, All.class, Assertion.class,
				AssertionBuilderFactory.class, AssertionBuilderFactoryImpl.class, Constants.class, ExactlyOne.class,
				IntersectableAssertion.class, Policy.class, PolicyBuilder.class, PolicyComponent.class,
				PolicyContainingAssertion.class, PolicyEngine.class, PolicyOperator.class, PolicyReference.class,
				PolicyRegistry.class, PolicyRegistryImpl.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AssertionBuilder.class, PolicyContainingPrimitiveAssertion.class,
				PrimitiveAssertion.class }));

		classes.addAll(Arrays.asList(new Class<?>[] { AbstractDOMConverter.class, AbstractOMConverter.class,
				AbstractStaxConverter.class, Converter.class, ConverterException.class, ConverterRegistry.class,
				DOMToDOMConverter.class, DOMToOMConverter.class, DOMToStaxConverter.class, OMToDOMConverter.class,
				OMToOMConverter.class, OMToStaxConverter.class, StaxToDOMConverter.class, StaxToOMConverter.class,
				StaxToStaxConverter.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { XmlPrimitiveAssertion.class, XMLPrimitiveAssertionBuilder.class }));

		classes.addAll(
				Arrays.asList(new Class<?>[] { PolicyComparator.class, PolicyIntersector.class, Service.class }));

		summary(classes);

	}
}
