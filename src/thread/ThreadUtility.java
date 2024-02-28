package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

import utility.InputDefectException;
import utility.UtilityHelper;

public class ThreadUtility {
	
	private static Logger logger= Logger.getLogger("thread");
	
	public void threadDetailPrint() {
		long threadId= Thread.currentThread().getId();
		String threadName= getThreadName();
		int threadPriority= Thread.currentThread().getPriority();
		logger.info("current thread id is : "+threadId);
		logger.info("current thread name is : "+threadName);
		logger.info("current thread priority  is : "+threadPriority);
		logger.info("======================================================================");
	}
	public void threadSleep(long sleepInMillis) {
		logger.info("Going to sleep-----------------"+getThreadName());
		try {
			UtilityHelper.checkNegative(sleepInMillis);
			Thread.sleep(sleepInMillis);
		} catch (InterruptedException e) {
			logger.log(Level.WARNING,"",e);
		}
		catch (InputDefectException e) {
			logger.log(Level.WARNING,"",e);
		}
		logger.info("After sleeping-----------------"+getThreadName());
	}
	public String getThreadName() {
		return Thread.currentThread().getName();
	}
}
