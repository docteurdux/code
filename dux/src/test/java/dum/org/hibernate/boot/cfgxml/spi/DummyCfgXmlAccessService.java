package dum.org.hibernate.boot.cfgxml.spi;

import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.cfgxml.spi.LoadedConfig;

public class DummyCfgXmlAccessService implements CfgXmlAccessService {

	private static final long serialVersionUID = 1L;
	
	private LoadedConfig aggregatedConfig;

	@Override
	public LoadedConfig getAggregatedConfig() {
		return aggregatedConfig;
	}

	public void setAggregatedConfig(LoadedConfig aggregatedConfig) {
		this.aggregatedConfig = aggregatedConfig;
	}

}
