package com.github.docteurdux.test;

import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Jdk14Logger;
import org.junit.Assert;

public class TS {
	public static Level setLogLevel(Log log, Level level) {
		Assert.assertTrue(log instanceof Jdk14Logger);
		Jdk14Logger logj = (Jdk14Logger) log;
		Level previousLevel = logj.getLogger().getLevel();
		logj.getLogger().setLevel(level);
		return previousLevel;
	}
}
