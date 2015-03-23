package xom.test.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

public class TaskStatusLogger extends Thread {
	ScheduledFuture<?> future;
	public TaskStatusLogger(ScheduledFuture<?> future) {
		this.future = future;
	}

	public void run() {
		try {
			System.out.println("in here");			
		    System.out.println(future.get());
		    System.out.println("out of here");
		} catch (ExecutionException e) {
		    Throwable cause = e.getCause();
		    cause.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


//public class TaskStatusLogger extends Thread {
//	private ScheduledFuture<?> future;
//	private Logger logger;
//	
//	public TaskStatusLogger(ScheduledFuture<?> future, Logger logger) {
//		this.future = future;
//		this.logger = logger;
//	}
//
//	public void run() {
//		try {
//			logger.debug("Waiting for task to complete..");			
//		    future.get();
//		    logger.debug("Task completed..");
//		} catch (ExecutionException e) {
//		    Throwable cause = e.getCause();
//		    cause.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}