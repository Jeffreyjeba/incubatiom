package runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import regularexpression.RegularExpressionTask;
import utility.InputDefectException;
import utility.UtilityHelper;

public class RegularExpressionRunner {

	private static Scanner scan=new Scanner(System.in);
	private static Logger logger=Logger.getLogger("Regex");


	public static void main(String...args) {
		try {
			UtilityHelper.logSetter("regexLog",true, logger);
		}
		catch (SecurityException | IOException e) {
			logger.warning("Something went wrong with log setting");
		}
		RegularExpressionRunner runner=new RegularExpressionRunner();
		boolean flag =true;
		while(flag) {
			int option=runner.getNumber("Enter the option between 1 to 8 : ");
			runner.run(option);
			int loop=runner.getNumber("Enter 1 to continue");
			flag=(loop==1);
		}
	}

	RegularExpressionTask task =new RegularExpressionTask();

	@SuppressWarnings("rawtypes")
	private void run(int option) {
		switch(option) {
		case 1:
			logger.info("Enter the phone number");
			Long phoneNumber= scan.nextLong();
			boolean result=task.validatePhoenNo(phoneNumber.toString());
			resultLogger(result);
			break;
			
		case 2:
			String alphaNumeric=getString("Enter a alpha numeric statement : ");
			boolean result2= task.ValidateAlphaNume(alphaNumeric);
			resultLogger(!result2);
			break;
			
		case 3:
			String keyString=getString("Enter the key word : ");
			String subject=getString("Enter the subject : ");
			logger.info("1-");
			int innerOption=getNumber("Enter the option inner option :");
			switch (innerOption) {
			case 1:
				boolean result3= task.validateStartsWith(keyString, subject);
				resultLogger(result3);
				break;
			case 2:
				boolean result31= task.validateEndsWith(keyString, subject);
				resultLogger(result31);
				break;
			case 3:
				boolean result32= task.validateContains(keyString, subject);
				resultLogger(result32);
				break;
			case 4:
				boolean result33=task.validateStartsAndEndsWith(keyString, subject);
				resultLogger(result33);
				break;
			default:
				logger.info("Enter a option between 1-4");
				break;
			}
			break;
			
		case 4:
			String key=getString("Enter case insensitive key : ");
			ArrayList<String> arrayList3=multiStringAdd();
			int result4=task.countListInSensitive(key, arrayList3);
			logger.info("The number of occurance is : "+result4);
			break;
			
		case 5:
			String emailId=getString("Enter your emailId : ");
			boolean result5= task.validateEmail(emailId);
			resultLogger(result5);
			break;
			
		case 6:
			ArrayList<String> arrayList6=multiStringAdd();
			int min=getNumber("Enter the number of min characters");
			int max=getNumber("Enter the number of max characters");
			try {
				boolean result6=task.validateLengthRange(arrayList6, min, max);
				resultLogger(result6);
			} catch (InputDefectException e) {
				logger.log(Level.WARNING,"something went wrong ",e);
			}
			break;
			
		case 7:
			ArrayList<String> key7=multiStringAdd();
			logger.info("Enter the subject list");
			ArrayList<String> Subject=multiStringAdd();
			try {
				Map<String,Integer > result7=task.checkList(key7,Subject);
				logger.info(result7.toString());
			} catch (InputDefectException e) {
				logger.log(Level.WARNING,"something went wrong ",e);
			}
			break;
			
		case 8:
			String inputString=getString("Enter a input");
			List list= task.findAndSlice(inputString, "<", ">");
			logger.info(list.toString());
			break;
			
		case 9:
			String password=getString("Enter a input");
			boolean result9=task.validatePassWord(password);
			resultLogger(result9);
			break;
			
		default:
			logger.info("Enter a option between 1-8");

		}
	}
	
	private void resultLogger(boolean flag) {
		if(flag) {
			logger.info("Validation SuccessFul");
		}
		else {
			logger.info("Validation failed");
		}
	}
	private ArrayList<String> multiStringAdd(){
		ArrayList<String> arrayList=new ArrayList<String>();
		int times =getNumber("Enter the number of strings to be added in the array list: ");
		for (int i=0;times>i;i++) {
			String string=getString("please enter the String "+ (i+1) +" :");
			arrayList.add(string);
		}
		return arrayList;
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
	private String getString(){
		return scan.nextLine();
	}
	private String getString(String str){
		logger.info(str);
		return getString();
	}

}
