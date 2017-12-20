package dux.java.nio.file;

import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(OpenOption.class)
public class OpenOptionTest extends AbstractTest {
	@Test
	public void test() {
		OpenOption.class.isAssignableFrom(StandardOpenOption.class);
		OpenOption.class.isAssignableFrom(LinkOption.class);
	}

	@SuppressWarnings("unused")
	private void linkOptionCases(LinkOption o) {
		switch (o) {
		case NOFOLLOW_LINKS:
		default:
			break;
		}
	}

	@SuppressWarnings("unused")
	private void standardOpenOptionCases(StandardOpenOption o) {
		switch (o) {
		case APPEND:
		case CREATE:
		case CREATE_NEW:
		case DELETE_ON_CLOSE:
		case DSYNC:
		case READ:
		case SPARSE:
		case SYNC:
		case TRUNCATE_EXISTING:
		case WRITE:
		default:
			break;

		}
	}
}
