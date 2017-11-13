package dux.org.hibernate.persister.collection;

import org.hibernate.persister.collection.CollectionPropertyNames;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CollectionPropertyNamesTest extends AbstractTest {

	@Test
	public void test() {
		aeq("size", CollectionPropertyNames.COLLECTION_SIZE);
		aeq("elements", CollectionPropertyNames.COLLECTION_ELEMENTS);
		aeq("indices", CollectionPropertyNames.COLLECTION_INDICES);
		aeq("maxIndex", CollectionPropertyNames.COLLECTION_MAX_INDEX);
		aeq("minIndex", CollectionPropertyNames.COLLECTION_MIN_INDEX);
		aeq("maxElement", CollectionPropertyNames.COLLECTION_MAX_ELEMENT);
		aeq("minElement", CollectionPropertyNames.COLLECTION_MIN_ELEMENT);
		aeq("index", CollectionPropertyNames.COLLECTION_INDEX);

	}
}
