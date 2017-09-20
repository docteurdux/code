package com.github.docteurdux.spring.security.notes;

import java.util.List;

public class Partition<T> {

	private List<T> match;
	private List<T> nomatch;

	public Partition(List<T> match, List<T> nomatch) {
		this.match = match;
		this.nomatch = nomatch;
	}

	public List<T> getMatch() {
		return match;
	}

	public List<T> getNomatch() {
		return nomatch;
	}

}
