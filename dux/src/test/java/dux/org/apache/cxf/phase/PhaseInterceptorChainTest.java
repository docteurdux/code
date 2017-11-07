package dux.org.apache.cxf.phase;

import java.util.Collection;
import java.util.Set;

import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain.State;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.cxf.message.DummyMessage;

public class PhaseInterceptorChainTest extends AbstractTest {
	@Test
	public void test() {
		PhaseManagerImpl pm = new PhaseManagerImpl();
		PhaseInterceptorChain chain = new PhaseInterceptorChain(pm.getInPhases());
		an(PhaseInterceptorChain.getCurrentMessage());
		Message message = new DummyMessage();
		// PhaseInterceptorChain.setCurrentMessage(chain, message);
		aeq(State.EXECUTING, chain.getState());

		chain.releaseChain();

		// chain = chain.cloneChain();

		PhaseInterceptor<? extends Message> interceptor = new PhaseInterceptor<Message>() {

			@Override
			public void handleMessage(Message message) throws Fault {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleFault(Message message) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Set<String> getAfter() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Set<String> getBefore() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPhase() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<PhaseInterceptor<? extends Message>> getAdditionalInterceptors() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		chain.add(interceptor);
		
		chain.pause();
		chain.unpause();
		chain.suspend();
		chain.resume();
		chain.reset();
		
		
		
		
	}
}
