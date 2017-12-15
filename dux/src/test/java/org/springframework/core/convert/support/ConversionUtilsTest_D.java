package org.springframework.core.convert.support;

import org.junit.Test;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.Topic;

@Done
@Topic(ConversionUtils.class)
public class ConversionUtilsTest_D extends AbstractTest {

	private static class C1 {

	}

	private static class C {
		@SuppressWarnings("unused")
		Object object;
		@SuppressWarnings("unused")
		String string;
		@SuppressWarnings("unused")
		C1 c1;
	}

	enum E {

	}

	private Boolean canConvert;

	@Test
	public void test() throws NoSuchFieldException, SecurityException {

		TypeDescriptor objectTD = new TypeDescriptor(C.class.getDeclaredField("object"));
		TypeDescriptor stringTD = new TypeDescriptor(C.class.getDeclaredField("string"));
		TypeDescriptor c1TD = new TypeDescriptor(C.class.getDeclaredField("c1"));

		ConversionService conversionService = Recorder.create(ConversionService.class)
				.r("canConvert", new RunnableWithArgs<Boolean>() {
					@Override
					public Boolean run(Object... args) {
						return canConvert;
					}
				}).p();

		/* conversion to null type is always possible */
		aeq(true, ConversionUtils.canConvertElements(c1TD, null, null));

		/* conversion from null type is assumed possible */
		aeq(true, ConversionUtils.canConvertElements(null, c1TD, null));

		/* if conversion service says it is possible, then it is */
		canConvert = true;
		aeq(true, ConversionUtils.canConvertElements(c1TD, stringTD, conversionService));

		/*
		 * if conversion service says it is not possible, but types are compatible, then
		 * it is assumed possible
		 */
		canConvert = false;
		aeq(true, ConversionUtils.canConvertElements(objectTD, stringTD, conversionService));

		/* otherwise, it's not possible */
		aeq(false, ConversionUtils.canConvertElements(stringTD, objectTD, conversionService));

		/*
		 * invokeConverter just wraps exceptions in a
		 * org.springframework.core.convert.ConversionFailedException, but just rethrows
		 * ConversionFailedException without wrapping them
		 */

		expect(ConversionFailedException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				ConversionUtils.invokeConverter(null, new C(), objectTD, objectTD);
			}

			@Override
			public void inspect(Throwable e) {
				aeq(NullPointerException.class, e.getCause().getClass());
			}
		});

		/* I don't know when this method is actually useful */
		aeq(E.class, ConversionUtils.getEnumType(E.class));

	}
}
