package dux.java.awt.image;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.TileObserver;
import java.awt.image.WritableRaster;
import java.awt.image.WritableRenderedImage;
import java.util.Hashtable;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BufferedImage.class)
@Extends({ Image.class, WritableRenderedImage.class, Transparency.class })
@ExtendedBy({})
@Related({ IndexColorModel.class, WritableRaster.class, TileObserver.class, Rectangle.class, ImageObserver.class,
		Raster.class })
public class BufferedImageTest extends AbstractTest {
	@Test
	public void test() {

		int width = 0;
		int height = 0;
		int imageType = 0;
		IndexColorModel cm = null;
		WritableRaster raster = null;
		boolean isRasterPremultiplied = false;
		Hashtable<?, ?> properties = null;
		BufferedImage img = new BufferedImage(width, height, imageType);
		img = new BufferedImage(cm, raster, isRasterPremultiplied, properties);
		img = new BufferedImage(width, height, imageType, cm);

		TileObserver to = null;
		boolean isAlphaPremultiplied = false;
		WritableRaster outRaster = null;
		Rectangle rect = null;
		ImageObserver observer = null;
		String name = null;
		int x = 0;
		int y = 0;
		int startX = 0;
		int startY = 0;
		int w = 0;
		int h = 0;
		int[] rgbArray = null;
		int offset = 0;
		int scansize = 0;
		int tileX = 0;
		int tileY = 0;
		Raster r = null;
		int rgb = 0;

		img.addTileObserver(to);
		img.coerceData(isAlphaPremultiplied);
		img.copyData(outRaster);
		img.createGraphics();
		img.getAlphaRaster();
		img.getColorModel();
		img.getData();
		img.getData(rect);
		img.getGraphics();
		img.getHeight();
		img.getHeight(observer);
		img.getMinTileX();
		img.getMinTileY();
		img.getMinX();
		img.getMinY();
		img.getNumXTiles();
		img.getNumYTiles();
		img.getProperty(name);
		img.getProperty(name, observer);
		img.getPropertyNames();
		img.getRaster();
		img.getRGB(x, y);
		img.getRGB(startX, startY, w, h, rgbArray, offset, scansize);
		img.getSampleModel();
		img.getSource();
		img.getSources();
		img.getSubimage(x, y, w, h);
		img.getTile(tileX, tileY);
		img.getTileGridXOffset();
		img.getTileGridYOffset();
		img.getTileHeight();
		img.getTileWidth();
		img.getTransparency();
		img.getType();
		img.getWidth();
		img.getWidth(observer);
		img.getWritableTile(tileX, tileY);
		img.getWritableTileIndices();
		img.hasTileWriters();
		img.isAlphaPremultiplied();
		img.isTileWritable(tileX, tileY);
		img.releaseWritableTile(tileX, tileY);
		img.releaseWritableTile(tileX, tileY);
		img.removeTileObserver(to);
		img.setData(r);
		img.setRGB(x, y, rgb);
		img.setRGB(startX, startY, w, h, rgbArray, offset, scansize);
		img.toString();

	}
}
