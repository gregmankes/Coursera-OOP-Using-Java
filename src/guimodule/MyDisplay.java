package guimodule;

import processing.core.PApplet;

public class MyDisplay extends PApplet{

		public void setup(){
			size(400,400);
			background(200,200,200);
		}
		
		public void draw(){
			fill(255,247,138);
			ellipse(width/2,height/2,width,height);
			fill(0,0,0);
			ellipse(width/4,height/4,50,70);
			ellipse(3*width/4,height/4,50,70);
			
			noFill();
			arc(width/2, height/2+50, width/3, height/3,0,PI);
		}
}
