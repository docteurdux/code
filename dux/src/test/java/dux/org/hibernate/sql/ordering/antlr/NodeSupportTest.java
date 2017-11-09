package dux.org.hibernate.sql.ordering.antlr;

import org.hibernate.sql.ordering.antlr.NodeSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import antlr.CommonAST;

@Done
public class NodeSupportTest extends AbstractTest {
	@Test
	public void test() {
		aeq(CommonAST.class, NodeSupport.class.getSuperclass());

		NodeSupport support = new NodeSupport();
		support.setText("text");
		aeq("text", support.getText());
		aeq("text", support.getDebugText());
		aeq("text", support.getRenderableText());
	}
}
