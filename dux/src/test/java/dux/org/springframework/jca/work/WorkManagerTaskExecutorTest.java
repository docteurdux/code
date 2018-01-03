package dux.org.springframework.jca.work;

import java.util.concurrent.Callable;

import javax.naming.NamingException;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.work.ExecutionContext;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkListener;
import javax.resource.spi.work.WorkManager;

import org.junit.Test;
import org.springframework.core.task.TaskDecorator;
import org.springframework.jca.work.WorkManagerTaskExecutor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(WorkManagerTaskExecutor.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class WorkManagerTaskExecutorTest extends AbstractTest {
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test() throws NamingException, WorkException {

		WorkManager workManager = null;
		Work work = null;
		long delay = 0;
		ExecutionContext executionContext = null;
		WorkListener workListener = null;
		Runnable task = null;
		long startTimeout = 0;
		boolean blockUntilCompleted = false;
		boolean blockUntilStarted = false;
		BootstrapContext bootstrapContext = null;
		TaskDecorator taskDecorator = null;
		String workManagerName = null;
		Callable task1 = null;

		WorkManagerTaskExecutor e = new WorkManagerTaskExecutor();
		e = new WorkManagerTaskExecutor(workManager);

		e.afterPropertiesSet();
		e.doWork(work);
		e.doWork(work, delay, executionContext, workListener);
		e.execute(task);
		e.execute(task, startTimeout);
		e.prefersShortLivedTasks();
		e.scheduleWork(work);
		e.scheduleWork(work, delay, executionContext, workListener);
		e.setBlockUntilCompleted(blockUntilCompleted);
		e.setBlockUntilStarted(blockUntilStarted);
		e.setBootstrapContext(bootstrapContext);
		e.setTaskDecorator(taskDecorator);
		e.setWorkListener(workListener);
		e.setWorkManager(workManager);
		e.setWorkManagerName(workManagerName);
		e.startWork(work);
		e.startWork(work, delay, executionContext, workListener);
		e.submit(task);
		e.submit(task1);
		e.submitListenable(task);
		e.submitListenable(task1);
	}
}