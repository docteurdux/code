package dum.org.apache.cxf.message;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.Session;

public class DummyExchange implements Exchange {

	private Map<Class<?>, Object> classMap = new HashMap<Class<?>, Object>();
	private Message inMessage;
	private Message outMessage;
	private Message inFaultMessage;
	private Message outFaultMessage;
	private Session session;
	private Destination destination;
	private Conduit conduit;
	private boolean oneWay;
	private boolean synchronous;
	private Bus bus;
	private Service service;
	private Endpoint endpoint;
	private Binding binding;
	private BindingOperationInfo bindingOperationInfo;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> key) {
		return (T) classMap.get(key);
	}

	@Override
	public <T> void put(Class<T> key, T value) {
		classMap.put(key, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T remove(Class<T> key) {
		return (T) classMap.remove(key);
	}

	@Override
	public int size() {
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
	public Message getInMessage() {
		return inMessage;
	}

	@Override
	public void setInMessage(Message m) {
		inMessage = m;
	}

	@Override
	public Message getOutMessage() {
		return outMessage;
	}

	@Override
	public void setOutMessage(Message m) {
		outMessage = m;
	}

	@Override
	public Message getInFaultMessage() {
		return inFaultMessage;
	}

	@Override
	public void setInFaultMessage(Message m) {
		inFaultMessage = m;
	}

	@Override
	public Message getOutFaultMessage() {
		return outFaultMessage;
	}

	@Override
	public void setOutFaultMessage(Message m) {
		outFaultMessage = m;
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public Destination getDestination() {
		return destination;
	}

	@Override
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public Conduit getConduit(Message message) {
		return conduit;
	}

	@Override
	public void setConduit(Conduit conduit) {
		this.conduit = conduit;
	}

	@Override
	public boolean isOneWay() {
		return oneWay;
	}

	@Override
	public boolean isSynchronous() {
		return synchronous;
	}

	@Override
	public void setSynchronous(boolean b) {
		synchronous = b;
	}

	@Override
	public void setOneWay(boolean b) {
		oneWay = b;
	}

	@Override
	public void clear() {
		// TODO
	}

	@Override
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public Service getService() {
		return service;
	}

	@Override
	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	@Override
	public Binding getBinding() {
		return binding;
	}

	@Override
	public BindingOperationInfo getBindingOperationInfo() {
		return bindingOperationInfo;
	}

}
