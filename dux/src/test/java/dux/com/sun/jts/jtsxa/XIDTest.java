package dux.com.sun.jts.jtsxa;

import org.junit.Test;
import org.omg.CosTransactions.otid_t;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;
import com.sun.jts.jtsxa.XID;

import dux.javax.transaction.xa.XidTest;

@Topic(XID.class)
@Extends({ XidTest.class })
@ExtendedBy({})
@Related({})
public class XIDTest extends AbstractTest {
	@Test
	public void test() {

		XID from = null;
		otid_t from2 = null;
		byte[] data = null;
		XID xid = null;
		byte[] qual = null;
		int formatID = 0;

		XID x = new XID();
		x.copy(from);
		x.copy(from2);
		x.getBranchQualifier();
		x.getFormatID();
		x.getFormatId();
		x.getGlobalTransactionId();
		x.getGlobalTransactionIdentifier();
		x.isEqualBranchQualifier(data);
		x.isEqualGtrid(xid);
		x.setBranchQualifier(qual);
		x.setFormatID(formatID);

	}
}