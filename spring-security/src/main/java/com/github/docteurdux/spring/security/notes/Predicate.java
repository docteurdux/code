package com.github.docteurdux.spring.security.notes;

public interface Predicate<T> {
	boolean match(T t);
}
