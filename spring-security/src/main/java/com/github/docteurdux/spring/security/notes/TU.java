package com.github.docteurdux.spring.security.notes;

public class TU {

	public static void nil(Object o) {
		if (o != null) {
			throw new RuntimeException("Not null !");
		}
	}

	public static void tru(boolean b) {
		if (!b) {
			throw new RuntimeException("Not true !");
		}
	}

}
