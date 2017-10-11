package dux.org.springframework.expression.spel.support;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.spel.support.ReflectionHelper;

import dum.org.springframework.expression.DummyTypeConverter;

public class ReflectionHelperTest {

	public static class ConvertAllArgumentsTest {

		public static class EqualToOneAnother {
			@Override
			public boolean equals(Object obj) {
				return (obj instanceof EqualToOneAnother);
			}
		}

		public static class A {
			public void foo(String str) {
			}

			public void foo(Object... objects) {
			}

			public void foo(String str, Object... objects) {
			}
		}

		/**
		 * If the object X is converted into an array containing X as its first element,
		 * then no conversion occurred, comparison is made by object equality
		 */
		@Test
		public void test1() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object[] to = new Object[] { from };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertFalse(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If the object X is converted into an array containing a different object as
		 * its first element, then a conversion occurred, comparison is made by object
		 * equality
		 */
		@Test
		public void test2() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object[] to = new Object[] { new Object() };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * To show that the object equality is used, let's use a type that is always
		 * value-equal to itself : conversion occurred, yet value equality would have
		 * implied no conversion had occurred
		 */
		@Test
		public void test3() throws NoSuchMethodException, SecurityException {

			EqualToOneAnother from = new EqualToOneAnother();
			Object[] to = new Object[] { new EqualToOneAnother() };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * For primitive types, value equality is used
		 */
		@Test
		public void test4() throws NoSuchMethodException, SecurityException {

			int from = 1;
			int[] to = new int[] { 2 };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If conversion yields null, then conversion occurred and isFirstEntryInArray
		 * returns false because the converted object cannot be in there
		 */
		@Test
		public void test5() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object to = null;

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If conversion yields something that is not an array, then conversion occurred
		 * and isFirstEntryInArray returns false because the converted object cannot be
		 * in there, as part of an array
		 */
		@Test
		public void test6() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object to = new Object();

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If conversion yields an empty array, then conversion occurred and
		 * isFirstEntryInArray returns false because the converted object cannot be in
		 * there, as part of an array
		 */
		@Test
		public void test7() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object[] to = new Object[] {};

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If conversion yields a non-empty array whose type is not compatible, then
		 * conversion occurred and isFirstEntryInArray returns false because the
		 * converted object cannot be in there, as part of an array
		 */
		@Test
		public void test8() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			String[] to = new String[] { "s" };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(to, arguments[0]);
		}

		/**
		 * If conversion yields the same object, then no need to call
		 * isFirstEntryInArray
		 */
		@Test
		public void test9() throws NoSuchMethodException, SecurityException {

			Object o = new Object();

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(o, o);

			Object[] arguments = new Object[] { o };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertFalse(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(o, arguments[0]);
		}

		/**
		 * If several arguments are provided for the varargs, they are all converted in
		 * place, i.e. conversion from an object into an array containing that object is
		 * seen as a conversion, and not as equivalent. Equivalence reflects the fact
		 * that calling foo(new Object()) is equivalent to calling foo(new Object[]{new
		 * Object()}), which is not equivalent to calling foo((Object)(new Object[]{new
		 * Object()})). But if more arguments are provided than a single arguments for
		 * the varargs, then an array of arguments is the only possibility
		 */
		@Test
		public void test10() throws NoSuchMethodException, SecurityException {

			Object from = new Object();
			Object[] to = new Object[] { from };

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(from, to);

			Object[] arguments = new Object[] { from, from };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(2, arguments.length);
			Assert.assertEquals(to, arguments[0]);
			Assert.assertEquals(to, arguments[1]);
		}

		/**
		 * If all objects are not converted, then this is reflected in the return value
		 */
		@Test
		public void test11() throws NoSuchMethodException, SecurityException {

			Object o = new Object();

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(o, o);

			Object[] arguments = new Object[] { o, o };

			Method method = A.class.getMethod("foo", Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertFalse(conversionOccured);
			Assert.assertEquals(2, arguments.length);
			Assert.assertEquals(o, arguments[0]);
			Assert.assertEquals(o, arguments[1]);
		}

		/**
		 * Arguments that are not part of the varargs are converted the obvious way
		 */
		@Test
		public void test12() throws NoSuchMethodException, SecurityException {

			String str = "str";
			Object o = new Object();

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(str, str);
			converter.setConvert(o, o);

			Object[] arguments = new Object[] { str, o };

			Method method = A.class.getMethod("foo", String.class, Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertFalse(conversionOccured);
			Assert.assertEquals(2, arguments.length);
			Assert.assertEquals(str, arguments[0]);
			Assert.assertEquals(o, arguments[1]);
		}

		/**
		 * Conversion of those is noted
		 */
		@Test
		public void test13() throws NoSuchMethodException, SecurityException {

			String str = "str";
			String str1 = "str1";
			Object o = new Object();

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(str, str1);
			converter.setConvert(o, o);

			Object[] arguments = new Object[] { str, o };

			Method method = A.class.getMethod("foo", String.class, Object[].class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(2, arguments.length);
			Assert.assertEquals(str1, arguments[0]);
			Assert.assertEquals(o, arguments[1]);
		}

		/**
		 * If the method is not varargs, conversion is done the obvious way
		 */
		@Test
		public void test14() throws NoSuchMethodException, SecurityException {

			String str = "str";

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(str, str);

			Object[] arguments = new Object[] { str, };

			Method method = A.class.getMethod("foo", String.class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertFalse(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(str, arguments[0]);
		}

		/**
		 * And actual conversions are recorded there too
		 */
		@Test
		public void test15() throws NoSuchMethodException, SecurityException {

			String str = "str";
			String str1 = "str1";

			DummyTypeConverter converter = new DummyTypeConverter();
			converter.setConvert(str, str1);

			Object[] arguments = new Object[] { str, };

			Method method = A.class.getMethod("foo", String.class);

			boolean conversionOccured = ReflectionHelper.convertAllArguments(converter, arguments, method);
			Assert.assertTrue(conversionOccured);
			Assert.assertEquals(1, arguments.length);
			Assert.assertEquals(str1, arguments[0]);
		}
	}

	public static interface I {

	}

	public static class A implements I {
		public void foo(String s) {
		}

		public void foo(Object o) {
		}

		public void foo(I i) {
		}

		public void foo(A a) {
		}

		public void foo(int i) {
		}

		public void foo(Integer i) {
		}
	}

	/**
	 * Types match => 0 weight
	 */
	@Test
	public void test1() throws NoSuchMethodException, SecurityException {

		Method method1 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);

		Method method2 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);

		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);

		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(typeDescriptor2);

		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);

		Assert.assertEquals(0, weight);
	}

	/**
	 * Argument subclass of type parameters => 2
	 */
	@Test
	public void test2() throws NoSuchMethodException, SecurityException {

		Method method1 = A.class.getMethod("foo", Object.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);

		Method method2 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);

		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);

		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(typeDescriptor2);

		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);

		Assert.assertEquals(2, weight);
	}

