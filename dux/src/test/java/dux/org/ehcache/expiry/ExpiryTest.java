package dux.org.ehcache.expiry;

import org.ehcache.expiry.Expiry;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(Expiry.class)
public class ExpiryTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getExpiryForAccess(K, ValueSupplier<? extends V>)
		getExpiryForCreation(K, V)
		getExpiryForUpdate(K, ValueSupplier<? extends V>, V)
		 */
	}
}
