package com.github.docteurdux.test;

import java.io.IOException;

import org.junit.Test;

import dus.hibernate.core.HibernateCoreSummaryTest;

public class CleanupTest extends AbstractTest {
	@Test
	public void test() throws IOException {
		for (String mvnname : new String[] { HibernateCoreSummaryTest.MVNNAME, "mysql-connector-java-6.0.6" }) {
			cleanupSources(mvnname);
		}
	}

	
}
