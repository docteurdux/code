package com.github.docteurdux.test.hibernate;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;

public abstract class BasicColumnNameDeterminer {
	public abstract Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source);
}
