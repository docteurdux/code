package dux.org.springframework.security.access.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.model.SidRetrievalStrategy;
import org.springframework.security.core.Authentication;

public class DummySidRetrievalStrategy implements SidRetrievalStrategy {

	private List<Authentication> authentications = new ArrayList<>();
	private List<List<Sid>> listsOfSids = new ArrayList<>();

	@Override
	public List<Sid> getSids(Authentication authentication) {
		for (int i = 0; i < getSize(); ++i) {
			if (authentications.get(i) == authentication) {
				return listsOfSids.get(i);
			}
		}
		return null;
	}

	public void setSids(Authentication authentication, List<Sid> sids) {
		for (int i = 0; i < getSize(); ++i) {
			if (authentications.get(i) == authentication) {
				listsOfSids.set(i, sids);
			}
		}
		authentications.add(authentication);
		listsOfSids.add(sids);
	}

	private int getSize() {
		return authentications.size();
	}

}
