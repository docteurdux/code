package com.github.docteurdux.spring.security.dc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import com.github.docteurdux.org.springframework.security.core.AuthenticationDUX;
import com.github.docteurdux.spring.security.LogUtils;
import com.github.docteurdux.spring.security.notes.TU;

public class SergeAbiteboul {
	public static void main(String[] args) {

		List<String> messages = new ArrayList<>();
		LogUtils.recordAndDumpLog(messages, LoggerListener.class);

		LoggerListener l = new LoggerListener();

		authenticationCredentialsNotFound(l);
		authorizationFailure(l);
		authorized(l);
		publicInvocation(l);

		TU.eq(messages.size(), 4);

	}

	private static void publicInvocation(LoggerListener l) {
		Object o = new Object();
		AbstractAuthorizationEvent event = new PublicInvocationEvent(o);
		l.onApplicationEvent(event);

	}

	private static void authorized(LoggerListener l) {
		Object o = new Object();
		ArrayList<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
		Authentication authentication = new AuthenticationDUX();
		AbstractAuthorizationEvent event = new AuthorizedEvent(o, attributes, authentication);
		l.onApplicationEvent(event);
	}

	private static void authorizationFailure(LoggerListener l) {
		Object o = new Object();
		ArrayList<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
		Authentication authentication = new AuthenticationDUX();
		AccessDeniedException accessDeniedException = new AccessDeniedException("babar");
		AbstractAuthorizationEvent event = new AuthorizationFailureEvent(o, attributes, authentication,
				accessDeniedException);
		l.onApplicationEvent(event);
	}

	private static void authenticationCredentialsNotFound(LoggerListener l) {
		Object o = new Object();
		ArrayList<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
		AuthenticationCredentialsNotFoundException credentialsNotFoundException = new AuthenticationCredentialsNotFoundException(
				"babar");
		AbstractAuthorizationEvent event = new AuthenticationCredentialsNotFoundEvent(o, attributes,
				credentialsNotFoundException);
		l.onApplicationEvent(event);
	}

	
}
