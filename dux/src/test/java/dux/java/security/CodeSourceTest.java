package dux.java.security;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.cert.Certificate;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CodeSourceTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * We are looking here at java.security.CodeSource
		 * 
		 * There are two ways of instanciating a java.security.CodeSource
		 * 
		 * Both requires a java.net.URL, but one accepts an array of
		 * java.security.cert.Certificate and the other accepts a array of
		 * java.security.CodeSigner
		 */

		URL url = null;
		Certificate[] certs = null;
		CodeSource cs = new CodeSource(url, certs);
		CodeSigner[] signers = null;
		cs = new CodeSource(url, signers);

		/*-
		  CodeSource(URL, Certificate[])
		CodeSource(URL, CodeSigner[])
		equals(Object)
		getCertificates()
		getCodeSigners()
		getLocation()
		hashCode()
		implies(CodeSource)
		toString()
		 */
	}
}
