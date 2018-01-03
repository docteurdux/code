package dux.javax.transaction.xa;

import javax.transaction.xa.Xid;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;
import com.sun.jts.jtsxa.XID;

import bitronix.tm.BitronixXid;
import dux.com.mysql.cj.jdbc.MysqlXidTest;

@Topic(Xid.class)
@Extends({})
@ExtendedBy({ BitronixXid.class, MysqlXidTest.class, XID.class })
@Related({})
public class XidTest extends AbstractTest {
	@Test
	public void test() {

		Xid xid = new Xid() {

			@Override
			public byte[] getGlobalTransactionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getFormatId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public byte[] getBranchQualifier() {
				// TODO Auto-generated method stub
				return null;
			}
		};

	}
}