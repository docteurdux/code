package dum.java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyCallableStatement extends TestEventCollector implements CallableStatement {

	private RunnableWithArgs<Boolean> executeRWA;
	private RunnableWithArgs<Integer> updateCountRWA;
	private RunnableWithArgs<Boolean> getMoreResultsRWA;
	private RunnableWithArgs<ResultSet> getResultSetRWA;
	private RunnableWithArgs<Void> setObjectRWA;
	private RunnableWithArgs<Object> getObjectRWA;

	@Override
	public ResultSet executeQuery() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
		if (executeRWA != null) {
			return executeRWA.run();
		}
		return false;
	}

	public void setExecuteRWA(RunnableWithArgs<Boolean> executeRWA) {
		this.executeRWA = executeRWA;
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		if (getResultSetRWA != null) {
			return getResultSetRWA.run();
		}
		return null;
	}

	public void setGetResultSetRWA(RunnableWithArgs<ResultSet> getResultSetRWA) {
		this.getResultSetRWA = getResultSetRWA;
	}

	@Override
	public int getUpdateCount() throws SQLException {
		if (updateCountRWA != null) {
			return updateCountRWA.run();
		}
		return 0;
	}

	public void setUpdateCountRWA(RunnableWithArgs<Integer> updateCountRWA) {
		this.updateCountRWA = updateCountRWA;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		if (getMoreResultsRWA != null) {
			return getMoreResultsRWA.run();
		}
		return false;
	}

	public void setGetMoreResultsRWA(RunnableWithArgs<Boolean> getMoreResultsRWA) {
		this.getMoreResultsRWA = getMoreResultsRWA;
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
		// TODO Auto-generated method stub
		return null;
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
	public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean wasNull() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getString(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte getByte(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getShort(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloat(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDouble(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBytes(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref getRef(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getArray(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public URL getURL(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setURL(String parameterName, URL val) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(String parameterName, int sqlType) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBoolean(String parameterName, boolean x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setByte(String parameterName, byte x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setShort(String parameterName, short x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(String parameterName, int x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLong(String parameterName, long x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFloat(String parameterName, float x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDouble(String parameterName, double x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setString(String parameterName, String x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBytes(String parameterName, byte[] x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(String parameterName, Date x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(String parameterName, Time x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getString(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte getByte(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getShort(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloat(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDouble(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getBytes(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref getRef(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getArray(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String parameterName, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(String parameterName, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowId(String parameterName, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNString(String parameterName, String value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, NClob value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public NClob getNClob(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob getNClob(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public SQLXML getSQLXML(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNString(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNString(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getNCharacterStream(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getNCharacterStream(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getCharacterStream(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getCharacterStream(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBlob(String parameterName, Blob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Clob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	// region setObject

	@Override
	public void setObject(int parameter, Object object) throws SQLException {
		setObject(parameter, object, null, null, 2);
	}

	@Override
	public void setObject(int parameter, Object object, int targetSqlType) throws SQLException {
		setObject(parameter, object, targetSqlType, null, 3);
	}

	@Override
	public void setObject(int parameter, Object object, SQLType targetSqlType) throws SQLException {
		setObject(parameter, object, targetSqlType, null, 3);
	}

	@Override
	public void setObject(int parameter, Object object, int targetSqlType, int scale) throws SQLException {
		setObject(parameter, object, targetSqlType, scale, 4);
	}

	@Override
	public void setObject(int parameter, Object object, SQLType targetSqlType, int scale) throws SQLException {
		setObject(parameter, object, targetSqlType, scale, 4);
	}

	@Override
	public void setObject(String parameter, Object object) throws SQLException {
		setObject(parameter, object, null, null, 2);
	}

	@Override
	public void setObject(String parameter, Object object, int targetSqlType) throws SQLException {
		setObject(parameter, object, targetSqlType, null, 3);
	}

	@Override
	public void setObject(String parameter, Object object, SQLType targetSqlType) throws SQLException {
		setObject(parameter, object, targetSqlType, null, 3);
	}

	@Override
	public void setObject(String parameter, Object object, int targetSqlType, int scale) throws SQLException {
		setObject(parameter, object, targetSqlType, scale, 4);
	}

	@Override
	public void setObject(String parameter, Object object, SQLType targetSqlType, int scale) throws SQLException {
		setObject(parameter, object, targetSqlType, scale, 4);
	}

	private void setObject(Object parameter, Object object, Object targetSqlType, Object scale, int n) {

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

	// endregion setObject

	// region getObject

	public static enum GetObjectType {
		NONE, TYPE, MAP
	};

	@Override
	public Object getObject(int parameter) throws SQLException {
		return getObject(parameter, null, GetObjectType.NONE);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getObject(int parameter, Class<T> type) throws SQLException {
		return (T) getObject(parameter, type, GetObjectType.TYPE);
	}

	@Override
	public Object getObject(int parameter, Map<String, Class<?>> map) throws SQLException {
		return getObject(parameter, map, GetObjectType.MAP);
	}

	@Override
	public Object getObject(String parameter) throws SQLException {
		return getObject(parameter, null, GetObjectType.NONE);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getObject(String parameter, Class<T> type) throws SQLException {
		return (T) getObject(parameter, type, GetObjectType.TYPE);
	}

	@Override
	public Object getObject(String parameter, Map<String, Class<?>> map) throws SQLException {
		return getObject(parameter, map, GetObjectType.MAP);
	}

	private Object getObject(Object parameter, Object typeOrMap, GetObjectType getObjecType) {

		Object args[] = new Object[getObjecType == GetObjectType.NONE ? 2 : 3];
		args[0] = parameter;

		TestEvent testEvent = new TestEvent("getObject").prop("parameter", parameter);
		if (getObjecType == GetObjectType.TYPE) {
			args[1] = typeOrMap;
			testEvent.prop("type", typeOrMap);
		}
		if (getObjecType == GetObjectType.MAP) {
			args[1] = typeOrMap;
			testEvent.prop("map", typeOrMap);
		}
		testEvents.add(testEvent);
		
		if (getObjectRWA != null) {
			return getObjectRWA.run(args);
		}
		return null;
	}

	public void setGetObjectRWA(RunnableWithArgs<Object> getObjectRWA) {
		this.getObjectRWA = getObjectRWA;
	}

	// endregion getObject
}
