package resources;

//enum is a special class in java which has collection of constants or methods/ separate the methods with comma and complete the method with colon
public enum APIResources {
    AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");   // give comma and define all the apiresources
	private String resource; //Assigning resource name as a global 
	
	APIResources(String resource)  // constructor(the constructor can be defined directly from the class name and this constructor will accept arguments 
	{
		this.resource =resource;  // this refers to the current class of variable, resource comes from constructor
	}
	public String getResource()
	{
		return resource;
	}
}
