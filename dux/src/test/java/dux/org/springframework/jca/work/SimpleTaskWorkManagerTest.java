package dux.org.springframework.jca.work;

import javax.resource.spi.work.ExecutionContext;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkListener;

import org.junit.Test;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jca.work.SimpleTaskWorkManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SimpleTaskWorkManager.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SimpleTaskWorkManagerTest extends AbstractTest {
	@Test
	public void test() throws WorkException {

		Work work = null;
		long startTimeout = 0;
		ExecutionContext executionContext = null;
		WorkListener workListener = null;
		AsyncTaskExecutor asyncTaskExecutor = null;
		TaskExecutor syncTaskExecutor = null;

		SimpleTaskWorkManager w = new SimpleTaskWorkManager();
		w.doWork(work);
		w.doWork(work, startTimeout, executionContext, workListener);
		w.scheduleWork(work);
		w.scheduleWork(work, startTimeout, executionContext, workListener);
		w.setAsyncTaskExecutor(asyncTaskExecutor);
		w.setSyncTaskExecutor(syncTaskExecutor);
		w.startWork(work);
		w.scheduleWork(work, startTimeout, executionContext, workListener);

	}
}