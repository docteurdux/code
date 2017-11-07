package dux.cxf.rt.transports.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalDestination;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CXFRTTransportsLocalSummaryTest extends AbstractTest {
	@Test
	public void test() {
		List<Class<?>> classes = new ArrayList<>();

		classes.addAll(Arrays
				.asList(new Class<?>[] { LocalConduit.class, LocalDestination.class, LocalTransportFactory.class }));

		summary(classes);
	}
}
