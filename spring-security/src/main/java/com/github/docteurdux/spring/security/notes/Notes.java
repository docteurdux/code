package com.github.docteurdux.spring.security.notes;

import java.util.List;

public class Notes extends N {

	public Notes() {
		Todos.core(this);
		Todos.remoting(this);
		Todos.web(this);
		Todos.ldap(this);
		Todos.config(this);
		Todos.acl(this);
		Todos.cas(this);
		Todos.openid(this);
		Todos.taglibs(this);
		Todos.test(this);
	}

	public static void main(String[] args) {

		Notes n = new Notes();

		Partition<Class<?>> p = ClassUtils.filterInterfaces(n.getClasses());
		List<Class<?>> interfaces = p.getMatch();
		ClassUtils.sort(interfaces);
		System.out.println("There are " + interfaces.size() + " interfaces");
		for (Class<?> clazz : interfaces) {
			System.out.println(clazz.getName());
		}
		System.out.println();

		p = ClassUtils.filterExceptions(p.getNomatch());
		List<Class<?>> exceptions = p.getMatch();
		ClassUtils.sort(exceptions);
		System.out.println("There are " + exceptions.size() + " exceptions");
		for (Class<?> clazz : exceptions) {
			System.out.println(clazz.getName());
		}
		System.out.println();

		p = ClassUtils.filterAbstracts(p.getNomatch());
		List<Class<?>> abstracts = p.getMatch();
		ClassUtils.sort(abstracts);
		System.out.println("There are " + abstracts.size() + " abstract classes");
		for (Class<?> clazz : abstracts) {
			System.out.println(clazz.getName());
		}
		System.out.println();

		p = ClassUtils.filterStatics(p.getNomatch());
		List<Class<?>> statics = p.getMatch();
		ClassUtils.sort(statics);
		System.out.println("There are " + statics.size() + " classes with static methods");
		for (Class<?> clazz : statics) {
			System.out.println(clazz.getName());
		}
		System.out.println();

		p = ClassUtils.filterDefaultConstructor(p.getNomatch());
		List<Class<?>> defaultConstructors = p.getMatch();
		ClassUtils.sort(defaultConstructors);
		System.out.println("There are " + defaultConstructors.size() + " classes with public default constructor");
		for (Class<?> clazz : defaultConstructors) {
			System.out.println(clazz.getName());
		}
		System.out.println();

		List<Class<?>> other = p.getNomatch();
		ClassUtils.sort(other);
		System.out.println("There are " + other.size() + " other classes");
		for (Class<?> clazz : other) {
			System.out.println(clazz.getName());
		}

	}
}
