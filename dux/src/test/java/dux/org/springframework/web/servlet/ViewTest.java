package dux.org.springframework.web.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.view.AbstractViewTest;

@Topic(View.class)
@Related({AbstractViewTest.class})
public class ViewTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		/*-
		getContentType()
		render(Map<String, ?>, HttpServletRequest, HttpServletResponse)
		 */

		MappingJackson2JsonView view = new MappingJackson2JsonView();
		aeq("application/json", view.getContentType());

		Map<String, ?> model = new HashMap<>();
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		view.render(model, request, response);
	}
}
