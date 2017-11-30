package dud.java.sql;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import com.github.docteurdux.test.Delegating;
import com.github.docteurdux.test.Proxyfier;
import com.github.docteurdux.test.TestEvents;

public class DelegatingConnection implements Connection, Delegating {

	private Connection delegate;

	public DelegatingConnection(Connection delegate) {
		this.delegate = delegate;
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
	public Statement createStatement() throws SQLException {

		return TestEvents.record(delegate, "createStatement").result(Proxyfier.proxify(delegate.createStatement()));
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return TestEvents.record(delegate, "prepareStatement", sql)
				.result(Proxyfier.proxify(delegate.prepareStatement(sql)));
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		return TestEvents.record(delegate, "prepareCall", sql).result(Proxyfier.proxify(delegate.prepareCall(sql)));
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		return TestEvents.record(delegate, "nativeSQL", sql).result(delegate.nativeSQL(sql));
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		TestEvents.record(delegate, "setAutoCommit", autoCommit);
		delegate.setAutoCommit(autoCommit);
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return TestEvents.record(delegate, "getAutoCommit").result(delegate.getAutoCommit());
	}

	@Override
	public void commit() throws SQLException {
		TestEvents.record(delegate, "commit");
		delegate.commit();

	}

	@Override
	public void rollback() throws SQLException {
		TestEvents.record(delegate, "rollback");
		delegate.rollback();

	}

	@Override
	public void close() throws SQLException {
		TestEvents.record(delegate, "close");
		delegate.close();

	}

	@Override
	public boolean isClosed() throws SQLException {
		return TestEvents.record(delegate, "isClosed").result(delegate.isClosed());
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return TestEvents.record(delegate, "getMetaData").result(Proxyfier.proxify(delegate.getMetaData()));
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		TestEvents.record(delegate, "setReadOnly", readOnly);
		delegate.setReadOnly(readOnly);

	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return TestEvents.record(delegate, "isReadOnly").result(delegate.isReadOnly());
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		TestEvents.record(delegate, "setCatalog", catalog);
		delegate.setCatalog(catalog);

	}

	@Override
	public String getCatalog() throws SQLException {
		return TestEvents.record(delegate, "getCatalog").result(delegate.getCatalog());
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		TestEvents.record(delegate, "setTransactionIsolation", level);
		delegate.setTransactionIsolation(level);

	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return TestEvents.record(delegate, "getTransactionIsolation").result(delegate.getTransactionIsolation());
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
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		return TestEvents.record(delegate, "createStatement", resultSetType, resultSetConcurrency)
				.result(delegate.createStatement(resultSetType, resultSetConcurrency));
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return TestEvents.record(delegate, "prepareStatement", sql, resultSetType, resultSetConcurrency)
				.result(delegate.prepareStatement(sql, resultSetType, resultSetConcurrency));
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		return TestEvents.record(delegate, "prepareCall", sql, resultSetType, resultSetConcurrency)
				.result(delegate.prepareCall(sql, resultSetType, resultSetConcurrency));
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return TestEvents.record(delegate, "getTypeMap").result(delegate.getTypeMap());
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		TestEvents.record(delegate, "setTypeMap", map);
		delegate.setTypeMap(map);

	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		TestEvents.record(delegate, "setHoldability", holdability);
		delegate.setHoldability(holdability);

	}

	@Override
	public int getHoldability() throws SQLException {
		return TestEvents.record(delegate, "getHoldability").result(delegate.getHoldability());
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		return TestEvents.record(delegate, "setSavepoint").result(delegate.setSavepoint());
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		return TestEvents.record(delegate, "setSavepoint", name).result(delegate.setSavepoint(name));
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		TestEvents.record(delegate, "rollback", savepoint);
		delegate.rollback();

	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		TestEvents.record(delegate, "releaseSavepoint", savepoint);
		delegate.releaseSavepoint(savepoint);

	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return TestEvents.record(delegate, "createStatement", resultSetType, resultSetConcurrency, resultSetHoldability)
				.result(delegate.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return TestEvents
				.record(delegate, "prepareStatement", sql, resultSetType, resultSetConcurrency, resultSetHoldability)
				.result(delegate.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return TestEvents
				.record(delegate, "prepareCall", sql, resultSetType, resultSetConcurrency, resultSetHoldability)
				.result(delegate.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		return TestEvents.record(delegate, "prepareStatement", sql, autoGeneratedKeys)
				.result(delegate.prepareStatement(sql, autoGeneratedKeys));
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return TestEvents.record(delegate, "prepareStatement", sql, columnIndexes)
				.result(delegate.prepareStatement(sql, columnIndexes));
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return TestEvents.record(delegate, "prepareStatement", sql, columnNames)
				.result(delegate.prepareStatement(sql, columnNames));
	}

	@Override
	public Clob createClob() throws SQLException {
		return TestEvents.record(delegate, "createClob").result(delegate.createClob());
	}

	@Override
	public Blob createBlob() throws SQLException {
		return TestEvents.record(delegate, "createBlob").result(delegate.createBlob());
	}

	@Override
	public NClob createNClob() throws SQLException {
		return TestEvents.record(delegate, "createNClob").result(delegate.createNClob());
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return TestEvents.record(delegate, "createSQLXML").result(delegate.createSQLXML());
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		return TestEvents.record(delegate, "isValid", timeout).result(delegate.isValid(timeout));
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		TestEvents.record(delegate, "setClientInfo", name, value);
		delegate.setClientInfo(name, value);

	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		TestEvents.record(delegate, "setClientInfo", properties);
		delegate.setClientInfo(properties);

	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		return TestEvents.record(delegate, "getClientInfo", name).result(delegate.getClientInfo(name));
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return TestEvents.record(delegate, "getClientInfo").result(delegate.getClientInfo());
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		return TestEvents.record(delegate, "createArrayOf", typeName, elements)
				.result(delegate.createArrayOf(typeName, elements));
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		return TestEvents.record(delegate, "createStruct", typeName, attributes)
				.result(delegate.createStruct(typeName, attributes));
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		TestEvents.record(delegate, "setSchema", schema);
		delegate.setSchema(schema);

	}

	@Override
	public String getSchema() throws SQLException {
		return TestEvents.record(delegate, "getSchema").result(delegate.getSchema());
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		TestEvents.record(delegate, "abort", executor);
		delegate.abort(executor);

	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		TestEvents.record(delegate, "setNetworkTimeout", executor, milliseconds);
		delegate.setNetworkTimeout(executor, milliseconds);

	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		return TestEvents.record(delegate, "getNetworkTimeout").result(delegate.getNetworkTimeout());
	}

	@Override
	public Object getTestDelegate() {
		return delegate;
	}

}
