package dux.java.awt.color;

import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ICC_ColorSpace.class)
@Extends({ ColorSpaceTest.class })
@ExtendedBy({})
@Related({ICC_ProfileTest.class})
public class ICC_ColorSpaceTest extends AbstractTest {
	@Test
	public void test() {

		ICC_Profile profile = null;
		ICC_ColorSpace c = new ICC_ColorSpace(profile);

		float[] floats = null;
		int component = 0;
		c.fromCIEXYZ(floats);
		c.fromRGB(floats);
		c.getMaxValue(component);
		c.getMinValue(component);
		c.getProfile();
		c.toCIEXYZ(floats);
		c.toRGB(floats);

		/*-
		ICC_ColorSpace(ICC_Profile)
		fromCIEXYZ(float[])
		fromRGB(float[])
		getMaxValue(int)
		getMinValue(int)
		getProfile()
		toCIEXYZ(float[])
		toRGB(float[])
		 */
	}
}
