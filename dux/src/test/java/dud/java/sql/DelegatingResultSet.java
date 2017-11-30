package dud.java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import com.github.docteurdux.test.Delegating;
import com.github.docteurdux.test.TestEvents;

public class DelegatingResultSet implements Delegating, ResultSet {

	private ResultSet delegate;

	public DelegatingResultSet(ResultSet delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object getTestDelegate() {
		return delegate;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return TestEvents.record(this, "unwrap", iface).result(delegate.unwrap(iface));
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return TestEvents.record(this, "isWrapperFor", iface).result(delegate.isWrapperFor(iface));
	}

	@Override
	public boolean next() throws SQLException {
		return TestEvents.record(this, "next").result(delegate.next());
	}

	@Override
	public void close() throws SQLException {
		TestEvents.record(this, "close");
		delegate.close();
	}

	@Override
	public boolean wasNull() throws SQLException {
		return TestEvents.record(this, "wasNull").result(delegate.wasNull());
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getString", columnIndex).result(delegate.getString(columnIndex));
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getBoolean", columnIndex).result(delegate.getBoolean(columnIndex));
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getByte", columnIndex).result(delegate.getByte(columnIndex));
	}

	@Override
	public short getShort(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getShort", columnIndex).result(delegate.getShort(columnIndex));
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getInt", columnIndex).result(delegate.getInt(columnIndex));
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getLong", columnIndex).result(delegate.getLong(columnIndex));
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getFloat", columnIndex).result(delegate.getFloat(columnIndex));
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getDouble", columnIndex).result(delegate.getDouble(columnIndex));
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		return TestEvents.record(this, "getBigDecimal", columnIndex).result(delegate.getBigDecimal(columnIndex));
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getBytes", columnIndex).result(delegate.getBytes(columnIndex));
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getDate", columnIndex).result(delegate.getDate(columnIndex));
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getTime", columnIndex).result(delegate.getTime(columnIndex));
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getTimestamp", columnIndex).result(delegate.getTimestamp(columnIndex));
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getAsciiStream", columnIndex).result(delegate.getAsciiStream(columnIndex));
	}

	@Override
	@SuppressWarnings("deprecation")
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getUnicodeStream", columnIndex).result(delegate.getUnicodeStream(columnIndex));
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getBinaryStream", columnIndex).result(delegate.getBinaryStream(columnIndex));
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getString", columnLabel).result(delegate.getString(columnLabel));
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getBoolean", columnLabel).result(delegate.getBoolean(columnLabel));
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getByte", columnLabel).result(delegate.getByte(columnLabel));
	}

	@Override
	public short getShort(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getShort", columnLabel).result(delegate.getShort(columnLabel));
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getInt", columnLabel).result(delegate.getInt(columnLabel));
	}

	@Override
	public long getLong(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getLong", columnLabel).result(delegate.getLong(columnLabel));
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getFloat", columnLabel).result(delegate.getFloat(columnLabel));
	}

