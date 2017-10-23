package dum.org.hibernate.exception.spi;

import java.sql.SQLException;

import org.hibernate.JDBCException;
import org.hibernate.exception.spi.SQLExceptionConverter;

public class DummySQLExceptionConverter implements SQLExceptionConverter {

	private static final long serialVersionUID = 1L;

	@Override
	public JDBCException convert(SQLException sqlException, String message, String sql) {
		return new JDBCException(message, sqlException, sql);
	}

}
