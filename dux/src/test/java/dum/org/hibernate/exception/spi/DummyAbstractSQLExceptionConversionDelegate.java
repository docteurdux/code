package dum.org.hibernate.exception.spi;

import java.sql.SQLException;

import org.hibernate.JDBCException;
import org.hibernate.exception.spi.AbstractSQLExceptionConversionDelegate;
import org.hibernate.exception.spi.ConversionContext;

public class DummyAbstractSQLExceptionConversionDelegate extends AbstractSQLExceptionConversionDelegate {

	public DummyAbstractSQLExceptionConversionDelegate(ConversionContext conversionContext) {
		super(conversionContext);
	}

	@Override
	public ConversionContext getConversionContext() {
		return super.getConversionContext();
	}

	@Override
	public JDBCException convert(SQLException sqlException, String message, String sql) {
		return null;
	}

}
