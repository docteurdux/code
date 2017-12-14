package com.github.docteurdux.test;

public interface RunnableWhichThrow {
	public void run() throws Throwable;

	public default void inspect(Throwable e) {
	};
}
