package xom.test.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String args[]) {
		ScheduledExecutorService timer = new ScheduledThreadPoolExecutor(1);
		ScheduledFuture<?> future = timer.schedule(new TimerTask(), 1000, TimeUnit.MILLISECONDS);
		
		System.out.println("im starting");
		
//		TaskStatusLogger logger = new TaskStatusLogger(future);		
//		logger.start();
		System.out.println("im ending");
	}


	
}
