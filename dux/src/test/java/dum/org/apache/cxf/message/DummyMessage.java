package dum.org.apache.cxf.message;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Destination;

public class DummyMessage implements Message {

	private Map<String, Object> strings = new HashMap<>();
	private Map<Class<?>, Object> contents = new HashMap<>();
	private Map<String, Object> contextualProperties = new HashMap<>();
	private Exchange exchange;
	private InterceptorChain interceptorChain;

	@Override
	public <T> T get(Class<T> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void put(Class<T> key, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T remove(Class<T> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		if (key instanceof String) {
			return strings.get(key);
		}
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		return strings.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return new HashMap<String, Object>().entrySet();
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public InterceptorChain getInterceptorChain() {
		return interceptorChain;
	}

	@Override
	public void setInterceptorChain(InterceptorChain chain) {
		this.interceptorChain = chain;
	}

	@Override
	public Destination getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange getExchange() {
		return exchange;
	}

	@Override
	public void setExchange(Exchange exchange) {
		this.exchange = exchange;

	}

	@Override
	public Collection<Attachment> getAttachments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttachments(Collection<Attachment> attachments) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getContent(Class<T> format) {
		return (T) contents.get(format);
	}

	@Override
	public <T> void setContent(Class<T> format, Object content) {
		contents.put(format, content);
	}

	@Override
	public Set<Class<?>> getContentFormats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void removeContent(Class<T> format) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getContextualProperty(String key) {
		return contextualProperties.get(key);
	}

	public Map<String, Object> getContextualProperties() {
		return contextualProperties;
	}

	@Override
	public void resetContextCache() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getContextualPropertyKeys() {
		return contextualProperties.keySet();
	}

}
