package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.RequestScope;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RequestScope.class)
@Related({ AbstractRequestAttributesScopeTest.class })
public class RequestScopeTest extends AbstractTest {
	@Test
	public void test() {

	}
}
