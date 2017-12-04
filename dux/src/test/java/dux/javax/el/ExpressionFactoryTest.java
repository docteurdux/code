package dux.javax.el;

import java.util.Properties;

import javax.el.ExpressionFactory;

import org.junit.Test;

public class ExpressionFactoryTest {
	@Test
	public void test() {
		Thread.currentThread().getContextClassLoader();
		Properties properties = null;
		ExpressionFactory.newInstance(properties);
	}
}
