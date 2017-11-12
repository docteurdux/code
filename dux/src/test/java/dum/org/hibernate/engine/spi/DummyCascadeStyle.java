package dum.org.hibernate.engine.spi;

import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.engine.spi.CascadingAction;

public class DummyCascadeStyle implements CascadeStyle {

	@Override
	public boolean doCascade(CascadingAction action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reallyDoCascade(CascadingAction action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasOrphanDelete() {
		// TODO Auto-generated method stub
		return false;
	}

}
