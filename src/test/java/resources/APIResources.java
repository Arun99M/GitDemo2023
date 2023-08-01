package resources;

//enum is a special class in java which has collection of constants or methods/ separate the methods with comma and complete the method with colon
public enum APIResources {
    AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource; //Assigning resource name as a global 
	
	APIResources(String resource)  // constructor
	{
		this.resource =resource;  // this refers to the current class of variable, resource comes from constructor
	}
	public String getResource()
	{
		return resource;
	}
}
