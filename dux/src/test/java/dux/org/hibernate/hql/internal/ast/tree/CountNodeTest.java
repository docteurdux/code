package dux.org.hibernate.hql.internal.ast.tree;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.tree.CountNode;
import org.hibernate.type.Type;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;

import antlr.SemanticException;
import dum.org.hibernate.dialect.function.DummySQLFunction;
import dum.org.hibernate.type.DummyType;

@Done
public class CountNodeTest extends AbstractTest {
	private Map<DUXFactories, Object> io;

	private String sqlFunctionName;

	private Map<String, SQLFunction> userFunctionMap;

	private DummyType type;

	private DummySQLFunction sf;

	private HqlSqlWalker hqlSqlWalker;

	public CountNodeTest() {

		io = new HashMap<>();

		sqlFunctionName = "sqlFunctionName";

		type = new DummyType();
		sf = new DummySQLFunction();
		sf.setGetReturnTypeRWA(new RunnableWithArgs<Type>() {
			@Override
			public Type run(Object... args) {
				return type;
			}
		});

		userFunctionMap = new HashMap<>();
		userFunctionMap.put(sqlFunctionName, sf);

		io.put(DUXFactories.USER_FUNCTION_MAP, userFunctionMap);

		hqlSqlWalker = DUXFactories.HQL_SQL_WALKER.get(io, HqlSqlWalker.class);

	}

	@Test
	public void test() throws SemanticException {

		CountNode countNode = new CountNode();
		countNode.setText(sqlFunctionName);
		countNode.initialize(hqlSqlWalker);

		aeqr(type, countNode.getDataType());

		countNode.setScalarColumnText(0);

		aeq(" as col_0_0_", countNode.getNextSibling().getText());

	}
}
