package module2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

import processing.core.PApplet;

public class LifeExpectancy extends PApplet{

	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup(){
		// setup the papplet as the canvas
		size(800,600,OPENGL);
		
		// create the map on the canvas
		map = new UnfoldingMap(this, 50,50,700,500, new Google.GoogleMapProvider());
		
		// make the map interactive
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// call the loading method that will allow us to read
		// the csv file
		lifeExpByCountry = loadLifeExpectancyByCountry
				("../../data/LifeExpectancyWorldBankModule3.csv");
		
		// load the json file of country data into our arraylist
		countries = GeoJSONReader.loadData(this, "../../data/countries.geo.json");
		
		// create simple markers based on the countries
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		// add the markers
		map.addMarkers(countryMarkers);
		
		// shade the markers
		shadeCountries();
	}
	
	public void draw(){
		map.draw();
	}
	
	private	Map<String,Float> loadLifeExpectancyByCountry(String fileName){
		
		// create a hash map of string and floats
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		// load the file into rows of strings
		String[] rows = loadStrings(fileName);
		
		// for each row in the rows of strings
		for (String row : rows){
			
			// separate the rows by the commas
			// note apparently this is not a good idea because some entries have
			// commas in them but we deal with this in the if statement
			String[] columns = row.split(",");
			
			// separate out all the rows that had commas in them
			if (columns.length == 6 && !columns[5].equals("..")){
				
				// look for a float in the column
				float value = Float.parseFloat(columns[5]);
				
				// place the key and value in the map
				lifeExpMap.put(columns[4], value);
			}
		}
		return lifeExpMap;
	}
	
	private void shadeCountries(){
		for(Marker marker : countryMarkers){
			// gets the country id from the marker
			String countryId = marker.getId();
			
			// if the map contains the key country id
			if (lifeExpByCountry.containsKey(countryId)){
				
				// get the life expectancy from the key
				float lifeExp = lifeExpByCountry.get(countryId);
				
				//set up a color level based on the range of life expectancies
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				
				// set the color, we subtract 255 - color level for red
				// and set the blue = to the color level
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}
			else {
				// just set the country color to grey
				marker.setColor(color(150,150,150));
			}
		}
	}
	
	
}
