package module1;

import processing.core.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyPApplet extends PApplet {
	private PImage backgroundImg;
	private String URL = "palmTrees.jpg";
	
	public void setup() {
		size(200,200);
		backgroundImg = loadImage(URL, "jpg");
	}
	
	public void draw(){
		backgroundImg.resize(0, height);
		image(backgroundImg,0,0);
		setFill();
		ellipse(width/4, height/5, width/5, height/5);
	}
	
	public void setFill(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hour = Integer.parseInt(sdf.format(cal.getTime()));
		if (hour > 6 && hour <= 10 ) {
			fill(244,245,196);
		}
		else if (hour > 10 && hour <= 17){
			fill(241,245,17);
		}
		else if (hour > 17 && hour <= 21) {
			fill(245,177,17);
		}
		else {
			fill(255,255,255);
		}
		
	}
}
