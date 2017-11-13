package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.jaxb.hbm.internal.ImplicitResultSetMappingDefinition;
import org.hibernate.boot.jaxb.hbm.internal.ImplicitResultSetMappingDefinition.Builder;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryCollectionLoadReturnType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryJoinReturnType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryReturnType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryScalarReturnType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ImplicitResultSetMappingDefinitionTest extends AbstractTest {

	@Test
	public void test1() {

		String resultSetMappingName = "resultSetMappingName";

		@SuppressWarnings("rawtypes")
		List valueMappingSources = new ArrayList<>();

		ImplicitResultSetMappingDefinition irsmd = new ImplicitResultSetMappingDefinition(resultSetMappingName,
				valueMappingSources);

		aeq(resultSetMappingName, irsmd.getName());
		aeqr(valueMappingSources, irsmd.getValueMappingSources());
	}

	@Test
	public void test2() {

		Builder b = new Builder("queryName");

		af(b.hasAnyReturns());

		b.addReturn(new JaxbHbmNativeQueryScalarReturnType());
		b.addReturn(new JaxbHbmNativeQueryReturnType());
		b.addReturn(new JaxbHbmNativeQueryJoinReturnType());
		b.addReturn(new JaxbHbmNativeQueryCollectionLoadReturnType());

		at(b.hasAnyReturns());

		ImplicitResultSetMappingDefinition implicitResultSetMappingDefinition = b.build();
		aeq("queryName-inline-result-set-mapping-def", implicitResultSetMappingDefinition.getName());
		aeq(4, implicitResultSetMappingDefinition.getValueMappingSources().size());
	}
}
