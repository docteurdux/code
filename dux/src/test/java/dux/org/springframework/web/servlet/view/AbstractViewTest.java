package dux.org.springframework.web.servlet.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AbstractView.class)
public class AbstractViewTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		AbstractView view = new AbstractView() {
			@Override
			protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
			}
		};

		Map<String, ?> model = new HashMap<>();
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		view.render(model, request, response);

		
		String name = null;
		Object value = null;
		view.addStaticAttribute(name, value);
		view.getAttributesMap();
		view.getBeanName();
		view.getContentType();
		view.getRequestContextAttribute();
		view.getStaticAttributes();
		view.isExposePathVariables();
		Properties attributes = null;
		view.setAttributes(attributes);
		String propString = null;
		view.setAttributesCSV(propString);
		Map<String, ?> attributess = null;
		view.setAttributesMap(attributess);
		String beanName = null;
		view.setBeanName(beanName);
		String contentType = null;
		view.setContentType(contentType);
		boolean exposeContextBeansAsAttributes = false;
		view.setExposeContextBeansAsAttributes(exposeContextBeansAsAttributes);
		String exposedContextBeanNames = null;
		view.setExposedContextBeanNames(exposedContextBeanNames);
		boolean exposePathVariables = false;
		view.setExposePathVariables(exposePathVariables);
		String requestContextAttribute = null;
		view.setRequestContextAttribute(requestContextAttribute);
		view.toString();
		

	}
}
