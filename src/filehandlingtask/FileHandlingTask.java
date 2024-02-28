package filehandlingtask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;
import propertiestask.PropertiesTask;
import java.io.IOException;
import utility.InputDefectException;
import utility.UtilityHelper;

public class FileHandlingTask {

	public File createFile(String fileName)throws IOException,SecurityException,InputDefectException {
		UtilityHelper.nullCheck(fileName,"The file name cannot be null");
		File newFile=new File(fileName);
		createFile(newFile);
		return newFile;
	}
	public boolean createFile(File file) throws IOException,SecurityException, InputDefectException{
		UtilityHelper.nullCheck(file,"The file cannot be null");
		return  file.createNewFile();
	}
	public File createfileDirectory(String directory,String file) throws SecurityException, IOException, InputDefectException {
		File newFile=new File(directory,file);
		createFile(newFile);
		return newFile;                     
	}
	public boolean makeDirectory(String file) throws InputDefectException ,SecurityException{
		UtilityHelper.nullCheck(file,"The file cannot be null");
		File newFile=new File(file);
		return newFile.mkdirs();
	}

	public void println(PrintWriter writer,String output ) throws InputDefectException {
		UtilityHelper.nullCheck(writer,"The writer cannot be null");
		writer.println(output);
	}
	
	public void contentPrintWriter(File file,String content)throws IOException  {

		PrintWriter write=createPrintWriter(file);
		try {
			write.println(content);
		}
		finally {
			try {
				write.close();
			}
			catch(Exception e ) {}
		}
	}
	public void propertiesFileWriter(File file,PropertiesTask propTable,Properties property,String commend)throws IOException, InputDefectException  {
		UtilityHelper.nullCheck(propTable,"PropertyTask cannot be null");
		FileWriter write=createFileWriter(file);
		try {
			propTable.store(property, write, commend);
		}
		finally {
			try {
				write.close();
			}
			catch(Exception e ) {}
		}
	}
	public void PropertiesFileReader(File file,PropertiesTask propTable,Properties property) throws InputDefectException, IllegalArgumentException, IOException{
		UtilityHelper.nullCheck(propTable,"PropertyTask cannot be null");
		FileReader read=createFileReader(file);
		try{
			propTable.load(read, property);
		}
		finally {
			try {
				read.close();
			}
			catch(Exception e ) {}

		}
	}
	private PrintWriter createPrintWriter(File file) throws FileNotFoundException {
		return new PrintWriter(file);
	}
	private FileWriter createFileWriter(File file) throws  IOException {
		return new FileWriter(file);
	}
	private FileReader createFileReader(File fileName) throws FileNotFoundException {
		return new FileReader(fileName);
	}
}
