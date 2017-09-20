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

	public static void eq(int a, int b) {
		if (a != b) {
			throw new RuntimeException("Not equal !");
		}

	}

	public static void eq(String a, String b) {

		if (a == null && b != null || !a.equals(b)) {
			throw new RuntimeException("Not equal !");
		}
	}

}
