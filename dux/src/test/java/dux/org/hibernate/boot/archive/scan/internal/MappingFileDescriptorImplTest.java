package dux.org.hibernate.boot.archive.scan.internal;

import org.hibernate.boot.archive.scan.internal.MappingFileDescriptorImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.archive.spi.DummyInputStreamAccess;

@Done
public class MappingFileDescriptorImplTest extends AbstractTest {

	private String name;
	private DummyInputStreamAccess inputStreamAccess;

	@Before
	public void before() {

		name = "name";
		inputStreamAccess = new DummyInputStreamAccess();

	}

	@Test
	public void test() {

		MappingFileDescriptorImpl mappingFileDescriptorImpl = new MappingFileDescriptorImpl(name, inputStreamAccess);

		aeq(name, mappingFileDescriptorImpl.getName());
		aeq(inputStreamAccess, mappingFileDescriptorImpl.getStreamAccess());
	}
}
