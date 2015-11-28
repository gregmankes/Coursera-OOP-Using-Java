package testing;

import java.util.*;

public class AirportFind {

//	public static String findAirportCode(String toFind, Airport[] airports){
//		for (Airport a : airports){
//			if (a.getCity().equalsIgnoreCase(toFind)){
//				return a.getCode3();
//			}
//		}
//		
//		return null;
//	}

	public static void main(String[] args) {
		airportSort();
	}
	
	public static void airportSort(){
		ArrayList<Airport> airports = new ArrayList();
		
		airports.add(new Airport("Montreal","Canada","YMX"));
		airports.add(new Airport("Lagos","Nigeria","LOS"));
		airports.add(new Airport("Essen","Germany","ESS"));
		airports.add(new Airport("Chicago","USA","ORD"));
		airports.add(new Airport("Beijing","China","PEK"));
		airports.add(new Airport("Sydney","Australia","SYD"));
		airports.add(new Airport("Quito","Ecuador","UIO"));
		airports.add(new Airport("Agra","India","AGR"));
		
		Collections.sort(airports);
		
		for (Airport a : airports){
			System.out.println(a.getCity()+", "+a.getCountry());
		}

	}
	
	public static String linearFindAirportCode(String toFind, Airport[] airports){
		int index = 0;
		while ( index < airports.length){
			Airport a = airports[index];
			if (toFind.equalsIgnoreCase(a.getCity())){
				return a.getCode3();
			}
			index++;
		}
		
		return null;
	}
	
	// my initial implementation
//	public static String binaryFindAirportCode(String toFind, Airport[] airports){
//		int low = 0;
//		int high = airports.length-1;
//		int mid = 0;
//		while (low <= high){
//			mid = (high+low)/2;
//			if (airports[mid].getCity().equalsIgnoreCase(toFind)){
//				return airports[mid].getCode3();
//			}
//			else if (airports[mid].getCity().compareToIgnoreCase(toFind) > 1){
//				high = mid -1;
//			}
//			else {
//				low = mid+1;
//			}
//		}
//		
//		return null;
//	}
	public static String binaryFindAirportCode(String toFind, Airport[] airports){
		int low = 0;
		int high = airports.length;
		int mid;
		while(low <= high){
			mid = (low + high)/2;
			int compare = toFind.compareToIgnoreCase(airports[mid].getCity());
			if (compare < 0){
				high = mid-1;
			}
			else if (compare > 0){
				low = mid - 1;
			}
			else{
				return airports[mid].getCode3();
			}
		}
		return null;
	}
	
}
