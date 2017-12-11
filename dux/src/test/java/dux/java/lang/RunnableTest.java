package dux.java.lang;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.HTMLRenderer;

/*-
# java.lang.Runnable

The java.lang.Runnable interface is a very simple interface that only defines a void run() method.
It is great for defining code that will be run later.

{% include test %}

Output of which is:

{% include output %}

 */
public class RunnableTest extends AbstractTest {

	public void test() {
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello from myRunnable");
			}
		};
		myRunnable.run();
	}

	@Test
	public void renderTest() throws Exception {
		HTMLRenderer.renderToHTML(this.getClass(), RunnableTest.class.getMethod("test"), this);
	}

}
