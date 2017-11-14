package dux.org.hibernate.exception.internal;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.internal.SQLStateConverter;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class SQLStateConverterTest extends AbstractTest {

	private String message;
	private String sql;
	private String constraintName;

	private ViolatedConstraintNameExtracter violatedConstraintNameExtracter;
	private SQLException sqlException;

	@Before
	public void before() {

		message = "message";
		sql = "sql";
		constraintName = "constraintName";

		violatedConstraintNameExtracter = new ViolatedConstraintNameExtracter() {
			@Override
			public String extractConstraintName(SQLException sqle) {
				return constraintName;
			}

		};

		sqlException = new SQLException("reason", "23");
	}

	@Test
	public void test() {

		SQLStateConverter sqlStateConverter = new SQLStateConverter(violatedConstraintNameExtracter);

		ConstraintViolationException constraintViolationException = (ConstraintViolationException) sqlStateConverter
				.convert(sqlException, message, sql);

		aeq(constraintName, constraintViolationException.getConstraintName());
		aeq(sql, constraintViolationException.getSQL());
		aeq(message, constraintViolationException.getMessage());

	}
}
