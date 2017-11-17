package dum.org.hibernate.annotations;

import java.lang.annotation.Annotation;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.PolymorphismType;

@SuppressWarnings("deprecation")
public abstract class DummyEntity implements Entity {

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dynamicInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dynamicUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectBeforeUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PolymorphismType polymorphism() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OptimisticLockType optimisticLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String persister() {
		// TODO Auto-generated method stub
		return null;
	}

}
