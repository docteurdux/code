package dux.org.hibernate.query.criteria.internal;

import org.hibernate.query.criteria.internal.AbstractNode;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

@Done
public class AbstractNodeTest extends AbstractTest {
	@Test
	public void test() {

		CriteriaBuilderImpl criteriaBuilderImpl = CriteriaBuilderImplUtils.getAnInstance();

		AbstractNode abstractNode = new AbstractNode(criteriaBuilderImpl) {
			private static final long serialVersionUID = 1L;
		};

		aeqr(criteriaBuilderImpl, abstractNode.criteriaBuilder());
	}
}
