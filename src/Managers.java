
public class Managers extends Employees {

	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Managers(String firstName, String lastName, String salary, String department) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSalary(salary);
		this.department = department;
	}
}
