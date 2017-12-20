package dux.java.nio.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(WatchKey.class)
public class WatchKeyTest extends AbstractTest {
	@Test
	public void test() throws IOException, InterruptedException {

		WatchService ws = FileSystems.getDefault().newWatchService();
		WatchKey key = ws.poll(10, TimeUnit.SECONDS);
		key.cancel();
		key.isValid();
		for (WatchEvent<?> event : key.pollEvents()) {

		}
		key.reset();
		key.watchable();

		/*-
		  cancel()
		isValid()
		pollEvents()
		reset()
		watchable()
		 */

	}
}
