package dux.java.nio.file;

import java.net.URI;
import java.nio.file.Paths;

import org.junit.Test;

import com.github.docteurdux.test.Topic;

@Topic(Paths.class)
public class PathsTest {
	@Test public void test() {
		URI uri = null;
		String first = null;
		String more = null;
		Paths.get(uri);
		Paths.get(first, more);
	}
	/*-
	get(String, String...)
	get(URI)
	 */
}
