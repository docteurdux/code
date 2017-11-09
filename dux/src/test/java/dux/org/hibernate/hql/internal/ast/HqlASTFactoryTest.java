package dux.org.hibernate.hql.internal.ast;

import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.hibernate.hql.internal.ast.tree.Node;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import antlr.ASTFactory;

@Done
public class HqlASTFactoryTest extends AbstractTest {
	@Test
	public void test() {
		aeq(ASTFactory.class, HqlASTFactory.class.getSuperclass());

		HqlASTFactory f = new HqlASTFactory();
		
		int anyint = 0;
		aeq(Node.class, f.getASTNodeType(anyint));
	}

}
