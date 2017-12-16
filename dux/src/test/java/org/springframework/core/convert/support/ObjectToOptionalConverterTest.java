package org.springframework.core.convert.support;

import java.util.Optional;

import org.junit.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.core.convert.support.DefaultConversionServiceTest;

@Topic(ObjectToOptionalConverter.class)
@Related({ DefaultConversionServiceTest.class })
public class ObjectToOptionalConverterTest extends AbstractTest {

	private static class C1 {

	}

	private static class C2 {

	}

	private static class C3 {

	}

	private static class C {
		private C1 field1 = new C1();
		private C2 field2 = new C2();
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException {
		ConversionService conversionService = new DefaultConversionService();
		ObjectToOptionalConverter c = new ObjectToOptionalConverter(conversionService);
		C3 source = new C3();
		TypeDescriptor sourceType = new TypeDescriptor(C.class.getDeclaredField("field1"));
		TypeDescriptor targetType = new TypeDescriptor(C.class.getDeclaredField("field2"));
		Object result = c.convert(source, sourceType, targetType);
		aeqr(source, Optional.class.cast(result).get());
	}
}
