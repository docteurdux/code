package dux.org.junit.runner;

import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import dux.org.junit.runner.RunWithTest.R;

@RunWith(value = R.class)
public class RunWithTest {

	public static class R extends Runner {

		@Override
		public Description getDescription() {
			return Description.EMPTY;
		}

		@Override
		public void run(RunNotifier notifier) {

		}

	}

}
