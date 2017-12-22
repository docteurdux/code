package dux;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class MiscTest extends AbstractTest {

	public static enum MyEnum {
		A, B
	};

	@Test(expected = NullPointerException.class)
	public void test1() {
		an(MyEnum.valueOf(null));
	}

	@Test(expected = NullPointerException.class)
	public void test2() {
		String output = null;
		MyEnum foo = null;
		switch (foo) {
		case A:
			output = "A";
			break;
		case B:
			output = "B";
			break;
		default:
			output = "default";
		}
		aeq("default", output);
	}

	@Test
	public void test3() {
		aeq("null", null + "");
	}

	@Test
	public void test4() throws Exception {
		Marshaller marshaller = JAXBContext.newInstance(Object.class).createMarshaller();
		aeq("com.sun.xml.internal.bind.v2.runtime.MarshallerImpl", marshaller.getClass().getName());
		com.sun.xml.internal.bind.v2.runtime.MarshallerImpl.class.getName();

	}

	@Test
	public void test5() {
		af(null instanceof String);
	}

	@Test
	public void test6() {
		// https://geoservices.geoconcept.com/EU/GCW/geoconcept-web/
		Pattern p = Pattern.compile(".*/([^/]+)/GCW/geoconcept-web/$");
		Matcher m = p.matcher("https://geoservices.geoconcept.com/EU/GCW/geoconcept-web/");
		m.find();
		System.out.println(m.group(1));

	}

	@Test
	public void test7() {

		aeq(true, long.class.isPrimitive());
		aeq(false, Long.class.isPrimitive());

		aeq(false, String.class.isPrimitive());

		aeq(true, new Long(1) instanceof Number);
		aeq(true, ((Object) (1L)) instanceof Number);
	}

	
}
