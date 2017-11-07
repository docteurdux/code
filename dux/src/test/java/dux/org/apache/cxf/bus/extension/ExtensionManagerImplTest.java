package dux.org.apache.cxf.bus.extension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.configuration.ConfiguredBeanLocator.BeanLoaderListener;
import org.apache.cxf.transport.DestinationFactory;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ExtensionManagerImplTest extends AbstractTest {

	// @Test
	public void test() {

		List<Object> beans = new ArrayList<>();

		Bus bus = BusFactory.getDefaultBus();
		ExtensionManagerImpl em = (ExtensionManagerImpl) bus.getExtension(ExtensionManager.class);
		BeanLoaderListener<Object> listener = new BeanLoaderListener<Object>() {

			@Override
			public boolean loadBean(String name, Class<? extends Object> type) {
				return true;
			}

			@Override
			public boolean beanLoaded(String name, Object bean) {
				beans.add(bean);
				return false;
			}
		};
		em.loadBeansOfType(Object.class, listener);
		for (Object bean : beans) {
			if (bean != null) {
				System.out.println(bean.getClass().getName());
				try {
					Field field = bean.getClass().getDeclaredField("DEFAULT_NAMESPACES");
					field.setAccessible(true);
					@SuppressWarnings("unchecked")
					List<String> namespaces = (List<String>) field.get(null);
					for (String namespace : namespaces) {
						System.out.println(" - " + namespace);
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException e) {
				}
			} else {
				System.out.println("null!");
			}
		}
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test1() {

		List<Object> beans = new ArrayList<>();

		Bus bus = BusFactory.getDefaultBus();
		ExtensionManagerImpl em = (ExtensionManagerImpl) bus.getExtension(ExtensionManager.class);
		BeanLoaderListener<DestinationFactory> listener = new BeanLoaderListener<DestinationFactory>() {

			@Override
			public boolean loadBean(String name, Class<? extends DestinationFactory> type) {
				return true;
			}

			@Override
			public boolean beanLoaded(String name, DestinationFactory bean) {
				beans.add(bean);
				return false;
			}
		};
		em.loadBeansOfType(DestinationFactory.class, listener);
		for (Object bean : beans) {
			if (bean != null) {
				System.out.println(bean.getClass().getName());
				try {
					Field field = bean.getClass().getDeclaredField("DEFAULT_NAMESPACES");
					field.setAccessible(true);
					@SuppressWarnings("unchecked")
					List<String> namespaces = (List<String>) field.get(null);
					for (String namespace : namespaces) {
						System.out.println(" - " + namespace);
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException e) {
				}
			} else {
				System.out.println("null!");
			}
		}
		BusFactory.setDefaultBus(null);
	}
}
