package dux.org.hibernate.boot.cfgxml.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.cfgxml.internal.CfgXmlAccessServiceImpl;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.cfgxml.spi.LoadedConfig;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CfgXmlAccessServiceImplTest extends AbstractTest {

	private LoadedConfig loadedConfig;
	private Map<String, Object> configurationValues;

	@Before
	public void before() {

		loadedConfig = LoadedConfig.baseline();

		configurationValues = new HashMap<>();
		configurationValues.put(CfgXmlAccessService.LOADED_CONFIG_KEY, loadedConfig);
	}

	@Test
	public void test() {
		CfgXmlAccessServiceImpl cxasi = new CfgXmlAccessServiceImpl(configurationValues);
		aeqr(loadedConfig, cxasi.getAggregatedConfig());
	}
}
