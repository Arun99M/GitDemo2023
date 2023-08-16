package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;



public class Hooks {

	//Hooks will helps us to set precondition and Post condition like only delete need to run
	
	@Before ("@DeletePlace")
	public void beforeScenario() throws IOException
	{
	//	write a code that will give you place id
		//execute this code only when place id is null
		
		//Use hooks only when previous scenario is unavailable
	
		StepDefinitions m = new StepDefinitions();
		if(StepDefinitions.place_id==null)
		{
		m.add_place_payload_with("Shetty","french", "Asia");
	    m.user_calls_with_http_request("AddPlaceAPI", "POST");
	    m.verify_place_id_created_maps_to_using("Shetty","getPlaceAPI");
		}
	}
	
	
	
}
