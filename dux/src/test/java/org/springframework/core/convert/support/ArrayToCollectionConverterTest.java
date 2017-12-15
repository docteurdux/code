package org.springframework.core.convert.support;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ArrayToCollectionConverter.class)
@Related({ DefaultConversionService.class })
public class ArrayToCollectionConverterTest extends AbstractTest {

	private static class C {
		private Object[] objects;
		private ArrayList<Object> collection;
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException {

		ArrayToCollectionConverter c = new ArrayToCollectionConverter(new DefaultConversionService());

		Set<ConvertiblePair> pairs = c.getConvertibleTypes();
		aeq(1, pairs.size());

		ConvertiblePair pair = pairs.iterator().next();
		aeq(Object[].class, pair.getSourceType());
		aeq(Collection.class, pair.getTargetType());

		Field objectsField = C.class.getDeclaredField("objects");
		Field collectionField = C.class.getDeclaredField("collection");
		TypeDescriptor objectsTD = new TypeDescriptor(objectsField);
		TypeDescriptor collectionTD = new TypeDescriptor(collectionField);
		c.matches(objectsTD, collectionTD);

		if (t()) {
			return;
		}

		Object source = null;
		TypeDescriptor sourceType = null;
		TypeDescriptor targetType = null;
		c.convert(source, sourceType, targetType);
		c.matches(sourceType, targetType);
		/*-
		convert(Object, TypeDescriptor, TypeDescriptor)
		matches(TypeDescriptor, TypeDescriptor)
		 */
	}
}
