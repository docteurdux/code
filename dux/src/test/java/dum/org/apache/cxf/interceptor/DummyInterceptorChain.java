package dum.org.apache.cxf.interceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.MessageObserver;

public class DummyInterceptorChain implements InterceptorChain {

	private MessageObserver faultObserver;
	private State state;
	private List<Interceptor<? extends Message>> interceptors = new ArrayList<>();

	@Override
	public Iterator<Interceptor<? extends Message>> iterator() {
		return interceptors.iterator();
	}

	@Override
	public void add(Interceptor<? extends Message> i) {
		interceptors.add(i);
	}

	@Override
	public void add(Collection<Interceptor<? extends Message>> interceptors) {
		this.interceptors.addAll(interceptors);
	}

	@Override
	public void remove(Interceptor<? extends Message> interceptor) {
		interceptors.remove(interceptor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean doIntercept(Message message) {
		for (Interceptor interceptor : interceptors) {
			interceptor.handleMessage(message);
		}
		return false;
	}

	@Override
	public boolean doInterceptStartingAfter(Message message, String startingAfterInterceptorID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doInterceptStartingAt(Message message, String startingAtInterceptorID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suspend() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unpause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public ListIterator<Interceptor<? extends Message>> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageObserver getFaultObserver() {
		return faultObserver;
	}

	@Override
	public void setFaultObserver(MessageObserver faultObserver) {
		this.faultObserver = faultObserver;
	}

	@Override
	public void abort() {
	}

}
