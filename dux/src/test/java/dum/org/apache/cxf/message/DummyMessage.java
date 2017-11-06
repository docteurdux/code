package dum.org.apache.cxf.message;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Destination;

public class DummyMessage implements Message {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInterceptorChain(InterceptorChain chain) {
		// TODO Auto-generated method stub

	}

	@Override
	public Destination getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange getExchange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExchange(Exchange exchange) {
		// TODO Auto-generated method stub

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

	@Override
	public <T> T getContent(Class<T> format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void setContent(Class<T> format, Object content) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetContextCache() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getContextualPropertyKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
