package dux.org.hibernate.boot.model.source.internal.hbm;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmHibernateMapping;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.model.source.internal.hbm.DummyAbstractHbmSourceNode;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;

@Done
public class AbstractHbmSourceNodeTest extends AbstractTest {

	private Origin origin;

	private JaxbHbmHibernateMapping jaxbHbmHibernateMapping;

	private DummyMappingDefaults mappingDefaults;

	private DummyMetadataBuildingContext metadataBuildingContext;

	private MappingDocument mappingDocument;

	@Before
	public void before() {

		origin = new Origin(SourceType.OTHER, "name");

		jaxbHbmHibernateMapping = new JaxbHbmHibernateMapping();

		mappingDefaults = new DummyMappingDefaults();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMappingDefaults(mappingDefaults);

		mappingDocument = new MappingDocument(jaxbHbmHibernateMapping, origin, metadataBuildingContext);
	}

	@Test
	public void test() {
		DummyAbstractHbmSourceNode abstractHbmSourceNode = new DummyAbstractHbmSourceNode(mappingDocument);
		aeqr(origin, abstractHbmSourceNode.origin());
		aeqr(jaxbHbmHibernateMapping, abstractHbmSourceNode.mappingRoot());
		aeqr(mappingDocument, abstractHbmSourceNode.sourceMappingDocument());
		aeqr(mappingDocument, abstractHbmSourceNode.metadataBuildingContext());
	}
}
