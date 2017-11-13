package dux.org.hibernate.engine.jdbc.internal;

import java.lang.reflect.InvocationHandler;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.engine.jdbc.ColumnNameCache;
import org.hibernate.engine.jdbc.internal.ResultSetWrapperImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.hibernate.ProxyGenerator;

import dum.java.sql.DummyResultSet;
import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.service.DummyServiceRegistry;

@Done
public class ResultSetWrapperImplTest extends AbstractTest {

	private int columnCount;

	private DummyResultSet resultSet;
	private DummyResultSet proxyResultSet;

	private DummyClassLoaderService classLoaderService;

	private DummyServiceRegistry serviceRegistry;

	private ColumnNameCache columnNameCache;

	@Before
	public void before() {

		columnCount = 1;

		resultSet = new DummyResultSet();
		proxyResultSet = new DummyResultSet();

		classLoaderService = new DummyClassLoaderService();
		classLoaderService.setProxyGenerator(new ProxyGenerator() {
			@Override
			public Object generateProxy(InvocationHandler handler, @SuppressWarnings("rawtypes") Class[] interfaces) {
				return proxyResultSet;
			}
		});

		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.setService(ClassLoaderService.class, classLoaderService);

		columnNameCache = new ColumnNameCache(columnCount);
	}

	@Test
	public void test() {

		ResultSetWrapperImpl rswi = new ResultSetWrapperImpl(serviceRegistry);
		aeqr(proxyResultSet, rswi.wrap(resultSet, columnNameCache));
	}
}
