package dud.java.sql;

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

import com.github.docteurdux.test.Delegating;
import com.github.docteurdux.test.TestEvents;

public class DelegatingPreparedStatement implements Delegating, PreparedStatement {

	private PreparedStatement delegate;

	public DelegatingPreparedStatement(PreparedStatement delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object getTestDelegate() {
		return delegate;
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		return TestEvents.record(delegate, "executeQuery", sql).result(delegate.executeQuery(sql));
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		return TestEvents.record(delegate, "executeUpdate", sql).result(delegate.executeUpdate(sql));
	}

	@Override
	public void close() throws SQLException {
		TestEvents.record(delegate, "close");
		delegate.close();
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return TestEvents.record(delegate, "getMaxFieldSize").result(delegate.getMaxFieldSize());
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		TestEvents.record(delegate, "setMaxFieldSize", max);
		delegate.setMaxFieldSize(max);

	}

	@Override
	public int getMaxRows() throws SQLException {
		return TestEvents.record(delegate, "getMaxRows").result(delegate.getMaxRows());
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		TestEvents.record(delegate, "setMaxRows", max);
		delegate.setMaxRows(max);

	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		TestEvents.record(delegate, "setEscapeProcessing", enable);
		delegate.setEscapeProcessing(enable);

	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return TestEvents.record(delegate, "getQueryTimeout").result(delegate.getQueryTimeout());
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		TestEvents.record(delegate, "setQueryTimeout", seconds);
		delegate.setQueryTimeout(seconds);

	}

	@Override
	public void cancel() throws SQLException {
		TestEvents.record(delegate, "cancel");
		delegate.cancel();

	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return TestEvents.record(delegate, "getWarnings").result(delegate.getWarnings());
	}

	@Override
	public void clearWarnings() throws SQLException {
		TestEvents.record(delegate, "clearWarnings");
		delegate.clearWarnings();

	}

	@Override
	public void setCursorName(String name) throws SQLException {
		TestEvents.record(delegate, "setCursorName", name);
		delegate.setCursorName(name);

	}

	@Override
	public boolean execute(String sql) throws SQLException {
		return TestEvents.record(delegate, "execute", sql).result(delegate.execute(sql));
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return TestEvents.record(delegate, "getResultSet").result(delegate.getResultSet());
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return TestEvents.record(delegate, "getUpdateCount").result(delegate.getUpdateCount());
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return TestEvents.record(delegate, "getMoreResults").result(delegate.getMoreResults());
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		TestEvents.record(delegate, "setFetchDirection", direction);
		delegate.setFetchDirection(direction);

	}

	@Override
	public int getFetchDirection() throws SQLException {
		return TestEvents.record(delegate, "getFetchDirection").result(delegate.getFetchDirection());
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		TestEvents.record(delegate, "setFetchSize", rows);
		delegate.setFetchSize(rows);
	}

	@Override
	public int getFetchSize() throws SQLException {
		return TestEvents.record(delegate, "getFetchSize").result(delegate.getFetchSize());
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return TestEvents.record(delegate, "getResultSetConcurrency").result(delegate.getResultSetConcurrency());
	}

	@Override
	public int getResultSetType() throws SQLException {
		return TestEvents.record(delegate, "getResultSetType").result(delegate.getResultSetType());
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		TestEvents.record(delegate, "addBatch", sql);
		delegate.addBatch(sql);
	}

	@Override
	public void clearBatch() throws SQLException {
		TestEvents.record(delegate, "clearBatch");
		delegate.clearBatch();
	}

	@Override
	public int[] executeBatch() throws SQLException {
		return TestEvents.record(delegate, "executeBatch").result(delegate.executeBatch());
	}

	@Override
	public Connection getConnection() throws SQLException {
		return TestEvents.record(delegate, "getConnection").result(delegate.getConnection());
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		return TestEvents.record(delegate, "getMoreResults", current).result(delegate.getMoreResults(current));
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return TestEvents.record(delegate, "getGeneratedKeys").result(delegate.getGeneratedKeys());
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return TestEvents.record(delegate, "executeUpdate", sql, autoGeneratedKeys)
				.result(delegate.executeUpdate(sql, autoGeneratedKeys));
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return TestEvents.record(delegate, "executeUpdate", sql, columnIndexes)
				.result(delegate.executeUpdate(sql, columnIndexes));
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		return TestEvents.record(delegate, "executeUpdate", sql, columnNames)
				.result(delegate.executeUpdate(sql, columnNames));
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		return TestEvents.record(delegate, "execute", sql, autoGeneratedKeys)
				.result(delegate.execute(sql, autoGeneratedKeys));
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return TestEvents.record(delegate, "execute", sql, columnIndexes).result(delegate.execute(sql, columnIndexes));
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		return TestEvents.record(delegate, "execute", sql, columnNames).result(delegate.execute(sql, columnNames));
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return TestEvents.record(delegate, "getResultSetHoldability").result(delegate.getResultSetHoldability());
	}

	@Override
	public boolean isClosed() throws SQLException {
		return TestEvents.record(delegate, "isClosed").result(delegate.isClosed());
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		TestEvents.record(delegate, "setPoolable", poolable);
		delegate.setPoolable(poolable);
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return TestEvents.record(delegate, "isPoolable").result(delegate.isPoolable());
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		TestEvents.record(delegate, "closeOnCompletion");
		delegate.closeOnCompletion();
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return TestEvents.record(delegate, "isCloseOnCompletion").result(delegate.isCloseOnCompletion());
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return TestEvents.record(delegate, "unwrap", iface).result(delegate.unwrap(iface));
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return TestEvents.record(delegate, "isWrapperFor", iface).result(delegate.isWrapperFor(iface));
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return TestEvents.record(delegate, "executeQuery").result(new DelegatingResultSet(delegate.executeQuery()));
	}

	@Override
	public int executeUpdate() throws SQLException {
		return TestEvents.record(delegate, "executeUpdate").result(delegate.executeUpdate());
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		TestEvents.record(delegate, "setNull", parameterIndex, sqlType);
		delegate.setNull(parameterIndex, sqlType);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		TestEvents.record(delegate, "setBoolean", parameterIndex, x);
		delegate.setBoolean(parameterIndex, x);
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		TestEvents.record(delegate, "setByte", parameterIndex, x);
		delegate.setByte(parameterIndex, x);
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		TestEvents.record(delegate, "setShort", parameterIndex, x);
		delegate.setShort(parameterIndex, x);
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		TestEvents.record(delegate, "setInt", parameterIndex, x);
		delegate.setInt(parameterIndex, x);
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		TestEvents.record(delegate, "setLong", parameterIndex, x);
		delegate.setLong(parameterIndex, x);
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		TestEvents.record(delegate, "setFloat", parameterIndex, x);
		delegate.setFloat(parameterIndex, x);
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		TestEvents.record(delegate, "setDouble", parameterIndex, x);
		delegate.setDouble(parameterIndex, x);
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		TestEvents.record(delegate, "setBigDecimal", parameterIndex, x);
		delegate.setBigDecimal(parameterIndex, x);
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		TestEvents.record(delegate, "setString", parameterIndex, x);
		delegate.setString(parameterIndex, x);
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		TestEvents.record(delegate, "setBytes", parameterIndex, x);
		delegate.setBytes(parameterIndex, x);
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		TestEvents.record(delegate, "setDate", parameterIndex, x);
		delegate.setDate(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		TestEvents.record(delegate, "setTime", parameterIndex, x);
		delegate.setTime(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		TestEvents.record(delegate, "setTimestamp", parameterIndex, x);
		delegate.setTimestamp(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		TestEvents.record(delegate, "setAsciiStream", parameterIndex, x, length);
		delegate.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		TestEvents.record(delegate, "setUnicodeStream", parameterIndex, x, length);
		delegate.setUnicodeStream(parameterIndex, x, length);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		TestEvents.record(delegate, "setBinaryStream", parameterIndex, x, length);
		delegate.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void clearParameters() throws SQLException {
		TestEvents.record(delegate, "clearParameters");
		delegate.clearParameters();
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		TestEvents.record(delegate, "setObject", parameterIndex, x, targetSqlType);
		delegate.setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		TestEvents.record(delegate, "setObject", parameterIndex, x);
		delegate.setObject(parameterIndex, x);
	}

	@Override
	public boolean execute() throws SQLException {
		return TestEvents.record(delegate, "execute").result(delegate.execute());
	}

	@Override
	public void addBatch() throws SQLException {
		TestEvents.record(delegate, "addBatch");
		delegate.addBatch();
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		TestEvents.record(delegate, "setCharacterStream", parameterIndex, reader, length);
		delegate.setCharacterStream(parameterIndex, reader, length);

	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		TestEvents.record(delegate, "setRef", parameterIndex, x);
		delegate.setRef(parameterIndex, x);
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		TestEvents.record(delegate, "setBlob", parameterIndex, x);
		delegate.setBlob(parameterIndex, x);
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		TestEvents.record(delegate, "setClob", parameterIndex, x);
		delegate.setClob(parameterIndex, x);
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		TestEvents.record(delegate, "setArray", parameterIndex, x);
		delegate.setArray(parameterIndex, x);
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return TestEvents.record(delegate, "getMetaData").result(delegate.getMetaData());
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		TestEvents.record(delegate, "setDate", parameterIndex, x, cal);
		delegate.setDate(parameterIndex, x, cal);
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		TestEvents.record(delegate, "setTime", parameterIndex, x, cal);
		delegate.setTime(parameterIndex, x, cal);

	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		TestEvents.record(delegate, "setTimestamp", parameterIndex, x, cal);
		delegate.setTimestamp(parameterIndex, x, cal);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		TestEvents.record(delegate, "setNull", parameterIndex, sqlType, typeName);
		delegate.setNull(parameterIndex, sqlType, typeName);

	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		TestEvents.record(delegate, "setURL", parameterIndex, x);
		delegate.setURL(parameterIndex, x);

	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return TestEvents.record(delegate, "getParameterMetaData").result(delegate.getParameterMetaData());
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		TestEvents.record(delegate, "setRowId", parameterIndex, x);
		delegate.setRowId(parameterIndex, x);
	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		TestEvents.record(delegate, "setNString", parameterIndex, value);
		delegate.setNString(parameterIndex, value);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		TestEvents.record(delegate, "setNCharacterStream", parameterIndex, value, length);
		delegate.setNCharacterStream(parameterIndex, value, length);
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		TestEvents.record(delegate, "setNClob", parameterIndex, value);
		delegate.setNClob(parameterIndex, value);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		TestEvents.record(delegate, "setClob", parameterIndex, reader, length);
		delegate.setClob(parameterIndex, reader, length);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		TestEvents.record(delegate, "setBlob", parameterIndex, inputStream, length);
		delegate.setBlob(parameterIndex, inputStream, length);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		TestEvents.record(delegate, "setNClob", parameterIndex, reader, length);
		delegate.setNClob(parameterIndex, reader, length);
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		TestEvents.record(delegate, "setSQLXML", parameterIndex, xmlObject);
		delegate.setSQLXML(parameterIndex, xmlObject);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		TestEvents.record(delegate, "setObject", parameterIndex, x, targetSqlType, scaleOrLength);
		delegate.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		TestEvents.record(delegate, "setAsciiStream", parameterIndex, x, length);
		delegate.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		TestEvents.record(delegate, "setBinaryStream", parameterIndex, x, length);
		delegate.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		TestEvents.record(delegate, "setCharacterStream", parameterIndex, reader, length);
		delegate.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		TestEvents.record(delegate, "setAsciiStream", parameterIndex, x);
		delegate.setAsciiStream(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		TestEvents.record(delegate, "setBinaryStream", parameterIndex, x);
		delegate.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		TestEvents.record(delegate, "setCharacterStream", parameterIndex, reader);
		delegate.setCharacterStream(parameterIndex, reader);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		TestEvents.record(delegate, "setNCharacterStream", parameterIndex, value);
		delegate.setNCharacterStream(parameterIndex, value);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		TestEvents.record(delegate, "setClob", parameterIndex, reader);
		delegate.setClob(parameterIndex, reader);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		TestEvents.record(delegate, "setBlob", parameterIndex, inputStream);
		delegate.setBlob(parameterIndex, inputStream);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		TestEvents.record(delegate, "setNClob", parameterIndex, reader);
		delegate.setNClob(parameterIndex, reader);
	}

}
