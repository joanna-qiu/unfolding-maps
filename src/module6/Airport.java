package module6;

public class Airport {
	private String city;
	private String country;
	private String code;
	
	//linear search method to find the airport code for a city
	public String findairportcode (String targetcity, Airport [] airports) {
		int i = 0;
		while (i < airports.length) {
			if (targetcity.equals(airports[i].getcity())) {
				return airports[i].getcode();
			}
			else;
			i++;
		}
		return null;
	}
	
	//binary search method to find the airport code for a city
	public String findcode (String city, Airport [] airports){
		int low = 0;
		int high = airports.length;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			int compare = city.compareTo(airports[mid].getcity());
			if (compare == -1) {
				high = mid - 1;
			}
			else if (compare == 1){
				low = mid + 1;
			}
			else if (compare == 0) {
				return airports[mid].getcode();
			}
		}
		return null;
	}
	
	//getter method for city
	public String getcity(){
		return this.city;
	}
	
	//getter method for country
		public String getcountry(){
			return this.country;
		}
		
	//getter method for code
		public String getcode(){
			return this.code;
		}

}
