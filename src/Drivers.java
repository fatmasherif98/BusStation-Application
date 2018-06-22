
public class Drivers extends Employees {

	private String numberOfKilos;
	private String vehicle;

	public Drivers(String firstName, String lastName, String salary, String numberOfKilos, String vehicle) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSalary(salary);
		this.setNumberOfKilos(numberOfKilos);
		this.vehicle = vehicle;

	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getNumberOfKilos() {
		return numberOfKilos;
	}

	public void setNumberOfKilos(String numberOfKilos) {
		this.numberOfKilos = numberOfKilos;
	}

}
