package module6;

import java.util.Arrays;


public class SelectionSort {
	
	public static void main(String[] args) {
	
	int[] test = {7,16,66,43,97,51};
	selectionSort(test);
	System.out.println(Arrays.toString(test));
	
	}
	
	//selectionSort method
	private static void selectionSort (int[] values){
		for (int i=0; i<values.length-1; i++) {
			int min=i;
			for (int j=i+1; j<values.length; j++){
				if (values[min]>values[j]) {
					min=j;
				}
			}
			swap (values, min, i);
		}
	}
	
    //private helper method to swap
 	private static void swap(int[] values, int a, int b) {
		int x = values[b];
		values[b] = values[a];
		values[a] = x;
		
	}

}
