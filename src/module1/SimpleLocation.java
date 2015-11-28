package module1;

public class SimpleLocation {
	public double latitude;
	public double longitude;
	
	public static final double myLatitude = 40.35;
	public static final double myLongitude = -74.21;
	public static final double radius = 6371;
	
	public SimpleLocation(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public SimpleLocation(){
		this.latitude = myLatitude;
		this.longitude = myLongitude;
	}
	
	public double distance(SimpleLocation other){
		return getDist(this.latitude, this.longitude,
				other.latitude, other.longitude);
	}
	
	public double distance(double latitude, double longitude){
		return getDist(this.latitude, this.longitude, 
				latitude, longitude);
	}
	
	public double getDist(double lat1, double lon1, double lat2,
			double lon2){
		
		double phi1 = Math.toRadians(lat1);
		double phi2 = Math.toRadians(lat2);
		
		double deltaPhi = Math.toRadians(lat2-
				lat1);
		double deltaLambda = Math.toRadians(lon2-
				lon1);
		
		double a = Math.sin(deltaPhi/2) * Math.sin(deltaPhi/2) +
				Math.cos(phi1) * Math.cos(phi2) * 
				Math.sin(deltaLambda/2) * Math.sin(deltaLambda/2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		return radius * c;

	}
	
	
}
