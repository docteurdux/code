package com.github.docteurdux.test;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

public class DUXMessageSource implements MessageSource {

	@Override
	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return defaultMessage;
	}

	@Override
	public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
		return null;
	}

	@Override
	public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
		return resolvable.getDefaultMessage();
	}

}
