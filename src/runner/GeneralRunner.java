package runner;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rainbow.Rainbow;
import singleton.Singleton;
import utility.InputDefectException;
import utility.UtilityHelper;

public class GeneralRunner {

	private static Logger logger=Logger.getLogger("FileHandlingRunner");
	Scanner scan=new Scanner(System.in);


	public static void main(String[] args) {
		try {
			UtilityHelper.logSetter("general", true, logger);
		}
		catch (SecurityException e) {
			logger.log(Level.WARNING, "You dont have acces to this file",e);
		} 
		catch (IOException e) {
			logger.log(Level.WARNING, "Something wrong with io opeartion",e);
		}
		GeneralRunner runner=new GeneralRunner();


		boolean loop=true;
		while(loop) {
			int option=runner.getNumber("Enter an number between 1 to 2");
			switch(option) {
			case 1:
				runner.rainBow();
				break;
			case 2:
				try {
					runner.singleton();
				}
				catch(InputDefectException e){
					logger.log(Level.WARNING, "",e);
				}
				break;
			default:
				logger.info("Enter a value between 1 to 2");
			}
			int repeat =runner.getNumber("Enter 1 to continue : ");
			if(repeat!=1) {
				loop=false;
			}
		}
	}

	// methods
	private void rainBow() {
		Rainbow[] val1=Rainbow.values();
		for(Rainbow val:val1) {
			logger.info(val.getCode()+" is the key of "+val.toString().toLowerCase());
		}
		Rainbow val2= Rainbow.BLUE;
		logger.info(val2.getCode()+" is the key of "+val2.toString().toLowerCase());
		logger.info(val2.getWord());
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void singleton() throws InputDefectException {
		try {
			Class siClass=Class.forName("singleton.Singleton");
			Constructor constructor=siClass.getDeclaredConstructor(null);
			Method method=siClass.getDeclaredMethod("getString");
			Method method2=siClass.getDeclaredMethod("setString",String.class);
			constructor.setAccessible(true);
			Object construObject=constructor.newInstance();
			method2.invoke(construObject,"jeffrey is good ");
			String str=(String) method.invoke(construObject);
			logger.info("REFLECTION "+str);
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}


		Singleton firstObj =Singleton.getObject();
		logger.info("this is the reflection obj : "+firstObj.getString());
		firstObj.setString(getString("Enter a string :"));
		Singleton secondObj =Singleton.getObject();
		logger.info(secondObj.getString());
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

