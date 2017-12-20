package dux.java.nio.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(WatchEvent.class)
public class WatchEventTest_D extends AbstractTest {

	@Test
	public void test() throws InterruptedException, IOException {

		/*
		 * There's nothing to unit test here, but it's possible to play a little,
		 * uncomment the following
		 */
		
		/*-
		 Path cwd = Paths.get("");
		 loop(cwd, 1, 3);
		 */

		/*- Things not illusrated here:
		 * - Key cancellation
		 * - Event overflowing
		 * - Event count > 1
		 * - Invalidation due to external changes in the path
		 * - Interruption
		 * - Using the watchable
		 */

	}

	@SuppressWarnings("unused")
	private void loop(Path cwd, int max, int timeout) throws IOException, InterruptedException {
		System.out.println("Watching " + cwd.toAbsolutePath().toString());
		System.out.println("Timeout is " + timeout + " seconds");
		System.out.println("Max loops is " + max);
		WatchService watcher = FileSystems.getDefault().newWatchService();
		cwd.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		int count = 0;
		while (count < max) {
			WatchKey key = watcher.poll(timeout, TimeUnit.SECONDS);
			if (key == null) {
				System.out.println("Got nothing");
			} else {
				System.out.println("Got something !");
				System.out.println("Valid ? " + key.isValid());
				List<WatchEvent<?>> events = key.pollEvents();
				for (WatchEvent<?> event : events) {
					Path path = (Path) event.context();
					System.out.println("Event type: " + event.kind().name());
					System.out.println("Event count : " + event.count());
					System.out.println(path.toString());
				}
				if (!key.reset()) {
					System.out.println("Watch key is invalid");
					break;
				}
			}
			++count;
		}
	}
}
