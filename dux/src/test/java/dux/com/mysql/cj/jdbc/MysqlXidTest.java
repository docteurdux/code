package dux.com.mysql.cj.jdbc;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;
import com.mysql.cj.jdbc.MysqlXid;

import dux.javax.transaction.xa.XidTest;

@Topic(MysqlXid.class)
@Extends({XidTest.class})
@ExtendedBy({})
@Related({})
public class MysqlXidTest extends AbstractTest {
	@Test
	public void test() {
		byte[] gtrid = null;
		byte[] bqual = null;
		int formatId = 0;
		MysqlXid x = new MysqlXid(gtrid, bqual, formatId);
		x.getBranchQualifier();
		x.getFormatId();
		x.getGlobalTransactionId();

	}
}