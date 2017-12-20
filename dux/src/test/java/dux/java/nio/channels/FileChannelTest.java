package dux.java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Set;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.nio.channels.spi.AbstractInterruptibleChannelTest;

@Topic(FileChannel.class)
@Related({ AbstractInterruptibleChannelTest.class, GatheringByteChannelTest.class, ScatteringByteChannelTest.class,
		ScatteringByteChannelTest.class })
public class FileChannelTest extends AbstractTest {
	@Test
	public void test() throws IOException {
		FC fc = new FC();
		Path path = null;
		OpenOption option1 = null;
		OpenOption option2 = null;
		FileChannel.open(path, option1, option2);
		Set<? extends OpenOption> options = null;
		FileAttribute<?> attrs = null;
		FileChannel.open(path, options, attrs);
		ByteBuffer[] dsts = null;
		fc.read(dsts);
		ByteBuffer[] srcs = null;
		fc.write(srcs);
		fc.lock();
		fc.tryLock();

	}

	private static class FC extends FileChannel {

		@Override
		public int read(ByteBuffer dst) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int write(ByteBuffer src) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long position() throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public FileChannel position(long newPosition) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long size() throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public FileChannel truncate(long size) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void force(boolean metaData) throws IOException {
			// TODO Auto-generated method stub

		}

		@Override
		public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int read(ByteBuffer dst, long position) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int write(ByteBuffer src, long position) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FileLock lock(long position, long size, boolean shared) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FileLock tryLock(long position, long size, boolean shared) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected void implCloseChannel() throws IOException {
			// TODO Auto-generated method stub

		}

	}
}
