package dum.org.apache.cxf.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.message.Message;

public class DummyInterceptorProvider implements InterceptorProvider {

	private List<Interceptor<? extends Message>> inInterceptors = new ArrayList<Interceptor<? extends Message>>();
	private List<Interceptor<? extends Message>> outInterceptors = new ArrayList<Interceptor<? extends Message>>();
	private List<Interceptor<? extends Message>> inFaultInterceptors = new ArrayList<Interceptor<? extends Message>>();
	private List<Interceptor<? extends Message>> outFaultInterceptors = new ArrayList<Interceptor<? extends Message>>();

	public List<Interceptor<? extends Message>> getInInterceptors() {
		return inInterceptors;
	}

	public List<Interceptor<? extends Message>> getOutInterceptors() {
		return outInterceptors;
	}

	public List<Interceptor<? extends Message>> getInFaultInterceptors() {
		return inFaultInterceptors;
	}

	public List<Interceptor<? extends Message>> getOutFaultInterceptors() {
		return outFaultInterceptors;
	}

	public void setInInterceptors(List<Interceptor<? extends Message>> inInterceptors) {
		this.inInterceptors = inInterceptors;
	}

	public void setOutInterceptors(List<Interceptor<? extends Message>> outInterceptors) {
		this.outInterceptors = outInterceptors;
	}

	public void setInFaultInterceptors(List<Interceptor<? extends Message>> inFaultInterceptors) {
		this.inFaultInterceptors = inFaultInterceptors;
	}

	public void setOutFaultInterceptors(List<Interceptor<? extends Message>> outFaultInterceptors) {
		this.outFaultInterceptors = outFaultInterceptors;
	}

}
