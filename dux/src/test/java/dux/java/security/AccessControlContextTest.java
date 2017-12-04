package dux.java.security;

import java.security.AccessControlContext;
import java.security.DomainCombiner;
import java.security.ProtectionDomain;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;

public class AccessControlContextTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * The class we are studying here is java.security.AccessControlContext
		 */

		/*
		 * There are two ways of instanciating a java.security.AccessControlContext.
		 * 
		 * One involves providing an array of java.security.ProtectionDomain.
		 * 
		 * The other involves providing an already existing
		 * java.security.AccessControlContext and a java.security.DomainCombiner
		 * 
		 * TODO : continue this paragraph after studying java.security.ProtectionDomain
		 */

		ProtectionDomain[] context = new ProtectionDomain[] {};
		AccessControlContext acc = new AccessControlContext(context);

		DomainCombiner combiner = Recorder.create("domainCombiner", this, DomainCombiner.class).p();
		acc = new AccessControlContext(acc, combiner);
	}
}
