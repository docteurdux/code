package dux.org.hibernate.hql.internal.ast.tree;

import org.hibernate.hql.internal.antlr.HqlSqlTokenTypes;
import org.hibernate.hql.internal.antlr.SqlTokenTypes;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.hql.internal.ast.tree.DummyDeleteStatement;

@Done
public class DeleteStatementTest extends AbstractTest {
	
	@Test
	public void test() {
		DummyDeleteStatement deleteStatement = new DummyDeleteStatement();
		aeq(HqlSqlTokenTypes.DELETE, deleteStatement.getStatementType());
		at(deleteStatement.needsExecutor());
		aeq(SqlTokenTypes.FROM, deleteStatement.getWhereClauseParentTokenType());
	}
}
