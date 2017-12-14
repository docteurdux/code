package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.context.request.AbstractRequestAttributesScope;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.config.ScopeTest;

@Topic(AbstractRequestAttributesScope.class)
@Related({ RequestScopeTest.class, ScopeTest.class })
public class AbstractRequestAttributesScopeTest extends AbstractTest {
	@Test
	public void test() {

		AbstractRequestAttributesScope scope = new AbstractRequestAttributesScope() {
			@Override
			public String getConversationId() {
				return null;
			}

			@Override
			protected int getScope() {
				return 0;
			}
		};

		String name = null;
		ObjectFactory<?> objectFactory = new ObjectFactory<String>() {
			@Override
			public String getObject() throws BeansException {
				return "string";
			}
		};
		Runnable callback = null;
		String key = null;
		scope.get(name, objectFactory);
		scope.registerDestructionCallback(name, callback);
		scope.remove(name);
		scope.resolveContextualObject(key);
		/*-
		AbstractRequestAttributesScope()
		get(String, ObjectFactory<?>)
		registerDestructionCallback(String, Runnable)
		remove(String)
		resolveContextualObject(String)
		*/

	}
}
