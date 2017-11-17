package dum.org.hibernate.type.descriptor;

import java.util.TimeZone;

import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class DummyWrapperOptions implements WrapperOptions {

	@Override
	public boolean useStreamForLobBinding() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LobCreator getLobCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeZone getJdbcTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

}
