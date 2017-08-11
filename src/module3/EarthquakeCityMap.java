package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
		
	  //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();
	    
	 // Here is an example of how to use Processing's color method to generate 
	    // an int that represents the color yellow.  
	    int blue = color(0,0,255);
	    int yellow = color(255, 255, 0);
	    int red = color(255,0,0);
	    
	    // These print statements show you (1) all of the relevant properties 
	    // in the features, and (2) how to get one property and use it
	    if (earthquakes.size() > 0) {
	    	for (int j=0; j < earthquakes.size(); j++) {
	    		PointFeature f = earthquakes.get(j);
	    		//No need to use, for display System.out.println(f.getProperties());
		    	Object magObj = f.getProperty("magnitude");
		    	float mag = Float.parseFloat(magObj.toString());
		    	Marker mk = createMarker(f);
		    	mk.setStrokeWeight(0);
		    	//change color and size of the marker
		    	if (mag > THRESHOLD_MODERATE) {
	    		    mk.setColor(red);
	    		    ((SimplePointMarker) mk).setRadius(10);
	    		}
	    		else if (mag >= THRESHOLD_LIGHT){
	    			mk.setColor(yellow);
		    		((SimplePointMarker) mk).setRadius(6);	
	    		}
	    		else {
	    			mk.setColor(blue);
	    		    ((SimplePointMarker) mk).setRadius(3);
	    		}
		    	markers.add(mk);
		    	
	    	}
	    	// PointFeatures also have a getLocation method
	    }
	    
	    map.addMarkers(markers);
	
	    
	    //TODO: Add code here as appropriate
	}
		
	// A suggested helper method that takes in an earthquake feature and 
	// returns a SimplePointMarker for that earthquake
	// TODO: Implement this method and call it from setUp, if it helps
	private SimplePointMarker createMarker(PointFeature feature){
		SimplePointMarker marks = new SimplePointMarker (feature.getLocation());
		return marks;
		}
	
	public void draw() {
	    background(20);
	    map.draw();
	    addKey();
	}


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key using the Processing's graphics methods
	private void addKey() 
	{	
		// setting the rectangle
		fill(255,250,240);
		rect (30,50,140,250);
		// setting the title
		textSize(12);
		fill(0,0,0);
		text("Earthquake Key",55, 70);
		// setting the first line
		fill(255,0,0);
		stroke(0,0,0);
		ellipse(45, 120, 10, 10);
		textSize(12);
		fill(0,0,0);
		text("5.0+ Magnitude",65, 125);
		// setting the second line
		fill(255, 255, 0);
		stroke(0,0,0);
		ellipse(45, 170, 6, 6);
		textSize(12);
		fill(0,0,0);
		text("4.0+ Magnitude",65, 174);
		//setting the third line
		fill(0, 0, 255);
		stroke(0,0,0);
		ellipse(45, 220, 3, 3);
		textSize(12);
		fill(0,0,0);
		text("Below 4.0",65, 222);
	
	}
}
