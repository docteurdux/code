package dux.org.hibernate.tool.schema.extract.internal;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.QualifiedSequenceName;
import org.hibernate.tool.schema.extract.internal.SequenceInformationImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SequenceInformationImplTest extends AbstractTest {

	private QualifiedSequenceName qualifiedSequenceName;
	private int incrementSize;

	@Before
	public void before() {
		qualifiedSequenceName = new QualifiedSequenceName(new Identifier("catalogName", false),
				new Identifier("sequenceName", false), new Identifier("schemaName", false));
		incrementSize = 0;
	}

	@Test
	public void test() {

		SequenceInformationImpl ssi = new SequenceInformationImpl(qualifiedSequenceName, incrementSize);

		aeq(incrementSize, ssi.getIncrementSize());
		aeqr(qualifiedSequenceName, ssi.getSequenceName());
	}
}
