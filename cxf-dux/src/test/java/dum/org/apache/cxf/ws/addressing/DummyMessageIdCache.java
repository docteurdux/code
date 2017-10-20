package dum.org.apache.cxf.ws.addressing;

import org.apache.cxf.ws.addressing.MessageIdCache;

public class DummyMessageIdCache implements MessageIdCache {

	public boolean checkUniquenessAndCacheId(String messageId) {
		return false;
	}

}
