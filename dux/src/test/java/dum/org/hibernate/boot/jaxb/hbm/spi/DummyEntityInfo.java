package dum.org.hibernate.boot.jaxb.hbm.spi;

import java.util.List;

import org.hibernate.boot.jaxb.hbm.spi.EntityInfo;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmCustomSqlDmlType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmFetchProfileType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmLoaderType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNamedNativeQueryType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNamedQueryType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmResultSetMappingType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmSynchronizeType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmToolingHintType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTuplizerType;

public class DummyEntityInfo implements EntityInfo {

	@Override
	public List<JaxbHbmToolingHintType> getToolingHints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isAbstract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isLazy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDynamicInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDynamicUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelectBeforeUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<JaxbHbmTuplizerType> getTuplizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPersister() {
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
