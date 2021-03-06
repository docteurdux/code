package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.HqlParser;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

public enum DUXFactories {

	DIALECT() {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return new Dialect() {
			};
		}

	},

	USER_FUNCTION_MAP() {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return new HashMap<String, SQLFunction>();
		}

	},

	SQL_FUNCTION_REGISTRY() {
		@Override
		@SuppressWarnings("unchecked")
		protected Object defval(Map<DUXFactories, Object> io) {
			return new SQLFunctionRegistry((Dialect) DIALECT.get(io),
					(Map<String, SQLFunction>) USER_FUNCTION_MAP.get(io));
		}

	},

	SESSION_FACTORY_IMPLEMENTOR() {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			DummySessionFactoryImplementor sessionFactoryImplementor = new DummySessionFactoryImplementor();
			sessionFactoryImplementor.setSqlFunctionRegistry((SQLFunctionRegistry) SQL_FUNCTION_REGISTRY.get(io));
			return sessionFactoryImplementor;
		}
	},

	QUERY_IDENTIFIER {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return "queryIdentifier";
		}
	},

	QUERY {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return "query";
		}
	},

	ENABLED_FILTERS {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return new HashMap<>();
		}
	},

	QUERY_TRANSLATOR_IMPL {
		@Override
		@SuppressWarnings("rawtypes")
		protected Object defval(Map<DUXFactories, Object> io) {
			return new QueryTranslatorImpl((String) QUERY_IDENTIFIER.get(io), (String) QUERY.get(io),
					(Map) ENABLED_FILTERS.get(io), (SessionFactoryImplementor) SESSION_FACTORY_IMPLEMENTOR.get(io));
		}
	},

	HQL {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return "hql";
		}
	},
	HQL_PARSER {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return HqlParser.getInstance((String) HQL.get(io));
		}
	},

	TOKEN_REPLACEMENTS {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return new HashMap<>();
		}
	},

	COLLECTION_ROLE {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return "collectionRole";
		}
	},

	HQL_SQL_WALKER {
		@SuppressWarnings("rawtypes")
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return new HqlSqlWalker((QueryTranslatorImpl) QUERY_TRANSLATOR_IMPL.get(io),
					(SessionFactoryImplementor) SESSION_FACTORY_IMPLEMENTOR.get(io), (HqlParser) HQL_PARSER.get(io),
					(Map) TOKEN_REPLACEMENTS.get(io), (String) COLLECTION_ROLE.get(io));
		}
	},

	CRITERIA_BUILDER_IMPL {
		@Override
		protected Object defval(Map<DUXFactories, Object> io) {
			return CriteriaBuilderImplUtils.getAnInstance();
		}
	};

	protected abstract Object defval(Map<DUXFactories, Object> io);

	public Object get(Map<DUXFactories, Object> io) {
		if (io.containsKey(this)) {
			return io.get(this);
		} else {
			Object r = defval(io);
			io.put(this, r);
			return r;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Map<DUXFactories, Object> io, Class<T> clazz) {
		return (T) get(io);
	}

}
