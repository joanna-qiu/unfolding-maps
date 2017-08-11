package module6;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Mergesort {
	
	public static void main(String[] args) {
		
		List <Integer> test = new ArrayList <Integer> ();
		Random random = new Random();
		for (int i=0; i<5; i++){
			test.add(random.nextInt(100));
		}
		Collections.sort(test);
		System.out.println(test.toString());
		
		}

}
