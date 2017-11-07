package dum.org.apache.cxf.transport;

import java.io.IOException;

import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.ws.addressing.EndpointReferenceType;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyConduit extends TestEventCollector implements Conduit {

	private MessageObserver messageObserver;
	private EndpointReferenceType target;

	@Override
	public void setMessageObserver(MessageObserver observer) {
		this.messageObserver = observer;
	}

	@Override
	public MessageObserver getMessageObserver() {
		return messageObserver;
	}

	@Override
	public void prepare(Message message) throws IOException {
		testEvents.add(new TestEvent("prepare"));
	}

	@Override
	public void close(Message message) throws IOException {
		testEvents.add(new TestEvent("close"));
	}

	@Override
	public EndpointReferenceType getTarget() {
		return target;
	}

	@Override
	public void close() {
		testEvents.add(new TestEvent("close"));
	}

}
