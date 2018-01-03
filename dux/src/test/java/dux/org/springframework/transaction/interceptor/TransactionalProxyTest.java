package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.TransactionalProxy;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionalProxy.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionalProxyTest extends AbstractTest {
	@Test
	public void test() {

	}
}