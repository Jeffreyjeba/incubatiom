package filehandlingrunner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import filehandlingtask.FileHandlingTask;
import utility.InputDefectException;
import propertiestask.PropertiesTask;
import utility.PersonalDetail;

public class FileHandlingRunner{
	static Logger logger=Logger.getLogger("FileHandlingRunner");
	public static void main(String[] args) {
		try {
			FileHandler handler= new FileHandler("log",true);
			Formatter formatter=new SimpleFormatter();
			handler.setFormatter(formatter);
			logger.addHandler(handler);
			logger.setLevel(Level.ALL);
		}
		catch(IOException e) {
			logger.warning("The is some thing wrong with input output operation");
			logger.warning( e.getStackTrace().toString());
		}
		catch(SecurityException e){
			logger.log(Level.WARNING, "You dont have acces to this file",e);
		}
		boolean loop=true;
		while(loop) {
			FileHandlingRunner use =new FileHandlingRunner();
			logger.info("This program is for filehandlins and creation");
			int option=use.getNumber("Please enter the option  from 1 to 6: ");
			use.run(option);
			int cont=use.getNumber("Enter 1 if you want to continue : ");
			if(cont!=1) {
				loop=false;
			}
		}
	}
	private void run(int option)  {
		PropertiesTask propTable=new PropertiesTask();
		FileHandlingTask task= new FileHandlingTask();
		switch(option) {
		case 1:
			try {

				String fileName=fileNameHandler();
				File newFile=task.createFile(fileName);
				String content=getString("Enter the content : ");
				task.contentPrintWriter(newFile,content);
			}

			catch(IOException e) {
				logger.log(Level.WARNING,"The is some thing wrong with input output operation",e);
			}
			catch(SecurityException e){
				logger.log(Level.WARNING,"You dont have acces to this file",e);

			}
			catch(InputDefectException e){
				logger.log(Level.WARNING,"There is a defect in input",e);
			}
			break;

		case 2:
			try {
				String fileName=fileNameHandler();
				File file=task.createFile(fileName);
				propertyWriter(propTable,task,fileName,file);

			}	
			catch(IOException e) {
				logger.log(Level.WARNING,"The is some thing wrong with input output operation",e);
			}
			catch(InputDefectException e){
				logger.log(Level.WARNING,"There is a defect in input",e);
			}
			break;


		case 3:
			try {
				String fileName=getString("Enter the name of the old property file : ");
				File file=task.createFile(fileName);
				propertyReader(propTable,task,file);
			}
			catch (IllegalArgumentException e) {
				logger.log(Level.WARNING,"A malformed Unicode escape appears in the input",e);
			}	
			catch (IOException e) {
				logger.log(Level.WARNING,"The is some thing wrong with input output operation",e);
			}	
			catch(InputDefectException e){
				logger.log(Level.WARNING,"There is a defect in input",e);
			}
			break;

		case 4:
			try	{
				String fileName=fileNameHandler();
				String folderName=getString("Enter the folder name");
				String workingDirectory=System.getProperty("user.dir");
				logger.info(workingDirectory);
				char seprator= File.separatorChar;
				logger.info("The seprator is "+seprator);
				String folderPath=workingDirectory+seprator+folderName;
				if(task.makeDirectory(folderPath)){
					logger.info(" directory created");
				}
				else {
					logger.info(" directory creation failed check for existing path");
				}
				File file=task.createfileDirectory( folderPath,fileName);
				String content= getString("Enter the content");
				task.contentPrintWriter(file,content);


				String propertyFileName=fileNameHandler();
				File propertyFile=task.createfileDirectory(folderPath,propertyFileName);
				propertyWriter(propTable,task,propertyFileName,propertyFile);
				propertyReader(propTable,task,propertyFile);
			}
			catch(InputDefectException e) {
				logger.log(Level.WARNING,"There is a defect in input",e);
			}
			catch(FileNotFoundException e) {
				logger.log(Level.WARNING,"File not found",e);
			}
			catch (IllegalArgumentException e) {
				logger.log(Level.WARNING,"A malformed Unicode escape appears in the input",e);
			}	
			catch (IOException e) {
				logger.log(Level.WARNING,"The is some thing wrong with input output operation",e);
			}
			break;

		case 5:
			String name=getString("Enter your name : ");
			int age=getNumber("Enter your age : ");
			PersonalDetail student=new PersonalDetail(name,age);
			logger.info(student.toString());
			break;

		case 6:
			PersonalDetail student2 = new PersonalDetail();
			student2.setName(getString("Enter your name : "));
			student2.setAge(getNumber("Enter your age : "));
			logger.info(student2.toString());
			break;
		}
	}



	// over over




	@SuppressWarnings("unchecked")
	private void keyValueIterator(Properties property,PropertiesTask propTable) throws IOException, InputDefectException {
		Set<String> keys= propTable.keySet(property);
		for(String key:keys) {
			String value=propTable.getProperty(property,key);
			logger.info("The key is :"+key+" The value is : "+value);
		}

	}
	Scanner scan=new Scanner(System.in);
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

	private String fileNameHandler() {
		logger.info("Please add .txt at end and do not leave any space in the file name creation");
		String fileName=getString("Please enter the file name here"); 
		return fileName;
	}
	private void propertyWriter(PropertiesTask propTable,FileHandlingTask task,String fileName,File file) throws InputDefectException, SecurityException, IOException {
		Properties property=propTable.createProperties();
		multipropertyAdd(property, propTable);
		task.propertiesFileWriter(file, propTable, property, fileName);
		logger.info(" storing of object is successfull");
	}
	private void propertyReader(PropertiesTask propTable,FileHandlingTask task,File file) throws InputDefectException, SecurityException, IOException {
		Properties property= propTable.createProperties();
		task.PropertiesFileReader(file,propTable,property);
		keyValueIterator(property,propTable);
	}
	private void multipropertyAdd(Properties property,PropertiesTask proptable) throws InputDefectException{
		int times=getNumber("Enter the number of properties pairs you need to enter : ");
		int number=1;
		while(times>0) {
			proptable.setProperty(property,getString("Enter the key String "+number+" : "),getString("Enter the value String "+number+" : ") );
			times--;
			number++;
		}
	}
	

}
