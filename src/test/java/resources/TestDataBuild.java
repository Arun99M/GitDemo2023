package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {

	
	public AddPlace addPlacePayload(String name, String language, String address)  //create a new method
	{
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName(name);
		List<String> myList = new ArrayList<String>();     //Creating object class for arrayList due to array mentioned in List.
		myList.add("shoe park");
		myList.add("shop");
		
		p.setTypes(myList);
		Location l= new Location();  // drag on Location and import location(pojo)
		l.setLat(-38.383494);  // it is a double return type
		l.setLng(33.427362);
		
		p.setLocation(l);
		return p;
		
	}
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\": \""+placeId+"\"\r\n}";    // the body convert to java escape formate using JSON escape in online 
	}

}
