package dum.org.hibernate.loader.custom;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.loader.custom.CustomQuery;
import org.hibernate.loader.custom.Return;

public class DummyCustomQuery implements CustomQuery {

	private Set<String> querySpaces = new HashSet<>();
	private String sql;

	@Override
	public String getSQL() {
		return sql;
	}

	public void setSQL(String sql) {
		this.sql = sql;
	}

	@Override
	public Set<String> getQuerySpaces() {
		return querySpaces;
	}

	@Override
	public Map getNamedParameterBindPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Return> getCustomQueryReturns() {
		// TODO Auto-generated method stub
		return null;
	}

}
