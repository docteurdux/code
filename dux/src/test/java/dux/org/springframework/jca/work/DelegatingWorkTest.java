package dux.org.springframework.jca.work;

import org.junit.Test;
import org.springframework.jca.work.DelegatingWork;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(DelegatingWork.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class DelegatingWorkTest extends AbstractTest {
	@Test
	public void test() {

		Runnable delegate = null;
		DelegatingWork w = new DelegatingWork(delegate);
		w.getDelegate();
		w.release();
		w.run();

	}
}