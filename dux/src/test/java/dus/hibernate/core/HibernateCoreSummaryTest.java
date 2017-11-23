package dus.hibernate.core;

import java.io.IOException;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class HibernateCoreSummaryTest extends AbstractTest {

	public static final String ARTIFACT_ID = "hibernate-core";
	public static final String VERSION = "5.2.12.Final";
	public static final String MVNNAME = ARTIFACT_ID + "-" + VERSION;

	@Test
	public void test() throws IOException {
		summarize("hibernate-core");
	}
}
