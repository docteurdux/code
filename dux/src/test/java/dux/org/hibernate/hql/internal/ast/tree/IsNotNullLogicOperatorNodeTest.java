package dux.org.hibernate.hql.internal.ast.tree;

import org.hibernate.hql.internal.antlr.HqlSqlTokenTypes;
import org.hibernate.hql.internal.ast.tree.AbstractNullnessCheckNode;
import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IsNotNullLogicOperatorNodeTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(AbstractNullnessCheckNode.class, IsNotNullLogicOperatorNode.class.getSuperclass());

		IsNotNullLogicOperatorNode isNotNullLogicOperatorNode = new IsNotNullLogicOperatorNode();
		aeq(HqlSqlTokenTypes.OR, invoke(isNotNullLogicOperatorNode, "getExpansionConnectorType"));
		aeq("OR", invoke(isNotNullLogicOperatorNode, "getExpansionConnectorText"));

	}
}
