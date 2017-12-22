package dux.java.awt.image;

import java.awt.image.FilteredImageSource;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.awt.image.renderable.RenderableImageProducer;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ImageProducer.class)
@Extends({})
@ExtendedBy({ FilteredImageSource.class, MemoryImageSource.class, RenderableImageProducer.class })
@Related({ ImageConsumer.class })
public class ImageProducerTest extends AbstractTest {
	@Test
	public void test() {

		ImageProducer p = Recorder.create(ImageProducer.class).p();

		ImageConsumer ic = null;

		p.addConsumer(ic);
		p.isConsumer(ic);
		p.removeConsumer(ic);
		p.requestTopDownLeftRightResend(ic);
		p.startProduction(ic);

		/*-
		addConsumer(ImageConsumer)
		isConsumer(ImageConsumer)
		removeConsumer(ImageConsumer)
		requestTopDownLeftRightResend(ImageConsumer)
		startProduction(ImageConsumer)
		 */
	}
}
