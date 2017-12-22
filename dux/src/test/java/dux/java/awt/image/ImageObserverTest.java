package dux.java.awt.image;

import java.awt.Image;
import java.awt.image.ImageObserver;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ImageObserver.class)
@Extends({})
@ExtendedBy({})
@Related({ Image.class })
public class ImageObserverTest extends AbstractTest {
	@Test
	public void test() {

		ImageObserver io = new IO();

		Image img = null;
		int infoflags = 0;
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		io.imageUpdate(img, infoflags, x, y, width, height);
	}

	private static class IO implements ImageObserver {
		@Override
		public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
			return false;
		}

	}
}
