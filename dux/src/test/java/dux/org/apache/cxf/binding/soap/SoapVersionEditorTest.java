package dux.org.apache.cxf.binding.soap;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapVersionEditor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SoapVersionEditorTest extends AbstractTest {

	@Test
	public void test() {
		SoapVersionEditor editor = new SoapVersionEditor();

		editor.setAsText("1.1");
		at(editor.getValue() instanceof Soap11);

		editor.setAsText("1.2");
		at(editor.getValue() instanceof Soap12);
	}
}
