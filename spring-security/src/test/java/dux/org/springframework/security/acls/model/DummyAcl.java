package dux.org.springframework.security.acls.model;

import java.util.List;

import org.springframework.security.acls.model.AccessControlEntry;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.model.UnloadedSidException;

public class DummyAcl implements Acl {

	private static final long serialVersionUID = 1L;
	private List<AccessControlEntry> entries;
	private ObjectIdentity objectIdentity;
	private Sid owner;
	private Acl parentAcl;
	private boolean entriesInheriting;
	private boolean granted;
	private boolean sidLoaded;
	private boolean grantedThrow;

	@Override
	public List<AccessControlEntry> getEntries() {
		return entries;
	}

	@Override
	public ObjectIdentity getObjectIdentity() {
		return objectIdentity;
	}

	@Override
	public Sid getOwner() {
		return owner;
	}

	@Override
	public Acl getParentAcl() {
		return parentAcl;
	}

	@Override
	public boolean isEntriesInheriting() {
		return entriesInheriting;
	}

	@Override
	public boolean isGranted(List<Permission> permission, List<Sid> sids, boolean administrativeMode)
			throws NotFoundException, UnloadedSidException {
		if (grantedThrow) {
			throw new NotFoundException("not found");
		}
		return granted;
	}

	@Override
	public boolean isSidLoaded(List<Sid> sids) {
		return sidLoaded;
	}

	public void setEntries(List<AccessControlEntry> entries) {
		this.entries = entries;
	}

	public void setObjectIdentity(ObjectIdentity objectIdentity) {
		this.objectIdentity = objectIdentity;
	}

	public void setOwner(Sid owner) {
		this.owner = owner;
	}

	public void setParentAcl(Acl parentAcl) {
		this.parentAcl = parentAcl;
	}

	public void setEntriesInheriting(boolean entriesInheriting) {
		this.entriesInheriting = entriesInheriting;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}

	public void setSidLoaded(boolean sidLoaded) {
		this.sidLoaded = sidLoaded;
	}

	public void setGrantedThrow(boolean grantedThrow) {
		this.grantedThrow = grantedThrow;

	}

}
