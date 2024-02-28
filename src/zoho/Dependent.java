package zoho;

public class Dependent {
	private int id;
	private String name;
	private int age;
	private String relation;

	public String getName() {
		return name;
	}
	public void setName(String parent) {
		this.name = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Dependent() {

	}
	@Override
	public String toString() {
		return  " parent id "+id+" parent name "+name+ " age "+age+" Relation "+relation;
	}
}
