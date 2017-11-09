package dum.org.hibernate.exception.spi;

import org.hibernate.exception.spi.ConversionContext;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

public class DummyConversionContext implements ConversionContext {

	@Override
	public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
		return null;
	}

}
