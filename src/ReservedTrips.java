
public class ReservedTrips {

	private String from;
	private String to;
	private String numberOfStops;
	private String time;
	private String vehicle;
	private String typeOfTrip;
	private Double price;
	private String memberId;
	private String date;

	public ReservedTrips(String from, String to, String time, String numberOfStops, String vehicle, String typeOfTrip,
			Double price, String memberId, String date) {

		this.from = from;
		this.to = to;
		this.numberOfStops = numberOfStops;
		this.time = time;
		this.vehicle = vehicle;
		this.typeOfTrip = typeOfTrip;
		this.price = price;
		this.memberId = memberId;
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(String numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getTypeOfTrip() {
		return typeOfTrip;
	}

	public void setTypeOfTrip(String typeOfTrip) {
		this.typeOfTrip = typeOfTrip;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
