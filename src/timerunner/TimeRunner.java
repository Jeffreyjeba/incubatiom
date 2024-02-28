package timerunner;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.InputDefectException;
import utility.UtilityHelper;
import utility.TimeUtility;

public class TimeRunner {
	private static Scanner scan=new Scanner(System.in);
	private static Logger logger=Logger.getLogger("FileHandlingRunner");
	TimeUtility task= new TimeUtility();

	public static void main(String...args) {
		try {
			TimeRunner runner=new TimeRunner();
			try {
				UtilityHelper.logSetter("log",true,logger);
			}
			catch(IOException e) {
				logger.warning("The is some thing wrong with input output operation");
				logger.log(Level.WARNING, "",e);
			}
			catch(SecurityException e){
				logger.log(Level.WARNING, "You dont have acces to this file",e);
			}
			boolean loop=true;
			while(loop) {
				int option=runner.getNumber("enter a option between 1 to 3 : ");
				runner.run(option);
				int loopNumber=runner.getNumber("Enter 1 to continue : ");
				loop=(loopNumber!=1)?false : true ;
			}
		}
		finally {
			try {
				if(scan!=null) {
				scan.close();
				}
			}
			catch(Exception e) {
			}
		}
	}

	private void run(int option) {
		switch(option){
		case 1:
			String time=task.localTime();
			logger.info("The time while loging is "+time);
			long milli=System.currentTimeMillis();
			logger.info("The time in milliseconds is : "+milli);
			break;
		case 2:
			int region;
			try {
				region= getZone();
				logger.info(task.currentZoneTime(region));
			} catch (InputDefectException e) {
				logger.log(Level.WARNING,"",e);
			}

			break;
		case 3:
			try {
				long milliSecond ;
				int option1=getNumber("Enter 1 if you want to enter your own time :");
				if(option1==1) {
					logger.info("Enter the long time : ");
					milliSecond =scan.nextLong();
				}
				else {
					milliSecond =System.currentTimeMillis();
				}
				int zoneNo=getZone();
				String day =task.getDay(milliSecond, zoneNo);
				String month= task.getMonth(milliSecond, zoneNo);
				int year= task.getYear(milliSecond,zoneNo);
				logger.info("It is "+day+" of "+month+" of "+year);
			}
			catch (DateTimeException e) {
				logger.log(Level.WARNING,"The milli second exceeds the limit",e);
			}
			catch(InputMismatchException e) {
				logger.log(Level.WARNING,"Please enter a valid long valuet",e);
			}
			catch(InputDefectException e) {
				logger.log(Level.WARNING,"",e);
			}
			break;
		}
	}
	private int getZone() throws InputDefectException {
		Set<String> zoneIdSet=task.getZoneIdSet();
		logger.info("The zone ids are"+zoneIdSet);
		int zoneNo=getNumber("Enter the position of the zone id : ");
		UtilityHelper.lengthIndexCheck(zoneIdSet.size(), zoneNo);
		return zoneNo;
		//return task.getZone(zoneNo);
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
			scan.nextLine();
			return getNumber();
		}
	}
	private int getNumber(String str){
		logger.info(str);
		int temp= getNumber();
		return temp;
	}
}
