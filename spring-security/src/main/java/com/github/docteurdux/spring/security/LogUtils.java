package com.github.docteurdux.spring.security;

import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;

import com.github.docteurdux.spring.security.notes.TU;

public class LogUtils {
	public static void recordAndDumpLog(List<String> messages, Class<?> clazz) {
		Log log = LogFactory.getLog(clazz);
		TU.tru(log instanceof Jdk14Logger);

		Jdk14Logger jlog = (Jdk14Logger) log;
		Logger logger = jlog.getLogger();
		logger.setLevel(Level.ALL);
		logger.setFilter(new Filter() {
			@Override
			public boolean isLoggable(LogRecord record) {
				String m = record.getMessage();
				System.out.println(m);
				messages.add(m);
				return false;
			}
		});
	}
}
