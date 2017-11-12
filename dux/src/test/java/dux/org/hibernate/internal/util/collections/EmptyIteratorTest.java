package dux.org.hibernate.internal.util.collections;

import java.util.Iterator;

import org.hibernate.internal.util.collections.EmptyIterator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

@Done
public class EmptyIteratorTest extends AbstractTest {
	@Test
	public void test() {

		@SuppressWarnings("rawtypes")
		Iterator instance = EmptyIterator.INSTANCE;

		af(instance.hasNext());

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				instance.next();
			}
		});

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				instance.remove();
			}
		});

	}
}