	/**
	 * Param type is interface => weight 1
	 */
	@Test
	public void test3() throws NoSuchMethodException, SecurityException {

		Method method1 = A.class.getMethod("foo", I.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);

		Method method2 = A.class.getMethod("foo", A.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);

		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);

		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(typeDescriptor2);

		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);

		Assert.assertEquals(1, weight);
	}

	/**
	 * Primitive parameter are treated as objects. Here int=>Object is superclass of
	 * Integer, which contributes 2, and anything can be assigned to an object, so
	 * that contributes 2 also
	 */
	@Test
	public void test4() throws NoSuchMethodException, SecurityException {

		Method method1 = A.class.getMethod("foo", int.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);

		Method method2 = A.class.getMethod("foo", Integer.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);

		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);

		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(typeDescriptor2);

		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);

		Assert.assertEquals(4, weight);
	}

	/**
	 * 
	 */
	@Test
	public void test5() throws NoSuchMethodException, SecurityException {

		Method method1 = A.class.getMethod("foo", int.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);

		Method method2 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);

		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);

		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(typeDescriptor2);

		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);

		Assert.assertEquals(Integer.MAX_VALUE, weight);
	}
	
	/**
	 * 
	 */
	@Test
	public void test6() throws NoSuchMethodException, SecurityException {
		
		Method method1 = A.class.getMethod("foo", int.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);
		
		Method method2 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);
		
		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);
		
		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(null);
		
		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);
		
		Assert.assertEquals(Integer.MAX_VALUE, weight);
	}
	
	/**
	 * 
	 */
	@Test
	public void test7() throws NoSuchMethodException, SecurityException {
		
		Method method1 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);
		
		Method method2 = A.class.getMethod("foo", int.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);
		
		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);
		
		List<TypeDescriptor> argTypes = new ArrayList<>();
		argTypes.add(null);
		
		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);
		
		Assert.assertEquals(0, weight);
	}
	
	/**
	 * 
	 */
	@Test
	public void test8() throws NoSuchMethodException, SecurityException {
		
		Method method1 = A.class.getMethod("foo", String.class);
		MethodParameter methodParameter1 = new MethodParameter(method1, 0);
		TypeDescriptor typeDescriptor1 = new TypeDescriptor(methodParameter1);
		
		Method method2 = A.class.getMethod("foo", int.class);
		MethodParameter methodParameter2 = new MethodParameter(method2, 0);
		TypeDescriptor typeDescriptor2 = new TypeDescriptor(methodParameter2);
		
		List<TypeDescriptor> paramTypes = new ArrayList<>();
		paramTypes.add(typeDescriptor1);
		
		List<TypeDescriptor> argTypes = new ArrayList<>();
		
		int weight = ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);
		
		Assert.assertEquals(0, weight);
	}
}
