
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Arrays {
	ArrayList<Trips> arrayOfTrips = new ArrayList<Trips>();

	public ArrayList<ReservedTrips> reservedTripsArray = new ArrayList<ReservedTrips>();
	protected int countTrips = 0;
	protected int countReservedTrips = 0;

	public void readFromReservedTripsFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("ReservedTripsInfo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {

					String[] list = line.split(",");
					reservedTripsArray.add(new ReservedTrips(list[0], list[1], list[2], list[3], list[4], list[5],
							Double.parseDouble(list[6]), list[7], list[8]));
					countReservedTrips++;

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

	public void writeToReservedTripsFile() {
		try {
			x = new Formatter("ReservedTripsInfo.txt");

		} catch (Exception ex) {
			System.out.println("Error in writing to file ReservedTripsInfo");
		}
		for (int i = 0; i < countReservedTrips; i++) {
			x.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", this.reservedTripsArray.get(i).getFrom(),
					this.reservedTripsArray.get(i).getTo(), this.reservedTripsArray.get(i).getVehicle(),
					this.reservedTripsArray.get(i).getNumberOfStops(), this.reservedTripsArray.get(i).getTypeOfTrip(),
					this.reservedTripsArray.get(i).getTime(), this.reservedTripsArray.get(i).getPrice(),
					this.reservedTripsArray.get(i).getMemberId(), this.reservedTripsArray.get(i).getDate());
		}

		x.close();
	}

	public void addToReservedTripsList(ReservedTrips rt) {
		reservedTripsArray.add(rt);
		countReservedTrips++;
	}

	public void addToReservedTripsList(ReservedTrips rt, int i) {
		reservedTripsArray.add(i, rt);
		countReservedTrips++;
	}

	public ReservedTrips getFromReservedTripsList(int i) {
		return reservedTripsArray.get(i);
	}

	private Formatter x; // to write in file

	public void readFromTripsFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("TripsFile.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {
					String[] list = line.split("-");

					arrayOfTrips.add(new Trips(list[0], list[1], list[2], list[3]));

					countTrips++;

				}

			}
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToTripsFile() {
		try {
			x = new Formatter("TripsFile.txt");

		} catch (Exception ex) {
			System.out.println("Error in writing to file TripsFile");
		}
		for (int i = 0; i < countTrips; i++) {
			x.format("%s-%s-%s-%s\r\n", this.arrayOfTrips.get(i).getFrom(), this.arrayOfTrips.get(i).getTo(),
					this.arrayOfTrips.get(i).getTime(), this.arrayOfTrips.get(i).getStops());
		}

		x.close();
	}

	public void removeFromReversedTripsList(int i) {
		reservedTripsArray.remove(i);
	}

	public void removeFromAvailableTripsList(int i) {
		arrayOfTrips.remove(i);
	}

	public void addToTripsList(Trips t1, int i) {
		arrayOfTrips.add(i, t1);
	}

	public Trips getFromTripsList(int i) {
		return arrayOfTrips.get(i);
	}

}
