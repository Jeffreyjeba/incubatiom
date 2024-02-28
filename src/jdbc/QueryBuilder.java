package jdbc;


public class QueryBuilder {

	private StringBuilder stringBuilder;

	public QueryBuilder(StringBuilder stringBuilder) {
		this.stringBuilder=stringBuilder;
	}



	// select
	private void select(String ...input) {
		stringBuilder.append("select ");
		addWithComma(input);
	}
	private void from(String tableName) {
		stringBuilder.append(" from "+tableName+" ");
	}
	private void where(String input) {
		stringBuilder.append(" where ");
		stringBuilder.append(input);
	}
	private void limit(int limit) {
		stringBuilder.append(" limit 0,");
		stringBuilder.append(limit);
	}
	private void order(String target,boolean order) {
		stringBuilder.append(" order by ");
		stringBuilder.append(target);
		stringBuilder.append(order?" asc ":" desc ");
	}	

	public void selectAll(String tableName) {
		stringBuilder.append("select * from "+tableName+";");

	}

	public void selectFromOrderLimit(String tableName,String[] fields,int limit,String target,boolean order) {
		select(fields);
		from(tableName);
		order(target,order);
		limit(limit);
		close();
	}

	public void selectFromLimit(String tableName,String[] fields,int limit) {
		select(fields);
		from(tableName);
		limit(limit);
		close();
	}

	public void selectFromWhere( boolean where,String[] fields,String tableName,String...condition) {
		select(fields);
		from(tableName);
		if(where) {
			where(condition[1]);
		}
		close();
	}
	
	
	
	public void innerJoin(String child,String parent,String[] childFields,String cJoin,String pJoin,int limit,boolean oredr) {
		stringBuilder.append("select ");
		stitchWithTable(parent,pJoin);
		stringBuilder.append(",");
		stitchWithTable(child,childFields);
		from(child);
		stringBuilder.append(" inner join ");
		stringBuilder.append(parent);
		stringBuilder.append(" on ");
		stringBuilder.append(child+"."+cJoin+"="+parent+"."+pJoin);
		order(pJoin, oredr);
		limit(limit);
		close();
	}
	
	
	

	//add
	private void insert(String tableName) {
		stringBuilder.append("insert into ");
		stringBuilder.append(tableName);
		
	}
	private void fields(String...input) {
		stringBuilder.append("(");
		addWithComma(input);
		stringBuilder.append(")");
	}
	private void values(String...input) {
		stringBuilder.append(" values (");
		addWithComma(input);
		stringBuilder.append(")");
	}
	public void add(String tableName,String[] fieldList,String[] valueList) {
		insert(tableName);
		fields(fieldList);
		values(valueList);
	}
	public void multiAdd(String tableName,String[] fieldList,String[] valueList) {
		insert(tableName);
		fields(fieldList);
		stringBuilder.append(" values ");
		for(String value:valueList) {
			stringBuilder.append("(");
			stringBuilder.append(value);
			stringBuilder.append("),");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		close();
	}
	
	// update
	private void update(String tableName) {
		stringBuilder.append(" update ");
		stringBuilder.append(tableName);
	}
	private void set(String target,String value) {
		stringBuilder.append(" set ");
		stringBuilder.append(target);
		stringBuilder.append(" = '");
		stringBuilder.append(value);
		stringBuilder.append("'");
	}

	public void updateSetWhere(String tableName,String target,String value,String condition) {
		update(tableName);
		set(target, value);
		where(condition);
	}

	//delete
	public void deleteFrom(String tableName,String condition) {
		stringBuilder.append("delete from ");
		stringBuilder.append(tableName);
		stringBuilder.append(" where ");
		stringBuilder.append(condition);
		close();
	}

	//create
	public void createTable(String tableName,String[] parametre) {
		stringBuilder.append("create table ");
		stringBuilder.append(tableName);
		stringBuilder.append(" (");
		addWithComma(parametre);
		stringBuilder.append(" );");
	}
	
	
	

	private void close() {
		stringBuilder.append(" ;");
	}

	public void addWithComma(String...input) {
		int length=input.length;
		for(int loop=0;length>loop;loop++) {
			stringBuilder.append(input[loop]).append(",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
	}
	
	private void stitchWithTable(String tableName,String...fields) {
		int length=fields.length;
		for(int loop=0;length>loop;loop++) {
			stringBuilder.append(tableName).append(".").append(fields[loop]).append(",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
	}

}
