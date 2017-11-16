package dux.org.hibernate.loader.plan.build.spi;

import org.hibernate.loader.plan.build.spi.TreePrinterHelper;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class TreePrinterHelperTest extends AbstractTest {
	@Test
	public void test() {

		aeq(3, TreePrinterHelper.INDENTATION);

		aeq("    - ", TreePrinterHelper.INSTANCE.generateNodePrefix(1));
		aeq("       - ", TreePrinterHelper.INSTANCE.generateNodePrefix(2));

	}
}
