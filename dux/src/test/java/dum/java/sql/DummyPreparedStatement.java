package dum.java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyPreparedStatement extends TestEventCollector implements PreparedStatement {

	private RunnableWithArgs<Void> setObjectRWA;
	private RunnableWithArgs<int[]> executeBatchRWA;
	private RunnableWithArgs<Integer> executeUpdateRWA;

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws SQLException {
		testEvents.add(new TestEvent("close"));
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMaxRows() throws SQLException {
		testEvents.add(new TestEvent("getMaxRows"));
		return 0;
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getQueryTimeout() throws SQLException {
		testEvents.add(new TestEvent("getQueryTimeout"));
		return 0;
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCursorName(String name) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUpdateCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearBatch() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] executeBatch() throws SQLException {
		testEvents.add(new TestEvent("executeBatch"));
		if (executeBatchRWA != null) {
			return executeBatchRWA.run();
		}
		return null;
	}

	public void setExecuteBatchRWA(RunnableWithArgs<int[]> executeBatchRWA) {
		this.executeBatchRWA = executeBatchRWA;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPoolable() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate() throws SQLException {
		testEvents.add(new TestEvent("executeUpdate"));
		if (executeUpdateRWA != null) {
			return executeUpdateRWA.run();
		}
		return 0;
	}

	public void setExecuteUpdateRWA(RunnableWithArgs<Integer> executeUpdateRWA) {
		this.executeUpdateRWA = executeUpdateRWA;
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		testEvents.add(new TestEvent("setLong").prop("parameterIndex", parameterIndex).prop("x", x));

	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		testEvents.add(new TestEvent("setString").prop("parameterIndex", parameterIndex).prop("x", x));
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearParameters() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addBatch() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(int parameter, Object object) throws SQLException {
		setObject(parameter, object, null, null, 2);
	}

	@Override
	public void setObject(int parameter, Object object, int targetSqlType) throws SQLException {
		setObject(parameter, object, targetSqlType, null, 3);
	}

	@Override
	public void setObject(int parameter, Object object, int targetSqlType, int scale) throws SQLException {
		setObject(parameter, object, targetSqlType, scale, 4);
	}

	private void setObject(int parameter, Object object, Integer targetSqlType, Integer scale, int n) {

		Object args[] = new Object[n];
		args[0] = parameter;
		args[1] = object;

		TestEvent testEvent = new TestEvent("setObject").prop("parameter", parameter).prop("object", object);
		if (n > 2) {
			args[2] = targetSqlType;
			testEvent.prop("targetSqlType", targetSqlType);
		}
		if (n > 3) {
			args[3] = scale;
			testEvents.add(testEvent.prop("scale", scale));
		}
		testEvents.add(testEvent);
		if (setObjectRWA != null) {
			setObjectRWA.run(args);
		}
	}

	public void setSetObjectRWA(RunnableWithArgs<Void> setObjectRWA) {
		this.setObjectRWA = setObjectRWA;
	}
}
