package dux.java.awt.image;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.PackedColorModel;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ColorModel.class)
@Extends({ Transparency.class })
@ExtendedBy({ ComponentColorModel.class, IndexColorModel.class, PackedColorModel.class })
@Related({ ColorSpace.class, WritableRaster.class, SampleModel.class })
public class ColorModelTest extends AbstractTest {
	@Test
	public void test() {

		boolean hasAlpha = false;
		boolean isAlphaPremultiplied = false;
		int pixel_bits = 0;
		int transparency = 0;
		int transferType = 0;
		int[] bits = null;
		ColorSpace cspace = null;
		ColorModel c = new C(pixel_bits, bits, cspace, hasAlpha, isAlphaPremultiplied, transparency, transferType);

		int w = 0;
		int h = 0;
		int pixel = 0;
		int offset = 0;
		int componentIdx = 0;
		int normOffset = 0;
		int rgb = 0;
		WritableRaster raster = null;
		Object obj = null;
		Object inData = null;
		int[] components = null;
		Object pixelo = null;
		int[] normComponents = null;
		float[] normComponents2 = null;
		SampleModel sm = null;

		ColorModel.getRGBdefault();
		c.coerceData(raster, isAlphaPremultiplied);
		c.createCompatibleSampleModel(w, h);
		c.createCompatibleWritableRaster(w, h);
		c.equals(obj);
		c.finalize();
		c.getAlpha(inData);
		c.getAlphaRaster(raster);
		c.getBlue(inData);
		c.getColorSpace();
		c.getComponents(pixel, components, offset);
		c.getComponents(pixelo, components, offset);
		c.getComponentSize();
		c.getComponentSize(componentIdx);
		c.getDataElement(normComponents, normOffset);
		c.getDataElement(components, offset);
		c.getDataElements(rgb, pixel);
		c.getDataElements(normComponents, normOffset, obj);
		c.getDataElements(components, offset, obj);
		c.getGreen(inData);
		c.getNormalizedComponents(pixel, normComponents2, normOffset);
		c.getNormalizedComponents(components, offset, normComponents2, normOffset);
		c.getNumColorComponents();
		c.getNumComponents();
		c.getPixelSize();
		c.getRed(inData);
		c.getRGB(pixel);
		c.getRGB(inData);
		c.getTransferType();
		c.getTransparency();
		c.getUnnormalizedComponents(normComponents2, normOffset, components, offset);
		c.hasAlpha();
		c.hashCode();
		c.isAlphaPremultiplied();
		c.isCompatibleRaster(raster);
		c.isCompatibleSampleModel(sm);
		c.toString();

	}

	private static class C extends ColorModel {

		protected C(int pixel_bits, int[] bits, ColorSpace cspace, boolean hasAlpha, boolean isAlphaPremultiplied,
				int transparency, int transferType) {
			super(pixel_bits, bits, cspace, hasAlpha, isAlphaPremultiplied, transparency, transferType);
		}

		@Override
		public int getRed(int pixel) {
			return 0;
		}

		@Override
		public int getGreen(int pixel) {
			return 0;
		}

		@Override
		public int getBlue(int pixel) {
			return 0;
		}

		@Override
		public int getAlpha(int pixel) {
			return 0;
		}

	}
}