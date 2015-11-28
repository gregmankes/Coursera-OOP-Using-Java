import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Hello World!
 * 
 * This is the basic stub to start creating interactive maps.
 */
public class HelloUCSDWorld extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(900, 700, OPENGL);

		map = new UnfoldingMap(this, 200, 50, 650, 600, new Google.GoogleMapProvider());
//		map.zoomAndPanTo(14, new Location(32.881, -117.238)); // UCSD

		MapUtils.createDefaultEventDispatcher(this, map);
		
	}

	public void draw() {
		map.draw();
		addButtons();
	}
	
	private void addButtons(){
		fill(255,255,255);
		rect(250,100,25,25);
		
		fill(100,100,100);
		rect(250,150,25,25);
	}
	
	public void mouseReleased(){
		if (mouseX > 250 && mouseX < 275 && mouseY > 100 && mouseY < 125 ){
			background(255,255,255);
		}
		else if (mouseX > 250 && mouseX < 275 && mouseY > 150 && mouseY < 175 ){
			background(100,100,100);
		}
	}

}