	@Override
	public double getDouble(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getDouble", columnLabel).result(delegate.getDouble(columnLabel));
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
		return TestEvents.record(this, "getBigDecimal", columnLabel).result(delegate.getBigDecimal(columnLabel));
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getBytes", columnLabel).result(delegate.getBytes(columnLabel));
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getDate", columnLabel).result(delegate.getDate(columnLabel));
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getTime", columnLabel).result(delegate.getTime(columnLabel));
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getTimestamp", columnLabel).result(delegate.getTimestamp(columnLabel));
	}

	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getAsciiStream", columnLabel).result(delegate.getAsciiStream(columnLabel));
	}

	@Override
	@SuppressWarnings("deprecation")
	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getUnicodeStream", columnLabel).result(delegate.getUnicodeStream(columnLabel));
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getBinaryStream", columnLabel).result(delegate.getBinaryStream(columnLabel));
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return TestEvents.record(this, "getWarnings").result(delegate.getWarnings());
	}

	@Override
	public void clearWarnings() throws SQLException {
		TestEvents.record(this, "clearWarnings");
		delegate.clearWarnings();
	}

	@Override
	public String getCursorName() throws SQLException {
		return TestEvents.record(this, "getCursorName").result(delegate.getCursorName());
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return TestEvents.record(this, "getMetaData").result(delegate.getMetaData());
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getObject", columnIndex).result(delegate.getObject(columnIndex));
	}

	@Override
	public Object getObject(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getObject", columnLabel).result(delegate.getObject(columnLabel));
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException {
		return TestEvents.record(this, "findColumn", columnLabel).result(delegate.findColumn(columnLabel));
	}

	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getCharacterStream", columnIndex)
				.result(delegate.getCharacterStream(columnIndex));
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getCharacterStream", columnLabel)
				.result(delegate.getCharacterStream(columnLabel));
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getBigDecimal", columnIndex).result(delegate.getBigDecimal(columnIndex));
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getBigDecimal", columnLabel).result(delegate.getBigDecimal(columnLabel));
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		return TestEvents.record(this, "isBeforeFirst").result(delegate.isBeforeFirst());
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		return TestEvents.record(this, "isAfterLast").result(delegate.isAfterLast());
	}

	@Override
	public boolean isFirst() throws SQLException {
		return TestEvents.record(this, "isFirst").result(delegate.isFirst());
	}

	@Override
	public boolean isLast() throws SQLException {
		return TestEvents.record(this, "isLast").result(delegate.isLast());
	}

	@Override
	public void beforeFirst() throws SQLException {
		TestEvents.record(this, "beforeFirst");
		delegate.beforeFirst();
	}

	@Override
	public void afterLast() throws SQLException {
		TestEvents.record(this, "afterLast");
		delegate.afterLast();
	}

	@Override
	public boolean first() throws SQLException {
		return TestEvents.record(this, "first").result(delegate.first());
	}

	@Override
	public boolean last() throws SQLException {
		return TestEvents.record(this, "last").result(delegate.last());
	}

	@Override
	public int getRow() throws SQLException {
		return TestEvents.record(this, "getRow").result(delegate.getRow());
	}

	@Override
	public boolean absolute(int row) throws SQLException {
		return TestEvents.record(this, "absolute", row).result(delegate.absolute(row));
	}

	@Override
	public boolean relative(int rows) throws SQLException {
		return TestEvents.record(this, "relative", rows).result(delegate.relative(rows));
	}

	@Override
	public boolean previous() throws SQLException {
		return TestEvents.record(this, "previous").result(delegate.previous());
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		TestEvents.record(this, "setFetchDirection", direction);
		delegate.setFetchDirection(direction);
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return TestEvents.record(this, "getFetchDirection").result(delegate.getFetchDirection());
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		TestEvents.record(this, "setFetchSize", rows);
		delegate.setFetchSize(rows);
	}

	@Override
	public int getFetchSize() throws SQLException {
		return TestEvents.record(this, "getFetchSize").result(delegate.getFetchSize());
	}

	@Override
	public int getType() throws SQLException {
		return TestEvents.record(this, "getType").result(delegate.getType());
	}

	@Override
	public int getConcurrency() throws SQLException {
		return TestEvents.record(this, "getConcurrency").result(delegate.getConcurrency());
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		return TestEvents.record(this, "rowUpdated").result(delegate.rowUpdated());
	}

	@Override
	public boolean rowInserted() throws SQLException {
		return TestEvents.record(this, "rowInserted").result(delegate.rowInserted());
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		return TestEvents.record(this, "rowDeleted").result(delegate.rowDeleted());
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException {
		TestEvents.record(this, "updateNull", columnIndex);
		delegate.updateNull(columnIndex);
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		TestEvents.record(this, "updateBoolean", columnIndex, x);
		delegate.updateBoolean(columnIndex, x);
	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException {
		TestEvents.record(this, "updateByte", columnIndex, x);
		delegate.updateByte(columnIndex, x);
	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException {
		TestEvents.record(this, "updateShort", columnIndex, x);
		delegate.updateShort(columnIndex, x);
	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException {
		TestEvents.record(this, "updateInt", columnIndex, x);
		delegate.updateInt(columnIndex, x);
	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException {
		TestEvents.record(this, "updateLong", columnIndex, x);
		delegate.updateLong(columnIndex, x);
	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException {
		TestEvents.record(this, "updateFloat", columnIndex, x);
		delegate.updateFloat(columnIndex, x);
	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException {
		TestEvents.record(this, "updateDouble", columnIndex, x);
		delegate.updateDouble(columnIndex, x);
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		TestEvents.record(this, "updateBigDecimal", columnIndex, x);
		delegate.updateBigDecimal(columnIndex, x);
	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException {
		TestEvents.record(this, "updateString", columnIndex, x);
		delegate.updateString(columnIndex, x);
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		TestEvents.record(this, "updateBytes", columnIndex, x);
		delegate.updateBytes(columnIndex, x);
	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException {
		TestEvents.record(this, "updateDate", columnIndex, x);
		delegate.updateDate(columnIndex, x);
	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException {
		TestEvents.record(this, "updateTime", columnIndex, x);
		delegate.updateTime(columnIndex, x);
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		TestEvents.record(this, "updateTimestamp", columnIndex, x);
		delegate.updateTimestamp(columnIndex, x);
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnIndex, x, length);
		delegate.updateAsciiStream(columnIndex, x, length);
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnIndex, x, length);
		delegate.updateBinaryStream(columnIndex, x, length);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnIndex, x, length);
		delegate.updateCharacterStream(columnIndex, x, length);
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		TestEvents.record(this, "updateObject", columnIndex, x, scaleOrLength);
		delegate.updateObject(columnIndex, x, scaleOrLength);
	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException {
		TestEvents.record(this, "updateObject", columnIndex, x);
		delegate.updateObject(columnIndex, x);
	}

	@Override
	public void updateNull(String columnLabel) throws SQLException {
		TestEvents.record(this, "updateNull", columnLabel);
		delegate.updateNull(columnLabel);
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) throws SQLException {
		TestEvents.record(this, "updateBoolean", columnLabel, x);
		delegate.updateBoolean(columnLabel, x);
	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException {
		TestEvents.record(this, "updateByte", columnLabel, x);
		delegate.updateByte(columnLabel, x);
	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException {
		TestEvents.record(this, "updateShort", columnLabel, x);
		delegate.updateShort(columnLabel, x);
	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException {
		TestEvents.record(this, "updateInt", columnLabel, x);
		delegate.updateInt(columnLabel, x);
	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException {
		TestEvents.record(this, "updateLong", columnLabel, x);
		delegate.updateLong(columnLabel, x);
	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException {
		TestEvents.record(this, "updateFloat", columnLabel, x);
		delegate.updateFloat(columnLabel, x);
	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException {
		TestEvents.record(this, "updateDouble", columnLabel, x);
		delegate.updateDouble(columnLabel, x);
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		TestEvents.record(this, "updateBigDecimal", columnLabel, x);
		delegate.updateBigDecimal(columnLabel, x);
	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException {
		TestEvents.record(this, "updateString", columnLabel, x);
		delegate.updateString(columnLabel, x);
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		TestEvents.record(this, "updateBytes", columnLabel, x);
		delegate.updateBytes(columnLabel, x);
	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException {
		TestEvents.record(this, "updateDate", columnLabel, x);
		delegate.updateDate(columnLabel, x);
	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException {
		TestEvents.record(this, "updateTime", columnLabel, x);
		delegate.updateTime(columnLabel, x);
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		TestEvents.record(this, "updateTimestamp", columnLabel, x);
		delegate.updateTimestamp(columnLabel, x);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnLabel, x, length);
		delegate.updateAsciiStream(columnLabel, x, length);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnLabel, x, length);
		delegate.updateBinaryStream(columnLabel, x, length);
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnLabel, reader, length);
		delegate.updateCharacterStream(columnLabel, reader, length);
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		TestEvents.record(this, "updateObject", columnLabel, x, scaleOrLength);
		delegate.updateObject(columnLabel, x, scaleOrLength);
	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException {
		TestEvents.record(this, "updateObject", columnLabel, x);
		delegate.updateObject(columnLabel, x);
	}

	@Override
	public void insertRow() throws SQLException {
		TestEvents.record(this, "insertRow");
		delegate.insertRow();
	}

	@Override
	public void updateRow() throws SQLException {
		TestEvents.record(this, "updateRow");
		delegate.updateRow();
	}

	@Override
	public void deleteRow() throws SQLException {
		TestEvents.record(this, "deleteRow");
		delegate.deleteRow();
	}

	@Override
	public void refreshRow() throws SQLException {
		TestEvents.record(this, "refreshRow");
		delegate.refreshRow();
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		TestEvents.record(this, "cancelRowUpdates");
		delegate.cancelRowUpdates();
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		TestEvents.record(this, "moveToInsertRow");
		delegate.moveToInsertRow();
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		TestEvents.record(this, "moveToCurrentRow");
		delegate.moveToCurrentRow();
	}

	@Override
	public Statement getStatement() throws SQLException {
		return TestEvents.record(this, "getStatement").result(delegate.getStatement());
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
		return TestEvents.record(this, "getObject", columnIndex, map).result(delegate.getObject(columnIndex, map));
	}

	@Override
	public Ref getRef(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getRef", columnIndex).result(delegate.getRef(columnIndex));
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getBlob", columnIndex).result(delegate.getBlob(columnIndex));
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getClob", columnIndex).result(delegate.getClob(columnIndex));
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getArray", columnIndex).result(delegate.getArray(columnIndex));
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
		return TestEvents.record(this, "getObject", columnLabel, map).result(delegate.getObject(columnLabel, map));
	}

	@Override
	public Ref getRef(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getRef", columnLabel).result(delegate.getRef(columnLabel));
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getBlob", columnLabel).result(delegate.getBlob(columnLabel));
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getClob", columnLabel).result(delegate.getClob(columnLabel));
	}

	@Override
	public Array getArray(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getArray", columnLabel).result(delegate.getArray(columnLabel));
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getDate", columnIndex, cal).result(delegate.getDate(columnIndex, cal));
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getDate", columnLabel, cal).result(delegate.getDate(columnLabel, cal));
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getTime", columnIndex, cal).result(delegate.getTime(columnIndex, cal));
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getTime", columnLabel, cal).result(delegate.getTime(columnLabel, cal));
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getTimestamp", columnIndex, cal)
				.result(delegate.getTimestamp(columnIndex, cal));
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
		return TestEvents.record(this, "getTimestamp", columnLabel, cal)
				.result(delegate.getTimestamp(columnLabel, cal));
	}

	@Override
	public URL getURL(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getURL", columnIndex).result(delegate.getURL(columnIndex));
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getURL", columnLabel).result(delegate.getURL(columnLabel));
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		TestEvents.record(this, "updateRef", columnIndex, x);
		delegate.updateRef(columnIndex, x);
	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		TestEvents.record(this, "updateRef", columnLabel, x);
		delegate.updateRef(columnLabel, x);
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		TestEvents.record(this, "updateBlob", columnIndex, x);
		delegate.updateBlob(columnIndex, x);
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		TestEvents.record(this, "updateBlob", columnLabel, x);
		delegate.updateBlob(columnLabel, x);
	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		TestEvents.record(this, "updateClob", columnIndex, x);
		delegate.updateClob(columnIndex, x);
	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		TestEvents.record(this, "updateClob", columnLabel, x);
		delegate.updateClob(columnLabel, x);
	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		TestEvents.record(this, "updateArray", columnIndex, x);
		delegate.updateArray(columnIndex, x);
	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		TestEvents.record(this, "updateArray", columnLabel, x);
		delegate.updateArray(columnLabel, x);
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getRowId", columnIndex).result(delegate.getRowId(columnIndex));
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getRowId", columnLabel).result(delegate.getRowId(columnLabel));
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		TestEvents.record(this, "updateRowId", columnIndex, x);
		delegate.updateRowId(columnIndex, x);
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		TestEvents.record(this, "updateRowId", columnLabel, x);
		delegate.updateRowId(columnLabel, x);
	}

	@Override
	public int getHoldability() throws SQLException {
		return TestEvents.record(this, "getHoldability").result(delegate.getHoldability());
	}

	@Override
	public boolean isClosed() throws SQLException {
		return TestEvents.record(this, "isClosed").result(delegate.isClosed());
	}

	@Override
	public void updateNString(int columnIndex, String nString) throws SQLException {
		TestEvents.record(this, "updateNString", columnIndex, nString);
		delegate.updateNString(columnIndex, nString);

	}

	@Override
	public void updateNString(String columnLabel, String nString) throws SQLException {
		TestEvents.record(this, "updateNString", columnLabel, nString);
		delegate.updateNString(columnLabel, nString);

	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		TestEvents.record(this, "updateNClob", columnIndex, nClob);
		delegate.updateNClob(columnIndex, nClob);
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		TestEvents.record(this, "updateNClob", columnLabel, nClob);
		delegate.updateNClob(columnLabel, nClob);
	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getNClob", columnIndex).result(delegate.getNClob(columnIndex));
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getNClob", columnLabel).result(delegate.getNClob(columnLabel));
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getSQLXML", columnIndex).result(delegate.getSQLXML(columnIndex));
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getSQLXML", columnLabel).result(delegate.getSQLXML(columnLabel));
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		TestEvents.record(this, "updateSQLXML", columnIndex, xmlObject);
		delegate.updateSQLXML(columnIndex, xmlObject);
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		TestEvents.record(this, "updateSQLXML", columnLabel, xmlObject);
		delegate.updateSQLXML(columnLabel, xmlObject);
	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getNString", columnIndex).result(delegate.getNString(columnIndex));
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getNString", columnLabel).result(delegate.getNString(columnLabel));
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		return TestEvents.record(this, "getNCharacterStream", columnIndex)
				.result(delegate.getNCharacterStream(columnIndex));
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		return TestEvents.record(this, "getNCharacterStream", columnLabel)
				.result(delegate.getNCharacterStream(columnLabel));
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		TestEvents.record(this, "updateNCharacterStream", columnIndex, x, length);
		delegate.updateNCharacterStream(columnIndex, x, length);
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateNCharacterStream", columnLabel, reader, length);
		delegate.updateNCharacterStream(columnLabel, reader, length);

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnIndex, x, length);
		delegate.updateAsciiStream(columnIndex, x, length);
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnIndex, x, length);
		delegate.updateBinaryStream(columnIndex, x, length);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnIndex, x, length);
		delegate.updateCharacterStream(columnIndex, x, length);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnLabel, x, length);
		delegate.updateAsciiStream(columnLabel, x, length);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnLabel, x, length);
		delegate.updateBinaryStream(columnLabel, x, length);
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnLabel, reader, length);
		delegate.updateCharacterStream(columnLabel, reader, length);
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		TestEvents.record(this, "updateBlob", columnIndex, inputStream, length);
		delegate.updateBlob(columnIndex, inputStream, length);
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		TestEvents.record(this, "updateBlob", columnLabel, inputStream, length);
		delegate.updateBlob(columnLabel, inputStream, length);
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateClob", columnIndex, reader, length);
		delegate.updateClob(columnIndex, reader, length);
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateClob", columnLabel, reader, length);
		delegate.updateClob(columnLabel, reader, length);
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateNClob", columnIndex, reader, length);
		delegate.updateNClob(columnIndex, reader, length);
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		TestEvents.record(this, "updateNClob", columnLabel, reader, length);
		delegate.updateNClob(columnLabel, reader, length);
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		TestEvents.record(this, "updateNCharacterStream", columnIndex, x);
		delegate.updateNCharacterStream(columnIndex, x);
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		TestEvents.record(this, "updateNCharacterStream", columnLabel, reader);
		delegate.updateNCharacterStream(columnLabel, reader);
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnIndex, x);
		delegate.updateAsciiStream(columnIndex, x);
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnIndex, x);
		delegate.updateBinaryStream(columnIndex, x);
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnIndex, x);
		delegate.updateCharacterStream(columnIndex, x);
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		TestEvents.record(this, "updateAsciiStream", columnLabel, x);
		delegate.updateAsciiStream(columnLabel, x);
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		TestEvents.record(this, "updateBinaryStream", columnLabel, x);
		delegate.updateBinaryStream(columnLabel, x);
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		TestEvents.record(this, "updateCharacterStream", columnLabel, reader);
		delegate.updateCharacterStream(columnLabel, reader);
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		TestEvents.record(this, "updateBlob", columnIndex, inputStream);
		delegate.updateBlob(columnIndex, inputStream);
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		TestEvents.record(this, "updateBlob", columnLabel, inputStream);
		delegate.updateBlob(columnLabel, inputStream);
	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		TestEvents.record(this, "updateClob", columnIndex, reader);
		delegate.updateClob(columnIndex, reader);
	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		TestEvents.record(this, "updateClob", columnLabel, reader);
		delegate.updateClob(columnLabel, reader);
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		TestEvents.record(this, "updateNClob", columnIndex, reader);
		delegate.updateNClob(columnIndex, reader);
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		TestEvents.record(this, "updateNClob", columnLabel, reader);
		delegate.updateNClob(columnLabel, reader);
	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		return TestEvents.record(this, "getObject", columnIndex, type).result(delegate.getObject(columnIndex, type));
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		return TestEvents.record(this, "getObject", columnLabel, type).result(delegate.getObject(columnLabel, type));
	}

}
