package dum.java.util.concurrent;

import java.util.concurrent.Callable;

public class DummyCallable<T> implements Callable<T> {

	private T result;
	private Exception exception;

	public T call() throws Exception {
		if (exception != null) {
			throw exception;
		}
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public void setException(Exception exception) {
		this.exception = exception;

	}

}
