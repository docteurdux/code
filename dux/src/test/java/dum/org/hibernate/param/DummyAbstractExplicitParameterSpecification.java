package dum.org.hibernate.param;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.param.AbstractExplicitParameterSpecification;

public class DummyAbstractExplicitParameterSpecification extends AbstractExplicitParameterSpecification {

	public DummyAbstractExplicitParameterSpecification(int sourceLine, int sourceColumn) {
		super(sourceLine, sourceColumn);
	}

	@Override
	public int bind(PreparedStatement statement, QueryParameters qp, SharedSessionContractImplementor session,
			int position) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String renderDisplayInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
