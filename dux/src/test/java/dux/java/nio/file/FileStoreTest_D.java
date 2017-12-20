package dux.java.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Iterator;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(FileStore.class)
public class FileStoreTest_D extends AbstractTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() throws IOException {

		Iterator<FileStore> it = FileSystems.getDefault().getFileStores().iterator();
		while (it.hasNext()) {

			FileStore fileStore = it.next();

			aeq(true, fileStore.supportsFileAttributeView(DosFileAttributeView.class));
			aeq(true, fileStore.supportsFileAttributeView(FileOwnerAttributeView.class));
			aeq(true, fileStore.supportsFileAttributeView(AclFileAttributeView.class));
			aeq(true, fileStore.supportsFileAttributeView(UserDefinedFileAttributeView.class));
			aeq(false, fileStore.supportsFileAttributeView(PosixFileAttributeView.class));

			// Was always null
			for (Class<?> cl : new Class<?>[] { DosFileAttributeView.class, FileOwnerAttributeView.class,
					AclFileAttributeView.class, UserDefinedFileAttributeView.class, PosixFileAttributeView.class }) {
				aeq(null, fileStore.getFileStoreAttributeView((Class) cl));
			}
			System.out.println("Name: " + fileStore.name());
			System.out.println("Type: " + fileStore.type());
			System.out.println("Total space: " + fileStore.getTotalSpace());
			System.out.println("Unallocated space: " + fileStore.getUnallocatedSpace());
			System.out.println("Usable space: " + fileStore.getUsableSpace());
			System.out.println("Read only: " + fileStore.isReadOnly());

			// TODO : find where that kind of thing is documented
			System.out.println("CD-ROM: " + fileStore.getAttribute("volume:isCdrom"));

			System.out.println("---");

		}

	}

}
