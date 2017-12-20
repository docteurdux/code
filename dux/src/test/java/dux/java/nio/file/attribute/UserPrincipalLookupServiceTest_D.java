package dux.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(UserPrincipalLookupService.class)
public class UserPrincipalLookupServiceTest_D extends AbstractTest {

	@Test
	public void test() {
		aeq(true, FileSystems.getDefault().getUserPrincipalLookupService() != null);
	}

	@SuppressWarnings("unused")
	private void exampleInvocation() throws IOException {
		testByGroupName("Administrateurs", "BUILTIN\\Administrateurs");
	}

	/* This is very system dependent ; to be called manually */
	@SuppressWarnings("unused")
	private void testByName(String inputName, String expectedName) throws IOException {
		FileSystem fs = FileSystems.getDefault();
		UserPrincipalLookupService service = fs.getUserPrincipalLookupService();
		UserPrincipal principal = service.lookupPrincipalByName(inputName);
		aeq(expectedName, principal.getName());
	}

	/* This is very system dependent ; to be called manually */
	@SuppressWarnings("unused")
	private void testByGroupName(String inputName, String expectedName) throws IOException {
		FileSystem fs = FileSystems.getDefault();
		UserPrincipalLookupService service = fs.getUserPrincipalLookupService();
		GroupPrincipal principal = service.lookupPrincipalByGroupName(inputName);
		aeq(expectedName, principal.getName());
	}

}
