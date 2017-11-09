package dux.org.hibernate.boot.model.relational;

import org.hibernate.boot.model.relational.InitCommand;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class InitCommandTest extends AbstractTest {
	@Test
	public void test() {

		InitCommand ic = new InitCommand("a", "b");

		String[] commands = ic.getInitCommands();

		aeq("a", commands[0]);
		aeq("b", commands[1]);

	}
}
