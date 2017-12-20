package dux.java.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(FileSystem.class)
public class FileSystemTest extends AbstractTest {
	@Test
	public void test() throws IOException {

		FileSystem fs = FileSystems.getDefault();

		Iterator<Path> rit = fs.getRootDirectories().iterator();
		while (rit.hasNext()) {
			System.out.println(rit.next().toString());
		}
		System.out.println("--");

		Iterator<FileStore> sit = fs.getFileStores().iterator();
		while (sit.hasNext()) {
			System.out.println(sit.next().toString());
		}
		System.out.println("--");

		aeq(true, fs.getUserPrincipalLookupService() != null);

		System.out.println("Open : " + fs.isOpen());
		System.out.println("Read only : " + fs.isReadOnly());
		System.out.println("Separator : " + fs.getSeparator());

		System.out.println("--");

		for (String a : fs.supportedFileAttributeViews()) {
			System.out.println(a);
		}

		System.out.println("--");

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				if (t()) {
					// remove if you want to play
					throw new UnsupportedOperationException();
				}
				fs.close(); // may be dangerous, don't actually call that
			}
		});

		FileSystemProvider provider = fs.provider();
		System.out.println(provider.getClass().getName());

		aeq(true, fs.getPathMatcher("glob:**/target").matches(fs.getPath(System.getProperty("user.dir"), "target")));

		WatchService ws = fs.newWatchService();
		System.out.println(ws.getClass().getName());
		ws.close();

	}

}
