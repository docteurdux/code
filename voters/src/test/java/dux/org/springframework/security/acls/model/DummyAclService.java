package dux.org.springframework.security.acls.model;

import java.util.List;
import java.util.Map;

import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;

public class DummyAclService implements AclService {

	private List<ObjectIdentity> children;
	private Acl acl;
	private Map<ObjectIdentity, Acl> acls;

	@Override
	public List<ObjectIdentity> findChildren(ObjectIdentity parentIdentity) {
		return children;
	}

	@Override
	public Acl readAclById(ObjectIdentity object) throws NotFoundException {
		return acl;
	}

	@Override
	public Acl readAclById(ObjectIdentity object, List<Sid> sids) throws NotFoundException {
		if (acl == null) {
			throw new NotFoundException("Not found");
		}
		return acl;
	}

	@Override
	public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects) throws NotFoundException {
		return acls;
	}

	@Override
	public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects, List<Sid> sids)
			throws NotFoundException {
		return acls;
	}

	public void setAcl(Acl acl) {
		this.acl = acl;
	}
	
	

}
