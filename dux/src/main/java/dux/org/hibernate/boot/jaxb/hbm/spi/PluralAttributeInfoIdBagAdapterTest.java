package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.jaxb.hbm.spi.DummyPluralAttributeInfoIdBagAdapter;

@Done
public class PluralAttributeInfoIdBagAdapterTest extends AbstractTest {
	@Test
	public void test() {

		DummyPluralAttributeInfoIdBagAdapter pluralAttributeInfoIdBagAdapter = new DummyPluralAttributeInfoIdBagAdapter();

		af(pluralAttributeInfoIdBagAdapter.isInverse());
		an(pluralAttributeInfoIdBagAdapter.getOneToMany());
	}
}
