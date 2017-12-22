package dux.java.awt.color;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.io.Serializable;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ColorSpace.class)
@Extends({ Serializable.class })
@ExtendedBy({ ICC_ColorSpace.class })
@Related({})
public class ColorSpaceTest extends AbstractTest {
	@Test
	public void test() {

		float[] result = null;

		ColorSpace cRGB = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		aeq(true, cRGB.isCS_sRGB());
		aeq(5, cRGB.getType());
		aeq(3, cRGB.getNumComponents());
		aeq("Red", cRGB.getName(0));
		aeq(0.0F, cRGB.getMinValue(0));
		aeq(1.0F, cRGB.getMaxValue(0));
		aeq("Green", cRGB.getName(1));
		aeq(0.0F, cRGB.getMinValue(1));
		aeq(1.0F, cRGB.getMaxValue(1));
		aeq("Blue", cRGB.getName(2));
		aeq(0.0F, cRGB.getMinValue(2));
		aeq(1.0F, cRGB.getMaxValue(2));

		result = cRGB.toCIEXYZ(new float[3]);
		result = cRGB.toRGB(new float[3]);
		result = cRGB.fromCIEXYZ(new float[3]);
		result = cRGB.fromRGB(new float[3]);

		ColorSpace cGray = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		aeq(false, cGray.isCS_sRGB());
		aeq(6, cGray.getType());
		aeq(1, cGray.getNumComponents());
		aeq("Gray", cGray.getName(0));
		aeq(0.0F, cGray.getMinValue(0));
		aeq(1.0F, cGray.getMaxValue(0));

		result = cGray.toCIEXYZ(new float[1]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cGray.toRGB(new float[1]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cGray.fromCIEXYZ(new float[3]);
		aeq(0.0F, result[0]);
		result = cGray.fromRGB(new float[3]);
		aeq(0.0F, result[0]);

		ColorSpace cLinearRGB = ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB);
		aeq(false, cLinearRGB.isCS_sRGB());
		aeq(5, cLinearRGB.getType());
		aeq(3, cLinearRGB.getNumComponents());
		aeq("Red", cLinearRGB.getName(0));
		aeq(0.0F, cLinearRGB.getMinValue(0));
		aeq(1.0F, cLinearRGB.getMaxValue(0));
		aeq("Green", cLinearRGB.getName(1));
		aeq(0.0F, cLinearRGB.getMinValue(1));
		aeq(1.0F, cLinearRGB.getMaxValue(1));
		aeq("Blue", cLinearRGB.getName(2));
		aeq(0.0F, cLinearRGB.getMinValue(2));
		aeq(1.0F, cLinearRGB.getMaxValue(2));

		result = cLinearRGB.toCIEXYZ(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cLinearRGB.toRGB(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cLinearRGB.fromCIEXYZ(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cLinearRGB.fromRGB(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);

		ColorSpace cPYCC = ColorSpace.getInstance(ColorSpace.CS_PYCC);
		aeq(false, cPYCC.isCS_sRGB());
		aeq(13, cPYCC.getType());
		aeq(3, cPYCC.getNumComponents());
		aeq("Unnamed color component(0)", cPYCC.getName(0));
		aeq(0.0F, cPYCC.getMinValue(0));
		aeq(1.0F, cPYCC.getMaxValue(0));
		aeq("Unnamed color component(1)", cPYCC.getName(1));
		aeq(0.0F, cPYCC.getMinValue(1));
		aeq(1.0F, cPYCC.getMaxValue(1));
		aeq("Unnamed color component(2)", cPYCC.getName(2));
		aeq(0.0F, cPYCC.getMinValue(2));
		aeq(1.0F, cPYCC.getMaxValue(2));

		result = cPYCC.toCIEXYZ(new float[3]);
		aeq(0.030212402F, result[0]);
		aeq(0.15951538F, result[1]);
		aeq(0.0F, result[2]);
		result = cPYCC.toRGB(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.56304264F, result[1]);
		aeq(0.0F, result[2]);
		result = cPYCC.fromCIEXYZ(new float[3]);
		aeq(9.155413E-4F, result[0]);
		aeq(0.6117647F, result[1]);
		aeq(0.53485924F, result[2]);
		result = cPYCC.fromRGB(new float[3]);
		aeq(9.155413E-4F, result[0]);
		aeq(0.6117647F, result[1]);
		aeq(0.53485924F, result[2]);

		ColorSpace cCIEXYZ = ColorSpace.getInstance(ColorSpace.CS_CIEXYZ);
		aeq(false, cCIEXYZ.isCS_sRGB());
		aeq(0, cCIEXYZ.getType());
		aeq(3, cCIEXYZ.getNumComponents());
		aeq("X", cCIEXYZ.getName(0));
		aeq(0.0F, cCIEXYZ.getMinValue(0));
		aeq(1.9999695F, cCIEXYZ.getMaxValue(0));
		aeq("Y", cCIEXYZ.getName(1));
		aeq(0.0F, cCIEXYZ.getMinValue(1));
		aeq(1.9999695F, cCIEXYZ.getMaxValue(1));
		aeq("Z", cCIEXYZ.getName(2));
		aeq(0.0F, cCIEXYZ.getMinValue(2));
		aeq(1.9999695F, cCIEXYZ.getMaxValue(2));

		result = cCIEXYZ.toCIEXYZ(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cCIEXYZ.toRGB(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cCIEXYZ.fromCIEXYZ(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);
		result = cCIEXYZ.fromRGB(new float[3]);
		aeq(0.0F, result[0]);
		aeq(0.0F, result[1]);
		aeq(0.0F, result[2]);

		new float[] { 0.0F, 0.0F, 0.0F }.getClass(); // triangle bevel
		new float[] { 0.0F, 0.0F, 1.0F }.getClass();
		new float[] { 0.0F, 1.0F, 0.0F }.getClass(); 
		new float[] { 0.0F, 1.0F, 1.0F }.getClass(); 
		new float[] { 1.0F, 0.0F, 0.0F }.getClass(); 
		new float[] { 1.0F, 0.0F, 1.0F }.getClass(); 
		new float[] { 1.0F, 1.0F, 0.0F }.getClass(); 
		new float[] { 1.0F, 1.0F, 1.0F }.getClass(); 

	}

	@SuppressWarnings("unused")
	private static class C extends ColorSpace {

		private static final long serialVersionUID = 1L;

		protected C(int type, int numcomponents) {
			super(type, numcomponents);
		}

		@Override
		public float[] toRGB(float[] colorvalue) {
			return null;
		}

		@Override
		public float[] fromRGB(float[] rgbvalue) {
			return null;
		}

		@Override
		public float[] toCIEXYZ(float[] colorvalue) {
			return null;
		}

		@Override
		public float[] fromCIEXYZ(float[] colorvalue) {
			return null;
		}

	}
}