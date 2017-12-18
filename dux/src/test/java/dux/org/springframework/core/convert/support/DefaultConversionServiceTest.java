package dux.org.springframework.core.convert.support;

import org.junit.Test;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.support.DefaultConversionService;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(DefaultConversionService.class)
public class DefaultConversionServiceTest extends AbstractTest {

	private static class C1 {

	}

	private static class C2 {

	}

	@Test
	public void test() {

		ConversionService s = DefaultConversionService.getSharedInstance();

		expect(ConverterNotFoundException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				s.convert(new C1(), C2.class);
			}
		});

		aeq(null, s.convert(null, C2.class));

		expect(ConversionFailedException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				aeq(null, s.convert(null, int.class));
			}
		});

		aeq(1L, s.convert(1, Long.class));

		ConverterFactory<?, ?> factory = null;
		((ConverterRegistry) s).addConverterFactory(factory);

		/*-
		addCollectionConverters(ConverterRegistry)
		addDefaultConverters(ConverterRegistry)
		getSharedInstance()
		 */

		/*-
		addConverter(Class<S>, Class<T>, Converter<? super S, ? extends T>)
		addConverter(Converter<?, ?>)
		addConverter(GenericConverter)
		addConverterFactory(ConverterFactory<?, ?>)
		canBypassConvert(TypeDescriptor, TypeDescriptor)
		canConvert(Class<?>, Class<?>)
		canConvert(TypeDescriptor, TypeDescriptor)
		convert(Object, Class<T>)
		convert(Object, TypeDescriptor)
		convert(Object, TypeDescriptor, TypeDescriptor)
		removeConvertible(Class<?>, Class<?>)
		toString()
		 */
	}
}
