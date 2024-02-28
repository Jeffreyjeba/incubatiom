package utility;

public class PersonalDetail {
	private String name;
	private int age;
	
	
	// methods
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setName(String word) {
		this.name=word;
	}
	
	
	//constructors
	public  PersonalDetail(String name,int age) {
		setAge(age);
		setName(name);
	}
	public  PersonalDetail() {
	}
	@Override
	public String toString() {
		return "your name is "+name+" and your age is "+age;
	}

}



