package dum.com.mysql.cj.api.conf;

import com.mysql.cj.api.conf.DatabaseUrlContainer;

public class DummyDatabaseUrlContainer implements DatabaseUrlContainer {

	private String databaseUrl;

	@Override
	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

}
