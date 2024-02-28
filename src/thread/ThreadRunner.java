package thread;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.UtilityHelper;

public class ThreadRunner {

	private static Logger logger= Logger.getLogger("thread");
	private static Scanner scan= new Scanner(System.in);
	public static void main(String...args) {
		try {
			UtilityHelper.logSetter("Thread", true, logger);
		} 
		catch (SecurityException e) {
			logger.log(Level.WARNING, "You dont have acces to this file",e);
		} 
		catch (IOException e) {
			logger.log(Level.WARNING, "Something wrong with io opeartion",e);
		}

		boolean loop=true;
		Thread.currentThread().setPriority(6);
		ThreadRunner runner=new ThreadRunner();
		String name=runner.getString("Enter the name of main string");
		Thread.currentThread().setName(name);;
		while(loop) {
			int option= runner.getNumber("Enter a number between 1-5");
			runner.run(option);	
			int end =runner.getNumber("Please enter 1 to continue");
			loop = (end==1);
		}
	}

	private void run(int option) {
		switch(option) {
		case 1:
			Thread thread1= getExtendeThread();
			logProperties();
			thread1.start();
			logProperties();
			break;
		case 2:

			Thread thread2=getRunnableThread();
			Thread thread3=getRunnableThread();
			logProperties();
			thread2.start();
			thread3.start();
			logProperties();
			break;
		case 3:
			Thread thread4= getRunnableThread();
			Thread thread5=getExtendeThread();
			logProperties();
			thread4.start();
			thread5.start();
			logProperties();
			break;
		case 4:
			String nameExtended=getString("Enter the name of the EXTENDED thread : ");
			String nameRunner=getString("Enter the name of RUNNABLE thread : ");
			int limit=getNumber("Enter the number of THREADS to be created in each class : ");
			long[] sleepArray=new long[limit*2];
			ExtendedThread[] extendedThread=new ExtendedThread[limit];
			RunnableThread[] runnableThread=new RunnableThread[limit];
			int index=0;
			int loop2=1;
			while(loop2<=limit){
				logger.info("Enter the sleep for Extended thread "+ (loop2));
				sleepArray[index]=scan.nextLong();
				logger.info("Enter the sleep for runnable thread "+ (loop2));
				sleepArray[index+1]=scan.nextLong();
				loop2++;
				index=index+2;
			}
			try {
				int loop=1;
				int inc=0;
				while(loop<=limit) {
					extendedThread[inc]= new ExtendedThread(nameExtended+loop,sleepArray[inc]);
					runnableThread[inc]=new RunnableThread(sleepArray[inc+1]);
					extendedThread[inc].start();
					new Thread(runnableThread[inc],nameRunner+loop).start();
					loop++;
					inc++;
				}
				
			}
			finally {
				
				stop(extendedThread, runnableThread);
			}
			
		case 5:
			Callable<String> newThread=new CallableThread();
			FutureTask<String> future =new FutureTask<String>(newThread);
			Thread callableThread=new Thread(future,"callableThread");
			callableThread.start();
			logger.info("===");
			try {
				String name=future.get();
				logger.info(name);
			} catch (InterruptedException | ExecutionException e) {
				logger.log(Level.WARNING,"",e);
			}

		}
	}
	private void stop(ExtendedThread[] extendedThread,RunnableThread[] runnableThread) {
		try {
			Thread.currentThread().wait();
			for(ExtendedThread thread:extendedThread) {
				thread.setToggle(false);
			}
			logger.info("EXTENDED threads killed --------------------------------------+");
			Thread.sleep(30000);
			for(RunnableThread thread:runnableThread) {
				thread.setToggle(false);
			}
			logger.info("RUNNABLE threads killed --------------------------------------+");
		} 
		catch (InterruptedException e) {
			for(RunnableThread thread:runnableThread) {
				thread.setToggle(false);
			}
			for(RunnableThread thread:runnableThread) {
				thread.setToggle(false);
			}
		}
	}
	private Thread getExtendeThread() {
		return new ExtendedThread();
	}
	private Thread getRunnableThread() {
		RunnableThread runnable=new RunnableThread();
		return new Thread(runnable);
	}
	private void logProperties() {
		logger.info("__________________________________________");
		logger.info(Thread.currentThread().getName());
		logger.info(""+Thread.currentThread().getPriority());
	}
	private int getNumber(){
		try{

			int temp= scan.nextInt();
			scan.nextLine();
			return temp;
		}
		catch(InputMismatchException x){
			logger.warning("Please eneter an integer");
			logger.warning("Enter again : ");
			return getNumber();
		}
	}
	private int getNumber(String str){
		logger.info(str);
		int temp= getNumber();
		return temp;
	}
	private String getString(){
		return scan.nextLine();
	}
	private String getString(String str){
		logger.info(str);
		return getString();
	}

}
