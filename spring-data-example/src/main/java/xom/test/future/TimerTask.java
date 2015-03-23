package xom.test.future;

import java.util.concurrent.ExecutionException;

import javax.management.RuntimeErrorException;


public class TimerTask implements Runnable {	
	private StateChange stateTransition;
	
	public TimerTask() {
		this.stateTransition = null;
	}
	
	public void run() {	
		try {
			stateTransition.callback();
		} catch (Exception ex) {
			System.out.println("EXCEPTION!!!!!");
		}
	}		
}


