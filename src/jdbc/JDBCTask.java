package jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import zoho.Dependent;
import zoho.Employee;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBCTask {
	private String url;
	private String userName;
	private String password;

	public JDBCTask(String url,String userName,String password) {
		this.url=url;
		this.userName=userName;
		this.password=password;
	}

	public List<String> getFieldName(String tableName ) throws SQLException {
		try(Connection connection=getConnection();){
			try(ResultSet set =getFieldsData(connection,tableName );){
				return colunmName(set);
			}
		}
	}	


	public boolean generalExecuter(String query) throws SQLException {
		try(Connection connection=getConnection();){
			try(Statement statement=connection.createStatement();){
				return statement.execute(query);
			}
		}
	}

	public List<Employee> getData(String query) throws SQLException,Exception{
		try(Connection connection=getConnection();){
			try(Statement statement=connection.createStatement();){
				try(ResultSet set =statement.executeQuery(query)){
					return resultReflector(set,"zoho.Employee"); 
				}
			}
		}
	}
	
	public Map<Integer,List<Dependent>> getDependent(String query)throws SQLException,Exception{
		try(Connection connection=getConnection();){
			try(Statement statement=connection.createStatement();){
				try(ResultSet set =statement.executeQuery(query)){
					return resultDependent(set,"zoho.Dependent"); 
				}
			}
		}
	}
	


	private List<String> colunmName(ResultSet set) throws SQLException{
		ArrayList<String> arrayList=new ArrayList<String>();
		while(set.next()) {
			arrayList.add(set.getString("COLUMN_NAME"));
		}
		return arrayList;
	}

	private ResultSet getFieldsData(Connection connection,String tableName) throws SQLException {
		DatabaseMetaData metaData=	connection.getMetaData();
		return metaData.getColumns(null, null, tableName,null);	
	}

	private Connection getConnection() throws SQLException {
		Connection connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private List<Employee> resultReflector(ResultSet set, String className) throws SQLException,Exception{
		ResultSetMetaData metaData= set.getMetaData();
		Class employee=Class.forName(className);
		List<Employee> list=new ArrayList<Employee>();
		while(set.next()) {
			int colunmNo=metaData.getColumnCount();
			Employee employee2 =new Employee();
			while(colunmNo>0){
				String field=metaData.getColumnName(colunmNo);
				String type= metaData.getColumnTypeName(colunmNo);
				colunmNo--;
				methodInvoker(set, type, field, employee, employee2);
			}
			list.add(employee2);
		}
		return list;
	}
	
	
	@SuppressWarnings({ "rawtypes"})
	private Map<Integer,List<Dependent>> resultDependent(ResultSet set, String className) throws SQLException,Exception{
		ResultSetMetaData metaData= set.getMetaData();
		Class dependent=Class.forName(className);
		Map<Integer,List<Dependent>> dependentMap=new HashMap<>();
		while(set.next()) {
			int colunmNo=metaData.getColumnCount();
			int loop=1;
			int key=set.getInt(metaData.getColumnName(loop));
			loop++;
			Dependent dependentOb =new Dependent();
			while(colunmNo>loop){
				String field=metaData.getColumnName(loop);
				String type= metaData.getColumnTypeName(loop);
				loop++;
				methodInvoker(set, type, field, dependent, dependentOb);
			}
			dependentMap.computeIfAbsent(key, K ->new ArrayList<Dependent>()).add(dependentOb);
		}
		return dependentMap;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void methodInvoker(ResultSet set,String type,String field,Class pojo,Object object) throws SQLException,Exception{
				
				switch(type){
				case "INT":
					Method intMethod= pojo.getDeclaredMethod(fieldToSetMethod(field),int.class);
					intMethod.invoke(object, set.getInt(field)) ;
					break;
				case "VARCHAR":
					Method stringMethod= pojo.getDeclaredMethod(fieldToSetMethod(field),String.class);
					stringMethod.invoke(object,set.getString(field));
					break;
				case "BIGINT":
					Method longMethod= pojo.getDeclaredMethod(fieldToSetMethod(field),long.class);
					longMethod.invoke(object,set.getLong(field));
					break;	
				}
	}
	
	public String fieldToSetMethod(String fieldName) {
		return "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1).toLowerCase();	
	}
	
	
	
}




