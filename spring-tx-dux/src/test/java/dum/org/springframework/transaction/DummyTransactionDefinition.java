package dum.org.springframework.transaction;

import org.springframework.transaction.TransactionDefinition;

public class DummyTransactionDefinition implements TransactionDefinition {

	private int propagationBehavior;
	private int isolationLevel;
	private int timeout;
	private boolean readOnly;
	private String name;

	public int getPropagationBehavior() {
		return propagationBehavior;
	}

	public int getIsolationLevel() {
		return isolationLevel;
	}

	public int getTimeout() {
		return timeout;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public String getName() {
		return name;
	}

	public void setPropagationBehavior(int propagationBehavior) {
		this.propagationBehavior = propagationBehavior;
	}

	public void setIsolationLevel(int isolationLevel) {
		this.isolationLevel = isolationLevel;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public void setName(String name) {
		this.name = name;
	}

}
