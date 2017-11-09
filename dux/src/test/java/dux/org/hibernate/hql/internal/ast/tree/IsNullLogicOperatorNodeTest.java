package dux.org.hibernate.hql.internal.ast.tree;

import org.hibernate.hql.internal.antlr.HqlSqlTokenTypes;
import org.hibernate.hql.internal.ast.tree.AbstractNullnessCheckNode;
import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IsNullLogicOperatorNodeTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(AbstractNullnessCheckNode.class, IsNullLogicOperatorNode.class.getSuperclass());

		IsNullLogicOperatorNode isNullLogicOperatorNode = new IsNullLogicOperatorNode();

		aeq(HqlSqlTokenTypes.AND, invoke(isNullLogicOperatorNode, "getExpansionConnectorType"));
		aeq("AND", invoke(isNullLogicOperatorNode, "getExpansionConnectorText"));

	}
}
