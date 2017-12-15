package dux.org.springframework.web.servlet.support;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.AbstractFlashMapManager;
import org.springframework.web.util.UrlPathHelper;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.FlashMapManagerTest;

@Topic(AbstractFlashMapManager.class)
@Related({FlashMapManagerTest.class, SessionFlashMapManagerTest.class})
public class AbstractFlashMapManagerTest extends AbstractTest {
	@Test
	public void test() {

		AbstractFlashMapManager m = new AbstractFlashMapManager() {

			@Override
			protected void updateFlashMaps(List<FlashMap> flashMaps, HttpServletRequest request,
					HttpServletResponse response) {
				// TODO Auto-generated method stub

			}

			@Override
			protected List<FlashMap> retrieveFlashMaps(HttpServletRequest request) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		aeq(UrlPathHelper.class, m.getUrlPathHelper().getClass());

		UrlPathHelper urlPathHelper = new UrlPathHelper();
		aeqr(urlPathHelper, m.getUrlPathHelper());

		aeq(180, m.getFlashMapTimeout());
		m.setFlashMapTimeout(360);
		aeq(360, m.getFlashMapTimeout());

		FlashMap flashMap = new FlashMap();
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();

		m.saveOutputFlashMap(flashMap, request, response);
		
		m.retrieveAndUpdate(request, response);

	}
}
