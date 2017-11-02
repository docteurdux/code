package dux.org.apache.cxf.ws.addressing.soap;

import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class MAPCodecTest extends AbstractTest {

	@Before
	public void before() {

	}

	@Test
	public void test001() {
		MAPCodec codec = new MAPCodec();
		aeq(Phase.PRE_PROTOCOL, codec.getPhase());
	}
}
