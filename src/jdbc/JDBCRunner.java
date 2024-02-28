package jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.UtilityHelper;
import zoho.Dependent;
import zoho.Employee;


public class JDBCRunner {
	private static Logger logger=Logger.getLogger("JDBC");

	public static void main(String...args) {
		try {
			UtilityHelper.logSetter("JDBC",true, logger);
		} 
		catch (SecurityException | IOException e) {
			logger.log(Level.WARNING,"An error occured at log setting",e);
		}
		JDBCRunner runner=new JDBCRunner();
		boolean flag =true;
		while(flag) {
			int option=runner.getNumber("Enter the option between 1 to 12 : ");
			runner.run(option);
			int loop=runner.getNumber("Enter 1 to continue");
			flag=(loop==1);
		}
	}


	public void run(int option)  {

		JDBCTask task=new JDBCTask("jdbc:mysql://localhost:3306/incubationDB","root","0000");
		String tableName= getString("Enter the table name ");
		StringBuilder query=new StringBuilder();
		QueryBuilder queryBuilder=new QueryBuilder(query); 

		switch(option) {
		case 1:
			try {
				String[] fieldData=fieldData();
				queryBuilder.createTable(tableName, fieldData);
				task.generalExecuter(query.toString());
				logger.info("The table creation is created");
			} catch (SQLException e) {
				logger.log(Level.WARNING,"sql error",e);
			}
			break;
		case 2:
			try {
				List<String> fieldList=task.getFieldName(tableName);		
				String[] inputList=inputValuesforAdd(fieldList);
				queryBuilder.multiAdd(tableName,listToArray(fieldList),inputList);
				task.generalExecuter(query.toString());
			}
			catch (Exception e) {
				logger.log(Level.WARNING,"error",e);
			}
			break;
		case 3:
			try {
				List<String> fieldList =task.getFieldName(tableName);
				String[] requiredFields=filterArrayList(fieldList);				
				queryBuilder.selectFromWhere(false, requiredFields, tableName);
				List<Employee> employeeData= task.getData(query.toString());
				showResult(employeeData);
			}
			catch (Exception e) {
				logger.log(Level.WARNING,"error",e);
			}
			break;
		case 4:
			try {
				List<String> fieldList =task.getFieldName(tableName);
				String targetString=getValueAtPosition(fieldList);
				String valueString=getString("Enter the value of the target :");
				String whereString=getValueAtPosition(fieldList); 
				String condition=getString("Enter the condition eg (= jefjerry)");
				queryBuilder.updateSetWhere(tableName, targetString, valueString,whereString+condition);
				task.generalExecuter(query.toString());	
			} 
			catch (SQLException e) {
				logger.log(Level.WARNING,"sql error",e);
			}
			break;
		case 5:
			try {
				List<String> fieldList =task.getFieldName(tableName);
				String[] requiredFields=filterArrayList(fieldList);
				int limit=getNumber("Enter the number of rows");
				queryBuilder.selectFromLimit(tableName, requiredFields,limit);
				List<Employee> employeeData= task.getData(query.toString());
				showResult(employeeData);
			} catch (Exception e) {
				logger.log(Level.WARNING,"error",e);
			}
		case 6:
			try {

				List<String> fieldList =task.getFieldName(tableName);
				String[] requiredFields=filterArrayList(fieldList);
				int limit=getNumber("Enter the number of rows");
				String target=getValueAtPosition(fieldList);
				boolean order=((getNumber("enter 1 for asscending")==1));
				queryBuilder.selectFromOrderLimit(tableName, requiredFields, limit,target, order);
				List<Employee> employeeData= task.getData(query.toString());
				showResult(employeeData);
			} catch (Exception e) {
				logger.log(Level.WARNING," error",e);
			}
			break;
		case 7:
			try {
				List<String> fieldList =task.getFieldName(tableName);
				String whereString=getValueAtPosition(fieldList); 
				String condition=getString("Enter the condition eg(= jefjerry)");
				queryBuilder.deleteFrom(tableName,whereString+condition);
				task.generalExecuter(query.toString());
			}
			catch (SQLException e) {
				logger.log(Level.WARNING,"sql error",e);
			}
			break;
		case 8:
			try {
				String childTableName= getString("Enter the child table name ");
				List<String> fieldList =task.getFieldName(tableName);
				String[] fieldData=fieldDataRelational(tableName,fieldList);
				queryBuilder.createTable(childTableName, fieldData);
				task.generalExecuter(query.toString());
				logger.info("The table creation is created");
			}
			catch (SQLException e) {
				logger.log(Level.WARNING,"sql error",e);
			}
			break;
		case 9:
			try {
				List<String> parentFieldList = task.getFieldName(tableName);
				logger.info("enter the join column of parent");
				String parentJoin=getValueAtPosition(parentFieldList);
				String childTableName= getString("Enter the child table name ");
				List<String> childFieldList = task.getFieldName(childTableName);
				filterArrayList(childFieldList);
				logger.info("enter the join column of child");
				String childJoin=getValueAtPosition(childFieldList);
				int limit=getNumber("Enter the number of rows");
				boolean order=((getNumber("enter 1 for asscending")==1));
				queryBuilder.innerJoin(childTableName,tableName,listToArray(childFieldList), childJoin, parentJoin,limit,order);
				Map<Integer, List<Dependent>> employeeData=task.getDependent(query.toString());
				showResult(employeeData);
			}
			catch (SQLException e) {
				logger.log(Level.WARNING,"sql error",e);
			} catch (Exception e) {
				e.printStackTrace();
			}



		}
	}
	private<E> E getValueAtPosition(List<E> input) {
		int index=getNumber("enter The Position of of the required  "+input);
		return input.get(index-1);
	}
	private <E> String[] filterArrayList(List<E> list) {
		ArrayList<E> temp =new ArrayList<E>();
		for(E value : list) {
			int option=getNumber("Enter 1 if you need to fetch "+value+" : ");
			if(option==1) {
				temp.add(value);
			}
		}
		return temp.toArray(new String[temp.size()]);
	}
	private<E> void showResult(List<E> list) {
		for(E em:list) {
			logger.info(em.toString());
		}
	}
	private<K,E> void showResult(Map<K, List<E> > map) {
		Set<K> keySet= map.keySet();
		for(K key:keySet) {
			logger.info("Employee "+key.toString());
			showResult(map.get(key));
		}
	}
	private String[] inputValuesforAdd(List<String> columnList){
		int inputNo=getNumber("Enter the number of users to be added : ");
		String[] value= new String[inputNo];
		int loop=0;
		while(inputNo>loop) {
			StringBuilder userData=new StringBuilder();
			for(String field:columnList) {
				String string=getString("Enter the value of "+field+" : ");
				userData.append("'").append(string).append("'").append(",");
			}
			value[loop]=userData.substring(0,userData.length()-1);
			loop++;	
		}
		return value;
	}
	private String[] fieldData() {
		int numberOfFields=getNumber("Enter the number of fields");
		String[] fieldStrings=fieldData(numberOfFields); 
		String primaryKey =getString("Enter the name of the primary key : ");
		fieldStrings[numberOfFields]="primary Key ("+primaryKey+")";
		return fieldStrings;
	}
	private String[] fieldData(int size) {
		String[] fieldStrings=new String[size+1];  
		int loop1=0;
		while(size>loop1) {
			String fieldName=getString("Enter the Field name : ");
			String typeString=mySQLType();
			fieldStrings[loop1]=fieldName+" "+typeString;
			loop1++;
		}
		return fieldStrings;
	}
	private String[] fieldDataRelational(String parentTableName,List<String> parentFieldList) {
		int numberOfFields=getNumber("Enter the number of fields");
		String[] fieldStrings=fieldData(numberOfFields) ; 
		String foreignKey =getString("Enter the name of the foreign key : ");
		logger.info("select the relational column");
		String relation=getValueAtPosition(parentFieldList);
		fieldStrings[numberOfFields]="foreign Key ("+foreignKey+") "
				+ "references "+parentTableName+"("+relation+")"+" on delete cascade";
		return fieldStrings;
	}
	private String mySQLType() {
		String type = null;
		logger.info("select the type");
		int option=getNumber("enter = 1-int ,2-long, 3-varchar, 4-char");
		switch(option) { 
		case 1:
			type= "int";
			break;
		case 2:
			type= "bigint";
			break;
		case 3:
			int size=getNumber("please enter the Size less than 65535");
			type= "varchar("+size+")";
			break;
		case 4:
			int size4=getNumber("please enter the Size less than 225");
			type= "char("+size4+")";
			break;
		default:
			logger.info("please enter a number between 1-4");
			mySQLType();
		}
		return type;
	}
	private String[] listToArray(List<String> list) {
		return list.toArray(new String[list.size()]);
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
