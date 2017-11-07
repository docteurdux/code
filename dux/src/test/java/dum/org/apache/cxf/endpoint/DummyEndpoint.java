package dum.org.apache.cxf.endpoint;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.apache.cxf.binding.Binding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.MessageObserver;

public class DummyEndpoint implements Endpoint {

	private Map<String, Object> map = new HashMap<>();
	private MessageObserver inFaultObserver;
	private MessageObserver outFaultObserver;
	private Executor executor;
	private List<Feature> features;
	private List<Closeable> hooks = new ArrayList<>();
	private EndpointInfo endpointInfo;
	private Binding binding;
	private Service service;
	private List<Interceptor<? extends Message>> inInterceptors = new ArrayList<>();
	private List<Interceptor<? extends Message>> outInterceptors = new ArrayList<>();
	private List<Interceptor<? extends Message>> inFaultInterceptors = new ArrayList<>();
	private List<Interceptor<? extends Message>> outFaultInterceptors = new ArrayList<>();

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<String> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<Object> values() {
		return map.values();
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	@Override
	public List<Interceptor<? extends Message>> getInInterceptors() {
		return inInterceptors;
	}

	@Override
	public List<Interceptor<? extends Message>> getOutInterceptors() {
		return outInterceptors;
	}

	@Override
	public List<Interceptor<? extends Message>> getInFaultInterceptors() {
		return inFaultInterceptors;
	}

	@Override
	public List<Interceptor<? extends Message>> getOutFaultInterceptors() {
		return outFaultInterceptors;
	}

	@Override
	public EndpointInfo getEndpointInfo() {
		return endpointInfo;
	}

	public void setEndpointInfo(EndpointInfo endpointInfo) {
		this.endpointInfo = endpointInfo;
	}

	@Override
	public Binding getBinding() {
		return binding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	@Override
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public void setExecutor(Executor executor) {
		this.executor = executor;

	}

	@Override
	public Executor getExecutor() {
		return executor;
	}

	@Override
	public MessageObserver getInFaultObserver() {
		return inFaultObserver;
	}

	@Override
	public MessageObserver getOutFaultObserver() {
		return outFaultObserver;
	}

	@Override
	public void setInFaultObserver(MessageObserver observer) {
		this.inFaultObserver = observer;

	}

	@Override
	public void setOutFaultObserver(MessageObserver observer) {
		this.outFaultObserver = observer;

	}

	@Override
	public List<Feature> getActiveFeatures() {
		return features;
	}

	@Override
	public void addCleanupHook(Closeable c) {
		hooks.add(c);
	}

	@Override
	public List<Closeable> getCleanupHooks() {
		return hooks;
	}

}
