package dux.org.springframework.core;

import java.util.Set;

import org.junit.Test;
import org.springframework.core.Constants;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Previous;

import dux.org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSourceTest;

@Previous(AbstractRoutingDataSourceTest.class)
//@Next(ConstantsTest.class)
public class ConstantsTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.springframework.core.Constants is a simple class when it comes to
		 * inheritance
		 */

		Constants c = new Constants(dux.org.springframework.core.ConstantsTest.A.class);
		aeq("dux.org.springframework.core.ConstantsTest$A", c.getClassName());

		aeq(5L, c.asNumber("AZE"));

		aeq("bar", c.asString("BAR"));

		aeqr(A.CUK, c.asObject("CUK"));

		Set<String> dex = c.getNames("DEX");
		aeq(2, dex.size());
		aeq(true, dex.contains("DEX1"));
		aeq(true, dex.contains("DEX2"));

		Set<String> euk = c.getNamesForProperty("eukEuk");
		aeq(2, euk.size());
		aeq(true, euk.contains("EUK_EUK_1"));
		aeq(true, euk.contains("EUK_EUK_2"));

		Set<String> two = c.getNamesForSuffix("2");
		aeq(2, two.size());
		aeq(true, two.contains("DEX2"));
		aeq(true, two.contains("EUK_EUK_2"));

		Set<Object> dexv = c.getValues("DEX");
		aeq(2, dexv.size());
		aeq(true, dexv.contains("dex1"));
		aeq(true, dexv.contains("dex2"));

		Set<Object> eukv = c.getValuesForProperty("eukEuk");
		aeq(2, eukv.size());
		aeq(true, eukv.contains("euk1"));
		aeq(true, eukv.contains("euk2"));

		Set<Object> twov = c.getValuesForSuffix("2");
		aeq(2, twov.size());
		aeq(true, twov.contains("dex2"));
		aeq(true, twov.contains("euk2"));

		aeq("DEX2", c.toCode("dex2", "DEX"));
		aeq("EUK_EUK_2", c.toCodeForProperty("euk2", "eukEuk"));
		aeq("EUK_EUK_2", c.toCodeForSuffix("euk2", "2"));

		aeq("FOO_BAR_BAZ", c.propertyToConstantNamePrefix("fooBarBaz"));

	}

	public static class A {
		public static final Long AZE = 5L;
		public static final StringBuffer BAR = new StringBuffer();
		static {
			BAR.append("bar");
		}
		public static final Object CUK = new Object();
		public static final String DEX1 = "dex1";
		public static final String DEX2 = "dex2";
		public static final String EUK_EUK_1 = "euk1";
		public static final String EUK_EUK_2 = "euk2";
		public static final String FOO = "foo";
	}
}
