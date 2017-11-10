package dux.org.hibernate.cfg.annotations.reflection;

import org.hibernate.cfg.annotations.reflection.PersistentAttributeFilter;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PersistentAttributeFilterTest extends AbstractTest {

	@Test
	public void test() {

		PersistentAttributeFilter paf = PersistentAttributeFilter.INSTANCE;

		af(paf.returnStatic());
		af(paf.returnTransient());
	}
}
