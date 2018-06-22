
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

import org.omg.Messaging.SyncScopeHelper;

public class SearchFrom_To {

	protected static int countTrips = 0; // fixed counter
	private Formatter x; // to write in file

	ArrayList<Trips> arrayOfTrips = new ArrayList<Trips>();

	public ArrayList<Trips> Searching_From_To_External(String FromExternal, String ToExternal) {

		ArrayList<Trips> arrTripsWanted = new ArrayList<Trips>();

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

		for (int i = 0; i < arrayOfTrips.size(); i++) {

			if (FromExternal.equals(arrayOfTrips.get(i).getFrom()) && ToExternal.equals(arrayOfTrips.get(i).getTo())) {

				arrTripsWanted.add(new Trips(arrayOfTrips.get(i).getFrom(), arrayOfTrips.get(i).getTo(),
						arrayOfTrips.get(i).getTime(), arrayOfTrips.get(i).getStops()));

			}

		}

		return arrTripsWanted;

	}

	public ArrayList<Trips> Searching_From_To_Internal(String FromInternal, String ToInternal) {
		ArrayList<Trips> arrTripsWanted = new ArrayList<Trips>();
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

		for (int i = 0; i < arrayOfTrips.size(); i++) {

			if (FromInternal.equals(arrayOfTrips.get(i).getFrom()) && ToInternal.equals(arrayOfTrips.get(i).getTo())) {

				arrTripsWanted.add(new Trips(arrayOfTrips.get(i).getFrom(), arrayOfTrips.get(i).getTo(),
						arrayOfTrips.get(i).getTime(), arrayOfTrips.get(i).getStops()));

			}

		}
		return arrTripsWanted;

	}

}
