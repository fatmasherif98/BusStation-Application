

public class Trips {
	
	
	private int numberOfTrip ;		
	
	private String price;
	private String distance;
	private String from;
	private String to;
	private String time;
	private String stops;
	private String TypeOfTicket;
	
	
	public String getTypeOfTicket() {
		return TypeOfTicket;
	}




	public void setTypeOfTicket(String typeOfTicket) {
		TypeOfTicket = typeOfTicket;
	}






	public Trips (String from,String to,String time,String stops){
		this.from=from;
		this.to=to;
		this.time=time;
		this.stops=stops;
		
		
				
	}
	
	
	
	
	
	
	public Trips( String from, String to,String price) {
		
		this.price = price;
		this.from = from;
		this.to = to;
	}






	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	
	
	
	
	public int getNumberOfTrip() {
		return numberOfTrip;
	}
	public void setNumberOfTrip(int numberOfTrip) {
		this.numberOfTrip = numberOfTrip;
	}
	

	public String getPrice() {
		return price;
	}
	public void setPrice() {
		this.price = price ;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
	
	
	

}
