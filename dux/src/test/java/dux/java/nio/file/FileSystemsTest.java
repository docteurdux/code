package dux.java.nio.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(FileSystems.class)
public class FileSystemsTest extends AbstractTest {
	@Test
	public void test() throws IOException {

		for (FileSystemProvider fs : FileSystemProvider.installedProviders()) {
			System.out.println(fs.getClass().getName());
		}
		Iterator<FileSystemProvider> sl = ServiceLoader.load(FileSystemProvider.class, this.getClass().getClassLoader())
				.iterator();
		while (sl.hasNext()) {
			System.out.println(sl.next().getClass().getName());
		}
		if (t()) {
			return;
		}
		FileSystems.getDefault();
		URI uri = null;
		FileSystems.getFileSystem(uri);
		ClassLoader loader = null;
		Path path = null;
		FileSystems.newFileSystem(path, loader);
		Map<String, ?> env = null;
		FileSystems.newFileSystem(uri, env);
		FileSystems.newFileSystem(uri, env, loader);

		/*-
		getDefault()
		getFileSystem(URI)
		newFileSystem(URI, Map<String, ?>)
		newFileSystem(URI, Map<String, ?>, ClassLoader)
		newFileSystem(Path, ClassLoader)
		 */
	}
}
