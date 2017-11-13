package dum.org.hibernate.boot.model.source.spi;

import org.hibernate.boot.model.Caching;
import org.hibernate.boot.model.CustomSql;
import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;
import org.hibernate.boot.model.source.spi.AttributePath;
import org.hibernate.boot.model.source.spi.AttributeRole;
import org.hibernate.boot.model.source.spi.CollectionIdSource;
import org.hibernate.boot.model.source.spi.FetchCharacteristicsPluralAttribute;
import org.hibernate.boot.model.source.spi.FilterSource;
import org.hibernate.boot.model.source.spi.HibernateTypeSource;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSource;
import org.hibernate.boot.model.source.spi.PluralAttributeKeySource;
import org.hibernate.boot.model.source.spi.PluralAttributeNature;
import org.hibernate.boot.model.source.spi.PluralAttributeSource;
import org.hibernate.boot.model.source.spi.TableSpecificationSource;
import org.hibernate.boot.model.source.spi.ToolingHintContext;

public class DummyPluralAttributeSource implements PluralAttributeSource {

	@Override
	public XmlElementMetadata getSourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingular() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getXmlNodeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributePath getAttributePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeRole getAttributeRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HibernateTypeSource getTypeInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyAccessorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIncludedInOptimisticLocking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ToolingHintContext getToolingHintContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCascadeStyleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluralAttributeNature getNature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIdSource getCollectionIdSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluralAttributeKeySource getKeySource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluralAttributeElementSource getElementSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterSource[] getFilterSources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableSpecificationSource getCollectionTableSpecificationSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCollectionTableComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCollectionTableCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSynchronizedTableNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caching getCaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomPersisterClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWhere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCustomLoaderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSql getCustomSqlInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSql getCustomSqlUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSql getCustomSqlDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSql getCustomSqlDeleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMappedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean usesJoinTable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FetchCharacteristicsPluralAttribute getFetchCharacteristics() {
		// TODO Auto-generated method stub
		return null;
	}

}
