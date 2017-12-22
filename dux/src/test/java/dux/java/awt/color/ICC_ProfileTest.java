package dux.java.awt.color;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.io.SerializableTest;

@Topic(ICC_Profile.class)
@Extends({ SerializableTest.class })
@ExtendedBy({})
@Related({})
public class ICC_ProfileTest extends AbstractTest {
	@Test
	@SuppressWarnings("null")
	public void test() throws IOException {

		ICC_Profile a = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
		ICC_Profile b = ICC_Profile.getInstance(ColorSpace.CS_CIEXYZ);
		ICC_Profile c = ICC_Profile.getInstance(ColorSpace.CS_GRAY);
		ICC_Profile d = ICC_Profile.getInstance(ColorSpace.CS_LINEAR_RGB);
		ICC_Profile e = ICC_Profile.getInstance(ColorSpace.CS_PYCC);

		Map<String, ICC_Profile> map = new HashMap<>();
		map.put("sRGB", a);
		map.put("CIEXYZ", b);
		map.put("GRAY", c);
		map.put("LINEAR_RGB", d);
		map.put("CS_PYCC", e);

		for (Entry<String, ICC_Profile> f : map.entrySet()) {

			System.out.println(f.getKey());
			ICC_Profile g = f.getValue();
			System.out.println("Version : " + g.getMajorVersion() + "." + g.getMinorVersion());
			System.out.println("Components : " + g.getNumComponents());
			String cstr = null;
			switch (g.getProfileClass()) {
			case ICC_Profile.CLASS_ABSTRACT:
				cstr = "ABSTRACT";
				break;
			case ICC_Profile.CLASS_COLORSPACECONVERSION:
				cstr = "COLORSPACECONVERSION";
				break;
			case ICC_Profile.CLASS_DEVICELINK:
				cstr = "DEVICELINK";
				break;
			case ICC_Profile.CLASS_DISPLAY:
				cstr = "DISPLAY";
				break;
			case ICC_Profile.CLASS_INPUT:
				cstr = "INPUT";
				break;
			case ICC_Profile.CLASS_NAMEDCOLOR:
				cstr = "NAMEDCOLOR";
				break;
			case ICC_Profile.CLASS_OUTPUT:
				cstr = "OUTPUT";
				break;
			default:
				cstr = "UNKNOWN";
			}
			System.out.println("Profile class: " + cstr);
			System.out.println("PCSType: " + g.getPCSType());
			System.out.println("ColorSpaceType: " + g.getColorSpaceType());
			System.out.println("Data size: " + g.getData().length);
			System.out.println("--");
		}

		if (t()) {
			return;
		}

		ICC_Profile p = null;

		byte[] data = null;
		ICC_Profile.getInstance(data);
		int s = 0;
		ICC_Profile.getInstance(s);
		InputStream cspace = null;
		ICC_Profile.getInstance(cspace);
		String fileName = null;
		ICC_Profile.getInstance(fileName);
		int tagSignature = 0;
		p.getData(tagSignature);
		byte[] tagData = null;
		p.setData(tagSignature, tagData);
		OutputStream o = null;
		p.write(o);
		p.write(fileName);

		/*-
		getInstance(byte[])
		getInstance(int)
		getInstance(InputStream)
		getInstance(String)
		getColorSpaceType()
		getData()
		getData(int)
		getNumComponents()
		getPCSType()
		getProfileClass()
		setData(int, byte[])
		write(OutputStream)
		write(String)
		 */
	}
}