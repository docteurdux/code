package dux.org.hibernate.hql.internal.ast.tree;

import org.hibernate.hql.internal.ast.tree.SqlNode;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.DummyType;

@Done
public class SqlNodeTest extends AbstractTest {

	private DummyType type;

	@Before
	public void before() {
		type = new DummyType();
	}

	@Test
	public void test() {

		SqlNode node = new SqlNode();

		an(node.getOriginalText());

		node.setText("text");
		aeq("text", node.getOriginalText());
		aeq("text", node.getText());

		node.setText(null);
		aeq("text", node.getOriginalText());
		an(node.getText());

		an(node.getDataType());
		node.setDataType(type);
		aeqr(type, node.getDataType());
	}
}
