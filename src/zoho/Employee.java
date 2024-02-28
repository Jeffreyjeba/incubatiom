package zoho;

public class Employee {
	private int employee_id;
	private String name;
	private long phone;
	private String email_id;
	private String depatment;





	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employeeId) {
		this.employee_id = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return email_id;
	}
	public void setEmail_id(String emailId) {
		email_id = emailId;
	}
	public String getDepatment() {
		return depatment;
	}
	public void setDepartment(String depatment) {
		this.depatment = depatment;
	}

	public Employee() {
	}
	@Override
	public String toString() {
		return  "The name is "+name+" id "+employee_id+
				" phone number "+phone+" EmailID "+email_id+
				" Department "+depatment;
	}

}
