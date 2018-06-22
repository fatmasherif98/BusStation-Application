
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calculateprice {
	public double readPriceFromFile_External(String FromExternal, String ToExternal, String TypeOfTicket,
			String vehicle) {

		ArrayList<Trips> arrayOfTrips = new ArrayList<Trips>();
		this.readFromFilesForPrice("Prices.txt", arrayOfTrips); // function reads from files Price.txt
		for (int i = 0; i < arrayOfTrips.size(); i++) {

			if (FromExternal.equals(arrayOfTrips.get(i).getFrom()) && ToExternal.equals(arrayOfTrips.get(i).getTo())) {

				String Price = arrayOfTrips.get(i).getPrice();
				double PriceInDouble = Double.parseDouble(Price);

				if (TypeOfTicket == "Round Trip") {

					double FinalPrice = (PriceInDouble * 0.8);

					return FinalPrice;
				} else
					return PriceInDouble;

			}

		}

		return 0;

	}

	public static void main(String[] args) {

	}

	public double readPriceFromFile_Internal(String FromInternal, String ToInternal, String TypeOfTicket,
			String TypeOfVehicle) {
		Vehicles veh1;
		ArrayList<Trips> arrayOfTrips = new ArrayList<Trips>();
		this.readFromFilesForPrice("Prices.txt", arrayOfTrips);

		for (int i = 0; i < arrayOfTrips.size(); i++) {

			if (FromInternal.equals(arrayOfTrips.get(i).getFrom()) && ToInternal.equals(arrayOfTrips.get(i).getTo())) {

				String Price = arrayOfTrips.get(i).getPrice();
				double PriceInDouble = Double.parseDouble(Price);

				if (TypeOfTicket == "Round Trip") {
					if (TypeOfVehicle == "car") {
						veh1 = new Car();
						return (PriceInDouble * 0.8) * veh1.getFactor();

					} else if (TypeOfVehicle == "Minibus") {
						veh1 = new Minibus();
						return (PriceInDouble * 0.8) * veh1.getFactor();

					} else {
						return (PriceInDouble * 0.8);
					}

				} else // One Way trip

					return PriceInDouble;

			}

		}

		return 0;

	}

	public void readFromFilesForPrice(String filename, ArrayList arrayOfTrips) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals("")) {
				} else {
					String[] list = line.split("-");

					arrayOfTrips.add(new Trips(list[0], list[1], list[2]));

				}

			}
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
