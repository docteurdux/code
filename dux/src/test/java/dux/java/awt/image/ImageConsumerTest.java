package dux.java.awt.image;

import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageFilter;
import java.awt.image.PixelGrabber;
import java.util.Hashtable;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ImageConsumer.class)
@Extends({})
@ExtendedBy({ ImageFilter.class, PixelGrabber.class })
@Related({ ColorModel.class })
public class ImageConsumerTest extends AbstractTest {
	@Test
	public void test() {

		ImageConsumer c = Recorder.create(ImageConsumer.class).p();

		int status = 0;
		ColorModel model = null;
		int width = 0;
		int height = 0;
		int hintflags = 0;
		int x = 0;
		int y = 0;
		int w = 0;
		int h = 0;
		byte[] pixels = null;
		int off = 0;
		int scansize = 0;
		int[] pixels2 = null;
		Hashtable<?, ?> props = null;

		c.imageComplete(status);
		c.setColorModel(model);
		c.setDimensions(width, height);
		c.setHints(hintflags);
		c.setPixels(x, y, w, h, model, pixels, off, scansize);
		c.setPixels(x, y, w, h, model, pixels2, off, scansize);
		c.setProperties(props);

		/*-
		imageComplete(int)
		setColorModel(ColorModel)
		setDimensions(int, int)
		setHints(int)
		setPixels(int, int, int, int, ColorModel, byte[], int, int)
		setPixels(int, int, int, int, ColorModel, int[], int, int)
		setProperties(Hashtable<?, ?>)
		 */
	}
}
