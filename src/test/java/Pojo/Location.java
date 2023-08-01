package Pojo;

public class Location {

	   // here returntype mentioning double due to lat and lng value is in negative and float eg:("lat": -38.383494, "lng": 33.427362)
	private double lat;
	private double lng;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
