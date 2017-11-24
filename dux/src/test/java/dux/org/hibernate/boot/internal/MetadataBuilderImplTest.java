package dux.org.hibernate.boot.internal;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dus.hibernate.core.HibernateCoreSummaryTest;

public class MetadataBuilderImplTest extends AbstractTest {

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, MetadataBuilderImpl.class);
	}

	@Test
	public void test() {
		MetadataSources sources = new MetadataSources();
		MetadataBuilderImpl i = new MetadataBuilderImpl(sources);
	}
}
