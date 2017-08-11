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
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

public class TryEarthquakeMap extends PApplet{
	
	private static final long serialVersionUID = 1L;
	
	private UnfoldingMap map;
	
	public void setup()
	{
		size(950,600,OPENGL);
		map = new UnfoldingMap (this,200,50,700,500,new OpenStreetMap.OpenStreetMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		//Inputing the val Eq.
		Location valLoc = new Location (-38.14f,-73.03f);
		PointFeature valEq = new PointFeature (valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		//Inputing the alaska Eq.
		Location alaskaLoc = new Location (61.02f, -147.65f);
		PointFeature alaskaEq = new PointFeature (alaskaLoc);
		alaskaEq.addProperty("title","alaska");
		alaskaEq.addProperty("magnitude", "9.2");
		
		//Adding single marker
		//Marker val = new SimplePointMarker (valLoc,valEq.getProperties());
		//map.addMarker(val);
		
		//The list of point features of the eqs.
		List<PointFeature> bigEqs = new ArrayList <PointFeature>();
		bigEqs.add(valEq);
		bigEqs.add(alaskaEq);
		
		//Adding list of marker
		List<Marker> markers = new ArrayList <Marker> ();
		for (PointFeature eq: bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));	
		}
		
		map.addMarkers(markers);
		
	}
	
	public void draw()
	{
		background(200);
		map.draw();
	}

}
