package dux.org.apache.cxf.bus.managers;

import java.util.SortedSet;

import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseManager;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PhaseManagerImplTest extends AbstractTest {
	@Test
	public void test() {

		PhaseManagerImpl pm = new PhaseManagerImpl();
		SortedSet<Phase> inPhases = pm.getInPhases();
		SortedSet<Phase> outPhases = pm.getOutPhases();
		aeq(PhaseManager.class, pm.getRegistrationType());

		aeq(19, inPhases.size());
		aeq(32, outPhases.size());
	}
}
