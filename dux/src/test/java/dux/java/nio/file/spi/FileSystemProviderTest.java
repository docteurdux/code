package dux.java.nio.file.spi;

import java.io.IOException;
import java.net.URI;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(FileSystemProvider.class)
public class FileSystemProviderTest extends AbstractTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() throws IOException {

		for (FileSystemProvider fsp : FileSystemProvider.installedProviders()) {
			Path path = null;
			AccessMode mode1 = null;
			fsp.checkAccess(path, mode1);
			Path source = null;
			Path target = null;
			CopyOption option1 = null;
			fsp.copy(source, target, option1);
			Path dir = null;
			FileAttribute<?> attr1 = null;
			fsp.createDirectory(dir, attr1);
			Path link = null;
			Path existing = null;
			fsp.createLink(link, existing);
			fsp.createSymbolicLink(link, target, attr1);
			fsp.delete(path);
			fsp.deleteIfExists(path);
			Class type = null;
			LinkOption option1___ = null;
			fsp.getFileAttributeView(path, type, option1___);
			fsp.getFileStore(path);
			URI uri = null;
			FileSystem fs = fsp.getFileSystem(uri);
			fsp.getPath(uri);
			fsp.getScheme();
			fsp.isHidden(path);
			Path path2 = null;
			fsp.isSameFile(path, path2);
			fsp.move(source, target, option1);
			Set<? extends OpenOption> options = null;
			ExecutorService executor = null;
			fsp.newAsynchronousFileChannel(path, options, executor, attr1);
			fsp.newByteChannel(path, options, attr1);
			Filter<? super Path> filter = null;
			fsp.newDirectoryStream(dir, filter);
			fsp.newFileChannel(path, options, attr1);
			Map<String, ?> env = null;
			fsp.newFileSystem(path, env);
			fsp.newFileSystem(uri, env);
			OpenOption option1_ = null;
			fsp.newInputStream(path, option1_);
			fsp.newOutputStream(path, option1_);
			LinkOption option1__ = null;
			fsp.readAttributes(path, type, option1__);
			Class attributes = null;
			fsp.readAttributes(path, attributes, option1__);
			fsp.readSymbolicLink(link);
			String attribute = null;
			Object value = null;
			fsp.setAttribute(path, attribute, value, option1__);

		}
		/*-
		installedProviders()
		checkAccess(Path, AccessMode...)
		copy(Path, Path, CopyOption...)
		createDirectory(Path, FileAttribute<?>...)
		createLink(Path, Path)
		createSymbolicLink(Path, Path, FileAttribute<?>...)
		delete(Path)
		deleteIfExists(Path)
		getFileAttributeView(Path, Class<V>, LinkOption...)
		getFileStore(Path)
		getFileSystem(URI)
		getPath(URI)
		getScheme()
		isHidden(Path)
		isSameFile(Path, Path)
		move(Path, Path, CopyOption...)
		newAsynchronousFileChannel(Path, Set<? extends OpenOption>, ExecutorService, FileAttribute<?>...)
		newByteChannel(Path, Set<? extends OpenOption>, FileAttribute<?>...)
		newDirectoryStream(Path, Filter<? super Path>)
		newFileChannel(Path, Set<? extends OpenOption>, FileAttribute<?>...)
		newFileSystem(URI, Map<String, ?>)
		newFileSystem(Path, Map<String, ?>)
		newInputStream(Path, OpenOption...)
		newOutputStream(Path, OpenOption...)
		readAttributes(Path, Class<A>, LinkOption...)
		readAttributes(Path, String, LinkOption...)
		readSymbolicLink(Path)
		setAttribute(Path, String, Object, LinkOption...)
		 */

	}
}
