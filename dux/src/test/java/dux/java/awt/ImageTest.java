package dux.java.awt;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.VolatileImage;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.awt.image.BufferedImageTest;

@Topic(Image.class)
@Extends({})
@ExtendedBy({ BufferedImageTest.class, VolatileImage.class })
@Related({ GraphicsConfiguration.class, ImageObserver.class, ImageProducer.class, Graphics.class })
public class ImageTest extends AbstractTest {
	@Test
	public void test() {

		Image i = new I();

		GraphicsConfiguration gc = null;
		int width = 0;
		int height = 0;
		int hints = 0;
		float priority = 0;

		i.flush();
		i.getAccelerationPriority();
		i.getCapabilities(gc);
		i.getScaledInstance(width, height, hints);
		i.setAccelerationPriority(priority);
		/*-
		Image()
		flush()
		getAccelerationPriority()
		getCapabilities(GraphicsConfiguration)
		getScaledInstance(int, int, int)
		setAccelerationPriority(float)
		 */

	}

	private static class I extends Image {

		@Override
		public int getWidth(ImageObserver observer) {
			return 0;
		}

		@Override
		public int getHeight(ImageObserver observer) {
			return 0;
		}

		@Override
		public ImageProducer getSource() {
			return null;
		}

		@Override
		public Graphics getGraphics() {
			return null;
		}

		@Override
		public Object getProperty(String name, ImageObserver observer) {
			return null;
		}

	}
}
