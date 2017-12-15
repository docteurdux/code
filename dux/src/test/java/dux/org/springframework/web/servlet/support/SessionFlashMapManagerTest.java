package dux.org.springframework.web.servlet.support;

import org.junit.Test;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SessionFlashMapManager.class)
@Related({ AbstractFlashMapManagerTest.class })
public class SessionFlashMapManagerTest extends AbstractTest {
	@Test
	public void test() {
		SessionFlashMapManager m = new SessionFlashMapManager();
		
		
	}
}
