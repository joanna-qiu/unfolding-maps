package module3;

import processing.core.*;
public class MyPApplet extends PApplet
{
//when loading photo from URL
//private String URL = "http://c3-q.mafengwo.net/s7/M00/64/E3/wKgB6lS2cnSAG-c7AAiyn56g2Fs68.jpeg";
private PImage backgroundImg;

public void setup()
{
size(200,200);
//name of the background photo, the file must be in the data directory
backgroundImg = loadImage("palmTrees.jpg");
}
public void draw()
{
	backgroundImg.resize(0, height);
	image(backgroundImg,0,0);
	fill (255,209,0);
	ellipse(width/4, height/5, width/5, height/5);
	// add in loops to change color of the sun
	if (hour() == 14) {
		fill (241,158,194);
		ellipse((width/4)*3, height/4, width/5, height/5);
	    }
}
}
