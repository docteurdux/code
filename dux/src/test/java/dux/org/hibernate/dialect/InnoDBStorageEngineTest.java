package dux.org.hibernate.dialect;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQLStorageEngine;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class InnoDBStorageEngineTest extends AbstractTest {
	@Test
	public void test() {
		MySQLStorageEngine instance = InnoDBStorageEngine.INSTANCE;
		at(instance.supportsCascadeDelete());
		at(instance.hasSelfReferentialForeignKeyBug());
		at(instance.dropConstraints());
		aeq(" keyword=InnoDB", instance.getTableTypeString("keyword"));
	}
}
