package dut.neethi;

import org.apache.neethi.PolicyBuilder;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.tutorial.TutorialBuilder;

public class NeethiTutorial extends AbstractTest {

	private TutorialBuilder tb;

	@Before
	public void before() {
		tb = new TutorialBuilder();
	}

	@Test
	public void test() {

		// https://www.ibm.com/developerworks/webservices/tutorials/ws-understand-web-services5/index.html

		tb.blah("Neethi is a framework for using WS Policy");

	}
}
