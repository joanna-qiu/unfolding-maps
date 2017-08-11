package module3;

import processing.core.PApplet;
import processing.core.PImage;
public class ChangeColor extends PApplet{
	private PImage backgroundImg;
	
public void setup()
{
	size(400,400);
	backgroundImg = loadImage("palmTrees.jpg");
	backgroundImg.resize(0,height);
	image(backgroundImg,0,0);
}

public void draw()
{
	int [] color = sunColor(second());
	fill(color[0],color[1],color[2]);
	ellipse(width/4,height/5,width/5,height/5);
}

public int[] sunColor (float second)
{
    int[] rgb = new int[3];
    float diff = Math.abs(30-second);
    float ratio = diff/30;
    rgb[0] = (int)(255*ratio);
    rgb[1]=(int)(255*ratio);
    rgb[2]=0;
    return rgb;
}
}
