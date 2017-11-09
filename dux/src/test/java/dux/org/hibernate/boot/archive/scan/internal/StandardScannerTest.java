package dux.org.hibernate.boot.archive.scan.internal;

import org.hibernate.boot.archive.internal.StandardArchiveDescriptorFactory;
import org.hibernate.boot.archive.scan.internal.StandardScanner;
import org.hibernate.boot.archive.scan.spi.AbstractScannerImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.archive.spi.DummyArchiveDescriptorFactory;

@Done
public class StandardScannerTest extends AbstractTest {

	private DummyArchiveDescriptorFactory adf;

	@Before
	public void before() {
		adf = new DummyArchiveDescriptorFactory();
	}

	@Test
	public void test() {

		aeq(AbstractScannerImpl.class, StandardScanner.class.getSuperclass());

		StandardScanner ss = new StandardScanner();

		aeqr(StandardArchiveDescriptorFactory.INSTANCE, getADF(ss));

		ss = new StandardScanner(adf);

		aeqr(adf, getADF(ss));

	}

	private Object getADF(StandardScanner ss) {
		return getField(ss, "archiveDescriptorFactory", AbstractScannerImpl.class);
	}
}
