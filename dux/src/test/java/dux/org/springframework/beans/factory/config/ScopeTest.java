package dux.org.springframework.beans.factory.config;

import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.RequestScope;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.context.request.AbstractRequestAttributesScopeTest;

@Topic(Scope.class)
@Related({ AbstractRequestAttributesScopeTest.class })
public class ScopeTest extends AbstractTest {
	@Test
	public void test() {

		RequestScope scope = new RequestScope();

		String name = null;
		ObjectFactory<?> objectFactory = null;
		Runnable callback = null;
		String key = null;

		scope.get(name, objectFactory);
		scope.getConversationId();
		scope.registerDestructionCallback(name, callback);
		scope.remove(name);
		scope.resolveContextualObject(key);

		/*-
		get(String, ObjectFactory<?>)
		getConversationId()
		registerDestructionCallback(String, Runnable)
		remove(String)
		resolveContextualObject(String)
		 */
	}
}
