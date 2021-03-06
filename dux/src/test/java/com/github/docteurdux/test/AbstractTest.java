package com.github.docteurdux.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dum.org.hibernate.DummySessionEventListener;

public abstract class AbstractTest {

	protected static final Boolean[] BOOLEANS = { null, Boolean.FALSE, Boolean.TRUE };
	protected static final boolean[] booleans = { false, true };
	private static boolean tried;
	private static RuntimeException requireSourcesException;
	private ObjectMapper om;

	@SuppressWarnings("rawtypes")
	public Map<String, Recorder> recorders = new HashMap<>();
	private int baeqOffset;

	public AbstractTest() {
		recorders = new HashMap<>();
	}

	protected void at(Boolean b) {
		Assert.assertTrue(b);
	}

	protected void af(Boolean b) {
		Assert.assertFalse(b);
	}

	protected void an(Object o) {
		Assert.assertNull(o);
	}

	protected void ann(Object o) {
		Assert.assertNotNull(o);
	}

	protected void aeq(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	protected void aneq(Object expected, Object actual) {
		Assert.assertNotEquals(expected, actual);
	}

	protected void aeqr(Object expected, Object actual) {
		Assert.assertTrue(expected == actual);
	}

	protected TestEvent event(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				return event;
			}
		}
		Assert.fail();
		return null;
	}

	protected void noevent(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				Assert.fail();
			}
		}
	}

	protected void fail() {
		Assert.fail();
	}

	protected Object getField(Object o, String fieldName) {
		return getField(o, fieldName, o.getClass());
	}

	protected Object getField(Object o, String fieldName, Class<?> clazz) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(o);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail();
			return null;
		}
	}

	protected String str(Object o) {
		if (o == null) {
			return "n$";
		}
		if (o instanceof String) {
			return (String) o;
		}
		if (o instanceof Number) {
			return "n$" + o;
		}
		if (o.getClass().isArray()) {
			Class<?> componentType = o.getClass().getComponentType();
			if (componentType == String.class) {
				return "a$" + componentType.getName() + " " + strom(o);
			} else if (Number.class.isAssignableFrom(componentType)) {
				return "a$" + componentType.getName() + " " + strom(o);
			} else {
				return "a$" + o.getClass().getComponentType().getName() + " (" + ((Object[]) o).length + ")";
			}
		}
		if (o instanceof Collection) {
			return "col$" + o.getClass().getName() + " (" + ((Collection) o).size() + ")";
		}
		return "c$" + o.getClass().getName();
	}

	private String strom(Object o) {
		try {
			return getObjectMapper().writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private ObjectMapper getObjectMapper() {
		if (om == null) {
			om = new ObjectMapper();
		}
		return om;
	}

	protected void has4(Map<String, ?> map, String key, Class<?> clazz) {
		aeq(clazz.getName(), map.get(key).getClass().getName());
	}

	protected void summary(List<Class<?>> classes) {
		summary(classes, true, null);
	}

	protected void summary(List<Class<?>> classes, Map<String, Long> sizes) {
		summary(classes, true, sizes);
	}

	protected void summary(List<Class<?>> classes, boolean dumpPackageStats, Map<String, Long> sizes) {
		Map<String, Integer> dones = new HashMap<>();
		Map<String, Integer> notDones = new HashMap<>();
		Set<String> packageNames = new HashSet<>();

		for (Class<?> clazz : classes) {
			if (isPackage(clazz)) {
				continue;
			}
			if (clazz.isInterface()) {
				continue;
			}
			if (clazz.isEnum()) {
				continue;
			}
			if (isException(clazz)) {
				continue;
			}
			if (clazz.isAnnotationPresent(XmlType.class)) {
				continue;
			}
			Long sz = null;
			if (sizes != null) {
				sz = sizes.get(clazz.getName());
			}
			String szStr = sz != null ? (" (" + sz + ")") : "";
			String testClassName = "dux." + clazz.getName() + "Test";
			String packageName = clazz.getPackage().getName();
			packageNames.add(packageName);
			try {
				Class<?> testClass = Class.forName(testClassName);

				if (testClass.isAnnotationPresent(Done.class)) {
					dones.put(packageName, get(dones, packageName, 0) + 1);
				} else {

					System.out.println(testClassName + " : not done !" + szStr);
					notDones.put(packageName, get(notDones, packageName, 0) + 1);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(testClassName + " not found" + szStr);
				notDones.put(packageName, get(notDones, packageName, 0) + 1);
			}
		}

		int doneTotal = 0;
		int notDoneTotal = 0;

		for (String packageName : packageNames) {
			Integer done = get(dones, packageName, 0);
			Integer notDone = get(notDones, packageName, 0);
			if (dumpPackageStats) {
				System.out.println(packageName + " : " + done + "/" + (done + notDone));
			}
			doneTotal += done;
			notDoneTotal += notDone;
		}

		System.out.println(doneTotal + "/" + (doneTotal + notDoneTotal));

		if (this.getClass().isAnnotationPresent(Done.class) && notDoneTotal > 0) {
			fail();
		}
	}

	protected void summarize(String jarname) throws IOException {

		List<Class<?>> classes = new ArrayList<>();

		Map<String, Long> sizes = new HashMap<>();

		String cp = System.getProperty("java.class.path");
		for (String p : cp.split(";")) {
			if (p.endsWith(".jar") && p.indexOf('\\') > 0) {
				File f = new File(p);
				if (f.getName().matches(".*" + jarname + ".*")) {
					if (f.exists()) {
						ZipFile z = new ZipFile(p);
						Enumeration<? extends ZipEntry> entries = z.entries();
						while (entries.hasMoreElements()) {
							ZipEntry entry = entries.nextElement();
							String name = entry.getName();
							long size = entry.getCompressedSize();
							if (name.endsWith(".class") && !name.contains("$")) {
								name = name.substring(0, name.length() - 6);
								name = name.replaceAll("/", ".");
								try {
									Class<?> clazz = Class.forName(name);
									classes.add(clazz);
									sizes.put(name, size);
								} catch (NoClassDefFoundError e) {
								} catch (ClassNotFoundException e) {
								} catch (Error e) {

								}
							}
						}
						z.close();
					}
				}
			}
		}

		classes.sort(new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				Long s1 = sizes.get(c1.getName());
				Long s2 = sizes.get(c2.getName());
				if (s1 == null) {
					s1 = 0L;
				}
				if (s2 == null) {
					s2 = 0L;
				}
				return s1 < s2 ? 1 : s1 > s2 ? -1 : 0;
			}

		});

		summary(classes, false, sizes);
	}

	private boolean isException(Class<?> clazz) {
		while (clazz != null) {
			if (clazz == Exception.class) {
				return true;
			}
			clazz = clazz.getSuperclass();
		}
		return false;
	}

	private <T, U> U get(Map<T, U> map, T key, U defaultValue) {
		U value = map.get(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	protected void dumpTestEvents(TestEventCollector tec) {
		for (TestEvent te : tec.getTestEvents()) {
			System.out.println(te.getName());
			for (Entry<String, Object> prop : te.getProps().entrySet()) {
				System.out.println(" - " + prop.getKey() + " : " + str(prop.getValue()));
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T instantiate(Class<?> clazz, Class<?>[] types, Object... params)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?> constructor = clazz.getDeclaredConstructor(types);
		constructor.setAccessible(true);
		return (T) constructor.newInstance(params);
	}

	protected <T> T instantiate(Constructor<T> constructor, Object... params) {
		constructor.setAccessible(true);
		try {
			return (T) constructor.newInstance(params);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	protected Object invoke(Object o, String name) {
		try {
			Method m = o.getClass().getDeclaredMethod(name);
			m.setAccessible(true);
			return m.invoke(o);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	protected Object invoke(Object o, String name, Object... params) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?>[] parameterTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; ++i) {
			parameterTypes[i] = params[i].getClass();
		}
		Method m = o.getClass().getDeclaredMethod(name, parameterTypes);
		m.setAccessible(true);
		return m.invoke(o, params);
	}

	protected Object invoke(Object o, String name, Class<?> clazz, Object... params) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?>[] parameterTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; ++i) {
			parameterTypes[i] = params[i].getClass();
		}
		Method m = clazz.getDeclaredMethod(name, parameterTypes);
		m.setAccessible(true);
		return m.invoke(o, params);
	}

	protected Object invoke(Object o, String name, Class<?> clazz, Class<?>[] types, Object... params)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		Method m = clazz.getDeclaredMethod(name, types);
		m.setAccessible(true);
		return m.invoke(o, params);
	}

	protected void expect(Class<?> clazz, RunnableWhichThrow runnableWhichThrow) {
		Throwable cex = null;
		try {
			runnableWhichThrow.run();
			fail();
		} catch (Throwable e) {
			runnableWhichThrow.inspect(e);
			cex = e;
		}
		aeq(clazz, cex.getClass());
	}

	protected void expect(RunnableWhichThrow runnableWhichThrow) {
		Throwable cex = null;
		try {
			runnableWhichThrow.run();
			fail();
		} catch (Throwable e) {
			runnableWhichThrow.inspect(e);
			cex = e;
		}
	}

	protected void expect(Class<?> clazz, String msg, RunnableWhichThrow runnableWhichThrow) {
		Throwable cex = null;
		try {
			runnableWhichThrow.run();
			fail();
		} catch (Throwable e) {
			aeq(msg, e.getMessage());
			runnableWhichThrow.inspect(e);
			cex = e;
		}
		aeq(clazz, cex.getClass());
	}

	protected TestEvent getTestEvent(TestEventCollector testEventCollector, int idx) {
		return testEventCollector.testEvents.get(idx);
	}

	protected String testEvent(TestEventCollector testEventCollector, int idx) {
		return testEventCollector.testEvents.get(idx).getName();
	}

	protected Object testEvent(TestEventCollector testEventCollector, int idx, String name) {
		return testEventCollector.testEvents.get(idx).getProps().get(name);
	}

	protected boolean isPackage(Class<?> clazz) {
		return !Modifier.isPublic(clazz.getModifiers()) && !Modifier.isProtected(clazz.getModifiers())
				&& !Modifier.isPrivate(clazz.getModifiers());
	}

	protected boolean isPackage(Constructor<?> constructor) {
		return !Modifier.isPublic(constructor.getModifiers()) && !Modifier.isProtected(constructor.getModifiers())
				&& !Modifier.isPrivate(constructor.getModifiers());
	}

	protected void allDifferent(String[] strings) {
		for (int i = 0; i < strings.length; ++i) {
			for (int j = 0; j < strings.length; ++j) {
				if (i == j) {
					continue;
				}
				Assert.assertNotEquals(strings[i], strings[j]);
			}
		}
	}

	protected void log(Object o) {
		if (!this.getClass().isAnnotationPresent(Done.class)) {
			System.out.println(o);
		}
	}

	protected static interface Stringifier<T> {
		String stringify(T t);
	}

	protected <T extends Enum<T>> void dumpMap(Class<T> clazz, Stringifier<T> stringifier) {
		System.out.println("Map<" + clazz.getSimpleName() + ",String> map = new HashMap<>();");
		for (T t : clazz.getEnumConstants()) {
			String key = clazz.getSimpleName() + "." + t.name();
			String value = "\"" + stringifier.stringify(t) + "\"";
			System.out.println("map.put(" + key + "," + value + ");");
		}
	}

	protected <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotationClass) {
		try {
			T ann = clazz.getAnnotation(annotationClass);
			ann(ann);
			return ann;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	protected <T extends Annotation> T getAnnotation(Class<?> clazz, String methodName, Class<?>[] signature,
			Class<T> annotationClass) {
		try {
			T ann = clazz.getMethod(methodName, signature).getAnnotation(annotationClass);
			ann(ann);
			return ann;
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	protected TestEvent getLastTestEvent(TestEventCollector tec) {
		List<TestEvent> testEvents = tec.getTestEvents();
		int sz = testEvents.size();
		if (sz == 0) {
			return null;
		}
		return testEvents.get(sz - 1);
	}

	protected boolean f() {
		return false;
	}

	protected boolean t() {
		return true;
	}

	protected void dumpTestEvents(Object instance) {
		List<TestEvent> allTestEvents = getAllTestEvents(instance);
		dumpTestEvents(allTestEvents);
	}

	protected List<TestEvent> getAllTestEvents(Object instance) {
		List<TestEvent> allTestEvents = new ArrayList<>();

		try {
			Class<?> clazz = instance.getClass();
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				Object value = field.get(instance);
				TestEventCollector tec = null;

				if (value instanceof TestEventCollectorI) {
					tec = ((TestEventCollectorI) value).getTestEventCollector();

				} else if (value instanceof TestEventCollector) {
					tec = (TestEventCollector) value;
				}
				if (tec != null) {

					String tecSourceName = null;
					tecSourceName = tec.getTestEventSourceName();
					if (tecSourceName == null) {
						tecSourceName = value.getClass().getSimpleName();
						if (tecSourceName.startsWith("Dummy")) {
							tecSourceName = tecSourceName.substring("Dummy".length());
						}
					}
					List<TestEvent> testEvents = tec.getTestEvents();
					for (TestEvent testEvent : testEvents) {
						testEvent.setSource(tecSourceName);
						allTestEvents.add(testEvent);
					}
				}
			}
			allTestEvents.sort(new Comparator<TestEvent>() {
				@Override
				public int compare(TestEvent te1, TestEvent te2) {
					return Integer.compare(te1.getId(), te2.getId());
				}
			});
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return allTestEvents;
	}

	protected void dumpTestEvents(List<TestEvent> allTestEvents) {

		try {
			for (TestEvent testEvent : allTestEvents) {
				StringBuffer buf = new StringBuffer();
				buf.append(testEvent.getId());
				buf.append(":");
				buf.append(testEvent.getSource());
				buf.append(":");
				buf.append(testEvent.getName());
				System.out.println(buf.toString());
				for (Entry<String, Object> entry : testEvent.getProps().entrySet()) {
					String name = entry.getKey();
					Object value = entry.getValue();
					String formattedValue = str(value);
					System.out.println(" - " + name + " : " + formattedValue);
				}
				if (testEvent.hasResult()) {
					System.out.println(" => " + testEvent.getResult());
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		try {
			throw new Exception();
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace()[1].getMethodName());
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	protected void ate(TestEventCollector tec, TEI[] inspectors) {
		aeq(inspectors.length, tec.getTestEvents().size());
		for (int i = 0; i < inspectors.length; ++i) {
			TEI inspector = inspectors[i];
			TestEvent testEvent = tec.getTestEvents().get(i);
			aeq(inspector.getName(), testEvent.getName());
			inspector.i(testEvent.getProps());
		}
	}

	protected void ate(TestEvent testEvent, TEI inspector) {
		aeq(inspector.getName(), testEvent.getName());
		inspector.i(testEvent.getProps());
	}

	protected void tesz(TestEventCollector tec, int sz) {
		aeq(sz, tec.getTestEvents().size());
	}

	protected void dumpTree(Class<?> clazz, Set<String> set) {
		if (clazz == null) {
			return;
		}
		String name = clazz.getName();
		Class<?> superClazz = clazz.getSuperclass();
		if (superClazz != null) {
			set.add("\"" + name + "\" -> \"" + superClazz.getName() + "\";");
			dumpTree(superClazz, set);
		}
		for (Class<?> i : clazz.getInterfaces()) {
			set.add("\"" + name + "\" -> \"" + i.getName() + "\";");
			dumpTree(i, set);
		}

	}

	protected void requireSources(String mvnName, Class<?>... classes) {

		if (tried) {
			if (requireSourcesException != null) {
				throw requireSourcesException;
			}
			return;
		}

		boolean refreshNeeded = false;

		tried = true;

		String userDir = System.getProperty("user.dir");

		Set<String> targets = new HashSet<>();
		for (Class<?> clazz : classes) {
			String name = clazz.getName();
			name = name.replaceAll("\\.", "/");
			name = name + ".java";
			targets.add(name);
		}

		try {
			for (String cp : System.getProperty("java.class.path").split(";")) {
				if (cp.contains(mvnName)) {
					cp = cp.replace(".jar", "-sources.jar");
					File f = new File(cp);
					if (f.exists()) {
						ZipFile z = new ZipFile(cp);
						Enumeration<? extends ZipEntry> entries = z.entries();
						while (entries.hasMoreElements()) {
							ZipEntry entry = entries.nextElement();
							String name = entry.getName();
							if (targets.contains(name)) {
								InputStream is = z.getInputStream(entry);
								String targetFileName = userDir + "/src/main/java/" + name;
								File targetFile = new File(targetFileName);
								if (targetFile.exists()) {
									System.out.println(targetFileName + " exists");
								} else {
									System.out.println(targetFileName + " does not exist ; creating it");
									targetFile.getParentFile().mkdirs();
									targetFile.createNewFile();
									FileOutputStream fos = new FileOutputStream(targetFile);
									IOUtils.copy(is, fos);
									refreshNeeded = true;
								}
							}
						}
						z.close();
					}
				}
			}
		} catch (Exception ex) {
			requireSourcesException = new RuntimeException(ex);
			throw requireSourcesException;
		}

		if (refreshNeeded) {
			requireSourcesException = new RuntimeException(
					"Project content modified ; refresh workspace and try again");
			throw requireSourcesException;
		}
	}

	protected void requireAllSourcesBut(String mvnName, String... classnames) {

		if (tried) {
			if (requireSourcesException != null) {
				throw requireSourcesException;
			}
			return;
		}

		boolean refreshNeeded = false;

		tried = true;

		String userDir = System.getProperty("user.dir");

		Set<String> blacklist = new HashSet<>();
		for (String name : classnames) {
			name = name.replaceAll("\\.", "/");
			name = name + ".java";
			blacklist.add(name);
		}

		try {
			for (String cp : System.getProperty("java.class.path").split(";")) {
				if (cp.contains(mvnName)) {
					cp = cp.replace(".jar", "-sources.jar");
					File f = new File(cp);
					if (f.exists()) {
						ZipFile z = new ZipFile(cp);
						Enumeration<? extends ZipEntry> entries = z.entries();
						while (entries.hasMoreElements()) {
							ZipEntry entry = entries.nextElement();
							String name = entry.getName();
							if (name.endsWith(".java")) {
								InputStream is = z.getInputStream(entry);
								String targetFileName = userDir + "/src/main/java/" + name;
								File targetFile = new File(targetFileName);
								if (targetFile.exists()) {
									if (blacklist.contains(name)) {
										System.out.println("Delete [blacklisted]: " + targetFileName);
										targetFile.delete();
										refreshNeeded = true;
									}
									// System.out.println("Exists: " + targetFileName);
								} else {
									if (!blacklist.contains(name)) {
										System.out.println("Create: " + targetFileName);
										targetFile.getParentFile().mkdirs();
										targetFile.createNewFile();
										FileOutputStream fos = new FileOutputStream(targetFile);
										IOUtils.copy(is, fos);
										refreshNeeded = true;
									} else {
										// System.out.println("Blacklist: " + targetFileName);
									}

								}
							}
						}
						z.close();
					}
				}
			}
		} catch (Exception ex) {
			requireSourcesException = new RuntimeException(ex);
			throw requireSourcesException;
		}

		if (refreshNeeded) {
			requireSourcesException = new RuntimeException(
					"Project content modified ; refresh workspace and try again");
			throw requireSourcesException;
		}
	}

	protected void resetRequireAllSources() {
		tried = false;
		requireSourcesException = null;
	}

	@SuppressWarnings("unchecked")
	protected <T> T get(Map<String, Object> map, String key, Class<T> clazz) {
		return (T) map.get(key);
	}

	protected boolean isProtected(Constructor<?> constructor) {
		return Modifier.isProtected(constructor.getModifiers());
	}

	protected <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	protected void generateTestEventCollection(Class<DummySessionEventListener> clazz) {
		for (Method method : clazz.getDeclaredMethods()) {
			System.out.println("testEvents.add(new TestEvent(\"" + method.getName() + "\")");
			for (Parameter p : method.getParameters()) {
				String name = p.getName();
				System.out.println(".prop(\"" + name + "\"," + name + ")");
			}
			System.out.println(");");
		}
		throw new RuntimeException("HALT !");
	}

	protected Set<Class<?>> collectInheritance(Object o) {
		Set<Class<?>> classes = new HashSet<>();
		if (o != null) {
			if (o instanceof Class) {
				collectInheritance((Class<?>) o, classes);
			} else {
				collectInheritance(o.getClass(), classes);
			}
		}
		return classes;

	}

	protected void collectInheritance(Class<?> clazz, Set<Class<?>> classes) {
		if (clazz != null && !classes.contains(clazz)) {
			classes.add(clazz);
			collectInheritance(clazz.getSuperclass(), classes);
			for (Class<?> i : clazz.getInterfaces()) {
				collectInheritance(i, classes);
			}
		}
	}

	protected List<Class<?>> sortClassesByName(Set<Class<?>> set) {
		List<Class<?>> list = new ArrayList<>();
		list.addAll(set);
		return sortClassesByName(list);
	}

	protected List<Class<?>> sortClassesByName(List<Class<?>> list) {
		list.sort(new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> o1, Class<?> o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list;
	}

	protected List<WeakReference<Class<?>>> sortClassesByNameWR(Collection<WeakReference<Class<?>>> list) {
		return list.stream().filter(new Predicate<WeakReference<Class<?>>>() {
			@Override
			public boolean test(WeakReference<Class<?>> t) {
				return t.get() != null;
			}
		}).sorted(new Comparator<WeakReference<Class<?>>>() {
			@Override
			public int compare(WeakReference<Class<?>> o1, WeakReference<Class<?>> o2) {
				return o1.get().getName().compareTo(o2.get().getName());
			}
		}).collect(Collectors.toList());
	}

	protected boolean hasBeenCalled(String source, String name) {
		for (TestEvent te : TestEvents.getTestEvents()) {
			if (source.equals(te.getSource()) && name.equals(te.getName())) {
				return true;
			}
		}
		return false;
	}

	protected void include(Class<?> clazz) {

	}

	protected Object isAbstract(Class<?> clazz) {
		return Modifier.isAbstract(clazz.getModifiers());
	}

	protected void next(Class<?> clazz) {
	}

	protected void ateq(String name, String method, Object arg0) {
		for (TestEvent te : TestEvents.getTestEvents()) {
			if (name.equals(te.getSource()) && method.equals(te.getName())) {
				aeq(arg0, te.getProps().get("arg0"));
				return;
			}
		}
		fail();
	}

	protected void baeq(byte[] actual, int... expected) {
		for (int ex : expected) {
			aeq((byte) ex, actual[baeqOffset]);
			++baeqOffset;
		}
	}

	protected void baeq(byte[] actual, byte[] expected) {
		for (int ex : expected) {
			aeq((byte) ex, actual[baeqOffset]);
			++baeqOffset;
		}
	}

	protected void baeqEnd(byte[] actual) {
		aeq(baeqOffset, actual.length);
	}

	protected void baeqOffset(int offset) {
		baeqOffset = offset;
	}

	protected void dumpBytes(byte[] bytes) {
		boolean sep = false;
		for (byte b : bytes) {
			if (sep) {
				System.out.print(", ");
			}
			System.out.print(String.format("0x%02X ", b));
			sep = true;
		}
	}

	protected byte[] bytes(int... ints) {
		byte[] bytes = new byte[ints.length];
		for (int i = 0; i < ints.length; ++i) {
			bytes[i] = (byte) ints[i];
		}
		return bytes;
	}

	protected void cleanupSources(String mvnName) throws IOException {

		String userDir = System.getProperty("user.dir");

		for (String cp : System.getProperty("java.class.path").split(";")) {
			if (cp.contains(mvnName)) {
				cp = cp.replace(".jar", "-sources.jar");
				File f = new File(cp);
				if (f.exists()) {
					ZipFile z = new ZipFile(cp);
					Enumeration<? extends ZipEntry> entries = z.entries();
					while (entries.hasMoreElements()) {
						ZipEntry entry = entries.nextElement();
						String name = entry.getName();
						if (name.endsWith(".java")) {
							String targetFileName = userDir + "/src/main/java/" + name;
							File targetFile = new File(targetFileName);
							if (targetFile.exists()) {
								System.out.println(targetFile.getAbsolutePath());
								targetFile.delete();
							}
						}
					}
					z.close();
				}
			}
		}

	}
}
