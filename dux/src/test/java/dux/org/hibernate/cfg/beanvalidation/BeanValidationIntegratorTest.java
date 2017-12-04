package dux.org.hibernate.cfg.beanvalidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.ValidationMode;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.beanvalidation.BeanValidationIntegrator;
import org.hibernate.engine.config.internal.ConfigurationServiceImpl;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.RunnableWithArgs;

public class BeanValidationIntegratorTest extends AbstractTest {

	private Set<ValidationMode> validationModes;

	private Map<String, Object> configurationSettings;

	private Recorder<ConfigurationService> configurationServiceR;
	private ConfigurationService configurationService;

	private Recorder<ClassLoaderService> classLoaderServiceR;
	private ClassLoaderService classLoaderService;

	private Map<Class<?>, Object> services;

	private Recorder<Metadata> metadataR;
	private Recorder<SessionFactoryImplementor> sessionFactoryImplementorR;
	private Recorder<SessionFactoryServiceRegistry> sessionFactoryServiceRegistryR;

	private Metadata metadata;
	private SessionFactoryImplementor sessionFactoryImplementor;
	private SessionFactoryServiceRegistry sessionFactoryServiceRegistry;

	private Recorder<SessionFactoryOptions> sessionFactoryOptionsR;

	private SessionFactoryOptions sessionFactoryOptions;

	public BeanValidationIntegratorTest() {
	}

	@Before
	public void before() {

		validationModes = null;

		configurationSettings = new HashMap<>();
		configurationSettings.put("javax.persistence.validation.mode", validationModes);

		configurationService = new ConfigurationServiceImpl(configurationSettings);

		classLoaderServiceR = Recorder.create("classLoaderService", this, ClassLoaderService.class);
		classLoaderServiceR.r("classForName", new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				try {
					return Class.forName((String) args[0]);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});
		classLoaderService = classLoaderServiceR.p();

		services = new HashMap<>();
		services.put(ConfigurationService.class, configurationService);
		services.put(ClassLoaderService.class, classLoaderService);

		metadataR = Recorder.create("metadata", this, Metadata.class);
		metadata = metadataR.p();

		sessionFactoryOptionsR = Recorder.create("sessionFactoryOptions", this, SessionFactoryOptions.class);
		sessionFactoryOptions = sessionFactoryOptionsR.p();

		sessionFactoryImplementorR = Recorder.create("sessionFactoryImplementor", this,
				SessionFactoryImplementor.class);
		sessionFactoryImplementorR.v("getSessionFactoryOptions", sessionFactoryOptions);
		sessionFactoryImplementor = sessionFactoryImplementorR.p();

		sessionFactoryServiceRegistryR = Recorder.create("sessionFactoryImplementor", this,
				SessionFactoryServiceRegistry.class);
		sessionFactoryServiceRegistryR.r("getService", new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				return services.get(args[0]);
			}
		});
		sessionFactoryServiceRegistry = sessionFactoryServiceRegistryR.p();

	}

	/*-
	 * org.hibernate.cfg.beanvalidation.BeanValidationIntegrator integrates bean validation into hibernate
	 * 
	 * The javax.persistence.validation.mode configuration setting tells which validation mode to use.
	 * 
	 * If the setting is not set, it defaults to AUTO
	 * 
	 * Available validation modes are AUTO, CALLBACK, NONE, and DDL
	 * 
	 * If validation mode is set to NONE, then bean validation is not integrated.
	 * 
	 * If the javax.validation.Validation class is not available, bean validation is not integrated.
	 * 
	 * If validation mode is AUTO and javax.validation.Validation was not found, bean validation is not integrated.
	 * If validation mode is CALLBACK or DDL and javax.validation.Validation was not found, an exception is triggered.
	 * 
	 * If the javax.validation.Validation class is available and validation mode is not NONE,
	 * then org.hibernate.cfg.beanvalidation.TypeSafeActivator must be available,
	 * and it must have a public static "activate" method.
	 * 
	 * At this point, we need to focus our interest on org.hibernate.cfg.beanvalidation.TypeSafeActivator.
	 * 
	 * Activation of org.hibernate.cfg.beanvalidation.TypeSafeActivator relies on the session factory options of the session factory.
	 * 
	 * In these options, it looks at the validator factory reference. If it is null, then it tries with the configuration service.
	 * 
	 * Finally, if no custom validator factory have been defined, then the default validator factory is created, using the
	 * public static "buildDefaultValidationFactory" method of the javax.validation.Validation class.
	 * 
	 * This method looks for javax.validation.spi.ValidationProvider in
	 * META-INF/services/javax.validation.spi.ValidationProvider
	 * 
	 * Such a file is available in org.hibernate.validator:hibernate-validator
	 * and simply defines org.hibernate.validator.HibernateValidator as a provider
	 * 
	 * The configuration of the validator is quite complex. Among other things, it requires a
	 * javax/el/ExpressionFactory
	 * 
	 */
	@Test
	public void test() {
		BeanValidationIntegrator bvi = new BeanValidationIntegrator();
		bvi.integrate(metadata, sessionFactoryImplementor, sessionFactoryServiceRegistry);
	}
}
