package dux.org.hibernate.bytecode.enhance.internal.tracker;

import org.hibernate.bytecode.enhance.internal.tracker.NoopCollectionTracker;
import org.hibernate.bytecode.enhance.spi.CollectionTracker;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class NoopCollectionTrackerTest extends AbstractTest {
	@Test
	public void test() {

		String name = "name";
		int size = 0;

		CollectionTracker instance = NoopCollectionTracker.INSTANCE;
		instance.add(name, size); // does nothing
		aeq(-1, instance.getSize(name));

	}
}
