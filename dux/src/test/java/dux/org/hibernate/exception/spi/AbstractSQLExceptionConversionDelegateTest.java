package dux.org.hibernate.exception.spi;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.exception.spi.DummyAbstractSQLExceptionConversionDelegate;
import dum.org.hibernate.exception.spi.DummyConversionContext;

@Done
public class AbstractSQLExceptionConversionDelegateTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		DummyConversionContext conversionContext = new DummyConversionContext();

		DummyAbstractSQLExceptionConversionDelegate abstractSQLExceptionConversionDelegate = new DummyAbstractSQLExceptionConversionDelegate(
				conversionContext);

		aeqr(conversionContext, abstractSQLExceptionConversionDelegate.getConversionContext());
	}
}
