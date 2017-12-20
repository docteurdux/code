package dux.java.nio.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(WatchService.class)
public class WatchServiceTest extends AbstractTest {
	@Test
	public void test() throws IOException, InterruptedException {
		WatchService ws = FileSystems.getDefault().newWatchService();
		System.out.println(ws.getClass().getName());

		WatchKey key = ws.poll();
		TimeUnit unit = TimeUnit.SECONDS;
		ws.poll(1, unit);
		
//		key=ws.take();

		ws.close();

		/*-
		close()
		poll()
		poll(long, TimeUnit)
		take()
		 */
	}
}
