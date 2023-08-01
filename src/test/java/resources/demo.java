package resources;

public class demo {
	
	String addPlaceAPI = "/maps/api/place/add/json";
	String getPlaceAPI = "/maps/api/place/get/json";
	String deletePlaceAPI = "/maps/api/place/delete/json";

	
	
public String getAddPlaceAPI()   //This method will return below variable and this variable have example "/maps/api/place/add/json" 
{
		return addPlaceAPI;
}
public String getPlaceAPI()
{
		return getPlaceAPI;
}
public String deletePlaceAPI()
{
	return deletePlaceAPI;
}

}
