package com.github.docteurdux.test;

public interface RunnableWithArgs<T> {
	T run(Object... args);

	static <T> RunnableWithArgs<T> always(T r) {
		return new RunnableWithArgs<T>() {
			@Override
			public T run(Object... args) {
				return r;
			}

		};
	}
}
