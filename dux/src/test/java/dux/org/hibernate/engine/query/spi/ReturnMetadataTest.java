package dux.org.hibernate.engine.query.spi;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.hibernate.type.Type;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ReturnMetadataTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		String[] returnAliases = new String[] {};
		Type[] returnTypes = new Type[] {};

		ReturnMetadata rm = getInstance(returnAliases, returnTypes);

		aeqr(returnAliases, rm.getReturnAliases());
		aeqr(returnTypes, rm.getReturnTypes());

	}

	private ReturnMetadata getInstance(String[] returnAliases, Type[] returnTypes) throws Exception {
		return instantiate(ReturnMetadata.class, new Class<?>[] { String[].class, Type[].class }, returnAliases,
				returnTypes);
	}

}
