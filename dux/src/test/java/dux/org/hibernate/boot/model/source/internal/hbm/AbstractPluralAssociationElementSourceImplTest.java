package dux.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmHibernateMapping;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.model.source.internal.hbm.DummyAbstractPluralAssociationElementSourceImpl;
import dum.org.hibernate.boot.model.source.spi.DummyPluralAttributeSource;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;

@Done
public class AbstractPluralAssociationElementSourceImplTest extends AbstractTest {

	private SourceType sourceType;
	private String name;
	private Origin origin;
	private JaxbHbmHibernateMapping jaxbHbmHibernateMapping;
	private DummyMappingDefaults mappingDefaults;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private MappingDocument mappingDocument;
	private DummyPluralAttributeSource pluralAttributeSource;

	public AbstractPluralAssociationElementSourceImplTest() {

		sourceType = SourceType.OTHER;
		name = "name";
		origin = new Origin(sourceType, name);

		jaxbHbmHibernateMapping = new JaxbHbmHibernateMapping();

		mappingDefaults = new DummyMappingDefaults();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMappingDefaults(mappingDefaults);

		mappingDocument = new MappingDocument(jaxbHbmHibernateMapping, origin, metadataBuildingContext);

		pluralAttributeSource = new DummyPluralAttributeSource();

	}

	@Test
	public void test() {

		AbstractPluralAssociationElementSourceImpl apaesi = new DummyAbstractPluralAssociationElementSourceImpl(
				mappingDocument, pluralAttributeSource);

		af(apaesi.isMappedBy());
		aeqr(pluralAttributeSource, apaesi.getAttributeSource());
	}
}
