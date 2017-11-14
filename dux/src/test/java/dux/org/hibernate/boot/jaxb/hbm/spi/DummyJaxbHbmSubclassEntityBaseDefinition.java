package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.List;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmCustomSqlDmlType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmFetchProfileType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmLoaderType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNamedNativeQueryType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNamedQueryType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmResultSetMappingType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmSubclassEntityBaseDefinition;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmSynchronizeType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTuplizerType;

public class DummyJaxbHbmSubclassEntityBaseDefinition extends JaxbHbmSubclassEntityBaseDefinition {

	private static final long serialVersionUID = 1L;

	@Override
	public List<JaxbHbmTuplizerType> getTuplizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JaxbHbmLoaderType getLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JaxbHbmCustomSqlDmlType getSqlInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JaxbHbmCustomSqlDmlType getSqlUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JaxbHbmCustomSqlDmlType getSqlDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JaxbHbmSynchronizeType> getSynchronize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JaxbHbmFetchProfileType> getFetchProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JaxbHbmResultSetMappingType> getResultset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JaxbHbmNamedNativeQueryType> getSqlQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JaxbHbmNamedQueryType> getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
