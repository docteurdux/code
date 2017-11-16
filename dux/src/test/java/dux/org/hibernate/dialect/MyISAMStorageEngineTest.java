package dux.org.hibernate.dialect;

import org.hibernate.dialect.MyISAMStorageEngine;
import org.hibernate.dialect.MySQLStorageEngine;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MyISAMStorageEngineTest extends AbstractTest {
	@Test
	public void test() {
		MySQLStorageEngine instance = MyISAMStorageEngine.INSTANCE;
		af(instance.supportsCascadeDelete());
		af(instance.hasSelfReferentialForeignKeyBug());
		af(instance.dropConstraints());
		aeq(" keyword=MyISAM", instance.getTableTypeString("keyword"));
	}
}
