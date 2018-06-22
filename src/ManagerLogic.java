import java.io.FileReader;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ManagerLogic implements FileManagement {

	public ArrayList<Drivers> driverArray = new ArrayList<Drivers>();
	public ArrayList<Managers> managerArray = new ArrayList<Managers>();
	public ArrayList<Members> memberArray = new ArrayList<Members>();
	public ArrayList<Members> passwordArray = new ArrayList<Members>();

	protected int countDrivers = 0;
	protected int countManagers = 0;
	protected int countMembers = 0;
	private Formatter x;

	public void readFromDriversFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("DriversInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {

					String[] list = line.split(",");
					driverArray.add(new Drivers(list[0], list[1], list[2], list[3], list[4]));
					countDrivers++;

				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fr != null) {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void readFromManagersFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("ManagersInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {

					String[] list = line.split(",");
					managerArray.add(new Managers(list[0], list[1], list[2], list[3]));
					countManagers++;

				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fr != null) {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean passwordCheck(String ID, String password) {
		for (int i = 0; i < passwordArray.size(); i++) {
			if (ID.equals(passwordArray.get(i).getID()) && password.equals(passwordArray.get(i).getPassword()))
				return true;
		}
		return false;
	}

	public void readFromMembersFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("MembersInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {

					String[] list = line.split(",");
					memberArray.add(new Members(list[0], list[1], list[2], list[3], list[4], list[5]));
					countMembers++;

				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fr != null) {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void readPassWords() {
		FileReader fr = null;
		try {
			fr = new FileReader("MembersInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {

					String[] list = line.split(",");
					passwordArray.add(new Members(list[0], list[5]));
					countMembers++;

				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fr != null) {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeToDriversFile() {
		try {
			x = new Formatter("DriversInfo.txt");

		} catch (Exception ex) {
			System.out.println("Error in writing to file DriversInfo");
		}
		for (int i = 0; i < countDrivers; i++) {
			x.format("%s,%s,%s,%s,%s\r\n", this.driverArray.get(i).getFirstName(),
					this.driverArray.get(i).getLastName(), this.driverArray.get(i).getSalary(),
					this.driverArray.get(i).getNumberOfKilos(), this.driverArray.get(i).getVehicle());
		}

		x.close();
	}

	public void writeToManagersFile() {
		try {
			x = new Formatter("ManagersInfo.txt");

		} catch (Exception ex) {
			System.out.println("Error in writing to file ManagersInfo");
		}
		for (int i = 0; i < countManagers; i++) {
			x.format("%s,%s,%s,%s\r\n", this.managerArray.get(i).getFirstName(), this.managerArray.get(i).getLastName(),
					this.managerArray.get(i).getSalary(), this.managerArray.get(i).getDepartment());
		}

		x.close();
	}

	public void writeToMembersFile() {
		try {
			x = new Formatter("MembersInfo.txt");

		} catch (Exception ex) {
			System.out.println("Error in writing to file MembersInfo");
		}
		for (int i = 0; i < countMembers; i++) {
			x.format("%s,%s,%s,%s,%s,%s\r\n", this.memberArray.get(i).getID(), this.memberArray.get(i).getFirstName(),
					this.memberArray.get(i).getLastName(), this.memberArray.get(i).getPhoneNumber(),
					this.memberArray.get(i).getRank(), this.memberArray.get(i).getPassword());
		}

		x.close();
	}

	public void removeFromDriverList(int i) {
		driverArray.remove(i);
	}

	public void removeFromManagerList(int i) {
		managerArray.remove(i);
	}

	public void removeFromMemberList(int i) {
		memberArray.remove(i);
	}

	public void addToDriverList(Drivers d1, int i) {
		driverArray.add(i, d1);
	}

	public void addToManagerList(Managers m1, int i) {
		managerArray.add(i, m1);
	}

	public void addToMemberList(Members m1, int i) {
		memberArray.add(i, m1);
	}

	public Drivers getFromDriverList(int i) {
		return driverArray.get(i);
	}

	public Managers getFromManagerList(int i) {
		return managerArray.get(i);
	}

	public Members getFromMemberList(int i) {
		return memberArray.get(i);
	}
}
