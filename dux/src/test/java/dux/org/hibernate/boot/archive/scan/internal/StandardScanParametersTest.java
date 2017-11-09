package dux.org.hibernate.boot.archive.scan.internal;

import org.hibernate.boot.archive.scan.internal.StandardScanParameters;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class StandardScanParametersTest extends AbstractTest {
	@Test
	public void test() {
		ann(StandardScanParameters.INSTANCE);
	}
}
