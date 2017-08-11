package module6;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int[] test = {7,16,66,43,97,51};
		insertionSort(test);
		System.out.println(Arrays.toString(test));
		
		}
		
		//insertionSort method
		private static void insertionSort (int[] values){
			for (int i=1; i<values.length; i++) {
				int currentposition=i;
				while (currentposition>0 && values[currentposition] < values[currentposition-1]){
					swap (values,currentposition,currentposition-1);
					currentposition=currentposition-1;
				}
			}
		}
		
	    //private helper method to swap
	 	private static void swap(int[] values, int a, int b) {
			int x = values[b];
			values[b] = values[a];
			values[a] = x;
			
		}


}
