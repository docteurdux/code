package dux.org.apache.cxf.databinding;

import java.util.Map;

import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.databinding.DataReader;
import org.apache.cxf.databinding.DataWriter;
import org.apache.cxf.service.Service;

public class DummyDataBinding implements DataBinding {

	@Override
	public <T> DataReader<T> createReader(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> DataWriter<T> createWriter(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?>[] getSupportedReaderFormats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?>[] getSupportedWriterFormats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(Service service) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> getDeclaredNamespaceMappings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMtomEnabled(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMtomEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMtomThreshold(int threshold) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMtomThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}

}
