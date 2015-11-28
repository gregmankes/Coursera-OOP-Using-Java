package testing;

public class Airport implements Comparable<Airport>{
	private String city;
	private String country;
	private String code3;
	
	public String getCity() {return city;}
	public String getCountry() {return country;}
	public String getCode3() {return code3;}
	
	public Airport(String city, String country, String code3){
		this.city = city;
		this.country = country;
		this.code3 = code3;
	}
	
	@Override
	public int compareTo(Airport other) {
		return (this.getCity()).compareToIgnoreCase(other.getCity());
	}

}
