package dux.java.lang.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(WildcardType.class)
@Related({ Type.class })
public class WildcardTypeTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getLowerBounds()
		getUpperBounds()
		 */
	}
}
