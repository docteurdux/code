package dux.org.apache.ws.commons.schema.utils;

import org.apache.ws.commons.schema.utils.UtilObjects;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class UtilObjectsTest extends AbstractTest {
	@Test
	public void test() {
		UtilObjects.equals(this, this);
	}
}
